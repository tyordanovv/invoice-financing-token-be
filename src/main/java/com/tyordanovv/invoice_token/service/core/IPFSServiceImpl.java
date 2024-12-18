package com.tyordanovv.invoice_token.service.core;

import com.tyordanovv.invoice_token.service.core.interfaces.IPFSService;
import com.tyordanovv.invoice_token.utils.core.AbstractBlockchainService;
import io.ipfs.api.IPFS;
import io.ipfs.api.MerkleNode;
import io.ipfs.api.NamedStreamable;
import io.ipfs.multihash.Multihash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class IPFSServiceImpl
        extends AbstractBlockchainService
        implements IPFSService
{
    @Autowired
    private IPFS ipfs;

    @Override
    public String uploadFile(byte[] data) {
        try {
            NamedStreamable.ByteArrayWrapper bytearray = new NamedStreamable.ByteArrayWrapper(data);
            MerkleNode result = ipfs.add(bytearray).get(0);
            System.out.println("Hash (base 58): " + result.hash.toBase58());
            return result.hash.toString();
        } catch (IOException ex) {
            throw new RuntimeException("Error whilst communicating with the IPFS node", ex);
        }
    }

    @Override
    public byte[] downloadFile(String cid) {
        try {
            Multihash multihash = Multihash.fromBase58(cid);
            return ipfs.cat(multihash);
        } catch (IOException ex) {
            throw new RuntimeException("Error whilst communicating with the IPFS node", ex);
        }
    }

    @Override
    public void pinFile(String cid) throws Exception {
        try {
            Multihash multihash = Multihash.fromBase58(cid);
            ipfs.pin.add(multihash);
        } catch (IOException ex) {
            throw new RuntimeException("Error whilst communicating with the IPFS node", ex);
        }
    }

    private Multihash decodeString(String cid){
        return Multihash.decode(cid);
    }
}
