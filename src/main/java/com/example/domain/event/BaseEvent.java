/**
 * 
 */
package com.example.domain.event;

/**
 * @author shariefa
 *
 */
public class BaseEvent<T> {
	public final T id;

	public BaseEvent(T id) {
		this.id = id;
	}
}
