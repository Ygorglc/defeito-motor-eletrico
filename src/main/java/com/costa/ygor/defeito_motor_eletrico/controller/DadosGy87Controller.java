package com.costa.ygor.defeito_motor_eletrico.controller;


import com.costa.ygor.defeito_motor_eletrico.controller.request.DadosGy87Request;
import com.costa.ygor.defeito_motor_eletrico.controller.request.DadosRequest;
import com.costa.ygor.defeito_motor_eletrico.controller.response.DadosResponse;
import com.costa.ygor.defeito_motor_eletrico.service.DadosGy87Service;
import com.costa.ygor.defeito_motor_eletrico.service.DadosService;
import com.costa.ygor.defeito_motor_eletrico.service.EspRestService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/dados-gy87")
public class DadosGy87Controller {

    private DadosGy87Service dadosService;

    private EspRestService espRestService;

    public DadosGy87Controller(DadosGy87Service dadosService, EspRestService espRestService) {
        this.dadosService = dadosService;
        this.espRestService = espRestService;
    }


//    @GetMapping("aceleracao/{quantidadeDeAmostras}/{idTeste}")
//    @ResponseStatus(HttpStatus.OK)
//    @Operation(summary = "Coleta os dados da aceleração",
//            description = "Coleta os dados da aceleração no Esp",
//            tags = {"dados"})
//    public List<Aceleracao> buscarAceleracao(@PathVariable Long quantidadeDeAmostras,
//                                             @PathVariable Long idTeste) throws Exception {
//        return dadosService.buscarAceleracao(quantidadeDeAmostras, idTeste);
//    }
//    @GetMapping("/tempo/{quantidadeDeAmostras}")
//    @ResponseStatus(HttpStatus.OK)
//    @Operation(summary = "Coleta os dados de tempo",
//            description = "Coleta os dados de tempo no Esp",
//            tags = {"dados"})
//    public List<Tempo> buscarTempo(@PathVariable Long quantidadeDeAmostras,
//                                   @PathVariable Long idTeste) throws Exception {
//        return dadosService.buscarTempo(quantidadeDeAmostras, idTeste);
//    }
//    @GetMapping("/dados/{quantidadeDeAmostras}")
//    @ResponseStatus(HttpStatus.OK)
//    @Operation(summary = "Coleta os dados de aceleraçaõ e tempo",
//            description = "Coleta os dados de aceleração e de tempo no ESP",
//            tags = {"dados"})
//    public List<DadosResponse> buscarDados(@PathVariable Long quantidadeDeAmostras,
//                                           @PathVariable Long idTeste) throws Exception {
//        return dadosService.buscarDados(quantidadeDeAmostras, idTeste);
//    }
//    @GetMapping("/recupera/{quantidadeDeAmostras}")
//    @ResponseStatus(HttpStatus.OK)
//    @Operation(summary = "Faz o ESP armazenar os dados.",
//            description = "Faz o ESP armazenar os dados nele para coleta posterior.",
//            tags = {"dados"})
//    public void recuperarDados(@PathVariable Long quantidadeDeAmostras) throws Exception {
//        dadosService.recuperarDados(quantidadeDeAmostras);
//    }
//
//    @GetMapping("/iniciando")
//    @ResponseStatus(HttpStatus.OK)
//    @Operation(summary = "Faz o ESP armazenar os dados nos vetores.",
//            description = "Faz o ESP armazenar os dados nosvetores nele para coleta posterior.",
//            tags = {"dados"})
//    public void iniciandorDados() throws Exception {
//        espRestService.iniciarDados();
//    }

    @PostMapping("/dados-brutos")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Faz o ESP armazenar os dados brutos nas tabelas.",
            description = "Faz o ESP armazenar os dados brutos nas tabelas para formar os vetores futuros.",
            tags = {"dadosgy87"})
    public Boolean salvar(@RequestBody DadosGy87Request dadosRequest){
        return dadosService.salvandoDadosRequest(dadosRequest);
    }
}
