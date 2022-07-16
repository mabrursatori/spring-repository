package com.mabrur.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResponseData<T> {
    private Integer status;
    private List<String> messages = new ArrayList<>();
    private T payload;
}
