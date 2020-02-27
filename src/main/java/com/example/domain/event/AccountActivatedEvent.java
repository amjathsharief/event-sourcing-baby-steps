/**
 * 
 */
package com.example.domain.event;

import java.util.UUID;

/**
 * @author shariefa
 *
 */
public class AccountActivatedEvent extends BaseEvent<UUID> {
	public final long activatedTime;

	public AccountActivatedEvent(UUID id, long activatedTime) {
		super(id);
		this.activatedTime = activatedTime;
	}
}
