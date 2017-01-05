package by.notebook.mail.utils;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;


@Component()
public class SmtpMailSendler {

    @Autowired
    private JavaMailSender mailSender;
    private static final String FILESRC = "H:/demo/demo/src.zip";
    private static final String DIRSRC = "H:/demo/demo/src";

    public void setMailSender(String mailTo, String text) throws MessagingException, IOException {

        MimeMessage message = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(mailTo);
        helper.setText(text);

        ZipUtils.pack(DIRSRC, FILESRC);

        FileSystemResource file = new FileSystemResource(FILESRC);
        helper.addAttachment(file.getFilename(), file);

        mailSender.send(message);

        boolean f = new File(FILESRC).delete();
    }


}
