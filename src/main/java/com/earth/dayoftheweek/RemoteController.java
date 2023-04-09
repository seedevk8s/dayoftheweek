package com.earth.dayoftheweek;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 1. 원격 프로그램으로 등록
@RestController
public class RemoteController {
    // 2. URL과 메서드를 연결
    @RequestMapping("/")
    public String earth() {
        System.out.println("Hi Spring Boot!");
        return "Hi Spring Boot!";
    }
}
