<%@ page import="java.util.Timer" %>
<%@ page import="java.util.TimerTask" %>
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

        main section {
            display: flex;
            flex-direction: row;
            align-items: center;
            justify-content: center;
            margin-bottom: 12px;
            color: #fff;
            margin-top: 12px;
            background-color: #02cccc;
        }

        main section span {
            text-align: center;
        }

        .state-container {
            width: 150px;
            display: flex;
            flex-direction: column;
        }

        .state-header {
            font-weight: bold;
            text-align: center;
            color: #fff;
            padding: 8px;
            background-color: #02cccc;
        }

        .state-box {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            padding: 8px;
            background-color: #9a9a9a;
        }

        .red {
            background-color: red;
        }

        .yellow {
            background-color: yellow;
        }

        .green {
            background-color: green;
        }

        .state {
            width: 36px;
            border-radius: 50%;
            height: 36px;
            margin: 8px;
            box-shadow: 1px 1px 1px black;
        }

        .state-time-container {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
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
    <div class="state-container">
        <div class="state-header">S01</div>
        <div class="state-box">
            <div class="state-time-container">
                <div class="red state"></div>
                <span>30s</span>
            </div>
            <div class="state-time-container">
                <div class="yellow state"></div>
                <span>30s</span>
            </div>
            <div class="state-time-container">
                <div class="green state"></div>
                <span>30s</span>
            </div>
        </div>
    </div>
</main>
</body>
</html>
