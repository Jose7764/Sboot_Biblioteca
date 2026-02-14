package com.exemplo.biblioteca.controller;

import com.exemplo.biblioteca.model.Emprestimo;
import com.exemplo.biblioteca.service.EmprestimoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequestMapping("/emprestimo")
public class EmprestimoController {

    private final EmprestimoService service;

    public EmprestimoController(EmprestimoService service){
        this.service = service;
    }

    @PostMapping
    public Emprestimo inserirEmprestimo(@RequestBody Emprestimo emprestimo)throws SQLException{

        try{
            return service.salvarEmprestimo(emprestimo);
        }catch (SQLException e){
            e.printStackTrace();
        }
        throw new RuntimeException();
    }
 }
