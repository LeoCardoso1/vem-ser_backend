package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.Exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.dto.EmailDTO;
import com.dbc.pessoaapi.dto.PessoaDTO;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.kafka.Produtor;
import com.dbc.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor

public class EmailService {
    private final JavaMailSender emailSender;
    @Value("${spring.mail.username}")
    private String remetente;
    private final Configuration configuration;
    private final PessoaRepository pessoaRepository;
    private final ObjectMapper objectMapper;
    private final Produtor produtor;

    public void enviarEmailSimples(PessoaDTO pessoaDTO){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(remetente);
        message.setTo(pessoaDTO.getEmail());
        message.setSubject("Assunto do e-mail");
        message.setText("Olá, " + pessoaDTO.getNome() + "\n\nestamos felizes em ter você em nosso sistema :) \n\n\n" +
                "Seu cadastro foi realizado com sucesso, seu indentificador é: " + pessoaDTO.getIdPessoa() + ".\n" + remetente + "\nLeonardo.");
        emailSender.send(message);
    }

    public void enivarEmailAlteracao(PessoaDTO pessoaDTO) throws MessagingException, IOException, TemplateException{
        MimeMessage mimeMessage = emailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setFrom(remetente);
        helper.setTo(pessoaDTO.getEmail());
        helper.setSubject("Email de confirmação de alteração de cadastro");

        Template template = configuration.getTemplate("email-template-alteracao.html");
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", pessoaDTO.getNome());
        dados.put("remetente", remetente);
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);

        helper.setText(html, true);

        emailSender.send(mimeMessage);
    }

    public void enivarEmailExclusao(PessoaEntity pessoaEntity) throws MessagingException, IOException, TemplateException, RegraDeNegocioException {
//        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaRepository.getById(Id), PessoaDTO.class);

        MimeMessage mimeMessage = emailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setFrom(remetente);
        helper.setTo(pessoaEntity.getEmail());
        helper.setSubject("Email de confirmação de exclusão de cadastro");

        Template template = configuration.getTemplate("email-template-exclusao.html");
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", pessoaEntity.getNome());
        dados.put("remetente", remetente);
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);

        helper.setText(html, true);

        emailSender.send(mimeMessage);
    }

    public void enviarEmailEndereco(PessoaEntity pessoaEntity) throws MessagingException, IOException, TemplateException{
        MimeMessage mimeMessage = emailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setFrom(remetente);
        helper.setTo(pessoaEntity.getEmail());
        helper.setSubject("Email pedindo atualização de endereço");

        Template template = configuration.getTemplate("email-template-endereco.html");
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", pessoaEntity.getNome());
        dados.put("remetente", remetente);
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);

        helper.setText(html, true);

        emailSender.send(mimeMessage);
    }

    public void enviarEmailNatal(PessoaEntity pessoaEntity) throws MessagingException, IOException, TemplateException{
        MimeMessage mimeMessage = emailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setFrom(remetente);
        helper.setTo(pessoaEntity.getEmail());
        helper.setSubject("Promoções de Retrô-Natal");

        Template template = configuration.getTemplate("email-natal.html");
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", pessoaEntity.getNome());
        dados.put("remetente", remetente);
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);

        helper.setText(html, true);

        emailSender.send(mimeMessage);
    }

    @Scheduled(cron = "0 0 8,20 * * *", zone = "GMT-3")
    public void enviarEmailKafkaCadastro() throws JsonProcessingException {
        List<PessoaEntity> pessoasSemEndereco = pessoaRepository.pessoasSemEndereco();
        String message = "Estamos muito felizes que você está em nosso sistema." +
                "\n Para que possamos enviá-lo um brinde exclusivo, por gentileza, atualize seu endereço no cadastro";

        for (PessoaEntity key: pessoasSemEndereco){
            produtor.sendToSendBox(new EmailDTO(key.getEmail(),"Atualize seu cadastro", message));

        }
    }

    @Scheduled(cron = "* * * 23 12 ?", zone = "GMT-3")
    public void enviarEmailNatalKafka() throws JsonProcessingException{
        List<PessoaEntity> pessoas = pessoaRepository.findAll();
        String message = "Grande promoção de Natal!!!" +
                "\n Olá " + "selecionamos algumas das nossas ofertas para você:" +
                "\n - Na compra de um dos CDs do Chitãozinho e Xororó, ganhe um do Milionário e José Rico" +
                "\n - Na loucação de uma VHS, a outra loucação é grátis" +
                "\n - Fitas de SuperNintendo com 50% de desconto" +
                "\n Aproveite, Magazine OldSchool";

        for(PessoaEntity key: pessoas){
            produtor.sendToSendBox(new EmailDTO(key.getEmail(),"Promoção de Natal", message));
        }

    }
}


