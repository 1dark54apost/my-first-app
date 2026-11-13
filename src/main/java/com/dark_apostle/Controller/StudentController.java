package com.dark_apostle.Controller;

import com.dark_apostle.Entity.Student;
import com.dark_apostle.Mapper.StudentMapper;
import com.dark_apostle.Service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.junit.jupiter.api.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag("学生")//@Tag说明类
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping("/lookFor")
    @Operation(summary = "返回符合参数id的学生的集合")//@Operation说明接口
    //@Parameter说明参数
    public List<Student> lookForStuByID(@Parameter(description = "主键id") @RequestParam Integer id){
        return service.list(id);
    }


}
