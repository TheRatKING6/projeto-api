package com.example.apiCliProd.controller;

import com.example.apiCliProd.model.Cliente;
import com.example.apiCliProd.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apiCliente")
public class ClienteController {

    @Autowired
    ClienteRepository clirepo;

    @PostMapping("/inserir")
    public void cadastrarCliente(@RequestBody Cliente cli){
        clirepo.save(cli);
    }

    @GetMapping("/buscar")
    public List<Cliente> buscarTodosClientes(){
        return clirepo.findAll();
    }

    @GetMapping("/buscar/codigo/{codigo}")
    public Optional<Cliente> buscarCodigoCliente(@PathVariable("codigo") int codigo){
        return clirepo.findById(codigo);
    }

    @GetMapping("/buscar/nome/{nome}")
    public List<Cliente> buscarNomeCliente(@PathVariable("nome") String nome){
        return clirepo.findByParteNome(nome);
    }

    @GetMapping("/buscar/email/{email}")
    public List<Cliente> buscarEmailCliente(@PathVariable("email") String email){
        return clirepo.findByEmail(email);
    }

    @GetMapping("/buscar/nomeemail/{nome}/{email}")
    public List<Cliente> buscarNomeEmail(@PathVariable("nome") String nome, @PathVariable("email") String email){
        return clirepo.findByNomeEmail(nome, email);
    }

    @DeleteMapping("/apagar")
    public void apagarCliente(@RequestBody Cliente cli){
        clirepo.delete(cli);
    }

    @DeleteMapping("/apagar/codigo/{codigo}")
    public void apagarIdCliente(@PathVariable("codigo") int codigo){
        clirepo.deleteById(codigo);
    }

    @PutMapping("/atualizar")
    public void atualizarCliente(@RequestBody Cliente cli){
        clirepo.save(cli);
    }
}
