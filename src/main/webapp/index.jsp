<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Как вас зовут?</title>
</head>
<form>
    <p><strong>Ваше имя?</strong></p>

</form>
<form method="post" action="fullName">
    <label for="name">Имя</label>
    <input name="name" id="name" required="required"/>

    <label for="surname">Фамилия</label>
    <input name="surname" id="surname" required="required"/>

    <label for="patronymic">Отчество</label>
    <input name="patronymic" id="patronymic"/>

    <label for="dateOfBirth">Дата рождения</label>
    <input type="date" id="dateOfBirth" name="dateOfBirth">

    <button>Сохранить</button>
</form>
</html>