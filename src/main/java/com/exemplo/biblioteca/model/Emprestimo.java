package com.exemplo.biblioteca.model;

import java.sql.Date;
import java.time.LocalDateTime;

public class Emprestimo {

    private int id;
    private int livro_id;
    private int usuario_id;
    private Date dataEmprestimo;
    private Date dataDevolução;

    public Emprestimo() {
    }

    public Emprestimo(int livro_id, int usuario_id, Date dataEmprestimo, Date dataDevolução) {
        this.livro_id = livro_id;
        this.usuario_id = usuario_id;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolução = dataDevolução;
    }

    public Emprestimo(int id, int livro_id, int usuario_id, Date dataEmprestimo, Date dataDevolução) {
        this.id = id;
        this.livro_id = livro_id;
        this.usuario_id = usuario_id;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolução = dataDevolução;
    }

    public Emprestimo(int livro_id, int usuario_id, Date dataEmprestimo) {
        this.livro_id = livro_id;
        this.usuario_id = usuario_id;
        this.dataEmprestimo = dataEmprestimo;
    }
    public Emprestimo(int id ,int livro_id, int usuario_id, Date dataEmprestimo) {
        this.id = id;
        this.livro_id = livro_id;
        this.usuario_id = usuario_id;
        this.dataEmprestimo = dataEmprestimo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLivro_id() {
        return livro_id;
    }

    public void setLivro_id(int livro_id) {
        this.livro_id = livro_id;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Date getDataDevolução() {
        return dataDevolução;
    }

    public void setDataDevolução(Date dataDevolução) {
        this.dataDevolução = dataDevolução;
    }
}
