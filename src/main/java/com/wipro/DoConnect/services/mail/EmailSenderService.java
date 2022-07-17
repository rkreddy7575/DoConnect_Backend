package com.wipro.DoConnect.services.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.wipro.DoConnect.entities.Admin;
import com.wipro.DoConnect.entities.Answer;
import com.wipro.DoConnect.entities.Questions;
import com.wipro.DoConnect.repository.AdminRepo;

@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private AdminRepo adminRepo;

    public void sendEmailForNewQuestion( Questions questions) {
        Admin adminAccount = adminRepo.findFirstByEmail("yrkr1999@gmail.com");
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(adminAccount.getEmail());

        msg.setSubject("New Question Asked By : " + questions.getUser().getName() );
        msg.setText("Question Title : " +  questions.getTitle());

        javaMailSender.send(msg);

    }

    public void sendEmailForNewAnswer( Questions questions, Answer answer) {
        Admin adminAccount = adminRepo.findFirstByEmail("yrkr1999@gmail.com");
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(adminAccount.getEmail());

        msg.setSubject(answer.getUser().getName() + " " + " Answered a question" );
        msg.setText("Question : " + questions.getTitle() + System.lineSeparator() + "Answer : " +  answer.getBody());

        javaMailSender.send(msg);

    }

}
