package com.costa.ygor.defeito_motor_eletrico.service;

import com.costa.ygor.defeito_motor_eletrico.model.Testando_Esp_Rest;
import com.costa.ygor.defeito_motor_eletrico.repositories.TestandoEspRestRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestandoEspRestService {
    private TestandoEspRestRepository testandoEspRestRepository;
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public TestandoEspRestService(TestandoEspRestRepository testandoEspRestRepository) {
        this.testandoEspRestRepository = testandoEspRestRepository;
    }

    public List<Testando_Esp_Rest> listando(){
        return testandoEspRestRepository.findAll();
    }

    public Testando_Esp_Rest salvar(Testando_Esp_Rest testando_esp_rest){
        return testandoEspRestRepository.save(testando_esp_rest);
    }

    public void deletando (Long id){
        testandoEspRestRepository.deleteById(id);
    }
    public Testando_Esp_Rest atualizando(Testando_Esp_Rest testando_esp_rest) throws Exception {
        Testando_Esp_Rest testando_esp_rest1 = testandoEspRestRepository.findById(testando_esp_rest.getId()).orElseThrow(()-> new Exception("Teste não encontrado!!"));
        testando_esp_rest1.setDescricao(testando_esp_rest.getDescricao());
        return testandoEspRestRepository.save(testando_esp_rest1);
    }

}
