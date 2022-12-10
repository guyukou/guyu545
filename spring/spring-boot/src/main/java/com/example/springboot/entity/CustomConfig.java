package com.example.springboot.entity;

import com.example.springboot.enums.SexEnum;
import lombok.Data;

import java.util.Map;

@Data
public class CustomConfig {
    private Map<SexEnum, String> mm;
}
