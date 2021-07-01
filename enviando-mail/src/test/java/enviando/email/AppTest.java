package enviando.email;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class AppTest {

	private String userName = "seuemail@gmail.com";
	private String senha = "suaSenhaGmail";
	
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
			properties.put("mail.smtp.socketFactoryClass", "javax.net.ssl.SSLSocketFactory");// classe socket de conexão// ao SMTP
				
			//session do javamail depedencia colocada no pom.xml
            Session session = Session.getInstance(properties, new Authenticator() {
            	@Override
            	protected PasswordAuthentication getPasswordAuthentication() {
            		
            		return new PasswordAuthentication(userName, senha);
            	}
			});
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
