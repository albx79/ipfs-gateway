package io.nia.ipfs.gateway;

import io.ipfs.api.IPFS;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static java.util.Arrays.asList;

@SpringBootApplication
public class IpfsGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(IpfsGatewayApplication.class, args);
	}

	@Bean
	public IpfsController ipfsController(IpfsConnector connector) {
		return new IpfsController(connector);
	}

	@Bean
	public IPFS ipfs(@Value("ipfs.host") String ipfsHost, @Value("ipfs.port") int ipfsPort) {
		return new IPFS(ipfsHost, ipfsPort);
	}

	@Bean
	public IpfsConnector ipfsConnector(@Value("ipns.hashes") String hashes, IPFS ipfs) {
		return new IpfsConnector(asList(hashes.split(",")), ipfs);
	}
}
