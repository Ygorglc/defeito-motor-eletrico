package com.costa.ygor.defeito_motor_eletrico.service;

import com.costa.ygor.defeito_motor_eletrico.controller.request.DadosGy87Request;
import com.costa.ygor.defeito_motor_eletrico.controller.request.DadosRequest;
import com.costa.ygor.defeito_motor_eletrico.controller.response.DadosResponse;
import com.costa.ygor.defeito_motor_eletrico.exception.EntidadeNaoEncontradaException;
import com.costa.ygor.defeito_motor_eletrico.model.*;
import com.costa.ygor.defeito_motor_eletrico.repositories.*;
import org.springframework.stereotype.Service;

@Service
public class DadosGy87Service {

    private TesteRepository testeRepository;

    private AceleracaoRepository aceleracaoRepository;

    private TempoRepository tempoRepository;

    private GiroRepository giroRepository;

    private BarometroRepository barometroRepository;

    private MagnetometroRepository magnetometroRepository;

    public DadosGy87Service(TesteRepository testeRepository,
                            AceleracaoRepository aceleracaoRepository,
                            TempoRepository tempoRepository,
                            GiroRepository giroRepository,
                            BarometroRepository barometroRepository,
                            MagnetometroRepository magnetometroRepository) {
        this.testeRepository = testeRepository;
        this.aceleracaoRepository = aceleracaoRepository;
        this.tempoRepository = tempoRepository;
        this.giroRepository = giroRepository;
        this.barometroRepository = barometroRepository;
        this.magnetometroRepository = magnetometroRepository;
    }



    public Boolean salvandoDadosRequest(DadosGy87Request dadosRequest){
        Teste teste = testeRepository.findById(dadosRequest.idt()).orElseThrow(()->new EntidadeNaoEncontradaException("Não foi encontrado teste com esse id!!"));
        Aceleracao aceleracao = new Aceleracao(dadosRequest.ax(), dadosRequest.ay(), dadosRequest.az(), teste);
        Aceleracao aceleracaoSalva = aceleracaoRepository.save(aceleracao);

        Giro giro = new Giro(dadosRequest.p(), dadosRequest.gx(), dadosRequest.gy(), dadosRequest.gz(), teste);
        Giro giroSalvo = giroRepository.save(giro);

        Tempo tempo = new Tempo(dadosRequest.p(), dadosRequest.t(),teste);
        Tempo tempoSalvo = tempoRepository.save(tempo);

        Barometro barometro = new Barometro(dadosRequest.p(), dadosRequest.b(), teste);
        Barometro barometroSalvo = barometroRepository.save(barometro);

        Magnetometro magnetometro = new Magnetometro( dadosRequest.mx(), dadosRequest.my(), dadosRequest.mz(), teste);
        Magnetometro magnetometroSalvo = magnetometroRepository.save(magnetometro);

        return true;
    }
}
