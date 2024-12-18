package com.tyordanovv.invoice_token.service.core;

import io.ipfs.api.IPFS;
import io.ipfs.api.MerkleNode;
import io.ipfs.api.NamedStreamable;
import io.ipfs.multibase.Base58;
import io.ipfs.multihash.Multihash;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class IPFSServiceImplTest {

    @Mock
    private IPFS ipfs;

    @Mock
    private IPFS.Pin pin;

    @InjectMocks
    private IPFSServiceImpl ipfsService;
    private String hash;
    private byte[] data;
    private MerkleNode merkleNode;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        hash = "QmTzQ1K4a8tYxj7rHhpgj2Y62UpE1W6ukdLtG2fhu2ksrY";
        data = "hello".getBytes();
        merkleNode = new MerkleNode(hash);

    }

    @Test
    void testUploadFile() throws IOException {
        when(ipfs.add(any(NamedStreamable.class))).thenReturn(Collections.singletonList(merkleNode));

        String result = ipfsService.uploadFile(data);

        assertNotNull(result);
        assertEquals(hash, result);
        verify(ipfs, times(1)).add(any(NamedStreamable.class));
    }

    @Test
    void testDownloadFile() throws IOException {
        when(ipfs.cat(any(Multihash.class))).thenReturn(data);

        byte[] result = ipfsService.downloadFile(hash);

        assertNotNull(result);
        assertArrayEquals(data, result);
        verify(ipfs, times(1)).cat(any(Multihash.class));
    }
}