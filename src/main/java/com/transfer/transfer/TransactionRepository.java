package com.transfer.transfer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findBySenderIdOrReceiverIdOrderByTimestampDesc(Long senderId, Long receiverId);
}
