package com.apec.pos.service;

import com.apec.pos.dto.accountDto.MailAuth;
import com.apec.pos.dto.accountDto.PassAndOtp;
import com.apec.pos.dto.otpDto.OtpMail;
import com.apec.pos.dto.otpDto.TokenAndOtp;
import com.apec.pos.entity.AccountEntity;
import com.apec.pos.entity.RoleEntity;
import com.apec.pos.repository.AccountRepository;
import com.apec.pos.repository.RoleRepository;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Service
@SessionAttributes("otpMail")
public class EmailSenderService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private Map<String,OtpMail> keyValueMap = new LinkedHashMap<>();

    public String sendEmail(String toEmail,String username){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        OtpMail otpMail = new OtpMail();
        otpMail.generateOTPandTimeEx(toEmail);
        keyValueMap.put(username,otpMail);
        simpleMailMessage.setFrom("tlufood.career@gmail.com");
        simpleMailMessage.setTo(toEmail);
        simpleMailMessage.setSubject("Xác thực email");
        simpleMailMessage.setText("Mã OTP của bạn là "+otpMail.getOtp());
        javaMailSender.send(simpleMailMessage);
        return "OTP đã được tạo, mời bạn check mail";
    }

    public String sendEmailByForget(String username){
        return sendEmail(accountRepository.findByUsername(username).getEmail(),username);
    }

    public String changePassword(PassAndOtp passAndOtp,String username){
        if (!validateOtp(passAndOtp.getOtp(),username)){
            throw new RuntimeException("Đổi mật khâu thất bại");
        }
        AccountEntity accountEntity = accountRepository.findByUsername(username);
        accountEntity.setPassword(passwordEncoder.encode(passAndOtp.getNewPassword()));
        accountRepository.update(accountEntity);
        keyValueMap.remove(username);
        return "ĐỔI MẬT KHẨU THÀNH CÔNG";
    }

    public String validateOtpForVerify(String otp,String username){
        if (!validateOtp(otp,username)){
            throw new RuntimeException("otp không chính xác");
        }
        AccountEntity accountEntity = accountRepository.findByUsername(username);
        accountEntity.setEmail(keyValueMap.get(username).getEmail());
        accountRepository.update(accountEntity);
        keyValueMap.remove(username);
        return "Xác thực thành công";
    }

    public String validateOtpForForgetPass(String otp,String username){
        if (!validateOtp(otp,username)){
            throw new RuntimeException("otp không chính xác");
        }
        OtpMail otpMail = keyValueMap.get(username);
        otpMail.generateOTPandTimeEx("");
        keyValueMap.put(username,otpMail);
        return otpMail.getOtp();
    }
    public boolean isExitsEmail(String username){
        AccountEntity accountEntity = accountRepository.findByUsername(username);
        if (accountEntity==null){
            throw new RuntimeException("tài khoản không tồn tại");
        }
        if (accountEntity.getEmail()==null){
            return false;
        }
        return true;
    }

    @Autowired
    private RoleRepository roleRepository;


    @Scheduled(fixedRate = 24 * 60 * 60 * 1000)
    private void checkMap(){
        List<RoleEntity> roleEntity = roleRepository.findAll();
        if (roleEntity.size()==0) {
            RoleEntity roleAdmin = new RoleEntity();
            roleAdmin.setAuthority("ADMIN");
            roleRepository.insert(roleAdmin);

            RoleEntity roleUser = new RoleEntity();
            roleUser.setAuthority("USER");
            roleRepository.insert(roleUser);

            AccountEntity adminEntity = new AccountEntity();
            adminEntity.setUsername("ADMIN");
            adminEntity.setPassword("Toilaviet2003@");
            Set<RoleEntity> roleEntityTemp = new HashSet<>();
            RoleEntity userRole = new RoleEntity();
            userRole.setAuthority("ADMIN");
            userRole.setId(1);
            roleEntityTemp.add(userRole);
            adminEntity.setRoles(roleEntityTemp);

            accountRepository.insert(adminEntity);
        }
        keyValueMap.forEach((key,value)->{
            if (value.getTimeEx().isBefore(LocalDateTime.now())){
                keyValueMap.remove(key);
            }
        });
    }

    private boolean validateOtp(String otp,String username){
        OtpMail otpMail = keyValueMap.get(username);
        if (otpMail.authenticateOtp(otp)){
            return true;
        }
        return false;
    }
}
