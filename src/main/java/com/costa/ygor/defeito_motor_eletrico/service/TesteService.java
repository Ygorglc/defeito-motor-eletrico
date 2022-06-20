package com.costa.ygor.defeito_motor_eletrico.service;

import com.costa.ygor.defeito_motor_eletrico.controller.request.TesteRequest;
import com.costa.ygor.defeito_motor_eletrico.controller.response.TesteResponse;
import com.costa.ygor.defeito_motor_eletrico.model.Teste;
import com.costa.ygor.defeito_motor_eletrico.repositories.TesteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TesteService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private TesteRepository testeRepository;

    public TesteService(TesteRepository testeRepository) {
        this.testeRepository = testeRepository;
    }

    public TesteResponse salvar(TesteRequest testeRequest) {
        Teste teste = requestParaEntity(testeRequest);
        Teste testeSalvo = testeRepository.save(teste);
        return entityParaResponse(testeSalvo);
    }

    public TesteResponse atualizar(Long id, TesteRequest testeRequest) throws Exception {
        Teste teste = testeRepository.findById(id).orElseThrow(()->new Exception("ssfg"));
        teste.setDescricao(testeRequest.descricao());
        teste.setData(testeRequest.data());
        Teste testeSalvo = testeRepository.save(teste);
        return entityParaResponse(testeSalvo);
    }

    public TesteResponse buscar(Long id) throws Exception {
        Teste teste = testeRepository.findById(id).orElseThrow(()->new Exception("ssfg"));
        return entityParaResponse(teste);
    }

    public List<TesteResponse> listar() {
        List<Teste> testeList = testeRepository.findAll();
        List<TesteResponse> testeResponseList = new ArrayList<>();
        testeList.forEach(teste -> testeResponseList.add(entityParaResponse(teste)));
        return testeResponseList;
    }

    public void deletar(Long id) throws Exception{
        Teste teste = testeRepository.findById(id).orElseThrow(()->new Exception("ssfg"));
        testeRepository.delete(teste);
    }

    private TesteResponse entityParaResponse(Teste teste){
        return new TesteResponse(teste.getId(),
                teste.getDescricao(),
                teste.getData());
    }

    private Teste requestParaEntity(TesteRequest testeRequest){
        return new Teste(testeRequest.descricao(),
                testeRequest.data());
    }
}
