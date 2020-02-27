/**
 * 
 */
package com.example.repository.entity;

import java.util.UUID;

import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.domain.aggregate.Account;
import com.example.domain.event.BaseEvent;
import com.example.repository.AccountRepository;

/**
 * @author shariefa
 *
 */
@Component
public class AccountEntityManager {
	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private EventSourcingRepository<Account> accountEventSourcingRepository;

	@EventSourcingHandler
	void on(BaseEvent<UUID> baseEvent) {
		// Get the current state of the account domain aggregate from the event store
		Account accountAggregate = accountEventSourcingRepository.load(baseEvent.id.toString()).getWrappedAggregate()
				.getAggregateRoot();

		// Search for account entity for the account aggregate id in the account
		// repository, if found load that, else create a new account entity to store to
		// repository
		com.example.repository.entity.Account accountEntity = accountRepository.findById(accountAggregate.getId())
				.isPresent() ? accountRepository.findById(accountAggregate.getId()).get()
						: new com.example.repository.entity.Account();
		accountEntity.setId(accountAggregate.getId());
		accountEntity.setAccountBalance(accountAggregate.getAccountBalance());
		accountEntity.setCurrency(accountAggregate.getCurrency());
		accountEntity.setStatus(accountAggregate.getStatus());

		// Save or update the account entity to the repository
		accountRepository.save(accountEntity);
	}
}
