package io.nia.ipfs.gateway;

import io.ipfs.api.IPFS;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IpfsGatewayApplicationTests {

	@Test
	public void ipfs() {
		IPFS ipfs = new IPFS("localhost", 5001);
	}

}
