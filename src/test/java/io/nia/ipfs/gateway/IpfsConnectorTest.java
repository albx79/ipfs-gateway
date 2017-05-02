package io.nia.ipfs.gateway;

import io.ipfs.api.IPFS;
import io.ipfs.multihash.Multihash;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Collections;

import static org.mockito.Answers.RETURNS_DEEP_STUBS;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IpfsConnectorTest {
    IpfsConnector connector;

    String peerId = "QmXFt8FvYZxLipZeG76gUnnw6No3QVRdFs92Xx264yNnoj";
    String repoRootHash = "QmZ76fZRuuWouQN5zSeUtixjGNB2yT6qWL253FeCmxUWv1";
    String path = "/ipfs/" + repoRootHash;

    IPFS ipfs;
    IPFS.Name ipns;
    String artifactPath = "/org/slf4j/slf4j-api/1.5.6/slf4j-api-1.5.6.pom";
    byte[] pomContent = "<pom>pom contents</pom>".getBytes();

    @Before
    public void setUp() throws Exception {
        ipfs = mock(IPFS.class, RETURNS_DEEP_STUBS);
        ipns = mock(IPFS.Name.class, RETURNS_DEEP_STUBS);
        connector = new IpfsConnector(Collections.singletonList(peerId), ipfs, ipns);
    }

    @Test
    public void resolve_name_and_fetch_artifact() throws IOException {
        when(ipns.resolve(Multihash.fromBase58(peerId))).thenReturn(path);
        when(ipfs.cat(Multihash.fromBase58(repoRootHash), artifactPath)).thenReturn(pomContent);

        byte[] content = connector.resolve(artifactPath);

        Assert.assertThat(content, CoreMatchers.equalTo(pomContent));
    }
}