package com.example.accesskeybackend.template.controller;

import com.example.accesskeybackend.template.service.UtilsPublicService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/web")
@AllArgsConstructor
public class UtilsPublicController {

    private final UtilsPublicService utilsService;

    @GetMapping("/checkIpv6Support")
    public Boolean checkIpv6Support(@RequestParam String siteUrl) {
        return utilsService.checkIpv6Support(siteUrl);
    }
}
