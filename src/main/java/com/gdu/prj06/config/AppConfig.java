package com.gdu.prj06.config;

import com.gdu.prj06.aspect.MyAfterAspect;
import com.gdu.prj06.aspect.MyAroundAspect;
import com.gdu.prj06.aspect.MyBeforeAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@Configuration
public class AppConfig {

    @Bean
    public MyAroundAspect myAroundAspect(){
        return new MyAroundAspect();
    }

    @Bean
    public MyBeforeAspect myBeforeAspect(){
        return new MyBeforeAspect();
    }

    @Bean
    public MyAfterAspect myAfterAspect(){
        return new MyAfterAspect();
    }
}
