package io.nia.ipfs.gateway;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

import java.io.IOException;

import static org.springframework.web.servlet.HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE;

@Controller
public class IpfsController {

    private final IpfsConnector connector;

    public IpfsController(IpfsConnector connector) {
        this.connector = connector;
    }

    @RequestMapping("/ipfs/**")
    public ResponseEntity<byte[]> getArtifactFromIpfs(HttpServletRequest request) throws IOException {
        String restOfTheUrl = (String) request.getAttribute(PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
        String artifactPath = restOfTheUrl.substring("/ipfs".length());
        System.out.println("GET " + restOfTheUrl + " => " + artifactPath);
        return ResponseEntity.ok(connector.resolve(artifactPath));
    }
}
