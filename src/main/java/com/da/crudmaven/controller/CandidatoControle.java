package com.da.crudmaven.controller;

import com.da.crudmaven.dao.CandidatoDAO;
import com.da.crudmaven.model.Candidato;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CandidatoControle", urlPatterns = {"/candidato"})

public class CandidatoControle extends HttpServlet {
 


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");


        /* TODO output your page here. You may use following sample code. */

        String op = request.getParameter("op");
        String resultado;

        switch (op) {
            case "CADASTRAR":
                {
                    String nome = request.getParameter("nome");
                    String cpf = request.getParameter("cpf");
                    String dataNascText = request.getParameter("nascimento");
                    String endereco = request.getParameter("endereco");
                    float numero = Float.parseFloat(request.getParameter("numero"));
                    float cep = Float.parseFloat(request.getParameter("cep"));
                    String bairro = request.getParameter("bairro");
                    String areaInteresse;
            areaInteresse = request.getParameter("areaInteresse");
                    String deficienciaTxt = request.getParameter("deficiencia");
                    LocalDate dataNascLocal = LocalDate.parse(dataNascText);
                    Date dataNasc = Date.from(dataNascLocal.atStartOfDay(ZoneId.systemDefault()).toInstant());
                    Boolean deficiencia = false;
                    if ("true".equalsIgnoreCase(deficienciaTxt) || "1".equals(deficienciaTxt) || "Sim".equalsIgnoreCase(deficienciaTxt)) {
                    deficiencia = true;
                                      

                    }       CandidatoDAO fdao = new CandidatoDAO();
                    Candidato f = new Candidato(
                            0,
                            nome,
                            cpf,
                            dataNasc,
                            endereco,
                            numero,
                            cep,
                            bairro,
                            areaInteresse,
                            deficiencia
                    );      try {
                        fdao.cadastrar(f);
                        resultado = "Cadastrado com muito Sucesso.";
                        request.setAttribute("msg", resultado);
                    } catch (ClassNotFoundException | SQLException ex) {
                        System.out.println("Erro: " + ex.getMessage());
                        resultado = "Erro ao cadastrar.";
                        request.setAttribute("msg", resultado);
                    } finally {
                        request.getRequestDispatcher("sucesso.jsp").forward(request, response);
                    }       break;
                }

            case "DELETAR":
                {
                    int id = Integer.parseInt(request.getParameter("id"));
                    CandidatoDAO fdao = new CandidatoDAO();
                    Candidato f = new Candidato();
                    f.setId(id);
                    try {
                        fdao.deletar(f);
                        List<Candidato> candidatos = fdao.consultarTodos();
                        request.setAttribute("candidatos", candidatos);
                        request.getRequestDispatcher("resultadoconsultartodos.jsp").forward(request, response);
                    } catch (ClassNotFoundException | SQLException ex) {
                        System.out.println("Erro: " + ex.getMessage());
                        resultado = "Erro ao deletar.";
                        request.setAttribute("msg", resultado);
                        request.getRequestDispatcher("sucesso.jsp").forward(request, response);
                    }       break;
                }
            case "CONSULTARBYID":
                {
                    int id = Integer.parseInt(request.getParameter("id"));
                    CandidatoDAO fdao = new CandidatoDAO();
                    Candidato f = new Candidato();
                    f.setId(id);
                    try {
                        f = fdao.consultarById(f);
                        request.setAttribute("candidato", f);
                        request.getRequestDispatcher("resultadoconsultarbyid.jsp").forward(request, response);
                    } catch (ClassNotFoundException | SQLException ex) {
                        System.out.println("Erro: " + ex.getMessage());
                        resultado = "Erro ao consultar por ID.";
                        request.setAttribute("msg", resultado);
                        request.getRequestDispatcher("sucesso.jsp").forward(request, response);
                    }       break;
                }
            case "CONSULTARTODOS":
                {
                    CandidatoDAO fdao = new CandidatoDAO();
                    try {
                        List<Candidato> candidatos = fdao.consultarTodos();
                        request.setAttribute("candidatos", candidatos);
                        request.getRequestDispatcher("resultadoconsultartodos.jsp").forward(request, response);
                    } catch (ClassNotFoundException | SQLException ex) {
                        System.out.println("Erro: " + ex.getMessage());
                        resultado = "Erro ao consultar todos.";
                        request.setAttribute("msg", resultado);
                        request.getRequestDispatcher("sucesso.jsp").forward(request, response);
                    }       break;
                }
            case "ATUALIZAR":
                {                    
                    int id = Integer.parseInt(request.getParameter("id"));
                    String nome = request.getParameter("nome");
                    String cpf = request.getParameter("cpf");
                    String dataNascText = request.getParameter("nascimento");
                    String endereco = request.getParameter("endereco");
                    float numero = Float.parseFloat(request.getParameter("numero"));
                    float cep = Float.parseFloat(request.getParameter("cep"));
                    String bairro = request.getParameter("bairro");
                    String areaInteresse = request.getParameter("areaInteresse");
                    String deficienciaTxt = request.getParameter("deficiencia");
                    LocalDate dataNascLocal = LocalDate.parse(dataNascText);
                    Date dataNasc = Date.from(dataNascLocal.atStartOfDay(ZoneId.systemDefault()).toInstant());
                    Boolean deficiencia = false;
                    if ("true".equalsIgnoreCase(deficienciaTxt) || "1".equals(deficienciaTxt) || "Sim".equalsIgnoreCase(deficienciaTxt)) {
                    deficiencia = true;
                    }       CandidatoDAO fdao = new CandidatoDAO();
                    Candidato f = new Candidato(
                            id,
                            nome,
                            cpf,
                            dataNasc,
                            endereco,
                            numero,
                            cep,
                            bairro,
                            areaInteresse,
                            deficiencia
                    );      try{
                        fdao.atualizar(f);
                        resultado = "Atualizado com Sucesso.";
                        request.setAttribute("msg", resultado);
                    } catch (ClassNotFoundException | SQLException ex){
                        resultado = "Erro ao atualizar.";
                        request.setAttribute("msg", resultado);
                        System.out.println("ERRO: " + ex.getMessage());
                    }       request.getRequestDispatcher("sucesso.jsp").forward(request, response);
                    break;
                }
            case "EDITAR":
                {
                    int id = Integer.parseInt(request.getParameter("id"));
                    CandidatoDAO fdao = new CandidatoDAO();
                    Candidato f = new Candidato();
                    f.setId(id);
                    try {
                        f = fdao.consultarById(f);
                        request.setAttribute("candidato", f);
                        request.getRequestDispatcher("formularioeditar.jsp").forward(request, response);
                    } catch (ClassNotFoundException | SQLException ex) {
                        System.out.println("Erro: " + ex.getMessage());
                        resultado = "Erro ao consultar.";
                        request.setAttribute("msg", resultado);
                        request.getRequestDispatcher("sucesso.jsp").forward(request, response);
                    }       break;
                }
            default:
                break;
        }

    }
 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}