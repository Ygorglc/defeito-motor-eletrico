package com.costa.ygor.defeito_motor_eletrico.service;

import com.costa.ygor.defeito_motor_eletrico.controller.dto.AceleracaoDto;
import com.costa.ygor.defeito_motor_eletrico.controller.dto.DadosDto;
import com.costa.ygor.defeito_motor_eletrico.controller.dto.TempoDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class EspRestEndPointService {

    private final ModelMapper modelMapper;

    @Value("${acesso-externo.uri}")
    private String URI;

    public EspRestEndPointService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public List<AceleracaoDto> recuperaAceleracao(Long quantidadeDeAmostras){
        String URI_COLETA = URI +"aceleracao/"+ quantidadeDeAmostras;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List> responses =
                restTemplate.getForEntity(URI_COLETA, List.class);
        List<AceleracaoDto>  listarAceleracao = new ArrayList<>();

        responses.getBody().forEach(response ->listarAceleracao.add(
                modelMapper.map(response, AceleracaoDto.class)
        ));
        return listarAceleracao;
    }

    public List<TempoDto> recuperaTempo(Long quantidadeDeAmostras){
        String URI_COLETA = URI +"tempo/"+ quantidadeDeAmostras;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List> responses =
                restTemplate.getForEntity(URI_COLETA, List.class);
        List<TempoDto> tempoDtoList = new ArrayList<>();

        responses.getBody().forEach(response -> tempoDtoList.add(
                modelMapper.map(response, TempoDto.class)
        ));
        return tempoDtoList;
    }

    public List<DadosDto> recuperaDados(Long quantidadeDeAmostras){
        String URI_COLETA = URI +"dados/"+ quantidadeDeAmostras;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List> responses =
                restTemplate.getForEntity(URI_COLETA, List.class);
        List<DadosDto> listarDadosDto = new ArrayList<>();

        responses.getBody().forEach(response -> listarDadosDto.add(
                modelMapper.map(response,DadosDto.class)
        ));
        return listarDadosDto;
    }

    public void coletaDados(Long quantidadeDeAmostras){
        String URI_COLETA = URI +"coleta"+ quantidadeDeAmostras;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List> responses =
                restTemplate.getForEntity(URI_COLETA, List.class);
    }
}
