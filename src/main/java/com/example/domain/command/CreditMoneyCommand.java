/**
 * 
 */
package com.example.domain.command;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.UUID;

/**
 * @author shariefa
 *
 */
public class CreditMoneyCommand extends BaseCommand<UUID> {
	public final BigDecimal creditAmount;
	public final Currency currency;

	public CreditMoneyCommand(UUID id, BigDecimal creditAmount, Currency currency) {
		super(id);
		this.creditAmount = creditAmount;
		this.currency = currency;
	}
}
