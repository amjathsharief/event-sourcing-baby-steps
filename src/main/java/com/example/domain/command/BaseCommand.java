/**
 * 
 */
package com.example.domain.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

/**
 * @author shariefa
 *
 */
public class BaseCommand<T> {
	@TargetAggregateIdentifier
	public final T id;

	public BaseCommand(T id) {
		this.id = id;
	}
}
