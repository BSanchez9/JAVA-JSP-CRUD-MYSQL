<%-- 
    Document   : resultadoconsultarbyid
    Created on : 26 de ago. de 2024, 11:03:00
    Author     : ptoledo
--%>

<%@page import="com.da.crudmaven.model.Candidato"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado da Consulta por ID</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #e7f3ff; /* Azul claro */
                margin: 0;
                padding: 20px;
            }
            h1 {
                color: #003366; /* Azul escuro */
                text-align: center;
            }
            .table-container {
                overflow-x: auto; /* Permite rolagem horizontal em telas pequenas */
            }
            table {
                width: 100%; /* Faz a tabela ocupar toda a largura disponível */
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
            .btn {
                background: none;
                border: none;
                cursor: pointer;
                padding: 0;
                margin: 0 5px;
            }
            .btn img {
                width: 20px; /* Largura da imagem do ícone */
                height: 20px; /* Altura da imagem do ícone */
            }
            .btn:hover img {
                opacity: 0.8; /* Efeito ao passar o mouse */
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
        <h1>Resultado Consultar ID</h1>
        <%
            Candidato cand = (Candidato) request.getAttribute("candidato");
        %>
        <div class="table-container">
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nome</th>
                        <th>CPF</th>
                        <th>Data Nasc.</th>
                        <th>Endereço</th>
                        <th>Número</th>
                        <th>CEP</th>
                        <th>Bairro</th>
                        <th>Área de interesse</th>
                        <th>Possui Def</th>
                        <th>Ações</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><%out.print(cand.getId());%></td>
                        <td><%out.print(cand.getNome());%></td>
                        <td><%out.print(cand.getCpf());%></td>
                        <td><%out.print(cand.getNascimento());%></td>
                        <td><%out.print(cand.getEndereco());%></td>
                        <td><%= String.format("%.0f", cand.getNumero()) %></td>
                        <td><%= String.format("%.0f", cand.getCep()) %></td>
                        <td><%out.print(cand.getBairro());%></td>
                        <td><%out.print(cand.getAreaInteresse());%></td>
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
                </tbody>
            </table>
        </div>
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
