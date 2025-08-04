
public class SendEmailManual {    
    public static void main(String args[]) {
        EmailSender emailSender = new EmailSender();
        String emailText = "This is a sample email.";
        String email = "john.doe@gmail.com";
        boolean success = emailSender.sendEmail(email, emailText);
        System.out.println(success);
    }

}
