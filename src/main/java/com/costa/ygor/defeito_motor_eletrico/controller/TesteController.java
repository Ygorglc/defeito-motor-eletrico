package com.costa.ygor.defeito_motor_eletrico.controller;

import com.costa.ygor.defeito_motor_eletrico.controller.request.TesteRequest;
import com.costa.ygor.defeito_motor_eletrico.controller.response.TesteResponse;
import com.costa.ygor.defeito_motor_eletrico.service.TesteService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/teste")
public class TesteController {

    private final TesteService testeService;

    public TesteController(TesteService testeService) {
        this.testeService = testeService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Salva um novo teste",
                description = "Salva um novo teste",
                tags = {"teste"})
    public TesteResponse salvar(@RequestBody TesteRequest testeRequest) throws Exception{
        return testeService.salvar(testeRequest);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Atualiza um teste",
                description = "Atualiza um teste",
                tags = {"teste"})
    public TesteResponse atualizar(@PathVariable Long id, @RequestBody TesteRequest testeRequest) throws Exception{
        return testeService.atualizar(id, testeRequest);
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Buscar teste",
                description = "Busca um teste or id",
                tags = {"teste"})
    public TesteResponse buscar(@PathVariable Long id) throws Exception{
        return testeService.buscar(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Lista todos os testes",
                description = "Lista todos os testes existentes",
                tags = {"teste"})
    public List<TesteResponse> listar(){
        return testeService.listar();
    }

    @GetMapping("dados-coletados/id")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Lista todos os testes e os dados coletados",
            description = "Lista todos os testes existentes e os dados coletados",
            tags = {"teste"})
    public List<TesteResponse> listarDadosColetados(@PathVariable Long id){
        return testeService.listarDadosColetados(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Deleta um teste",
            description = "Deletaum teste pelo id",
            tags = {"teste"})
    public void deletar(@PathVariable Long id) throws Exception{
        testeService.deletar(id);
    }
}
