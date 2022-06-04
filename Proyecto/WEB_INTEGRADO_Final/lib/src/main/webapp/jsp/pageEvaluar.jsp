<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

<title>Ecomerce</title>
	<link href="../css/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="<%=request.getContextPath()%>/css/sb-admin-2.css" rel="stylesheet">
</head>
<body id="page-top">
<%@ page import="utp.webIntegrado.dao.*" %>
<%@ page import="utp.webIntegrado.entidades.*" %>
<%@ page import="java.util.List"%>




    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
                <div class="sidebar-brand-icon rotate-n-15">
                    <i class="fas fa-laugh-wink"></i>
                </div>
                <div class="sidebar-brand-text mx-3">Curso<sub>Education</sub></div>
            </a>

           
            <hr class="sidebar-divider">

            <!-- Heading -->
           <div class="sidebar-heading">
                <c:out value="${DTOObtenerUsuarioMenu.nombreRol}"></c:out>
            </div>

            <!-- Nav Item - Pages Collapse Menu -->
            <c:forEach items ="${DTOObtenerUsuarioMenu.lstMenu}" var="e"> 
            	<li class="nav-item">
                <a class="nav-link" href="<%=request.getContextPath() %>/jsp/${e.link}.jsp">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>  ${ e.nombre }</span></a>
            	</li>            
            </c:forEach>                         

        </ul>
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
                <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                    <!-- Sidebar Toggle (Topbar) -->
                    <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                        <i class="fa fa-window-close"></i> <span class="mr-2 d-none d-lg-inline text-gray-600 small"> <c:out value="${DTOObtenerUsuarioMenu.nombreUsuario}"></c:out></span> 
                    </button>

                   

                    <!-- Topbar Navbar -->
                    <ul class="navbar-nav ml-auto">

                       
                        <div class="topbar-divider d-none d-sm-block"></div>
							
						
                        <!-- Nav Item - User Information -->
                        <li class="nav-item dropdown no-arrow">
                        	
                            	
                            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                 <span class="mr-2 d-none d-lg-inline text-gray-600 small"><c:out value="${DTOObtenerUsuarioMenu.nombreUsuario}"></c:out></span>                              
                            </a>
                            <!-- Dropdown - User Information -->
                            
                        </li>

                    </ul>

                </nav>
                <!-- End of Topbar -->
                
          		<!---------Colocar contenido ------------------->
          		<div class="container">      
          		<h1>Evaluar Participantes:</h1>
          		       <form method="post" action="<%=request.getContextPath() %>/ServletPostParticipanteEvaluar">
						Participante:
						<input type="text" name="cadena"/>
						<input name="vista" value="" class="d-none" />
						<input class="btn btn-success" type="submit" value="Buscar">
						</form>
						<br/>
						
						<table class="table">
							<thead>
							   <tr>
							     <td>#</td>
							     <td>Participante</td>
							     <td>Curso</td>
							     <td>Nota</td> 
							     <td></td> 
							   </tr>
							</thead>
							<tbody>
								
								<c:forEach items="${lstParticipantesEvaluar}" var="e"  >
								<tr>
									<td> <c:out  value="${ e.idParticipante }"> </c:out>  </td>
									<td> <c:out  value="${ e.participante }"> </c:out>  </td>
									<td> <c:out  value="${ e.cursoNombre }"> </c:out>  </td>
									<td>
									<form method="post" action="<%=request.getContextPath() %>/ServletPostParticipanteEvaluar"  >
										<input name="nota" type="text" value="0.0" >
										<input class="d-none" name="vista" value="grabar" >
										<input class="d-none" name="idParticipanteMatricula" value="${e.idMatriculaParticipante}" >
										<input class="btn btn-success" type="submit" value="Grabar" >
									</form>
									</td>
								</tr>	
								</c:forEach>
								
							</tbody>
						</table>
          		
                
            </div>
            <!-- End of Main Content -->

            <!-- Footer -->
            <footer class="sticky-footer bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>Copyright &copy; Your Website 2021</span>
                    </div>
                </div>
            </footer>
            <!-- End of Footer -->

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">�</span>
                    </button>
                </div>
                <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" href="login.html">Logout</a>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin-2.min.js"></script>

    <!-- Page level plugins -->
    <script src="vendor/chart.js/Chart.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="js/demo/chart-area-demo.js"></script>
    <script src="js/demo/chart-pie-demo.js"></script>

		
	
	
</body>
</html>