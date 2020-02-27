/**
 * 
 */
package com.example.domain.aggregate;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.UUID;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import com.example.domain.AccountStatus;
import com.example.domain.command.CreateAccountCommand;
import com.example.domain.command.CreditMoneyCommand;
import com.example.domain.command.DebitMoneyCommand;
import com.example.domain.event.AccountActivatedEvent;
import com.example.domain.event.AccountCreatedEvent;
import com.example.domain.event.AccountHeldEvent;
import com.example.domain.event.MoneyCreditedEvent;
import com.example.domain.event.MoneyDebitedEvent;

/**
 * @author shariefa
 *
 */
@Aggregate
public class Account {
	@AggregateIdentifier
	private UUID id;

	private BigDecimal accountBalance;

	private Currency currency;

	private AccountStatus status;

	public UUID getId() {
		return this.id;
	}

	public BigDecimal getAccountBalance() {
		return this.accountBalance;
	}

	public Currency getCurrency() {
		return this.currency;
	}

	public AccountStatus getStatus() {
		return this.status;
	}

	/* private protected */ Account() {
	}

	@CommandHandler
	public Account(CreateAccountCommand createAccountCommand) {
		// Create an account created event
		AggregateLifecycle.apply(new AccountCreatedEvent(createAccountCommand.id,
				createAccountCommand.initialDepositAmount, createAccountCommand.currency, System.currentTimeMillis()));
	}

	@EventSourcingHandler
	protected void on(AccountCreatedEvent accountCreatedEvent) {
		// Assign the account id
		this.id = accountCreatedEvent.id;

		// Set the account balance from the initial deposit
		this.accountBalance = accountCreatedEvent.accountBalance;
		this.currency = accountCreatedEvent.currency;

		// Set the account status to created
		this.status = AccountStatus.CREATED;

		// Create an account activated event
		AggregateLifecycle.apply(new AccountActivatedEvent(this.id, System.currentTimeMillis()));
	}

	@EventSourcingHandler
	protected void on(AccountActivatedEvent accountActivatedEvent) {
		// Set the account status to active
		this.status = AccountStatus.ACTIVE;
	}

	@CommandHandler
	protected void on(CreditMoneyCommand creditMoneyCommand) {
		AggregateLifecycle.apply(new MoneyCreditedEvent(creditMoneyCommand.id, creditMoneyCommand.creditAmount,
				creditMoneyCommand.currency, System.currentTimeMillis()));
	}

	@EventSourcingHandler
	protected void on(MoneyCreditedEvent moneyCreditedEvent) {
		final BigDecimal newBalanceAfterCredit = this.accountBalance.add(moneyCreditedEvent.creditAmount);

		if (this.accountBalance.doubleValue() < 0 && newBalanceAfterCredit.doubleValue() >= 0) {
			AggregateLifecycle.apply(new AccountActivatedEvent(this.id, System.currentTimeMillis()));
		}

		this.accountBalance = newBalanceAfterCredit;
	}

	@CommandHandler
	protected void on(DebitMoneyCommand debitMoneyCommand) {
		AggregateLifecycle.apply(new MoneyDebitedEvent(debitMoneyCommand.id, debitMoneyCommand.debitAmount,
				debitMoneyCommand.currency, System.currentTimeMillis()));
	}

	@EventSourcingHandler
	protected void on(MoneyDebitedEvent moneyDebitedEvent) {
		final BigDecimal newBalanceAfterDebit = this.accountBalance.subtract(moneyDebitedEvent.debitAmount);

		if (this.accountBalance.doubleValue() >= 0 && newBalanceAfterDebit.doubleValue() < 0) {
			AggregateLifecycle.apply(new AccountHeldEvent(this.id, System.currentTimeMillis()));
		}

		this.accountBalance = newBalanceAfterDebit;

	}

	@EventSourcingHandler
	protected void on(AccountHeldEvent accountHeldEvent) {
		this.status = AccountStatus.ON_HOLD;
	}
}
