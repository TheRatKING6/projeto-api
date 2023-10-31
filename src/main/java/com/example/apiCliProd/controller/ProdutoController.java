package com.example.apiCliProd.controller;

import com.example.apiCliProd.model.Produto;
import com.example.apiCliProd.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apiProduto")
public class ProdutoController {

    @Autowired
    ProdutoRepository prodrepo;

    @PostMapping("/inserir")
    public void cadastrarProduto(@RequestBody Produto prod){
        prodrepo.save(prod);
    }

    @GetMapping("/buscar")
    public List<Produto> buscarTodosProdutos(){
        return prodrepo.findAll();
    }

    @GetMapping("/buscar/codigo/{codigo}")
    public Optional<Produto> buscarPorCodigo(@PathVariable("codigo") int codigo){
        return prodrepo.findById(codigo);
    }

    @GetMapping("/buscar/partedescricao/{descricao}")
    public List<Produto> buscarParteInicialDescricao(@PathVariable("descricao") String descricao){
        return prodrepo.findByParteInicialDescricao(descricao);
    }

    @GetMapping("buscar/preco/{preco}")
    public List<Produto> buscarPorPrecoMenor(@PathVariable("preco") double preco){
        return prodrepo.findByPrecoMenor(preco);
    }

    @GetMapping("/buscar/marca/{marca}")
    public List<Produto> buscarPorMarca(@PathVariable("marca") String marca){
        return prodrepo.findByMarca(marca);
    }

    @GetMapping("/buscar/marcapreco/{marca}/{preco}")
    public List<Produto> buscarPorMarcaPreco(@PathVariable("marca") String marca, @PathVariable("preco") double preco){
        return prodrepo.findByMarcaPreco(marca, preco);
    }

    @DeleteMapping("/apagar")
    public void apagarProduto(@RequestBody Produto prod){
        prodrepo.delete(prod);
    }

    @DeleteMapping("/apagar/codigo/{codigo}")
    public void apagarPorCodigo(@PathVariable("codigo") int codigo){
        prodrepo.deleteById(codigo);
    }

    @PutMapping("/atualizar")
    public void atualizarProduto(@RequestBody Produto prod){
        prodrepo.save(prod);
    }

}
