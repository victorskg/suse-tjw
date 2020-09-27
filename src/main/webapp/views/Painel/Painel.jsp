<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>SUSE | Painel</title>
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
    </style>
</head>
<body>
<header>
    <div class="logo">
        <span>SUSE</span>
    </div>
    <div class="header-right">
        <a href="painel" class="active">Painel</a>
        <a href="semaforos">Semáforos</a>
        <a href="planos-semaforicos">Planos Semafóricos</a>
    </div>
</header>
<main>
    <section>
        <span>Cadastre um semáforo e associe a um plano semafórico para visualizar seu funcionamento.</span>
    </section>
</main>
</body>
</html>
