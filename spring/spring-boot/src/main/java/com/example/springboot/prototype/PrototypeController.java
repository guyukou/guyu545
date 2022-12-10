package com.example.springboot.prototype;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guyu06
 * @date 2022/11/27 12:15
 */
@RequestMapping("/prototype")
@RestController
public class PrototypeController {
    @Autowired
    private ObjectFactory<MyProto> myProtoProvider;

    @GetMapping("/test")
    public String test() {
        MyProto myProto1 = myProtoProvider.getObject();
        return myProto1 + myProto1.toString();
    }
}
