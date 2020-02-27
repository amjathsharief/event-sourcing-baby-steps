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
public class MoneyDebitedEvent extends BaseEvent<UUID> {
	public final BigDecimal debitAmount;
	public final Currency currency;
	public final long debitTime;

	public MoneyDebitedEvent(UUID id, BigDecimal debitAmount, Currency currency, long debitTime) {
		super(id);
		this.debitAmount = debitAmount;
		this.currency = currency;
		this.debitTime = debitTime;
	}
}
