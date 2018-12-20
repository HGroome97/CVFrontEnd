<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page import="com.qa.util.Constants" %>
<html>
<head>
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
  <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
  <link rel="stylesheet" type="text/css" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
    <title>Register</title>
</head>

<body >

  <c:set var="LOGIN_API_URL_BASE" scope ="session"><%=Constants.LOGIN_API_URL_BASE%></c:set>
  <c:set var="LOGIN_API_URL_CREATE" scope ="session"><%=Constants.LOGIN_API_URL_CREATE%></c:set>
  <c:set var="POST_REQUEST" scope ="session"><%=Constants.POST_REQUEST%></c:set>
  <c:set var="LOGIN_URL" scope ="session"><%=Constants.LOGIN_URL%></c:set>
  <c:set var="TRAINEE_ROLE" scope ="session"><%=Constants.TRAINEE_ROLE%></c:set>


  <div class="container" style="margin: 50px;border: 1px solid green;">
		<h3>CV Management System Registration</h3>
		<c:if test="${param.error ne null}">
			<div style="color: red">Invalid credentials.</div>
		</c:if>
		<form onsubmit="return false;" method="${POST_REQUEST}">
			<div class="form-group">
				<label for="username">Username:</label>
        <input type="text" class="form-control" id="username" name="username">
			</div>
			<div class="form-group">
				<label for="pwd">Password:</label>
        <input type="password" class="form-control" id="pwd" name="password">
			</div>

			<button type="submit" class="btn btn-success" onclick="register()">Submit</button>
      <a href="/login">or login</a>

		</form>
    <script>
      register = function() {
        var xhr = new XMLHttpRequest();
        var url = "${LOGIN_API_URL_BASE}${LOGIN_API_URL_CREATE}";
        xhr.open("${POST_REQUEST}", url, true);
        xhr.setRequestHeader("Content-Type", "application/json");
        xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
          console.log(xhr.responseText);
        }
        };
        var username = document.getElementById('username').value;
        var pwd = document.getElementById('pwd').value;

        var data = JSON.stringify({
	         "username":username,
	         "password":pwd,
	         "enabled":true,
	         "role":"${TRAINEE_ROLE}"
        });
        xhr.send(data);
        document.getElementById('username').value="";
        document.getElementById('pwd').value="";
        window.location.href = "${LOGIN_URL}";
        alert("Successfully registered!")
      }
    </script>
	</div>

</body>
</html>
