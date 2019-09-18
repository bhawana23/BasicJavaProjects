package email;
import java.io.File;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message.RecipientType;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

// create a class that inherits Authenticator
class BabyOfAuthenticator extends Authenticator
{
	// create a method and return object of PS from this
	public PasswordAuthentication getPasswordAuthentication()
	{
		// create object of PS and provide sender email and password
		PasswordAuthentication ps = new PasswordAuthentication
		("kuchipuri123@gmail.com", "Kuchipuri@12");
		
		// return this object
		return ps;
	}
}

public class SendEmail 
{
	public static void main(String[] args) 
	{
	try
	{
	// create object of properties class to provide the
	// information about the service that will help 
	// us to send email
	Properties p = new Properties();
	
	// provide info about the mail server to which we will
	// send email
	p.put("mail.smtp.host", "smtp.gmail.com");
	p.put("mail.smtp.port", "587");
	p.put("mail.smtp.starttls.enable", "true");
	p.put("mail.smtp.auth","true");
	p.put("mail.debug","true");
	
	// create object of subclass of authenticator
	BabyOfAuthenticator baby = new BabyOfAuthenticator();
	
	// get object of session
	Session session = Session.getInstance(p, baby);
	
	// create object of mime-message to denote actual message
	MimeMessage message = new MimeMessage(session);
	
	// provide subject with message
	message.setSubject("DON'T PANIC, IT IS JUST A TEST MAIL");
	
	String[] receivers = {"saritab58@gmail.com"};
	
	// create an array of Internet-address 
	InternetAddress[] adrs = new InternetAddress[receivers.length];
	
	for(int i = 0; i < adrs.length; i++)
	{
		adrs[i] = new InternetAddress(receivers[i]);
	}
	
	// specify the RCVR types
	message.setRecipients(RecipientType.TO, adrs);
	
	// create few body parts to store content and 
	// attachments
	MimeBodyPart body1 = new MimeBodyPart(),
			body2 = new MimeBodyPart();
	
	// store content inside body1
	body1.setContent("This is the content of mail", "text/plain");
	
	String attach_path = "D:\\taylor swift\\2.jpg";
	
	// denote this path using file class
	File f = new File(attach_path);
	
	// associate attachment with body2
	body2.attachFile(f);
	
	// create a multipart to store  body parts
	MimeMultipart part = new MimeMultipart();
	
	// store body parts inside multipart
	part.addBodyPart(body1);
	part.addBodyPart(body2);
	
	// store multipart inside message
	message.setContent(part);
	
	// send this message to mail server
	Transport.send(message);
	
	System.out.println("OK");
	}
	catch(Exception e)
	{
		System.out.println("error "+e);
	}
	}
}