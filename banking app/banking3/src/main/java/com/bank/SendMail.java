package com.bank;

import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.mysql.cj.Session;

public class SendMail {
	
	
	public  String generateAccountNumber(	) {
        Random random = new Random();
        StringBuilder accountNumber = new StringBuilder();
              int length = 12 ;
        for (int i = 0; i < length; i++) {
            int digit = random.nextInt(10); // Generate a random digit (0-9)
            accountNumber.append(digit);
        }

        return accountNumber.toString();


    }
    public String generate_password() {
        // collection of characters that can be used in password
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*()_+-/.,<>?;':\"[]{}\\|`~";
         int size = 6 ;
        String password = "";
        // creating object of Random class
        Random rnd = new Random();
        // looping to generate password
        while (password.length() < size) {
            // get a random number between 0 and length of chars
            int index = (int) (rnd.nextFloat() * chars.length());
            // add character at index to password
            password += chars.charAt(index);
        }
        return password.toString();
    }
    public boolean  sendemail (User user) {
    	
    	boolean test = false ;
    	String toemail = user.getEmail();
    	String fromEmail = "vishweshvis@gmail.com";
    	String password = "vikkyrover";
    	
    	try {
    		Properties pr =  new Properties(); 
    		pr.setProperty("mail.smtp.host", "smtp.gmail.com");
    		pr.setProperty("mail.smtp.port", "587");
    		pr.setProperty("mail.smtp.auth", "true");
    		pr.setProperty("mail.smtp.starttls.enable", "true");
    		pr.put("mail.smtp.socketFactory.port","587");
    		pr.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
            

    		javax.mail.Session sen = javax.mail.Session.getInstance(pr, new Authenticator() {
    			@Override
    			protected PasswordAuthentication getPasswordAuthentication() {
    				return new PasswordAuthentication(fromEmail,"dwom yxnz nuas rjzf");
    			}
    		});
    		
    		
    		
    		Message mess = new MimeMessage(sen);
    		mess.setFrom(new InternetAddress(fromEmail));

    		mess.setRecipient(Message.RecipientType.TO,  new InternetAddress(toemail));

    		mess.setSubject(" sucess");
    		mess.setText("Subject: Successful Bank Account Generation\n"
    				 
    				+ "We are pleased to inform you that your bank account has been successfully generated.\n"+"Bank Code: ["+user.acc_num+"]\n"+"\nTemporary Passcode: "+user.temp_pass+"\nPlease be aware of the following important points:\r\n"
    						+ "Temporary Passcode: The passcode provided is temporary. For your security, we strongly advise you to change this passcode immediately after your first login.\r\n"
    						+ "Confidentiality: Do not share your bank code and temporary passcode with anyone. Keeping these details confidential is crucial to ensuring the security of your account.\r\n"
    						+ "First Login: Upon your first login, you will be prompted to set a new passcode. Please choose a strong and unique passcode to protect your account.\r\n"
    						+ "Customer Support: If you encounter any issues or have any questions, please do not hesitate to contact our customer support team at [Quziee team].Thank you for choosing [Bank Name]. We look forward to serving you.\r\n"
    						+ "Best regards,\r\n"
    						+ "\r\n"
    						+ ".vishwesh \r\n" +".Sangeeth\n" 
    						
    						+ "quzieebank"
    						
    						+ "");

    		
    		Transport.send(mess);
    		test = true;

    			 

    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return test;
    	
    }
} 
