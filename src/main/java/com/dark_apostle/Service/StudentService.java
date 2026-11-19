package com.dark_apostle.Service;

import com.dark_apostle.Entity.*;
import com.dark_apostle.Mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class StudentService {

    @Autowired
    private StudentService service;

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

    @Transactional
    public int registerThesis(List<ThesisAuthorDTO> authors,ThesisContentDTO contentDTO) throws RuntimeException{
        ThesisContent content = new ThesisContent(contentDTO,strID(),false);
        List<ThesisAuthor> author = new ArrayList<>();
        for (ThesisAuthorDTO dto : authors){
            author.add(new ThesisAuthor(dto,content.getContentID()));
        }
        int a = 0;
        int b = 0;
        while (true){
            try{
                a = mapper.registerAuthor(author);
                b = mapper.registerContent(content);
                break;
            }catch (DuplicateKeyException e){
                String str = rebornID(content.getContentID());
                content.setContentID(str);
                for (ThesisAuthor author1 : author){
                    author1.setContentID(str);
                }
                continue;
            }
        }
        if (a > 0 && b > 0){
            return 1;
        }else {
            throw new RuntimeException("出错了");
        }

    }

    private String strID(){
        UUID uuid = UUID.randomUUID();
        LocalDate date = LocalDate.now();
        return uuid.toString().substring(9) + date.toString();
    }

    private String rebornID(String oldStr){
        String str;
        do {
            str = strID();
        } while (str.equals(oldStr));
        return str;
    }

}
