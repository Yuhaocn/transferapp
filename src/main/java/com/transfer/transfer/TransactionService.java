package com.transfer.transfer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class TransactionService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    private static final Logger log = LoggerFactory.getLogger(TransactionService.class);

    public List<Transaction> getTransactionsByUserId(Long userId) {
        // Implement logic to retrieve transactions by user ID
        return transactionRepository.findBySenderIdOrReceiverIdOrderByTimestampDesc(userId, userId);
    }

    public void initiateTransaction(TransactionRequest transactionRequest) {
        // Implement logic to initiate the transaction
        // Retrieve sender and receiver information
        User sender = userRepository.findByUsername(transactionRequest.getSenderUsername())
                .orElseThrow(() -> new IllegalArgumentException("Sender not found"));

        User receiver = userRepository.findByUsername(transactionRequest.getReceiverUsername())
                .orElseThrow(() -> new IllegalArgumentException("Receiver not found"));
                log.debug("Sender: {}", sender);
                log.debug("Receiver: {}", receiver);

        // Validate amount
        if (transactionRequest.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Invalid amount");
        }

        // Perform the transaction
        if (sender.getAmount().compareTo(transactionRequest.getAmount()) >= 0) {
            // Update sender's amount
            sender.setAmount(sender.getAmount().subtract(transactionRequest.getAmount()));
            userRepository.save(sender);

            // Update receiver's amount
            receiver.setAmount(receiver.getAmount().add(transactionRequest.getAmount()));
            userRepository.save(receiver);

            // Record the transaction
            Transaction transaction = new Transaction();
            transaction.setSenderId(sender.getId());
            transaction.setReceiverId(receiver.getId());
            transaction.setAmount(transactionRequest.getAmount());
            transaction.setTimestamp(LocalDateTime.now());
            transactionRepository.save(transaction);
        } else {
            throw new IllegalArgumentException("Insufficient funds");
        }
    }
}
