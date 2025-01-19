package com.uas.pbo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class LoginController {
    // String nama;
    @GetMapping("/")
    public String login() {
        return "Selamat datang di aplikasi ini";
    }
}
