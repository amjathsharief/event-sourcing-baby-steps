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
public class MoneyCreditedEvent extends BaseEvent<UUID> {
	public final BigDecimal creditAmount;
	public final Currency currency;
	public final long creditTime;

	public MoneyCreditedEvent(UUID id, BigDecimal creditAmount, Currency currency, long creditTime) {
		super(id);
		this.creditAmount = creditAmount;
		this.currency = currency;
		this.creditTime = creditTime;
	}
}
