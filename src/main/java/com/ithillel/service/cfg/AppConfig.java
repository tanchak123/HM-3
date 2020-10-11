package com.ithillel.service.cfg;

import com.ithillel.service.textprocessor.InMemoryTextProcessor;
import com.ithillel.service.textprocessor.TextProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.ithillel")
@ImportResource("classpath:/springCfg.xml")
public class AppConfig {

    public static TextProcessor textProcessor;

    public static void main(String[] args) {
        ApplicationContext applicationContext = new
                AnnotationConfigApplicationContext(AppConfig.class);
        InMemoryTextProcessor inMemoryTextProcessor = (InMemoryTextProcessor) applicationContext
                .getBean("inMemoryTextProcessor");
        System.out.println(applicationContext.getBean("fileTextProcessor"));
        System.out.println(inMemoryTextProcessor.getStorage());
        textProcessor = (TextProcessor) applicationContext.getBean("fileTextProcessor");
        System.out.println(textProcessor.toString());
        System.out.println(applicationContext.getBean("test"));

    }
}
