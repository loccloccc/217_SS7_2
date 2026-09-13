package com.example.accountservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private Environment environment;

    /**
     * Trả về thông tin instance hiện đang xử lý request.
     * Port được lấy động từ Spring Environment - không hard-code.
     */
    @GetMapping("/info")
    public Map<String, String> getInfo() {
        String port = environment.getProperty("local.server.port");
        Map<String, String> info = new HashMap<>();
        info.put("service", "account-service");
        info.put("port", port);
        return info;
    }
}
