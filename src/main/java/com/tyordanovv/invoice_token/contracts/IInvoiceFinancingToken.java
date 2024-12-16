package com.tyordanovv.invoice_token.contracts;

import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
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
public class IInvoiceFinancingToken extends Contract {
    public static final String BINARY = "";

    private static String librariesLinkedBinary;

    public static final String FUNC_CALCULATELOCKEDCOLLATERAL = "calculateLockedCollateral";

    public static final String FUNC_CREATEINVOICETOKEN = "createInvoiceToken";

    public static final String FUNC_DEPOSITCOLLATERAL = "depositCollateral";

    public static final String FUNC_PURCHASETOKEN = "purchaseToken";

    public static final String FUNC_REDEEMTOKENS = "redeemTokens";

    public static final String FUNC_WITHDRAWCOLLATERAL = "withdrawCollateral";

    public static final Event COLLATERALDEPOSITED_EVENT = new Event("CollateralDeposited", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event COLLATERALWITHDRAWN_EVENT = new Event("CollateralWithdrawn", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event INVOICETOKENCREATED_EVENT = new Event("InvoiceTokenCreated", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>(true) {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}));
    ;

    public static final Event INVOICETOKENPURCHASED_EVENT = new Event("InvoiceTokenPurchased", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event INVOICETOKENPURCHASEDBACK_EVENT = new Event("InvoiceTokenPurchasedback", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event TOKENSREDEEMED_EVENT = new Event("TokensRedeemed", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected IInvoiceFinancingToken(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected IInvoiceFinancingToken(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected IInvoiceFinancingToken(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected IInvoiceFinancingToken(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static List<CollateralDepositedEventResponse> getCollateralDepositedEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(COLLATERALDEPOSITED_EVENT, transactionReceipt);
        ArrayList<CollateralDepositedEventResponse> responses = new ArrayList<CollateralDepositedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            CollateralDepositedEventResponse typedResponse = new CollateralDepositedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.company = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static CollateralDepositedEventResponse getCollateralDepositedEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(COLLATERALDEPOSITED_EVENT, log);
        CollateralDepositedEventResponse typedResponse = new CollateralDepositedEventResponse();
        typedResponse.log = log;
        typedResponse.company = (String) eventValues.getIndexedValues().get(0).getValue();
        typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
        return typedResponse;
    }

    public Flowable<CollateralDepositedEventResponse> collateralDepositedEventFlowable(
            EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getCollateralDepositedEventFromLog(log));
    }

    public Flowable<CollateralDepositedEventResponse> collateralDepositedEventFlowable(
            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(COLLATERALDEPOSITED_EVENT));
        return collateralDepositedEventFlowable(filter);
    }

    public static List<CollateralWithdrawnEventResponse> getCollateralWithdrawnEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(COLLATERALWITHDRAWN_EVENT, transactionReceipt);
        ArrayList<CollateralWithdrawnEventResponse> responses = new ArrayList<CollateralWithdrawnEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            CollateralWithdrawnEventResponse typedResponse = new CollateralWithdrawnEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.company = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static CollateralWithdrawnEventResponse getCollateralWithdrawnEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(COLLATERALWITHDRAWN_EVENT, log);
        CollateralWithdrawnEventResponse typedResponse = new CollateralWithdrawnEventResponse();
        typedResponse.log = log;
        typedResponse.company = (String) eventValues.getIndexedValues().get(0).getValue();
        typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
        return typedResponse;
    }

    public Flowable<CollateralWithdrawnEventResponse> collateralWithdrawnEventFlowable(
            EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getCollateralWithdrawnEventFromLog(log));
    }

    public Flowable<CollateralWithdrawnEventResponse> collateralWithdrawnEventFlowable(
            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(COLLATERALWITHDRAWN_EVENT));
        return collateralWithdrawnEventFlowable(filter);
    }

    public static List<InvoiceTokenCreatedEventResponse> getInvoiceTokenCreatedEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(INVOICETOKENCREATED_EVENT, transactionReceipt);
        ArrayList<InvoiceTokenCreatedEventResponse> responses = new ArrayList<InvoiceTokenCreatedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            InvoiceTokenCreatedEventResponse typedResponse = new InvoiceTokenCreatedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.tokenId = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.totalAmount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.tokenPrice = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.tokensTotal = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.ipfsDocumentHash = (String) eventValues.getNonIndexedValues().get(3).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static InvoiceTokenCreatedEventResponse getInvoiceTokenCreatedEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(INVOICETOKENCREATED_EVENT, log);
        InvoiceTokenCreatedEventResponse typedResponse = new InvoiceTokenCreatedEventResponse();
        typedResponse.log = log;
        typedResponse.tokenId = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
        typedResponse.totalAmount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
        typedResponse.tokenPrice = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
        typedResponse.tokensTotal = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
        typedResponse.ipfsDocumentHash = (String) eventValues.getNonIndexedValues().get(3).getValue();
        return typedResponse;
    }

    public Flowable<InvoiceTokenCreatedEventResponse> invoiceTokenCreatedEventFlowable(
            EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getInvoiceTokenCreatedEventFromLog(log));
    }

