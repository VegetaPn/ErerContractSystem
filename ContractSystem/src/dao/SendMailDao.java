package dao;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class SendMailDao {
	static String host = "mail.bjtu.edu.cn";
	static String user = "13301026";//bjtu_hw_ffj_xyk
	static  String password =  "3035727yxc";//xiaokedou
	
	static  String from="13301026@bjtu.edu.cn";
	    public static void send(String to, String subject, String content) {
	        Properties props = new Properties();
	        props.put("mail.smtp.host", host); // ָ��SMTP������
	        props.put("mail.smtp.auth", "true"); // ָ���Ƿ���ҪSMTP��֤
	        try {
	            Session mailSession = Session.getDefaultInstance(props);
	            Message message = new MimeMessage(mailSession);
	            message.setFrom(new InternetAddress(from)); // ������
	            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to)); // �ռ���
	            message.setSubject(subject); // �ʼ�����
	            message.setText(content); // �ʼ�����
	            message.saveChanges();
	            Transport transport = mailSession.getTransport("smtp");
	            transport.connect(host, user, password);
	            transport.sendMessage(message, message.getAllRecipients());
	            transport.close();
	            System.out.print("Yeah!");
	        } catch(Exception e) {
	            System.out.println(e);
	        }
	    }
}
