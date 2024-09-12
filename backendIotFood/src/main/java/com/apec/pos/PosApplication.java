package com.apec.pos;

import com.apec.pos.entity.AccountEntity;
import com.apec.pos.entity.RoleEntity;
import com.apec.pos.repository.AccountRepository;
import com.apec.pos.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;

import com.twilio.Twilio;

import jakarta.annotation.PostConstruct;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
@EnableConfigurationProperties
@EnableScheduling
public class PosApplication extends SpringBootServletInitializer {

    public static void main(String[] args)throws IOException {
        SpringApplication.run(PosApplication.class, args);

    }
//    @Autowired
//    private RoleRepository roleRepository;
//
//    @Autowired
//    private AccountRepository accountRepository;
//    @PostConstruct
//    private void createRoleIfNotFound() {
//        List<RoleEntity> roleEntity = roleRepository.findAll();
//        if (roleEntity.size()==0) {
//            RoleEntity roleAdmin = new RoleEntity();
//            roleAdmin.setAuthority("ADMIN");
//            roleRepository.insert(roleAdmin);
//
//            RoleEntity roleUser = new RoleEntity();
//            roleUser.setAuthority("USER");
//            roleRepository.insert(roleUser);
//
//            AccountEntity adminEntity = new AccountEntity();
//            adminEntity.setUsername("ADMIN");
//            adminEntity.setPassword("Toilaviet2003@");
//            Set<RoleEntity> roleEntityTemp = new HashSet<>();
//            RoleEntity userRole = new RoleEntity();
//            userRole.setAuthority("ADMIN");
//            userRole.setId(1);
//            roleEntityTemp.add(userRole);
//            adminEntity.setRoles(roleEntityTemp);
//
//            accountRepository.insert(adminEntity);
//        }
//    }
    public static String currentUserGlobal = "";
    public static String currentUrlGlobal = "";

  
}
