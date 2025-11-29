z<%-- 
    Document   : resultadoconsultartodos
    Created on : 27 de ago. de 2024, 08:42:36
    Author     : ptoledo
--%>

<%@page import="java.util.List"%>
<%@page import="com.da.crudmaven.model.Candidato"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consultar Todos</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #e7f3ff; /* Azul claro */
                margin: 0;
                padding: 20px;
                text-align: center;
            }
            h1 {
                color: #003366; /* Azul escuro */
            }
            table {
                width: 100%; /* Tabela ocupa toda a largura */
                border-collapse: collapse;
                margin-top: 20px;
                background: #ffffff;
            }
            th, td {
                padding: 10px;
                text-align: left;
                border: 1px solid #0099cc; /* Azul médio */
            }
            th {
                background-color: #0099cc; /* Azul médio */
                color: white;
            }
            tr:nth-child(even) {
                background-color: #f0faff; /* Azul muito claro */
            }
            tr:hover {
                background-color: #cce7ff; /* Azul suave ao passar o mouse */
            }
            a {
                text-decoration: none; /* Remove underline dos links */
            }
            img {
                width: 30px; /* Largura da imagem do ícone */
                height: 30px; /* Altura da imagem do ícone */
                transition: opacity 0.2s; /* Efeito de transição */
            }
            img:hover {
                opacity: 0.8; /* Efeito ao passar o mouse */
            }
        </style>
    </head>
    <body>
        <h1>Consultar Todos</h1>
        <%
            List<Candidato> candidatos = (List<Candidato>) request.getAttribute("candidatos");
        %>

        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>CPF</th>
                    <th>Data Nasc.</th>
                    <th>Endereco</th>
                    <th>Número</th>
                    <th>CEP</th>
                    <th>Bairro</th>
                    <th>Área de interesse</th>
                    <th>Possui Deficiencia</th>
                    <th>Ações</th> <!-- Coluna para ações -->
                </tr>
            </thead>
            <tbody>
                <% for (Candidato cand : candidatos) { %>
                <tr>
                    <td><% out.print(cand.getId()); %></td>
                    <td><% out.print(cand.getNome()); %></td>
                    <td><% out.print(cand.getCpf()); %></td>
                    <td><% out.print(cand.getNascimento()); %></td>
                    <td><% out.print(cand.getEndereco()); %></td>
                    <td><%= String.format("%.0f", cand.getNumero()) %></td>
                    <td><%= String.format("%.0f", cand.getCep()) %></td>
                    <td><% out.print(cand.getBairro()); %></td>
                    <td><% out.print(cand.getAreaInteresse()); %></td>
                    <td><%out.print(cand.getDeficiencia());%></td>
                    <td>
                        <a href="candidato?op=EDITAR&id=<% out.print(cand.getId()); %>">
                            <img src="https://cdn-icons-png.flaticon.com/512/1159/1159633.png" alt="Editar" title="Editar">
                        </a>
                        <a class="delete-f" href="candidato?op=DELETAR&id=<% out.print(cand.getId()); %>">
                            <img src="https://cdn-icons-png.flaticon.com/512/126/126468.png" alt="Remover" title="Remover">
                        </a>
                    </td>
                </tr>
                <% } %>
            </tbody>
        </table>
            <script>
                const deleteBtns = document.querySelectorAll('a.delete-f');
                
                for (const delBtn of deleteBtns) {
                    delBtn.addEventListener('click', (evt) => {
                        const confirm = prompt('Tem certeza que quer deletar? Digite sim');
                        if (confirm !== 'sim') {
                            evt.preventDefault();
                        }
                    });
                }
            </script>
    </body>
</html>
