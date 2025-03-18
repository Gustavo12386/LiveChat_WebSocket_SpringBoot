package tech.buildrun.livechatms.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import tech.buildrun.livechatms.domain.ChatInput;
import tech.buildrun.livechatms.domain.ChatOutput;

@Controller
public class LiveChatController {
  
    @MessageMapping("/new-message")	
    @SendTo("/topics/livechat")
	public ChatOutput newMessage(ChatInput input) {
    	//HtmlUtils para proteger as informações que forem inseridas
		return new ChatOutput(HtmlUtils.htmlEscape(input.user() + ":" + input.message()));
	}
}
