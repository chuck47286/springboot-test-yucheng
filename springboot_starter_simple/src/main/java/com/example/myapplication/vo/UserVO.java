package com.example.myapplication.vo;

import lombok.Data;

@Data
public class UserVO implements BaseVO{
    int userId;
    String userName;
    int age;
    String gender;
}
