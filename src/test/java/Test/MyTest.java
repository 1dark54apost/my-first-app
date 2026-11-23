package Test;


import com.dark_apostle.Config.SpringDatasource;
import com.dark_apostle.Controller.StudentController;

import com.dark_apostle.Entity.Student;
import com.dark_apostle.Entity.ThesisAuthor;
import com.dark_apostle.Mapper.StudentMapper;
import com.dark_apostle.MyFirstApp;
import com.dark_apostle.Service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.UUID;

@SpringBootTest(classes = MyFirstApp.class)
public class MyTest {
    @Autowired
    StudentMapper mapper;

    @Autowired
    private Environment environment;

    @Autowired
    private StudentService service;

    @Autowired
    private SpringDatasource datasource;

    @Value("${spring.datasource.password}")
    private String password;

    @org.junit.jupiter.api.Test
    public void test(){
        System.out.println(datasource.getDriverClassName());
    }
}
