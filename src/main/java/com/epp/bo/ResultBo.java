package com.epp.bo;
/*
"code": 0
  ,"msg": ""
  ,"count": 1000*/

import lombok.Data;

import java.util.List;

@Data
public class ResultBo<T>{
    private int code;
    private String msg;
    private int count;
    private List<T> data;
}
