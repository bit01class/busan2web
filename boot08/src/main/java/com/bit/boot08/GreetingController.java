package com.bit.boot08;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {

	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public String room1(HelloMessage message) throws Exception {
		Thread.sleep(1000); // simulated delay
		return "{\"content\":\""+message.getName()+"\"}";
	}
}
