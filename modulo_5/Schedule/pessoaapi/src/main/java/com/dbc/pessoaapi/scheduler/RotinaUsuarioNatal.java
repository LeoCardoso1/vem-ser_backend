package com.dbc.pessoaapi.scheduler;

import com.dbc.pessoaapi.service.EmailService;
import com.dbc.pessoaapi.service.PessoaService;
import freemarker.template.TemplateException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.io.IOException;
import java.text.SimpleDateFormat;

@RequiredArgsConstructor
@Component
@Slf4j
public class RotinaUsuarioNatal {

    private static final SimpleDateFormat dateFormat
            = new SimpleDateFormat("HH:mm:ss");

    private final PessoaService pessoaService;

    @Scheduled(cron = "0 51 19 * * *", zone = "GMT-3")
    public void emailSemEndereco() throws InterruptedException, MessagingException, TemplateException, IOException {
        pessoaService.sendEmailNatal();
    }
}
