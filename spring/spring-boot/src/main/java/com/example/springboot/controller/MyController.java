package com.example.springboot.controller;

import com.example.springboot.entity.ReportConfigVo;
import com.example.springboot.enums.SexEnum;
import com.example.springboot.prototype.MyProto;
import com.example.springboot.service.MyService;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/")
public class MyController {

    @Autowired
    private MyService myService;
    @Autowired
    private ApplicationContext applicationContext;

    @GetMapping("/commonReport/index/经纪人报表")
    public String get(HttpServletRequest request) {
        String url = request.getRequestURI();
        try {
            String result = URLDecoder.decode(url, StandardCharsets.UTF_8.name());
            System.out.println(result);
        } catch (UnsupportedEncodingException e) {
            // not going to happen - value came from JDK's own StandardCharsets
        }

        return "ok";
    }

    @GetMapping("/test")
    public MyVO test(@RequestParam("name") String name) {
        MyVO myVO = new MyVO();
        myVO.setId(12);
        myVO.setSexEnum(SexEnum.MALE);
        System.out.println(name);

        return myVO;
    }

    @Autowired
    private MyProto2 myProto2;
    @GetMapping("/test2")
    public Object test2() throws InterruptedException {
        System.out.println(myProto2);
        System.out.println(myProto2);
        TimeUnit.MILLISECONDS.sleep(1500);
        return "ok";
    }

    @Data
    public static class MyRequest {
        private String name;
        private int age;

    }

    @PostMapping("/save")
    public String save(@RequestBody @Valid ReportConfigVo reportConfigVo) {
        System.out.println(reportConfigVo);
        return "ok";
    }

    @Data
    private static class MyVO {
        private int id;
        @JsonSerialize(using = SexEnumSerializer.class)
        private SexEnum sexEnum;
    }
    public static class SexEnumSerializer  extends JsonSerializer<SexEnum> {

        @Override
        public void serialize(SexEnum value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeNumber(value.getCode());
        }
    }

    @Component
    @Scope(proxyMode = ScopedProxyMode.TARGET_CLASS, value = "prototype")
    public static class MyProto2 {
        private int i = new Random().nextInt(100);

        @Override
        public String toString() {
            return "MyProto2{" +
                    "i=" + i +
                    '}';
        }
    }
}
