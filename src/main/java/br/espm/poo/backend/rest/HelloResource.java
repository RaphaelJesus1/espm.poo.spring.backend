package br.espm.poo.backend.rest;

import br.espm.poo.backend.datatype.MessageBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloResource {

    @RequestMapping(method = RequestMethod.GET, path = "/hello")
    public String hello() {
        return "Hello World";
    }

    @GetMapping(path = "/mensagem")
    public MessageBean message() {
        MessageBean m = new MessageBean();
        m.setMessage("Bom dia!");
        return m;
    }
}
