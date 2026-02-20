package com.exemplo.biblioteca.controller;

import com.exemplo.biblioteca.model.Emprestimo;
import com.exemplo.biblioteca.service.EmprestimoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

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

    @GetMapping
    public List<Emprestimo> buscarTodos(){
        try{
            return service.buscarTodos();
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public Emprestimo buscarPorId(@PathVariable int id){
        try{
            return service.buscarPorId(id);
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public Emprestimo atualizarDataEmprestimo(@PathVariable int id, @RequestBody Emprestimo emprestimo){
        try{
            return service.atualizarDataEmprestimo(id, emprestimo);
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @PutMapping("/{id}/devolucao")
    public Emprestimo atualizarDataDevolucao(@PathVariable int id, @RequestBody Emprestimo emprestimo){
        try{
            return service.atualizarDataDevolucao(id, emprestimo);
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable int id){
        try{
            service.deletar(id);
            return new ResponseEntity<>("Deletado com sucesso!", HttpStatus.OK);
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }
 }
