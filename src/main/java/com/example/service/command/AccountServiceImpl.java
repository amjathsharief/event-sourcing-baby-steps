/**
 * 
 */
package com.example.service.command;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.command.CreateAccountCommand;
import com.example.domain.command.CreditMoneyCommand;
import com.example.domain.command.DebitMoneyCommand;
import com.example.service.model.Money;

/**
 * @author shariefa
 *
 */
@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private CommandGateway commandGateway;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.example.service.command.AccountService#createAccount(com.example.service.
	 * model.Money)
	 */
	@Override
	public CompletableFuture<UUID> createAccount(Money initialDeposit) {
		return commandGateway
				.send(new CreateAccountCommand(UUID.randomUUID(), initialDeposit.amount, initialDeposit.currency));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.example.service.command.AccountService#creditMoneyToAccount(java.util.
	 * UUID, com.example.service.model.Money)
	 */
	@Override
	public void creditMoneyToAccount(UUID accountId, Money creditAmount) {
		commandGateway.send(new CreditMoneyCommand(accountId, creditAmount.amount, creditAmount.currency));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.example.service.command.AccountService#debitMoneyFromAccount(java.util.
	 * UUID, com.example.service.model.Money)
	 */
	@Override
	public void debitMoneyFromAccount(UUID accountId, Money debitAmount) {
		commandGateway.send(new DebitMoneyCommand(accountId, debitAmount.amount, debitAmount.currency));
	}
}
