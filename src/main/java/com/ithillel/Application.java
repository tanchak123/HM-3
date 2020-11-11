package com.ithillel;

import com.ithillel.persistence.entity.AccountEntity;
import com.ithillel.persistence.entity.ClientCommonInfo;
import com.ithillel.persistence.entity.ClientEntity;
import com.ithillel.persistence.entity.ClientType;
import com.ithillel.persistence.entity.service.interfaces.AccountService;
import com.ithillel.persistence.entity.service.interfaces.ClientService;
import com.ithillel.service.TextProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {


    //private ApplicationContext applicationContext = new PropertiesApplicationContext();
    private TextProcessor textProcessor;

    public Application() {
        //textProcessor = (TextProcessor) applicationContext.getBean("textProcessor");
    }

    public void save(String key, final String text) {
        textProcessor.save(key, text);
    }

    public String getByKey(String key) {
       return textProcessor.getByKey(key);
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/default-beans.xml");
        //ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        ClientService clientService = applicationContext.getBean(ClientService.class);
//        ClientEntity clientEntity = new ClientEntity();
//        clientEntity.setFullname("test full name");
//        clientEntity.setHaveAccess(true);
//        clientEntity.setUpdateDate(System.currentTimeMillis());
//        ClientCommonInfo clientCommonInfo = new ClientCommonInfo();
//        clientCommonInfo.setClientType(ClientType.USER);
//        clientCommonInfo.setDescription("sim[pldfddf");
//        clientEntity.setClientCommonInfo(clientCommonInfo);
//        clientDao.createClient(clientEntity);
//        System.out.println(clientEntity.getId());
//        System.out.println(clientEntity.getUpdateDate());


        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setFullname("test full name");
        clientEntity.setPassword("fasddfa");
        clientEntity.setHaveAccess(true);
        clientEntity.setUpdateDate(System.currentTimeMillis());
        ClientCommonInfo clientCommonInfo = new ClientCommonInfo();
        clientCommonInfo.setClientType(ClientType.USER);
        clientCommonInfo.setDescription("some description");
        clientEntity.setClientCommonInfo(clientCommonInfo);

        ClientEntity clientEntity2 = new ClientEntity();
        clientEntity2.setFullname("test full name2");
        clientEntity2.setPassword("fdasfas");
        clientEntity2.setHaveAccess(true);
        clientEntity2.setUpdateDate(System.currentTimeMillis());
        ClientCommonInfo clientCommonInfo2 = new ClientCommonInfo();
        clientCommonInfo2.setClientType(ClientType.USER);
        clientCommonInfo2.setDescription("some description2");
        clientEntity2.setClientCommonInfo(clientCommonInfo2);

        AccountService accountService = applicationContext.getBean(AccountService.class);
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setName("test name");
        accountEntity.getClients().add(clientEntity);
//        accountEntity.getClients().add(clientEntity2);
//        clientEntity.setAccount(accountEntity);
//        clientEntity2.setAccount(accountEntity);
        accountService.create(accountEntity);
        System.out.println(accountEntity.getId());
        System.out.println(accountService.getById(accountEntity.getId()).getClients().size());
        System.out.println("DESC: " + clientService.getById(1).getClientCommonInfo().getDescription());
        System.out.println("PASSWORD: " + clientService.getById(9).getPassword());

    }

}
