## Some Description
### Realize annotation() + xml spring cfg(for myself)
#### Annotation:
* create cfg package -> AppConfig.java
* add dependencies context
* Use ano @Configuration to say that this class is cfg for spring
* Then use @ComponentScan("com.ithillel") for scan @Component, @Autowired, etc annotations.
* Now let's test our config = create psvm on AppConfig.class.
* For annotationConfig we should no use AnnotationConfigApplicationContext(with class"AppConfig.class") 
instead ClassPathXmlApplicationContext("springCfg.xml");
* Now we run main and see next text:
*     com.ithillel.service.textprocessor.FileTextProcessor@1a4013
      com.ithillel.service.storage.HashMapStorage@1b6e1eff
      com.ithillel.service.textprocessor.FileTextProcessor@1a4013
#### Spring annotation + cfg(for myself):
* Just use @ImportResource("classpath:/springCfg.xml")
* classpath means package resources o this context
* in our psvm add new line
*     System.out.println(applicationContext.getBean("test"));
* RESULT:
*     com.ithillel.service.test.Test@702b8b12