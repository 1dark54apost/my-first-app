package com.dark_apostle.Mapper;

import com.dark_apostle.Entity.Student;
import org.apache.ibatis.annotations.*;

@Mapper
public interface StudentMapper {

    @Options(useGeneratedKeys = true , keyProperty = "id")
    int RegisterStu(Student student);

    @Select("SELECT studentID FROM student WHERE studentID = #{id}")
    Integer checkID(Integer id);

    @Select("SELECT password FROM student WHERE studentID = #{studentID}")
    String loginStu(Integer studentID);


}
