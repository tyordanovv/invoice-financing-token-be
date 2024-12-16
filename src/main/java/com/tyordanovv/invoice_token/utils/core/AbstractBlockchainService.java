package com.tyordanovv.invoice_token.utils.core;

import com.tyordanovv.invoice_token.utils.core.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.web3j.protocol.Web3j;

public abstract class AbstractBlockchainService {
    @Autowired
    protected Web3j web3j;

    /**
     * Generic method to execute a blockchain transaction
     * @return Transaction receipt
     */
    protected <T extends Response> T executeTransaction() { // TODO implement different responses
        return null; // TODO should execute some function which should be passed as param
    }

    /**
     * Map technical blockchain exceptions to domain-specific exceptions
     */
    protected RuntimeException mapBlockchainException(Throwable ex) {
        return new RuntimeException("Transaction failed", ex); // TODO should throw custom blockchain exception
    }
}
