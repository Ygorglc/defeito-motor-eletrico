package com.costa.ygor.defeito_motor_eletrico.service;

import com.costa.ygor.defeito_motor_eletrico.controller.request.TesteRequest;
import com.costa.ygor.defeito_motor_eletrico.controller.response.TesteResponse;
import com.costa.ygor.defeito_motor_eletrico.exception.EntidadeNaoEncontradaException;
import com.costa.ygor.defeito_motor_eletrico.model.No;
import com.costa.ygor.defeito_motor_eletrico.model.Teste;
import com.costa.ygor.defeito_motor_eletrico.repositories.NoRepository;
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

    private NoRepository noRepository;

    public TesteService(TesteRepository testeRepository, NoRepository noRepository) {
        this.testeRepository = testeRepository;
        this.noRepository = noRepository;
    }

    public TesteResponse salvar(TesteRequest testeRequest) {
        Teste teste = requestParaEntity(testeRequest);
        Teste testeSalvo = testeRepository.save(teste);
        return entityParaResponse(testeSalvo);
    }

    public TesteResponse atualizar(Long id, TesteRequest testeRequest) throws Exception {
        Teste teste = testeRepository.findById(id).orElseThrow(()->new EntidadeNaoEncontradaException("Não foi encontrado teste com esse id!!"));
        teste.setDescricao(testeRequest.descricao());
        teste.setData(testeRequest.data());
        Teste testeSalvo = testeRepository.save(teste);
        return entityParaResponse(testeSalvo);
    }

    public TesteResponse buscar(Long id) throws Exception {
        Teste teste = testeRepository.findById(id).orElseThrow(()->new EntidadeNaoEncontradaException("Não foi encontrado teste com esse id!!"));
        return entityParaResponse(teste);
    }

    public List<TesteResponse> listar() {
        List<Teste> testeList = testeRepository.findAll();
        List<TesteResponse> testeResponseList = new ArrayList<>();
        testeList.forEach(teste -> testeResponseList.add(entityParaResponse(teste)));
        return testeResponseList;
    }
    public TesteResponse listarDadosColetados(Long id) throws Exception {
        Teste teste = testeRepository.findById(id).orElseThrow(()->new EntidadeNaoEncontradaException("Não foi encontrado teste com esse id!!"));
        TesteResponse testeResponse =  entityParaResponse(teste);

    }

    public void deletar(Long id) throws Exception{
        Teste teste = testeRepository.findById(id).orElseThrow(()->new EntidadeNaoEncontradaException("Não foi encontrado teste com esse id!!"));
        testeRepository.delete(teste);
    }

    private TesteResponse entityParaResponse(Teste teste){
        return new TesteResponse(teste.getId(),
                teste.getTitulo(),
                teste.getDescricao(),
                teste.getData(),
                teste.getNo());
    }

    private Teste requestParaEntity(TesteRequest testeRequest){
        No no = noRepository.findById(testeRequest.idNo()).orElseThrow(()->new EntidadeNaoEncontradaException("No não encontrado!!"));
        return new Teste(testeRequest.titulo(),
                testeRequest.descricao(),
                testeRequest.data(),
                no
                );
    }
}
