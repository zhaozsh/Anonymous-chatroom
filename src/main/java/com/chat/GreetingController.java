package com.chat;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {


    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
		Date day=new Date();    
		SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss"); 
        return new Greeting(df.format(day) + ":" + HtmlUtils.htmlEscape(message.getName()));
    }

}