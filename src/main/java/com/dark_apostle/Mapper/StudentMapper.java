package com.dark_apostle.Mapper;

import com.dark_apostle.Entity.Student;
import com.dark_apostle.Entity.ThesisAuthor;
import com.dark_apostle.Entity.ThesisContent;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {


    //根据主键查人
    List<Student> getByID(Integer id);

    //前端发来json以注册学生,主键自增完成后取回主键
    @Options(useGeneratedKeys = true , keyProperty = "id")
    int RegisterStu(Student student);

    //根据主键查学号
    @Select("SELECT studentID FROM student WHERE studentID = #{id}")
    Integer checkID(Integer id);

    //根据学号查密码
    @Select("SELECT password FROM student WHERE studentID = #{studentID}")
    String loginStu(Integer studentID);

    //根据前端发来的json注册作者
    @Insert("INSERT INTO thesis_database (id,contentID,name,authorOrder) VALUE (#{id},#{contentID},#{name},#{authorOrder})")
    @Options(useGeneratedKeys = true , keyProperty = "id")
    int RegisterAuthor(ThesisAuthor author);

    //根据主键查作者身份
    @Select("SELECT * FROM thesis_database WHERE id = #{id}")
    ThesisAuthor getAuthorByID(Integer id);

    //根据作者名字，上传的论文编号查数据库
    @Select("SELECT * FROM thesis_database WHERE contentID = #{contentID} AND name = #{name}")
    ThesisAuthor getByNameANDId(String contentID,String name);

    //根据作者名字查论文标识
    @Select("SELECT contentID FROM thesis_database WHERE name = #{name}")
    String getContentIDByName(String name);

    //根据作者名字查论文标题
    List<String> getTitleByName(String name);

    //标题查对应论文
    List<String> getContentByTitle(String title);

    //写入论文
    @Insert("INSERT INTO thesis_context (contentID,content,title,isDelete) VALUES (#{contentID}," +
            "#{content},#{title},#{isDelete})")
    @Options(keyProperty = "id",useGeneratedKeys = true)
    int registerContent(ThesisContent content);

    //写入论文作者，和上面方法组合使用，要求必须是同一篇论文的作者
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int registerAuthor(@Param("author") List<ThesisAuthor> authors);
}
