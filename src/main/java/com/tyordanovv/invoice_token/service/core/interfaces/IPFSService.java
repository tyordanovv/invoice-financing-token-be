package com.tyordanovv.invoice_token.service.core.interfaces;

public interface IPFSService
{
    /**
     * Uploads a file to the IPFS network.
     *
     * @param data the byte array representing the file to upload
     * @return the CID (Content Identifier) of the uploaded file on IPFS
     * @throws Exception if any issue occurs during the file upload
     */
    String uploadFile(byte[] data) throws Exception;

    /**
     * Downloads a file from the IPFS network.
     *
     * @param cid the CID (Content Identifier) of the file to download
     * @return the byte array representing the downloaded file
     * @throws Exception if any issue occurs during the file retrieval
     */
    byte[] downloadFile(String cid) throws Exception;

    /**
     * Pinning is the action to replicate a file (already available somewhere on the network) to our local node.
     *
     * @param cid the CID (Content Identifier) of the file to pin
     * @throws Exception if any issue occurs during the pin operation
     */
    void pinFile(String cid) throws Exception;
}
