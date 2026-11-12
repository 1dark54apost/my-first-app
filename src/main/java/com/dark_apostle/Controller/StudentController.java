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
@Tag("学生")
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping("/lookFor")
    @Operation(summary = "根据id返回符合条件的学生")
    public List<Student> lookForStuByID(@Parameter(description = "主键id") @RequestParam Integer id){
        return service.list(id);
    }


}
