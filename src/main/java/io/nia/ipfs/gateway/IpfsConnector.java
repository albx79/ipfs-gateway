package io.nia.ipfs.gateway;

import io.ipfs.api.IPFS;
import io.ipfs.multihash.Multihash;

import java.io.IOException;
import java.util.List;

public class IpfsConnector {
    private final List<String> ipnsHashes;
    private final IPFS ipfs;
    private final IPFS.Name ipns;

    public IpfsConnector(List<String> ipnsHashes, IPFS ipfs, IPFS.Name ipns) {
        this.ipnsHashes = ipnsHashes;
        this.ipfs = ipfs;
        this.ipns = ipns;
    }

    // TODO implement. It should return something useful
    public byte[] resolve(String artifactPath) throws IOException {
        String repoRoot = ipns.resolve(Multihash.fromBase58(ipnsHashes.get(0)));
        String repoHash = repoRoot.substring("/ipfs/".length());
        return ipfs.cat(Multihash.fromBase58(repoHash), artifactPath);
    }
}
