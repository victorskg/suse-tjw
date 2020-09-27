<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="javatime" uri="http://sargue.net/jsptags/time" %>
<html>
<head>
    <title>SUSE | Planos Semafóricos</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: 'Arial';
        }

        header {
            display: flex;
            flex-direction: row;
            overflow: hidden;
            background: #00cccc;
            padding: 18px 12px;
        }

        header a {
            float: left;
            color: #fff;
            text-align: center;
            padding: 8px;
            text-decoration: none;
            font-size: 16px;
            line-height: 14px;
            border-radius: 14px;
            margin: 0 8px;
        }

        header div.logo {
            flex: 50;
            align-self: center;
            align-content: start;
            font-size: 25px;
            font-weight: bold;
            color: #fff;
        }

        header a:hover {
            background: #12a7ca96;
        }

        header a.active {
            background-color: #009a9b;
            color: white;
        }

        .header-right {
            float: right;
        }

        main {
            display: flex;
            flex-direction: column;
        }

        main section {
            padding: 12px;
        }

        main section .section-header {
            display: flex;
            flex-direction: row;
            align-items: center;
            justify-content: flex-end;
            margin-bottom: 12px;
        }

        table {
            width: 100%;
            font-family: 'Arial';
            border-collapse: collapse;
            border: 1px solid #eee;
            border-bottom: 2px solid #00cccc;
            box-shadow: 0px 0px 20px rgba(0, 0, 0, 0.10),
            0px 10px 20px rgba(0, 0, 0, 0.05),
            0px 20px 20px rgba(0, 0, 0, 0.05),
            0px 30px 20px rgba(0, 0, 0, 0.05);
        }

        tr {
            background: #f4f4f4;
        }

        td {
            color: #555;
        }

        th, td {
            color: #999;
            border: 1px solid #eee;
            padding: 12px 24px;
            border-collapse: collapse;
        }

        th {
            background: #00cccc;
            color: #fff;
            text-transform: uppercase;
            font-size: 12px;
        }

        .add-button {
            background-color: #00cccc;
            color: #fff;
            padding: 8px;
            border: none;
        }

        .add-button:hover {
            background: #12a7ca96;
        }

        .add-button a {
            text-decoration: none;
            color: inherit;
        }
    </style>
</head>
<body>
<header>
    <div class="logo">
        <span>SUSE</span>
    </div>
    <div class="header-right">
        <a href="painel">Painel</a>
        <a href="semaforos">Semáforos</a>
        <a href="planos-semaforicos" class="active">Planos Semafóricos</a>
    </div>
</header>
<main>
    <section>
        <div class="section-header">
            <button class="add-button">
                <a href="planos-semaforicos">Novo Plano Semafórico</a>
            </button>
        </div>
        <table>
            <thead>
            <tr>
                <th>Id</th>
                <th>Tempo Verde</th>
                <th>Tempo Vermelho</th>
                <th>Tempo Amarelo</th>
                <th>Criado em</th>
                <th colspan=2>Ação</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${planos}" var="plano">
                <tr>
                    <td><c:out value="${plano.id}"/></td>
                    <td><c:out value="${plano.tempoVerde}"/>s</td>
                    <td><c:out value="${plano.tempoVermelho}"/>s</td>
                    <td><c:out value="${plano.tempoAmarelo}"/>s</td>
                    <td><c:out value="${plano.dataCadastro}"/></td>
                    <td><a href="planos-semaforicos?acao=excluir&id=<c:out value="${plano.id}"/>">Excluir</a></td>
                    <td><a href="planos-semaforicos?acao=atualizar&id=<c:out value="${plano.id}"/>">Atualizar</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </section>
</main>
</body>
</html>
