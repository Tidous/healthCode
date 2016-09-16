package action.mail;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;


public class MailSendObserver implements Observer {

	@Override
	public void update(Observable obj, Object arg) {

	    // 发送邮件
		SimpleMailSender sms = MailSenderFactory
			.getSender();
		List<String> recipients = new ArrayList<String>();
		recipients.add("<573744612@qq.com>");
		recipients.add("<632020710@qq.com>");
		try {
			for (String recipient : recipients) {
				sms.send(recipient, "推送测试", "这是一份定时推送的测试邮件");
			}
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}
