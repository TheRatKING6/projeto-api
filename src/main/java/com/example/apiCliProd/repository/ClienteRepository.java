package com.example.apiCliProd.repository;

import com.example.apiCliProd.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteRepository extends JpaRepository <Cliente, Integer>{

    @Query("select cli from Cliente cli where cli.nome like %?1%")
    List<Cliente> findByParteNome(String nome);

    List<Cliente> findByEmail(String email);

    @Query("select cli from Cliente cli where cli.nome like %?1% and cli.email like %?2%")
    List<Cliente> findByNomeEmail(String nome, String email);
}
