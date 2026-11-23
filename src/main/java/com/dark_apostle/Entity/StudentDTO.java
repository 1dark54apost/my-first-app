package com.dark_apostle.Entity;


import lombok.Data;

@Data
public class StudentDTO {

    private String name;

    //学号唯一
    private Integer studentID;

    //班级
    private Integer classID;

    //宿舍号
    private String dormID;

    //密码
    private String password;


}