    public Flowable<InvoiceTokenCreatedEventResponse> invoiceTokenCreatedEventFlowable(
            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(INVOICETOKENCREATED_EVENT));
        return invoiceTokenCreatedEventFlowable(filter);
    }

    public static List<InvoiceTokenPurchasedEventResponse> getInvoiceTokenPurchasedEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(INVOICETOKENPURCHASED_EVENT, transactionReceipt);
        ArrayList<InvoiceTokenPurchasedEventResponse> responses = new ArrayList<InvoiceTokenPurchasedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            InvoiceTokenPurchasedEventResponse typedResponse = new InvoiceTokenPurchasedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.tokenId = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.buyer = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.tokenAmount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.paymentAmount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static InvoiceTokenPurchasedEventResponse getInvoiceTokenPurchasedEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(INVOICETOKENPURCHASED_EVENT, log);
        InvoiceTokenPurchasedEventResponse typedResponse = new InvoiceTokenPurchasedEventResponse();
        typedResponse.log = log;
        typedResponse.tokenId = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
        typedResponse.buyer = (String) eventValues.getIndexedValues().get(1).getValue();
        typedResponse.tokenAmount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
        typedResponse.paymentAmount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
        return typedResponse;
    }

    public Flowable<InvoiceTokenPurchasedEventResponse> invoiceTokenPurchasedEventFlowable(
            EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getInvoiceTokenPurchasedEventFromLog(log));
    }

    public Flowable<InvoiceTokenPurchasedEventResponse> invoiceTokenPurchasedEventFlowable(
            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(INVOICETOKENPURCHASED_EVENT));
        return invoiceTokenPurchasedEventFlowable(filter);
    }

    public static List<InvoiceTokenPurchasedbackEventResponse> getInvoiceTokenPurchasedbackEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(INVOICETOKENPURCHASEDBACK_EVENT, transactionReceipt);
        ArrayList<InvoiceTokenPurchasedbackEventResponse> responses = new ArrayList<InvoiceTokenPurchasedbackEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            InvoiceTokenPurchasedbackEventResponse typedResponse = new InvoiceTokenPurchasedbackEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.tokenId = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.buyer = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.paymentAmount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static InvoiceTokenPurchasedbackEventResponse getInvoiceTokenPurchasedbackEventFromLog(
            Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(INVOICETOKENPURCHASEDBACK_EVENT, log);
        InvoiceTokenPurchasedbackEventResponse typedResponse = new InvoiceTokenPurchasedbackEventResponse();
        typedResponse.log = log;
        typedResponse.tokenId = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
        typedResponse.buyer = (String) eventValues.getIndexedValues().get(1).getValue();
        typedResponse.paymentAmount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
        return typedResponse;
    }

    public Flowable<InvoiceTokenPurchasedbackEventResponse> invoiceTokenPurchasedbackEventFlowable(
            EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getInvoiceTokenPurchasedbackEventFromLog(log));
    }

    public Flowable<InvoiceTokenPurchasedbackEventResponse> invoiceTokenPurchasedbackEventFlowable(
            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(INVOICETOKENPURCHASEDBACK_EVENT));
        return invoiceTokenPurchasedbackEventFlowable(filter);
    }

    public static List<TokensRedeemedEventResponse> getTokensRedeemedEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(TOKENSREDEEMED_EVENT, transactionReceipt);
        ArrayList<TokensRedeemedEventResponse> responses = new ArrayList<TokensRedeemedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            TokensRedeemedEventResponse typedResponse = new TokensRedeemedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.tokenId = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.user = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.tokenAmount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.redemptionAmount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static TokensRedeemedEventResponse getTokensRedeemedEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(TOKENSREDEEMED_EVENT, log);
        TokensRedeemedEventResponse typedResponse = new TokensRedeemedEventResponse();
        typedResponse.log = log;
        typedResponse.tokenId = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
        typedResponse.user = (String) eventValues.getIndexedValues().get(1).getValue();
        typedResponse.tokenAmount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
        typedResponse.redemptionAmount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
        return typedResponse;
    }

    public Flowable<TokensRedeemedEventResponse> tokensRedeemedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getTokensRedeemedEventFromLog(log));
    }

    public Flowable<TokensRedeemedEventResponse> tokensRedeemedEventFlowable(
            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(TOKENSREDEEMED_EVENT));
        return tokensRedeemedEventFlowable(filter);
    }

    public RemoteFunctionCall<BigInteger> calculateLockedCollateral(String _company) {
        final Function function = new Function(FUNC_CALCULATELOCKEDCOLLATERAL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _company)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> createInvoiceToken(BigInteger _invoiceId,
            BigInteger _totalInvoiceAmount, BigInteger _tokenPrice, BigInteger _tokensTotal,
            BigInteger _maturityDate, String _ipfsDocumentHash, BigInteger weiValue) {
        final Function function = new Function(
                FUNC_CREATEINVOICETOKEN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_invoiceId), 
                new org.web3j.abi.datatypes.generated.Uint256(_totalInvoiceAmount), 
                new org.web3j.abi.datatypes.generated.Uint256(_tokenPrice), 
                new org.web3j.abi.datatypes.generated.Uint256(_tokensTotal), 
                new org.web3j.abi.datatypes.generated.Uint256(_maturityDate), 
                new org.web3j.abi.datatypes.Utf8String(_ipfsDocumentHash)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteFunctionCall<TransactionReceipt> depositCollateral(BigInteger weiValue) {
        final Function function = new Function(
                FUNC_DEPOSITCOLLATERAL, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteFunctionCall<TransactionReceipt> purchaseToken(BigInteger _invoiceId,
            BigInteger _tokenAmount, BigInteger weiValue) {
        final Function function = new Function(
                FUNC_PURCHASETOKEN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_invoiceId), 
                new org.web3j.abi.datatypes.generated.Uint256(_tokenAmount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteFunctionCall<TransactionReceipt> redeemTokens(BigInteger _invoiceId) {
        final Function function = new Function(
                FUNC_REDEEMTOKENS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_invoiceId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> withdrawCollateral(BigInteger _amount) {
        final Function function = new Function(
                FUNC_WITHDRAWCOLLATERAL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static IInvoiceFinancingToken load(String contractAddress, Web3j web3j,
            Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new IInvoiceFinancingToken(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static IInvoiceFinancingToken load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new IInvoiceFinancingToken(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static IInvoiceFinancingToken load(String contractAddress, Web3j web3j,
            Credentials credentials, ContractGasProvider contractGasProvider) {
        return new IInvoiceFinancingToken(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static IInvoiceFinancingToken load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new IInvoiceFinancingToken(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<IInvoiceFinancingToken> deploy(Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        return deployRemoteCall(IInvoiceFinancingToken.class, web3j, credentials, contractGasProvider, getDeploymentBinary(), "");
    }

    @Deprecated
    public static RemoteCall<IInvoiceFinancingToken> deploy(Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(IInvoiceFinancingToken.class, web3j, credentials, gasPrice, gasLimit, getDeploymentBinary(), "");
    }

    public static RemoteCall<IInvoiceFinancingToken> deploy(Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(IInvoiceFinancingToken.class, web3j, transactionManager, contractGasProvider, getDeploymentBinary(), "");
    }

    @Deprecated
    public static RemoteCall<IInvoiceFinancingToken> deploy(Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(IInvoiceFinancingToken.class, web3j, transactionManager, gasPrice, gasLimit, getDeploymentBinary(), "");
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

    public static class CollateralDepositedEventResponse extends BaseEventResponse {
        public String company;

        public BigInteger amount;
    }

    public static class CollateralWithdrawnEventResponse extends BaseEventResponse {
        public String company;

        public BigInteger amount;
    }

    public static class InvoiceTokenCreatedEventResponse extends BaseEventResponse {
        public BigInteger tokenId;

        public BigInteger totalAmount;

        public BigInteger tokenPrice;

        public BigInteger tokensTotal;

        public String ipfsDocumentHash;
    }

    public static class InvoiceTokenPurchasedEventResponse extends BaseEventResponse {
        public BigInteger tokenId;

        public String buyer;

        public BigInteger tokenAmount;

        public BigInteger paymentAmount;
    }

    public static class InvoiceTokenPurchasedbackEventResponse extends BaseEventResponse {
        public BigInteger tokenId;

        public String buyer;

        public BigInteger paymentAmount;
    }

    public static class TokensRedeemedEventResponse extends BaseEventResponse {
        public BigInteger tokenId;

        public String user;

        public BigInteger tokenAmount;

        public BigInteger redemptionAmount;
    }
}
