package com.costa.ygor.defeito_motor_eletrico.controller.response;

import com.costa.ygor.defeito_motor_eletrico.controller.request.MensagemRequest;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {


    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public String greeting(String message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return "Hello,  !";
    }

    @MessageMapping("/hello-messagem")
    @SendTo("/topic/greetings-mensagem")
    public MensagemResponse greeting(MensagemRequest message) throws Exception {
        //Thread.sleep(1000); // simulated delay
        return new MensagemResponse(HtmlUtils.htmlEscape(message.getMensagem()));
    }

}
