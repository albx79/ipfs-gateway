package io.nia.ipfs.gateway;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

import java.util.Arrays;
import java.util.List;

import static org.springframework.web.servlet.HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE;

@Controller
public class IpfsController {

    private final IpfsConnector connector;

    public IpfsController(IpfsConnector connector) {
        this.connector = connector;
    }

    @RequestMapping("/ipfs/**")
    public ResponseEntity<String> getArtifactFromIpfs(HttpServletRequest request) {
        String restOfTheUrl = (String) request.getAttribute(PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
        List<String> artifactPath = Arrays.asList(restOfTheUrl.split("/"));
        System.out.println("GET " + restOfTheUrl + " => " + artifactPath);
        connector.resolve(artifactPath);
        return ResponseEntity.ok("test " + restOfTheUrl);
    }
}
