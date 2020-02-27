package com.example.service.command;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import com.example.service.model.Money;

public interface AccountService {
	CompletableFuture<UUID> createAccount(Money initialDeposit);

	void creditMoneyToAccount(UUID accountId, Money creditAmount);

	void debitMoneyFromAccount(UUID accountId, Money debitAmount);
}
