package io.nia.ipfs.gateway;

import io.ipfs.api.IPFS;
import java.util.List;

public class IpfsConnector {
    private final List<String> ipnsHashes;
    private final IPFS ipfs;

    public IpfsConnector(List<String> ipnsHashes, IPFS ipfs) {
        this.ipnsHashes = ipnsHashes;
        this.ipfs = ipfs;
    }

    // TODO implement. It should return something useful
    public Void resolve(List<String> artifactPath) {
        return null;
    }
}
