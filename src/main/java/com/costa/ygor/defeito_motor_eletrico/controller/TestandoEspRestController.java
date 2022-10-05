package com.costa.ygor.defeito_motor_eletrico.controller;

import com.costa.ygor.defeito_motor_eletrico.model.Testando_Esp_Rest;
import com.costa.ygor.defeito_motor_eletrico.service.TestandoEspRestService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/testando-esp-rest")
public class TestandoEspRestController {
    private TestandoEspRestService testandoEspRestService;

    public TestandoEspRestController(TestandoEspRestService testandoEspRestService) {
        this.testandoEspRestService = testandoEspRestService;
    }

    @GetMapping("/todos")
    @ResponseStatus(HttpStatus.OK)
    public List<Testando_Esp_Rest> listando(){
        return testandoEspRestService.listando();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Testando_Esp_Rest salvar(@RequestBody Testando_Esp_Rest testando_esp_rest){
        return testandoEspRestService.salvar(testando_esp_rest);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Testando_Esp_Rest atualizando(@RequestBody Testando_Esp_Rest testando_esp_rest) throws Exception {
        return testandoEspRestService.atualizando(testando_esp_rest);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) throws Exception{
        testandoEspRestService.deletando(id);
    }
}
