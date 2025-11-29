/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.da.crudmaven.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class Conexao {
    
    public static final String USUARIO = "root";
    public static final String SENHA = "";
    public static final String BANCO = "candidato";
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://127.0.0.1:3306/" + BANCO + "?user=" + USUARIO;
    
    public static Connection getConexao() throws SQLException, ClassNotFoundException {
        try{
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        }catch (ClassNotFoundException e) {
            throw new ClassNotFoundException("Driver não encontrado" + e.getMessage());
        }catch (SQLException e) {
            throw new SQLException("Base de dados inacessivel" + e.getMessage());
        }
    }
    public static void fechaConexao(Connection con) {
        try {
            if (con != null) {
                con.close();
                System.out.println("Fechada a conexão com o banco de dados");
            }
        } catch (SQLException e) {
            System.out.println("Não foi possível fechar a conexão com o banco de dados " + e.getMessage());
        }
    }

    public static void fechaConexao(Connection con, PreparedStatement stmt) {
        try {
            if (con != null) {
                fechaConexao(con);
            }
            if (stmt != null) {
                stmt.close();
                System.out.println("Statement fechado com sucesso");
            }
        } catch (SQLException e) {
            System.out.println("Não foi possível fechar o statement " + e.getMessage());
        }
    }

    public static void fechaConexao(Connection con, PreparedStatement stmt, ResultSet rs) {
        try {
            if (con != null || stmt != null) {
                fechaConexao(con, stmt);
            }
            if (rs != null) {
                rs.close();
                System.out.println("ResultSet fechado com sucesso");
            }
        } catch (SQLException e) {
            System.out.println("Não foi possível fechar o ResultSet " + e.getMessage());
        }
    }

    public static Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
      }
    }