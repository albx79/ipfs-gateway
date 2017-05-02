package io.nia.ipfs.gateway;

import java.util.List;

public class IpfsConnector {
    private final List<String> ipnsHashes;

    public IpfsConnector(List<String> ipnsHashes) {
        this.ipnsHashes = ipnsHashes;

    }

    // TODO implement. It should return something useful
    public Void resolve(List<String> artifactPath) {
        return null;
    }
}
