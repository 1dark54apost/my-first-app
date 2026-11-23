package com.dark_apostle.Config;

import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "spring.datasource")
@Component
@Data
public class SpringDatasource {

    private String url;

    private String username;

    private String password;

    private String driverClassName;

}
