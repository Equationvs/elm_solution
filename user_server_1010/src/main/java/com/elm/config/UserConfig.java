package com.elm.config;
import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@Configuration
@MapperScan("com.elm.mapper")
public class UserConfig {
    /*逻辑删除*/
    @Bean
    public ISqlInjector sqlInjector(){
        return new LogicSqlInjector();
    }
}
