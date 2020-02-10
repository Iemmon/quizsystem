<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : 'en'}"
       scope="session"></c:set>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="localization"/>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<div class="container-fluid">
    <div class="row ">
        <div class="col-1 offset-10">
            <form>
                <select id="language" name="language" onchange="submit()">
                    <option value="en" ${language == 'en' ? 'selected' : ''}><fmt:message key="en"/></option>
                    <option value="ru" ${language == 'ru' ? 'selected' : ''}><fmt:message key="ru"/></option>
                </select>
            </form>
        </div>
    </div>

    <c:if test="${has_error != null}">
        <div class="row">
            <div class="col-2 offset-3">
                <p><fmt:message key="login-error"/></p>
            </div>
        </div>
    </c:if>

    <form method="post" action="${pageContext.servletContext.contextPath}/">
        <input type="hidden" name="command" value="processlogin">
        <div class="row">
            <div class="col-2 offset-5">
                <input type="text" name="email" required
                       pattern="^[a-zA-Z0-9_.-]+@[a-zA-Z0-9]+[\.][a-z]+$" placeholder="<fmt:message key="email"/>"/>
            </div>
        </div>

        <div class="row">
            <div class="col-2 offset-5">
                <input type="password" name="pass" required placeholder="<fmt:message key="pass"/>"/><br/>
            </div>
        </div>
        <div class="row">
            <div class="col-2 offset-5">
                <input type="submit" class="btn btn-info"/>
                <a href="?command=register"><fmt:message key="register"/></a>
            </div>
        </div>
    </form>
</div>
</div>
</div>
</body>
</html>
