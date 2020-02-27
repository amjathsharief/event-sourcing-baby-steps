/**
 * 
 */
package com.example.service.model;

import java.math.BigDecimal;
import java.util.Currency;

/**
 * @author shariefa
 *
 */
public class Money {
	public final BigDecimal amount;
	public final Currency currency;

	public Money(BigDecimal amount, Currency currency) {
		this.amount = amount;
		this.currency = currency;
	}
}
