/**
 * 
 */
package com.example.config;

import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.domain.aggregate.Account;

/**
 * @author shariefa
 *
 */
@Configuration
public class AxonConfig {
	@Bean
	public EventSourcingRepository<Account> accountEventSourcingRepository(EventStore eventStore) {
		return EventSourcingRepository.builder(Account.class).eventStore(eventStore).build();
	}
}
