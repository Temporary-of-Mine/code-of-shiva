package cn.shiva.activitisecond;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("cn.shiva.activitisecond.mapper")
@SpringBootApplication
public class ActivitiSecondApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActivitiSecondApplication.class, args);
    }

}
