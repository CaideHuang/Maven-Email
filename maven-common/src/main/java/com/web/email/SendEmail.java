package com.web.email;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {

	private final static String FROM_EMAIL = "yangzinan127@163.com";
	private final static String HOST = "smtp.163.com";
	private final static String PASSWORD = "yzn19960127";
	private final static String SMTP = "smtp";
	private static Properties properties = new Properties();
	private static Session session;

	public static void sendMail(String to, String title, String context) throws Exception {

	    properties.setProperty("mail.transport.protocol", "smtp");   // 使用的协议（JavaMail规范要求）
       
	    properties.setProperty("mail.smtp.host", HOST);   // 发件人的邮箱的 SMTP 服务器地址
        
	    properties.setProperty("mail.smtp.auth", "true"); 

		session = Session.getInstance(properties);
		
		session.setDebug(true);

		MimeMessage mimeMessage = new MimeMessage(session);

		mimeMessage.setSubject(title);
		
		mimeMessage.setContent(context, "text/html;charset=utf-8");

		mimeMessage.setFrom(new InternetAddress(FROM_EMAIL));

		mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(to));

		mimeMessage.setSentDate(new Date());

		mimeMessage.saveChanges();

		Transport transport = session.getTransport(SMTP);

		transport.connect(FROM_EMAIL, PASSWORD);

		transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());

		transport.close();

	}
}
