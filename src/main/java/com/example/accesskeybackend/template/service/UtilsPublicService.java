package com.example.accesskeybackend.template.service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.net.*;

@Service
@AllArgsConstructor
@Log4j2
public class UtilsPublicService {

    public Boolean checkIpv6Support(String siteUrl) {
        URI uri = null;
        try {
            uri = new URI(siteUrl);
        } catch (URISyntaxException e) {
            log.error("Not valid domain: {}", siteUrl);
            e.printStackTrace();
            return false;
        }
        String domain = (uri.getHost()) != null ? uri.getHost() : siteUrl;

        try {
            InetAddress addr = InetAddress.getByName(domain);
            return addr instanceof Inet6Address;
        } catch (UnknownHostException e) {
            System.out.println("Unable to resolve host name: " + e.getMessage());
            return false;
        }
    }
}
