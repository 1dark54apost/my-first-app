package com.dark_apostle.Controller;

import com.dark_apostle.Entity.Student;
import com.dark_apostle.Mapper.StudentMapper;
import com.dark_apostle.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    private StudentService service;

    @Autowired
    private StudentMapper mapper;


}
