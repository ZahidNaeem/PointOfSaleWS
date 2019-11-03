package org.zahid.apps.web.pos;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zahid.apps.web.pos.utils.MailService;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class MailServiceTest {

    @Autowired
    private MailService mailService;

    @DisplayName("Send email")
    @Test
    void sendMail(){
//        mailService.sendEmail("Test Email", "Test", "hzahidnaeem@gmail.com");
    }
}
