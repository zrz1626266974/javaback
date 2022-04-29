package com.zrz.service.config.utils;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Data
@Service
public class EmailUtils {
    @Autowired
    private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String emailFrom;   // 从配置文件取发件方

    public void sendSimpleMail(String recv, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(emailFrom);  // 发件方
        message.setTo(recv);  // 收件方
        message.setSubject(subject); // 邮件主题
        message.setText(content);  // 邮件内容
        javaMailSender.send(message);
    }
    public void test(){
        sendSimpleMail("2404761819@qq.com", "test email",
                "this is a test ");
    }

}
