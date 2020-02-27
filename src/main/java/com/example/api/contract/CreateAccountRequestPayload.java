/**
 * 
 */
package com.example.api.contract;

import com.example.service.model.Money;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author shariefa
 *
 */
@JsonDeserialize(builder = CreateAccountRequestPayload.Builder.class)
public class CreateAccountRequestPayload {
	private Money initialDeposit;

	public Money getInitialDeposit() {
		return this.initialDeposit;
	}

	private CreateAccountRequestPayload(Builder builder) {
		this.initialDeposit = builder.initialDeposit;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private Money initialDeposit;

		private Builder() {
		}

		public Builder withInitialDeposit(Money initialDeposit) {
			this.initialDeposit = initialDeposit;
			return this;
		}

		public CreateAccountRequestPayload build() {
			return new CreateAccountRequestPayload(this);
		}
	}
}
