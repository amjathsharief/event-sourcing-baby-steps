/**
 * 
 */
package com.example.domain.event;

import java.util.UUID;

/**
 * @author shariefa
 *
 */
public class AccountHeldEvent extends BaseEvent<UUID> {
	public final long heldTime;

	public AccountHeldEvent(UUID id, long heldTime) {
		super(id);
		this.heldTime = heldTime;
	}
}
