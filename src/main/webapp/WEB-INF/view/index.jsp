<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>

<head>
    <meta charset="utf-8">
    <title>Test-project</title>
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.9.1.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="resources/js/script.js"></script>
</head>
<body>

<h1 class="h2 page-header text-center">Тестовый блокнот с отправкой писем</h1>

<div class="container">
    <div class="row">
        <div class="col-sm-6 col-sm-offset-3">
            <!-- Контейнер, содержащий форму обратной связи -->
            <div class="panel panel-info">
                <!-- Заголовок контейнера -->
                <div class="panel-heading">
                    <h3 class="panel-title"></h3>
                </div>
                <!-- Содержимое контейнера -->
                <div class="panel-body">

                    <!-- Сообщение, отображаемое в случае успешной отправки данных -->
                    <div class="alert alert-success hidden" role="alert" id="successMessage">
                        <strong>Внимание!</strong> Ваше сообщение успешно отправлено.
                    </div>

                    <form id="contactForm" action="add" method="POST">
                        <div class="row">

                            <div id="error" class="col-sm-12" style="color: #ff0000; margin-top: 5px; margin-bottom: 5px;"></div>

                            <!-- Имя и email пользователя -->
                            <div class="col-sm-6">
                                <!-- Имя пользователя -->
                                <div class="form-group has-feedback">
                                    <label for="name" class="control-label">Введите ваше имя:</label>
                                    <input type="text" id="name" name="name" class="form-control"  value="" placeholder="Например, Иван Иванович" minlength="1" maxlength="30">
                                    <span class="glyphicon form-control-feedback"></span>
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <!-- Email пользователя -->
                                <div class="form-group has-feedback">
                                    <label for="email" class="control-label">Введите адрес email:</label>
                                    <input type="email" id="email" name="email" class="form-control"   value="" placeholder="Например, ivan@mail.ru" maxlength="30">
                                    <span class="glyphicon form-control-feedback"></span>
                                </div>
                            </div>
                        </div>

                        <button type="submit" id="btn-add" class="btn btn-primary pull-right" >Добавить запись</button><br><br><br>
                        </form>
                        <form id="sendForm" action="index" method="POST">
                        <table class="table table-bordered" name="myTable"  id="myTable">
                            <thead>
                            <tr>
                                <th>Имя</th>
                                <th>E-mail</th>
                                <th>      </th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="next" items="${list}">
                                <tr>
                                    <td>${next.getName()}</td>
                                    <td>${next.getEmail()}</td>
                                    <td><button type="button" class="btn btn-primary pull-right btn-send">Выбрать</button></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        <div class="col-sm-4">
                            <!-- Имя пользователя -->
                            <div class="form-group has-feedback">
                                <input type="text" id="name-send" name="name-send" class="form-control" value="" minlength="1" maxlength="30">
                                <span class="glyphicon form-control-feedback"></span>
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <!-- Email пользователя -->
                            <div class="form-group has-feedback">
                                <input type="email" id="email-send" name="email-send" class="form-control" value="" maxlength="30">
                                <span class="glyphicon form-control-feedback"></span>
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <button type="submit" class="btn btn-primary pull-right">Отправить</button>
                        </div>

                    </form>

                </div>
            </div>

        </div>
    </div>
</div>


</body>
</html>