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

	    properties.setProperty("mail.transport.protocol", "smtp");   // ʹ�õ�Э�飨JavaMail�淶Ҫ��
       
	    properties.setProperty("mail.smtp.host", HOST);   // �����˵������ SMTP ��������ַ
        
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
