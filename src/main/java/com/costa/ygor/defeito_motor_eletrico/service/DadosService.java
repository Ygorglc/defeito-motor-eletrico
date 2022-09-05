package com.costa.ygor.defeito_motor_eletrico.service;

import com.costa.ygor.defeito_motor_eletrico.controller.dto.AceleracaoDto;
import com.costa.ygor.defeito_motor_eletrico.controller.dto.DadosDto;
import com.costa.ygor.defeito_motor_eletrico.controller.dto.TempoDto;
import com.costa.ygor.defeito_motor_eletrico.controller.response.DadosResponse;
import com.costa.ygor.defeito_motor_eletrico.model.Aceleracao;
import com.costa.ygor.defeito_motor_eletrico.model.Tempo;
import com.costa.ygor.defeito_motor_eletrico.model.Teste;
import com.costa.ygor.defeito_motor_eletrico.repositories.AceleracaoRepository;
import com.costa.ygor.defeito_motor_eletrico.repositories.DeslocamentoRepository;
import com.costa.ygor.defeito_motor_eletrico.repositories.TempoRepository;
import com.costa.ygor.defeito_motor_eletrico.repositories.TesteRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DadosService {

    private EspRestEndPointService espRestEndPointService;

    private TesteRepository testeRepository;

    private AceleracaoRepository aceleracaoRepository;

    private TempoRepository tempoRepository;

    private DeslocamentoRepository deslocamentoRepository;


    public DadosService(EspRestEndPointService espRestEndPointService,
                        TesteRepository testeRepository,
                        AceleracaoRepository aceleracaoRepository,
                        TempoRepository tempoRepository,
                        DeslocamentoRepository deslocamentoRepository) {
        this.espRestEndPointService = espRestEndPointService;
        this.testeRepository = testeRepository;
        this.aceleracaoRepository = aceleracaoRepository;
        this.tempoRepository = tempoRepository;
        this.deslocamentoRepository = deslocamentoRepository;
    }

    public List<Aceleracao> buscarAceleracao(Long quantidadeDeAmostras, Long idTeste) throws Exception {
        List<AceleracaoDto> aceleracaoDtoLista = espRestEndPointService.recuperaAceleracao(quantidadeDeAmostras);
        List<Aceleracao> aceleracaoList = new ArrayList<>();
        List<Aceleracao> aceleracaoSalvoList = new ArrayList<>();

        Teste teste = testeRepository.findById(idTeste).orElseThrow(()-> new Exception("sdbfds"));

        aceleracaoDtoLista.forEach(aceleracaoDto -> aceleracaoList.add(new Aceleracao(aceleracaoDto.getAceleracao(),teste)));
        aceleracaoList.forEach(aceleracao -> aceleracaoSalvoList.add(aceleracaoRepository.save(aceleracao)));
        return aceleracaoSalvoList;
    }

    public List<Tempo> buscarTempo(Long quantidadeDeAmostras, Long idTeste) throws Exception {
        List<TempoDto> tempoDtoList = espRestEndPointService.recuperaTempo(quantidadeDeAmostras);
        List<Tempo> tempoList = new ArrayList<>();
        List<Tempo> tempoSalvoList = new ArrayList<>();

        Teste teste = testeRepository.findById(idTeste).orElseThrow(()-> new Exception("sdbfds"));

        tempoDtoList.forEach(tempoDto -> tempoList.add(new Tempo(tempoDto.getTempo(),teste)));
        tempoList.forEach(tempo -> tempoSalvoList.add(tempoRepository.save(tempo)));
        return tempoSalvoList;
    }

    public List<DadosResponse> buscarDados(Long quantidadeDeAmostras, Long idTeste) throws Exception {
        List<DadosDto> dadosDtoList = espRestEndPointService.recuperaDados(quantidadeDeAmostras);
        List<Aceleracao> aceleracaoList = new ArrayList<>();
        List<Aceleracao> aceleracaoSalvoList = new ArrayList<>();
        List<Tempo> tempoList = new ArrayList<>();
        List<Tempo> tempoSalvoList = new ArrayList<>();

        Teste teste = testeRepository.findById(idTeste).orElseThrow(()-> new Exception("sdbfds"));

        List<DadosResponse> dadosResponseList = new ArrayList<>();

        return  new ArrayList<>();

    }


//    public List<DadosResponse> buscarDados(Long quantidadeDeAmostras, Long idTeste) throws Exception {
//        List<DadosDto> dadosDtoList = espRestEndPointService.recuperaDados(quantidadeDeAmostras);
//        List<Aceleracao> aceleracaoList = new ArrayList<>();
//        List<Aceleracao> aceleracaoSalvoList = new ArrayList<>();
//        List<Tempo> tempoList = new ArrayList<>();
//        List<Tempo> tempoSalvoList = new ArrayList<>();
//
//        Teste teste = testeRepository.findById(idTeste).orElseThrow(()-> new Exception("sdbfds"));
//
//        List<DadosResponse> dadosResponseList = new ArrayList<>();
//
//        dadosDtoList.forEach(dadosDto -> );
//
//    }
//
//    private Map<Aceleracao,Tempo>

    public void recuperarDados(Long quantidadeDeAmostras) {
        espRestEndPointService.coletaDados(quantidadeDeAmostras);
    }

//    public List<DadosResponse> buscarDados(Long quantidadeDeAmostras, Long idTeste) {
//    }
}
