package com.tyordanovv.invoice_token.service.core;

import io.ipfs.api.IPFS;
import io.ipfs.multihash.Multihash;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.charset.StandardCharsets;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class IPFSServiceImplIntegrationTest {

    @Autowired
    private IPFSServiceImpl ipfsService;

    @Autowired
    private IPFS ipfs;

    private String testFileHash;

    @BeforeEach
    void setUp() {
        String content = "This is a test file for IPFS.";
        byte[] data = content.getBytes(StandardCharsets.UTF_8);
        testFileHash = ipfsService.uploadFile(data);
    }

    @Test
    void testUploadFile() throws Exception {
        assertNotNull(testFileHash, "The file hash should not be null");
        assertFalse(testFileHash.isEmpty(), "The file hash should not be empty");

        Multihash multihash = Multihash.fromBase58(testFileHash);
        byte[] fileContent = ipfs.cat(multihash);
        String fileString = new String(fileContent, StandardCharsets.UTF_8);

        assertEquals("This is a test file for IPFS.", fileString, "The file content should match.");
    }

    @Test
    void testDownloadFile() throws Exception {
        byte[] fileContent = ipfsService.downloadFile(testFileHash);
        String fileString = new String(fileContent, StandardCharsets.UTF_8);

        assertEquals("This is a test file for IPFS.", fileString, "The file content should match.");
    }

    @Test
    void testPinFile() throws Exception {
        Multihash multihashKey = Multihash.fromBase58(testFileHash);

        assertDoesNotThrow(() -> {
            ipfsService.pinFile(testFileHash);
        });

        Map<Multihash, Object> pinnedFiles = ipfs.pin.ls(IPFS.PinType.all);

        assertNotNull(pinnedFiles.get(multihashKey), "File should be pinned in IPFS");
        assertTrue(pinnedFiles.containsKey(multihashKey), "File CID should be present in pinned files");
    }
}