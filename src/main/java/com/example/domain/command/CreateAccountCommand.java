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
public class CreateAccountCommand extends BaseCommand<UUID> {
	public final BigDecimal initialDepositAmount;
	public final Currency currency;

	public CreateAccountCommand(UUID id, BigDecimal initialDepositAmount, Currency currency) {
		super(id);
		this.initialDepositAmount = initialDepositAmount;
		this.currency = currency;
	}
}
