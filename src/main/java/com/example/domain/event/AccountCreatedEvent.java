/**
 * 
 */
package com.example.domain.event;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.UUID;

/**
 * @author shariefa
 *
 */
public class AccountCreatedEvent extends BaseEvent<UUID> {
	public final BigDecimal accountBalance;
	public final Currency currency;
	public final long creationTime;

	public AccountCreatedEvent(UUID id, BigDecimal accountBalance, Currency currency, long creationTime) {
		super(id);
		this.accountBalance = accountBalance;
		this.currency = currency;
		this.creationTime = creationTime;
	}
}
