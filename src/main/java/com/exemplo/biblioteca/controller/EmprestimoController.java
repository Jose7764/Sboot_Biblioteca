package com.exemplo.biblioteca.controller;

import com.exemplo.biblioteca.dto.Emprestimo.EmprestimoResponseDto;
import com.exemplo.biblioteca.dto.Emprestimo.EmprestimoResquestDto;
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
    public EmprestimoResponseDto inserirEmprestimo(@RequestBody EmprestimoResquestDto emprestimo)throws SQLException{

        try{
            return service.salvarEmprestimo(emprestimo);
        }catch (SQLException e){
            e.printStackTrace();
        }
        throw new RuntimeException();
    }

    @GetMapping
    public List<EmprestimoResponseDto> buscarTodos(){
        try{
            return service.buscarTodos();
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public EmprestimoResponseDto buscarPorId(@PathVariable int id){
        try{
            return service.buscarPorId(id);
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public EmprestimoResponseDto atualizarDataEmprestimo(@PathVariable int id, @RequestBody EmprestimoResquestDto emprestimo){
        try{
            return service.atualizarDataEmprestimo(id, emprestimo);
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @PutMapping("/{id}/devolucao")
    public EmprestimoResponseDto atualizarDataDevolucao(@PathVariable int id, @RequestBody Emprestimo emprestimo){
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
