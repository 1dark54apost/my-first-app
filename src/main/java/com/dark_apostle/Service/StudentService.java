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
import java.util.Objects;
import java.util.UUID;

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
    public Integer RegisterStu(StudentDTO dto){
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        Student st = new Student(dto,encoder.encode(dto.getPassword()));
        return mapper.RegisterStu(st);
    }

    @Transactional//注册论文系统
    public int registerThesis(List<ThesisAuthorDTO> authors,ThesisContentDTO contentDTO) throws RuntimeException{
        if (!checkOrder(authors)){
            throw new RuntimeException("重复的作者排位！");
        }
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

    private boolean checkOrder(List<ThesisAuthorDTO> dto){
        for (int i = 1;i<dto.size();i++){
            if (Objects.equals(dto.get(0).getAuthorOrder(),dto.get(i).getAuthorOrder())){
                return false;
            }
        }
        return true;
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

    //用来检查pageSize的方法
    public Integer parameterCheck(Integer pageSize){
        if (pageSize > 50){
            return 50;
        }else if (pageSize < 10){
            return 10;
        }else {
            return pageSize;
        }
    }


}
