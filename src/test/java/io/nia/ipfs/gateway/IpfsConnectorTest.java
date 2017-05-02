package io.nia.ipfs.gateway;

import io.ipfs.api.IPFS;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.Assert.*;

public class IpfsConnectorTest {
    IpfsConnector connector;

    String hash1 = "asfjasdklf";
    String hash2 = "joukjoom";

    IPFS ipfs;



    @Before
    public void setUp() throws Exception {
        ipfs = Mockito.mock(IPFS.class, Answers.RETURNS_DEEP_STUBS);
        connector = new IpfsConnector(Arrays.asList(hash1, hash2), ipfs);
    }

    @Test
    public void resolve_name_and_fetch_artifact() throws IOException {
        String path = "/ipfs/hashhashhash";
        Mockito.when(ipfs.name.resolve(null)).thenReturn(path);
    }
}