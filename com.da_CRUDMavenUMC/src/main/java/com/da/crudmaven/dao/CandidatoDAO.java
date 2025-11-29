/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.da.crudmaven.dao;

/**
 *
 * @author Beyonder
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.da.crudmaven.model.Candidato;
import com.da.crudmaven.util.Conexao;

public class CandidatoDAO {

    public void cadastrar(Candidato f) throws ClassNotFoundException, SQLException {
        try (Connection con = Conexao.getConexao()) {
            PreparedStatement comando = con.prepareStatement("INSERT INTO candidatos (nome, cpf, nascimento, endereco, numero, cep, bairro, areaInteresse, deficiencia) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            comando.setString(1, f.getNome());
            comando.setString(2, f.getCpf());
            comando.setDate(3, new java.sql.Date(f.getNascimento().getTime()));
            comando.setString(4, f.getEndereco());
            comando.setFloat(5, f.getNumero());
            comando.setFloat(6, f.getCep());
            comando.setString(7, f.getBairro());
            comando.setString(8, f.getAreaInteresse());
            comando.setBoolean(9, f.getDeficiencia());
            
            comando.execute();
        }
    }
    
    public void deletar(Candidato f) throws ClassNotFoundException, SQLException {
        try (Connection con = Conexao.getConexao()) {
            PreparedStatement comando = con.prepareStatement("DELETE FROM candidatos WHERE id = ?");
            comando.setInt(1, f.getId());
            comando.execute();
        }
    }
    
    public void atualizar(Candidato f) throws ClassNotFoundException, SQLException {
        try (Connection con = Conexao.getConexao()) {
            PreparedStatement comando = con.prepareStatement("UPDATE candidatos SET nome = ?, cpf = ?, nascimento = ?, endereco = ?, numero = ?, cep = ?, bairro = ?, areaInteresse = ?, deficiencia = ? WHERE id = ?");
            comando.setString(1, f.getNome());
            comando.setString(2, f.getCpf());
            comando.setDate(3, new java.sql.Date(f.getNascimento().getTime()));
            comando.setString(4, f.getEndereco());
            comando.setFloat(5, f.getNumero());
            comando.setFloat(6, f.getCep());
            comando.setString(7, f.getBairro());
            comando.setString(8, f.getAreaInteresse());
            comando.setBoolean(9, f.getDeficiencia());
            comando.setInt(10, f.getId());
            comando.execute();
        }
    }

    public Candidato consultarById(Candidato candidato) throws ClassNotFoundException, SQLException {
        Candidato f;
        try (Connection con = Conexao.getConexao()) {
            PreparedStatement comando = con.prepareStatement("SELECT * FROM candidatos WHERE id = ?");
            comando.setInt(1, candidato.getId());
            ResultSet resultado = comando.executeQuery();
            f = null;
            if (resultado.next()) {
                f = new Candidato(
                        resultado.getInt("id"),
                        resultado.getString("nome"),
                        resultado.getString("cpf"),
                        resultado.getDate("nascimento"),
                        resultado.getString("endereco"),
                        resultado.getFloat("numero"),
                        resultado.getFloat("cep"),
                        resultado.getString("bairro"),
                        resultado.getString("areaInteresse"),
                        resultado.getBoolean("deficiencia"));
            }
        }
        return f;
    }

    public List<Candidato> consultarTodos() throws ClassNotFoundException, SQLException {
        List<Candidato> todosCandidatos;
        try (Connection con = Conexao.getConexao()) {
            PreparedStatement comando = con.prepareStatement("SELECT * FROM candidatos");
            ResultSet resultado = comando.executeQuery();
            todosCandidatos = new ArrayList<>();
            while (resultado.next()) {
                Candidato f = new Candidato(
                        resultado.getInt("id"),
                        resultado.getString("nome"),
                        resultado.getString("cpf"),
                        resultado.getDate("nascimento"),
                        resultado.getString("endereco"),
                        resultado.getFloat("numero"),
                        resultado.getFloat("cep"),
                        resultado.getString("bairro"),
                        resultado.getString("areaInteresse"),
                        resultado.getBoolean("deficiencia"));
                todosCandidatos.add(f);
            }
        }
        return todosCandidatos;
    }
}
