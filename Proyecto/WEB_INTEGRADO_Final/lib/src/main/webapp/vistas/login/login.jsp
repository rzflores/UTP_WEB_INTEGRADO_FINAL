<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<title>Ecomerce</title>

<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">


<link href="./css/styles.css" rel="stylesheet" type="text/css" >

</head>
<body>
	<div class="container">
		<div class="row text-center login-page">
			<div class="col-md-12 login-form">
				<form action="<%=request.getContextPath() %>/ServletLogin" method="post"> 				
					
					<div class="row">
						<div class="col-md-12 login-form-header">
							<p class="login-form-font-header">Curso<span>Education</span><p>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12 login-from-row">
							<input  name="usuario" type="text" placeholder="Correo" required/>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12 login-from-row">
							<input name="password" type="password" placeholder="Contrase�a" required/>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12 login-from-row">
							<input class="btn btn-info" type="submit" value="Ingresar"></input>
						</div>
					</div>
				</form>
			</div>
		</div>
</body>
</html>