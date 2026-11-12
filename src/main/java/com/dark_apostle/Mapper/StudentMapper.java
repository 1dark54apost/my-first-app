package com.dark_apostle.Mapper;

import com.dark_apostle.Entity.Student;
import com.dark_apostle.Entity.ThesisAuthor;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {


    List<Student> getByID(Integer id);

    @Options(useGeneratedKeys = true , keyProperty = "id")
    int RegisterStu(Student student);

    @Select("SELECT studentID FROM student WHERE studentID = #{id}")
    Integer checkID(Integer id);

    @Select("SELECT password FROM student WHERE studentID = #{studentID}")
    String loginStu(Integer studentID);

    @Insert("INSERT INTO thesis_database (id,contentID,name,authorOrder) VALUE (#{id},#{contentID},#{name},#{authorOrder})")
    @Options(useGeneratedKeys = true , keyProperty = "id")
    int RegisterAuthor(ThesisAuthor author);

    @Select("SELECT * FROM thesis_database WHERE id = #{id}")
    ThesisAuthor getAuthorByID(Integer id);

}
