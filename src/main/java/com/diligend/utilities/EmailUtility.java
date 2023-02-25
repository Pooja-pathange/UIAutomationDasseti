package com.diligend.utilities;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.testng.ITestContext;

public class EmailUtility {


	public static void sendEmail(ITestContext context) {

		// Create object of Property file
		Properties props = new Properties();
		// this will set host of server- you can change based on your requirement
		props.put("mail.smtp.host", "smtp.gmail.com");
		// set the port of socket factory
		props.put("mail.smtp.socketFactory.port", "587");
		// set socket factory
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		// set the authentication to true
		props.put("mail.smtp.auth", "true");
		// set the port of SMTP server
		props.put("mail.smtp.port", "587");
		
		// This will handle the complete authentication
		props.put("mail.smtp.starttls.enable", "true"); //TLS
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("dudetest.automation@gmail.com", "Test@123"); //company automation email ID
			}
		});
		try {
			// Create object of MimeMessage class
			Message message = new MimeMessage(session);
			// Set the from address
			message.setFrom(new InternetAddress("dudetest.automation@gmail.com"));
			// Set the recipient address
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("ppatange@diligend.com," + "ashetty@diligend.com," + "gahan.invstor@yopmail.com"));
			
			// Add the subject link
			message.setSubject("Automation Report");
			// Create object to add multimedia type content
			BodyPart messageBodyPart1 = new MimeBodyPart();
			// Set the body of email
			// messageBodyPart1.setText("Automation Run");
			int TEST_RESULT_COUNT = context.getPassedTests().size() + context.getFailedTests().size()
					+ context.getSkippedTests().size();
			messageBodyPart1.setContent(
					"<h3>TEST EXECUTION SUMMARY</h3>\n" + "<p style=\"color:black;\"><b>TOTAL TEST CASES : "
							+ TEST_RESULT_COUNT + "</b></p>\n" + "<p style=\"color:green;\">PASS : "
							+ context.getPassedTests().size() + "</p>" + "<p style=\"color:red;\">FAIL : "
							+ context.getFailedTests().size() + "</p>" + "<p style=\"color:orange;\">SKIP : "
							+ context.getSkippedTests().size() + "</p>"
							+ "<p style=\"color:black;\"><b><u>Job Overall Status : </u></b></p>\n\n"
							+ "<p style=\"color:black;\">=>>  Please refer attached report for execution details</p>",
					"text/html");
			// Create another object to add another content
			MimeBodyPart messageBodyPart2 = new MimeBodyPart();
			// Mention the file which you want to send
			String filename = System.getProperty("user.dir") + "/Diligend-AutomationReport.html";
			// Create data source and pass the filename
			DataSource source = new FileDataSource(filename);
			// set the handler
			messageBodyPart2.setDataHandler(new DataHandler(source));
			// set the file
			messageBodyPart2.setFileName(filename);
			// Create object of MimeMultipart class
			Multipart multipart = new MimeMultipart();
			// add body part 1
			multipart.addBodyPart(messageBodyPart2);
			// add body part 2
			multipart.addBodyPart(messageBodyPart1);
			// set the content
			message.setContent(multipart);
			// finally send the email
			Transport.send(message);
			System.out.println("=====Email Sent=====");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}


}
