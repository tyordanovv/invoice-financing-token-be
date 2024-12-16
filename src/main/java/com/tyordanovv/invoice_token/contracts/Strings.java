package com.tyordanovv.invoice_token.contracts;

import java.math.BigInteger;
import java.util.List;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/hyperledger/web3j/tree/main/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.12.1.
 */
@SuppressWarnings("rawtypes")
public class Strings extends Contract {
    public static final String BINARY = "60556032600b8282823980515f1a607314602657634e487b7160e01b5f525f60045260245ffd5b305f52607381538281f3fe730000000000000000000000000000000000000000301460806040525f80fdfea2646970667358221220dcb82d1bd450e45e54771092da417014af04fa92a30cafceb3b1530993efa7fb64736f6c634300081a0033";

    private static String librariesLinkedBinary;

    @Deprecated
    protected Strings(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Strings(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Strings(String contractAddress, Web3j web3j, TransactionManager transactionManager,
            BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Strings(String contractAddress, Web3j web3j, TransactionManager transactionManager,
            ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    @Deprecated
    public static Strings load(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        return new Strings(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Strings load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Strings(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Strings load(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        return new Strings(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Strings load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Strings(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Strings> deploy(Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Strings.class, web3j, credentials, contractGasProvider, getDeploymentBinary(), "");
    }

    @Deprecated
    public static RemoteCall<Strings> deploy(Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Strings.class, web3j, credentials, gasPrice, gasLimit, getDeploymentBinary(), "");
    }

    public static RemoteCall<Strings> deploy(Web3j web3j, TransactionManager transactionManager,
            ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Strings.class, web3j, transactionManager, contractGasProvider, getDeploymentBinary(), "");
    }

    @Deprecated
    public static RemoteCall<Strings> deploy(Web3j web3j, TransactionManager transactionManager,
            BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Strings.class, web3j, transactionManager, gasPrice, gasLimit, getDeploymentBinary(), "");
    }

    public static void linkLibraries(List<Contract.LinkReference> references) {
        librariesLinkedBinary = linkBinaryWithReferences(BINARY, references);
    }

    private static String getDeploymentBinary() {
        if (librariesLinkedBinary != null) {
            return librariesLinkedBinary;
        } else {
            return BINARY;
        }
    }
}