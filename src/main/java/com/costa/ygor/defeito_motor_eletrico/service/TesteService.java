package com.costa.ygor.defeito_motor_eletrico.service;

import com.costa.ygor.defeito_motor_eletrico.controller.request.TesteRequest;
import com.costa.ygor.defeito_motor_eletrico.controller.response.TesteComDadosResponse;
import com.costa.ygor.defeito_motor_eletrico.controller.response.TesteResponse;
import com.costa.ygor.defeito_motor_eletrico.exception.EntidadeNaoEncontradaException;
import com.costa.ygor.defeito_motor_eletrico.model.*;
import com.costa.ygor.defeito_motor_eletrico.repositories.*;
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

    private AceleracaoRepository aceleracaoRepository;

    private VelocidadeRepository velocidadeRepository;

    private DeslocamentoRepository deslocamentoRepository;

    private TempoRepository tempoRepository;

    private GiroRepository giroRepository;

    public TesteService(TesteRepository testeRepository,
                        NoRepository noRepository,
                        AceleracaoRepository aceleracaoRepository,
                        VelocidadeRepository velocidadeRepository,
                        DeslocamentoRepository deslocamentoRepository,
                        TempoRepository tempoRepository,
                        GiroRepository giroRepository) {
        this.testeRepository = testeRepository;
        this.noRepository = noRepository;
        this.aceleracaoRepository = aceleracaoRepository;
        this.velocidadeRepository = velocidadeRepository;
        this.deslocamentoRepository = deslocamentoRepository;
        this.tempoRepository = tempoRepository;
        this.giroRepository = giroRepository;
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
    public TesteComDadosResponse listarDadosColetados(Long id) throws Exception {
        Teste teste = testeRepository.findById(id).orElseThrow(()->new EntidadeNaoEncontradaException("Não foi encontrado teste com esse id!!"));
        List<Aceleracao> aceleracaos = aceleracaoRepository.findAllByTeste_Id(id);
        List<Velocidade> velocidades = velocidadeRepository.findAllByTeste_Id(id);
        List<Deslocamento> deslocamentos = deslocamentoRepository.findAllByTeste_Id(id);
        List<Tempo> tempos = tempoRepository.findAllByTeste_Id(id);
        List<Giro> giros = giroRepository.findAllByTeste_Id(id);

        TesteResponse testeResponse =  entityParaResponse(teste);
        return  entidadeParaResponseDadosTeste(testeResponse,aceleracaos,velocidades,deslocamentos, tempos, giros);
    }

    private TesteComDadosResponse entidadeParaResponseDadosTeste(TesteResponse testeResponse,
                                                                 List<Aceleracao> aceleracaos,
                                                                 List<Velocidade> velocidades,
                                                                 List<Deslocamento> deslocamentos,
                                                                 List<Tempo> tempos,
                                                                 List<Giro> giros){

        List<Double> deslocamento_x = new ArrayList<>();
        List<Double> deslocamento_y = new ArrayList<>();
        List<Double> deslocamento_z = new ArrayList<>();

        List<Double> velocidade_x = new ArrayList<>();
        List<Double> velocidade_y = new ArrayList<>();
        List<Double> velocidade_z = new ArrayList<>();

        List<Double> aceleracao_x = new ArrayList<>();
        List<Double> aceleracao_y = new ArrayList<>();
        List<Double> aceleracao_z = new ArrayList<>();

        List<Double> tempo_xyzg = new ArrayList<>();

        List<Double> giro_x = new ArrayList<>();
        List<Double> giro_y = new ArrayList<>();
        List<Double> giro_z = new ArrayList<>();
        if(!aceleracaos.isEmpty()){
            aceleracaos.forEach(aceleracao -> {
                aceleracao_x.add(aceleracao.getEixo_x());
                aceleracao_y.add(aceleracao.getEixo_y());
                aceleracao_z.add(aceleracao.getEixo_z());
            });
        }
        if(!velocidades.isEmpty()){
            velocidades.forEach(velocidade -> {
                velocidade_x.add(velocidade.getEixo_x());
                velocidade_y.add(velocidade.getEixo_y());
                velocidade_z.add(velocidade.getEixo_z());
            });
        }
        if(!deslocamentos.isEmpty()){
            deslocamentos.forEach(deslocamento -> {
                deslocamento_x.add(deslocamento.getEixo_x());
                deslocamento_y.add(deslocamento.getEixo_y());
                deslocamento_z.add(deslocamento.getEixo_z());
            });
        }
        if (!tempos.isEmpty()){
            tempos.forEach(tempo-> {
                tempo_xyzg.add(tempo.getValorTempo());
            });
        }
        if (!giros.isEmpty()){
            giros.forEach(giro -> {
                giro_x.add(giro.getEixo_x());
                giro_y.add(giro.getEixo_y());
                giro_z.add(giro.getEixo_z());
            });
        }
        return new TesteComDadosResponse(testeResponse,
                deslocamento_x,deslocamento_y, deslocamento_z,
                velocidade_x, velocidade_y, velocidade_z,
                aceleracao_x, aceleracao_y, aceleracao_z,
                tempo_xyzg,
                giro_x, giro_y, giro_z);
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
