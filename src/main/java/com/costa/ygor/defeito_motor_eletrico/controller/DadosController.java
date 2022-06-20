package com.costa.ygor.defeito_motor_eletrico.controller;

import com.costa.ygor.defeito_motor_eletrico.controller.dto.AceleracaoDto;
import com.costa.ygor.defeito_motor_eletrico.controller.dto.DadosDto;
import com.costa.ygor.defeito_motor_eletrico.controller.dto.TempoDto;
import com.costa.ygor.defeito_motor_eletrico.controller.response.DadosResponse;
import com.costa.ygor.defeito_motor_eletrico.model.Aceleracao;
import com.costa.ygor.defeito_motor_eletrico.model.Tempo;
import com.costa.ygor.defeito_motor_eletrico.service.DadosService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/dados")
public class DadosController {

    private DadosService dadosService;

    public DadosController(DadosService dadosService) {
        this.dadosService = dadosService;
    }

    @GetMapping("aceleracao/{quantidadeDeAmostras}/{idTeste}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Coleta os dados da aceleração",
            description = "Coleta os dados da aceleração no Esp",
            tags = {"dados"})
    public List<Aceleracao> buscarAceleracao(@PathVariable Long quantidadeDeAmostras,
                                             @PathVariable Long idTeste) throws Exception {
        return dadosService.buscarAceleracao(quantidadeDeAmostras, idTeste);
    }
    @GetMapping("/tempo/{quantidadeDeAmostras}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Coleta os dados de tempo",
            description = "Coleta os dados de tempo no Esp",
            tags = {"dados"})
    public List<Tempo> buscarTempo(@PathVariable Long quantidadeDeAmostras,
                                   @PathVariable Long idTeste) throws Exception {
        return dadosService.buscarTempo(quantidadeDeAmostras, idTeste);
    }
    @GetMapping("/dados/{quantidadeDeAmostras}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Coleta os dados de aceleraçaõ e tempo",
            description = "Coleta os dados de aceleração e de tempo no ESP",
            tags = {"dados"})
    public List<DadosResponse> buscarDados(@PathVariable Long quantidadeDeAmostras,
                                           @PathVariable Long idTeste) throws Exception {
        return dadosService.buscarDados(quantidadeDeAmostras, idTeste);
    }
    @GetMapping("/recupera/{quantidadeDeAmostras}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Faz o ESP armazenar os dados.",
            description = "Faz o ESP armazenar os dados nele para coleta posterior.",
            tags = {"dados"})
    public void recuperarDados(@PathVariable Long quantidadeDeAmostras) throws Exception {
        dadosService.recuperarDados(quantidadeDeAmostras);
    }
}
