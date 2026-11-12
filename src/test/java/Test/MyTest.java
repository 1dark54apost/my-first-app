package Test;


import com.dark_apostle.Controller.StudentController;

import com.dark_apostle.Entity.ThesisAuthor;
import com.dark_apostle.Mapper.StudentMapper;
import com.dark_apostle.MyFirstApp;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

@SpringBootTest(classes = MyFirstApp.class)
public class MyTest {
    @Autowired
    StudentMapper mapper;

    @Autowired
    private Environment environment;

    @Autowired
    private StudentController st;


    @org.junit.jupiter.api.Test
    public void test(){

    }
}
