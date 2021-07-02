package enviando.email;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class AppTest {

	private String userName = "jvdematos005@gmail.com";
	private String senha = "password";
	
	@org.junit.Test // mesmo que o método main
	public void testeEmail() {

		// Olhe as configurações smtp do seu email
		try {
			Properties properties = new Properties();
			properties.put("mail.smtp.auth", "true"); // autorização
			properties.put("mail.smtp.starttls", "true");// autenticação
			properties.put("mail.smtp.host", "smtp.gmail.com");// servidor do gmail do Google
			properties.put("mail.smtp.port", "465"); // porta do servidor
			properties.put("mail.smtp.socketFactory.port", "465");// Expecifica a porta a ser conectada pelo socket
			properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");// classe socket de conexão// ao SMTP
				
			//session do javamail depedencia colocada no pom.xml
            Session session = Session.getInstance(properties, new Authenticator() {
            	@Override
            	protected PasswordAuthentication getPasswordAuthentication() {
            		
            		return new PasswordAuthentication(userName, senha);
            	}
			});
            //array de adrees pode mandar pra varios email users , pra quem vai ser enviado aqui
            Address[] toUser = InternetAddress.parse("jvdematos004@gmail.com"); 
			
            Message message = new MimeMessage(session); //session do usuario que vai enviar os email
            message.setFrom(new InternetAddress(userName)); //quem está enviando o email
            message.setRecipients(Message.RecipientType.TO, toUser); //email de destino os array de email
            message.setSubject("Ceghou o email Enviado com Java"); //assunto do email titulo qnd envia
            message.setText("Ola programador, você acaba de receber um e-mail enviado com Java do curso Formação Java Web do Alex");//texto do envio do email
          
            Transport.send(message); //objeto de mensagem pra ser enviado
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
