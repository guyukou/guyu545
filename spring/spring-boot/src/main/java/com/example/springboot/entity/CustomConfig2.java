package com.example.springboot.entity;

import com.example.springboot.enums.SexEnum;
import lombok.Data;

import java.util.Map;

@Data
public class CustomConfig2 {
    private Map<String, SexEnum> mm;
}
