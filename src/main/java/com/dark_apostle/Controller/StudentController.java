package com.dark_apostle.Controller;

import com.dark_apostle.Entity.*;
import com.dark_apostle.Mapper.StudentMapper;
import com.dark_apostle.Response.Result;
import com.dark_apostle.Response.Unity;
import com.dark_apostle.Service.StudentService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.junit.jupiter.api.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag("学生")//@Tag说明类
@RequestMapping("/admin")
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping("/lookFor")
    @Operation(summary = "返回符合参数id的学生的集合")//@Operation说明接口
    //@Parameter说明参数
    public Unity<List<Student>> lookForStuByID(@Parameter(description = "主键id") @RequestParam Integer id){
        return Unity.success(Result.SUCCESS.getMessage(),service.list(id));
    }

    @PostMapping("/lookTitle")
    @Operation(summary = "根据名字进行模糊查询论文的标题")
    public Unity<PageInfo<String>> lookForTitleByName(@RequestBody SearchByStringDTO dto){
        Page<String> page =  PageHelper.startPage(dto.getPageNum(),
                service.parameterCheck(dto.getPageSize()));//查什么放什么
        PageInfo<String> info = new PageInfo<>(service.getTitleByName(dto.getName()));//查什么放什么
        page.close();
        return Unity.success(info);
    }

    @PutMapping("/register")
    @Operation(summary = "根据传入的ThesisDTO上传论文数据库")
    public Unity<Object> uploadThesis(@Parameter(description = "包含一个作者dto的集合" +
            "一个论文dto，其中作者dto要提供名字和排位，论文dto要提供标题和文体") @RequestBody ThesisDTO dto){
        service.registerThesis(dto.getAuthorDTO(),dto.getContentDTO());
        return Unity.success();
    }

}
