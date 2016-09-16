package action.mail;


/**
 * 发件箱工厂
 * 
 * @author
 * 
 */
public class MailSenderFactory {

	private static SimpleMailSender serviceSms = null;
	
	public static SimpleMailSender getSender() {
		if (serviceSms == null) {
			serviceSms = new SimpleMailSender("firefox_1989@163.com","HJJfox110112");
		}
		return serviceSms;
	}

}
