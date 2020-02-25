package org.example.config;

import org.springframework.context.annotation.*;


@Configuration
@ComponentScan("org.example.*")
@Import({PersistenceConfig.class})
@EnableAspectJAutoProxy
@PropertySource("classpath:application.properties")
public class AppConfig {
}