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
public class DebitMoneyCommand extends BaseCommand<UUID> {
	public final BigDecimal debitAmount;
	public final Currency currency;

	public DebitMoneyCommand(UUID id, BigDecimal debitAmount, Currency currency) {
		super(id);
		this.debitAmount = debitAmount;
		this.currency = currency;
	}
}
