package hello;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Reciever {

	@JmsListener(destination="mailbox",containerFactory="myFactory")
	public void recieveMessage(Email email)
	{
		System.out.println("## Received < "+email.toString()+ " >");
	}
}
