package hit.com.codebuoi9.email;


import javax.mail.MessagingException;

public interface MailSender {
    String sentMail(String to , String email) throws MessagingException;
}
