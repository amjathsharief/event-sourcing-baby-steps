/**
 * 
 */
package com.example.repository.entity;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.example.domain.AccountStatus;

/**
 * @author shariefa
 *
 */
@Entity
public class Account {

	@Id
	private UUID id;

	private BigDecimal accountBalance;

	private Currency currency;

	private AccountStatus status;

	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public BigDecimal getAccountBalance() {
		return this.accountBalance;
	}

	public void setAccountBalance(BigDecimal accountBalance) {
		this.accountBalance = accountBalance;
	}

	public Currency getCurrency() {
		return this.currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public AccountStatus getStatus() {
		return this.status;
	}

	public void setStatus(AccountStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Account [" + (this.id != null ? "id=" + this.id + ", " : "")
				+ (this.accountBalance != null ? "accountBalance=" + this.accountBalance + ", " : "")
				+ (this.currency != null ? "currency=" + this.currency + ", " : "")
				+ (this.status != null ? "status=" + this.status : "") + "]";
	}
}
