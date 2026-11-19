package com.dark_apostle.Service;

import com.dark_apostle.Entity.Student;
import com.dark_apostle.Mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentMapper mapper;


    public List<Student> list(Integer id){
        return mapper.getByID(id);
    }

    public List<String> getTitleByName(String name){
        return mapper.getTitleByName(name);
    }

    //学生注册功能将密码加密后存入数据库
    public Integer RegisterStu(Student student){
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        student.setPassword(encoder.encode(student.getPassword()));
        return mapper.RegisterStu(student);
    }


}
