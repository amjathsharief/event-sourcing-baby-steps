/**
 * 
 */
package com.example.service.query;

import java.util.List;
import java.util.UUID;

import com.example.repository.entity.Account;

/**
 * @author shariefa
 *
 */
public interface AccountQueryService {
	List<Object> listEventsForAccount(UUID accountId);

	Account retriveAccount(UUID accountId);
}
