package others;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmailToGmail {
    public static void main(String[] args) throws MessagingException {

        String to = "mitrandir@gmail.com";
        String emailName = "testrpa0@gmail.com";
        String emailPassword = "testrpa01";
        String title = "zaglavie";
        String body = "nothing to see here , move on";

        //String port = "25";
        //String port = "587";
        String port = "465";

        Properties props = System.getProperties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", port);
        //props.put("mail.smtp.socketFactory.port", port);
        //props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        //props.put("mail.smtp.socketFactory.fallback", "false");
//        props.put("mail.transport.protocol", "smtps");
        props.put("mail.smtp.ssl.enable", "true");
        props.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com");
        props.put("mail.debug", "true");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");
//        props.put("mail.smtp.user", emailName);
//        props.put("mail.smtp.EnableSSL.enable", "true");

//        props.put("mail.password", emailPassword);
//        props.put("mail.user", emailName);
//        props.put("mail.from", emailName);
//        props.put("mail.smtp.localhost", "codenjoy.com");

//        props.put("mail.smtp.port", port);
//        props.put("mail.smtp.socketFactory.port", port);

        // Get the default Session object.
        Session session = Session.getInstance(props, new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(emailName, emailPassword);
            }
        });
        //session.setProtocolForAddress("rfc822", "smtps");

        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(emailName));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.setSubject(title);
        message.setContent(body, "text/html; charset=utf-8");
        Transport transport = session.getTransport("smtps");
        transport.send(message);
        transport.close();
        System.out.println("---- Done -----");

    }
}
