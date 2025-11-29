<%@page import="com.da.crudmaven.model.Candidato"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Produto</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f4f4f4;
                margin: 0;
                padding: 20px;
            }
            h1 {
                color: #333;
            }
            form {
                background: #fff;
                padding: 20px;
                border-radius: 5px;
                box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
                max-width: 400px;
                margin: auto;
            }
            label {
                display: block;
                margin: 10px 0 5px;
            }
            input[type="text"],
            input[type="number"],
            input[type="hidden"] {
                width: 100%;
                padding: 10px;
                margin-bottom: 10px;
                border: 1px solid #ccc;
                border-radius: 4px;
                box-sizing: border-box;
            }
            input[type="submit"] {
                background-color: #5cb85c;
                color: white;
                padding: 10px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                width: 100%;
            }
            input[type="submit"]:hover {
                background-color: #4cae4c;
            }
        </style>
    </head>
    <body>
        <%
            Candidato f = (Candidato) request.getAttribute("candidato");
        %>
        <h1>Editar <% out.print(f.getNome()); %></h1>

        <form action="candidato" method="post">
    <input type="hidden" name="op" value="ATUALIZAR">
    <input type="hidden" name="id" value="${candidato.id}">

    <label>
        Nome:
        <input type="text" name="nome" value="${candidato.nome}" required>
    </label>
    <label>
        CPF:
        <input type="text" name="cpf" value="${candidato.cpf}" required>
    </label>
    <label>
        Data de nascimento:
        <input type="date" name="nascimento" value="${candidato.nascimento}" required>
    </label>
    <label>
        Possui deficiência?
        <select name="deficiencia" required>
            <option value="Sim" ${candidato.deficiencia ? 'selected' : ''}>Sim</option>
            <option value="Não" ${!candidato.deficiencia ? 'selected' : ''}>Não</option>
        </select>
    </label>
    <label>
        Endereço:
        <input type="text" name="endereco" value="${candidato.endereco}" required>
    </label>
    <label>
        Número:
        <input type="number" name="numero" value="<%= String.format("%.0f", f.getNumero()) %>">
    </label>
    <label>
        CEP:
        <input type="number" name="cep" value="<%= String.format("%.0f", f.getCep()) %>">
    </label>
    <label>
        Bairro:
        <input type="text" name="bairro" value="${candidato.bairro}" required>
    </label>
    <label>
        Área de interesse:
        <input type="text" name="areaInteresse" value="${candidato.areaInteresse}" required>
    </label>

    <input type="submit" value="Atualizar">
</form>
    </body>
</html>
