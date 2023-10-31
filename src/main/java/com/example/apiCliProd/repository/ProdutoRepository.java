package com.example.apiCliProd.repository;

import com.example.apiCliProd.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProdutoRepository extends JpaRepository <Produto, Integer> {

    @Query("select prod from Produto prod where prod.descricao like ?1%")
    List<Produto> findByParteInicialDescricao(String descricao);

    @Query("select prod from Produto prod where prod.preco < ?1")
    List<Produto> findByPrecoMenor(double preco);

    List<Produto> findByMarca(String marca);

    @Query("select prod from Produto prod where prod.marca like %?1% and prod.preco < ?2")
    List<Produto> findByMarcaPreco(String marca, double preco);
}
