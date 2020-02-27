/**
 * 
 */
package com.example.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.repository.entity.Account;
import com.example.service.query.AccountQueryService;

import io.swagger.annotations.Api;

/**
 * @author shariefa
 *
 */
@RestController
@RequestMapping(value = "/accounts")
@Api(value = "Account Queries", tags = "Account Queries")
public class AccountQueryController {

	private final AccountQueryService accountQueryService;

	public AccountQueryController(AccountQueryService accountQueryService) {
		this.accountQueryService = accountQueryService;
	}

	@GetMapping("/{accountNumber}/events")
	public List<Object> listEventsForAccount(@PathVariable(value = "accountNumber") UUID accountNumber) {
		return accountQueryService.listEventsForAccount(accountNumber);
	}

	@GetMapping("/{accountNumber}")
	public Account getAccount(@PathVariable(value = "accountNumber") UUID accountNumber) {
		return accountQueryService.retriveAccount(accountNumber);
	}
}
