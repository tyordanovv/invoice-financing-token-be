package com.tyordanovv.invoice_token.config;

import io.ipfs.api.IPFS;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration TODO uncomment when ipfs connection is available
public class IPFSConfig {

    @Value("${ipfs.url}")
    private String ipfsUrl;

    @Bean
    public IPFS ipfs() {
        return new IPFS(ipfsUrl);
    }
}