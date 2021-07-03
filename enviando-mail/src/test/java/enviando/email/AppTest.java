package enviando.email;

public class AppTest {

	
	@org.junit.Test // mesmo que o método main
	public void testeEmail() throws Exception {
              
		//passando mensagens com html no javamail
		StringBuilder stringBuilderTextoEmail = new StringBuilder();
		stringBuilderTextoEmail.append("Olá, <br/><br/>");
		stringBuilderTextoEmail.append("Você está Recebendo o acesso ao curso de Java.<br/><br/>");
		stringBuilderTextoEmail.append("Para ter acesso clique no botão abaixo. <br/><br/>");
		stringBuilderTextoEmail.append("<b>Login:</b> seuemail@gmail.com <br/>");
		stringBuilderTextoEmail.append("<b>Senha:</b> java-e-o-melhor-xw <br/><br/>");
		
		stringBuilderTextoEmail.append("<a target=\"_blank\" href=\"https://www.projetojavaweb.com/certificado-aluno/login\" style=\"color:#2525a7;  padding: 14px 24px; text-align:center; text-decoration:none; display:inline-block; border-radius:30px; font-size:20px; font-family:courier; border:3px solid green; background-color: #99DA39;\"> Acessar Portal do Aluno </a><br><br/>");
		
		stringBuilderTextoEmail.append("<span style=\"font-size: 8px;\">Ass.: Alex do Jdev Treinamento</span>");
		
		
		ObjetoEnviaEmail enviaEmail  = 
				new ObjetoEnviaEmail(
						"jvdematos004@gmail.com", 
						"João Victor JDEV",
						"Testndo e-mail com Java",
						stringBuilderTextoEmail.toString()); 
		
		//evio de email normal
		//enviaEmail.enviarEmail(true); //false ou true se vai usar html ou não
		
		//envio do teste de pdf com email
		enviaEmail.enviarEmailAnexo(true);
		
		 /*Caso o email não esteja sendo enviado então  coloque um tempo de espera
         * mais isso só pode ser usado para testes Thread.sleep(5000); 5 segundos*/
	}
}
