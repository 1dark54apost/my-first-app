package com.dark_apostle.Entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {

    private Integer id;

    //名字
    private String name;

    //学号唯一
    private Integer studentID;

    //班级
    private Integer classID;

    //宿舍号
    private String dormID;

    //密码
    private String password;

    public Student(StudentDTO dto,String password){
        name = dto.getName();
        studentID = dto.getStudentID();
        classID = dto.getClassID();
        dormID = dto.getDormID();
        this.password = password;
    }

}
