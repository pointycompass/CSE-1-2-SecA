import java.io.UnsupportedEncodingException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.PasswordAuthentication;


public class EmailSender {

    Session session;

    public EmailSender() {
        String SMTP_HOST = "smtp.office365.com";
        String SMTP_PORT = "587";
        //String SSL_ENABLE = "true"; 
        String FROM_ADDRESS = "ugadmission@iict.buet.ac.bd"; 
        String FROM_PASSWORD = "";       
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        //props.put("mail.smtp.ssl.protocols", "TLSv1.2");
        //props.put("mail.smtp.ssl.enable", SSL_ENABLE);
        props.put("mail.smtp.host", SMTP_HOST);
        props.put("mail.smtp.port", SMTP_PORT);
        session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(FROM_ADDRESS,FROM_PASSWORD);
                    }
                });

    }

    public boolean sendEmail(String email, String text) {
        String FROM_ADDRESS = "ugadmission@iict.buet.ac.bd";
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(FROM_ADDRESS, "Test Email Server"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject("Test Message");
            message.setText(text);
            Transport.send(message);
            return true;
        } catch (MessagingException | UnsupportedEncodingException e) {
            System.out.println(e);
            return false;
        }
    }
}
