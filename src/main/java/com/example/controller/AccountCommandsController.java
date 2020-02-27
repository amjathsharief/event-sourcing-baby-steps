/**
 * 
 */
package com.example.controller;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.contract.CreateAccountRequestPayload;
import com.example.service.command.AccountService;
import com.example.service.model.Money;

import io.swagger.annotations.Api;

/**
 * @author shariefa
 *
 */
@RestController
@RequestMapping(value = "/accounts")
@Api(value = "Account Commands", tags = "Account Commands")
public class AccountCommandsController {

	@Autowired
	private AccountService accountService;

	@PostMapping
	public CompletableFuture<UUID> createAccount(@RequestBody CreateAccountRequestPayload createAccountRequestPayload) {
		return accountService.createAccount(createAccountRequestPayload.getInitialDeposit());
	}

	@PutMapping(value = "/credits/{accountNumber}")
	public void creditMoneyToAccount(@PathVariable(value = "accountNumber") UUID accountNumber,
			@RequestBody Money creditAmount) {
		accountService.creditMoneyToAccount(accountNumber, creditAmount);
	}

	@PutMapping(value = "/debits/{accountNumber}")
	public void debitMoneyFromAccount(@PathVariable(value = "accountNumber") UUID accountNumber,
			@RequestBody Money debitAmount) {
		accountService.debitMoneyFromAccount(accountNumber, debitAmount);
	}
}
