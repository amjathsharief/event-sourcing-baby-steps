/**
 * 
 */
package com.example.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.example.repository.entity.Account;

/**
 * @author shariefa
 *
 */
public interface AccountRepository extends CrudRepository<Account, UUID> {
}
