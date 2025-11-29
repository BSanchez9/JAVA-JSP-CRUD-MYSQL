/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package com.da.crudmaven.model;
 
import java.util.Date;
 
/**
*
* @author alunocmc
*/
public class Candidato {
 
    public Candidato() {
        super();
    }
    private int id;
    private String nome;
    private String cpf;
    private Date nascimento;
    private String endereco;
    private float numero;
    private float cep;
    private String bairro;
    private String areaInteresse;
    private boolean deficiencia;
    
     public Candidato(int id, String nome, String cpf, Date nascimento, String endereco, float numero, float cep, String bairro, String areaInteresse, Boolean deficiencia) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.nascimento = nascimento;
        this.endereco = endereco;
        this.numero = numero;
        this.cep = cep;
        this.bairro = bairro;
        this.areaInteresse = areaInteresse;
        this.deficiencia = deficiencia;

     }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public float getNumero() {
        return numero;
    }

    public void setNumero(float numero) {
        this.numero = numero;
    }

    public float getCep() {
        return cep;
    }

    public void setCep(float cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getAreaInteresse() {
        return areaInteresse;
    }

    public void setAreaInteresse(String areaInteresse) {
        this.areaInteresse = areaInteresse;
    }
    
    public boolean getDeficiencia() {
        return deficiencia;
    }
    
    public boolean isDeficiencia() {
        return deficiencia;
    }

    public void setDeficiencia(boolean deficiencia) {
        this.deficiencia = deficiencia;
    }}
    