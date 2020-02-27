/**
 * 
 */
package com.example.service.query;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.stereotype.Service;

import com.example.repository.AccountRepository;
import com.example.repository.entity.Account;

/**
 * @author shariefa
 *
 */
@Service
public class AccountQueryServiceImpl implements AccountQueryService {
	private final EventStore eventStore;

	private final AccountRepository accountRepository;

	public AccountQueryServiceImpl(EventStore eventStore, AccountRepository accountRepository) {
		this.eventStore = eventStore;
		this.accountRepository = accountRepository;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.example.service.query.AccountQueryService#listEventsForAccount(java.util.
	 * UUID)
	 */
	@Override
	public List<Object> listEventsForAccount(UUID accountId) {
		return eventStore.readEvents(accountId.toString()).asStream().map(s -> s.getPayload())
				.collect(Collectors.toList());
	}

	@Override
	public Account retriveAccount(UUID accountId) {
		return accountRepository.findById(accountId).get();
	}
}
