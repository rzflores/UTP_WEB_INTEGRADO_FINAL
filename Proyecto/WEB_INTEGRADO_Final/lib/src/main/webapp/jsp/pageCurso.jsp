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

<%
	DaoCurso dao = new DaoCurso();
	List<Curso> lst = dao.consultarCurso(); 
%>


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

            <!-- Divider -->
            
            <!--<hr class="sidebar-divider my-0">-->

            <!--<!-- Nav Item - Dashboard -->
            <!--<li class="nav-item active">-->
            <!--    <a class="nav-link" href="index.html">-->
            <!--        <i class="fas fa-fw fa-tachometer-alt"></i>-->
             <!--       <span>Dashboard</span></a>-->
            <!--</li>-->

            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Heading -->
            <div class="sidebar-heading">
                Administrador
            </div>

            <!-- Nav Item - Pages Collapse Menu -->
             <li class="nav-item active">
                <a class="nav-link" href="pageCurso.jsp">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>Cursos</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="pageCategoria.jsp">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>Categoria</span></a>
            </li>
			 <li class="nav-item">
                <a class="nav-link" href="pageTemario.jsp">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>Temario</span></a>
            </li>                    

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
                        <i class="fa fa-window-close"></i> <span class="mr-2 d-none d-lg-inline text-gray-600 small">Douglas McGee</span> 
                    </button>

                   

                    <!-- Topbar Navbar -->
                    <ul class="navbar-nav ml-auto">

                       
                        <div class="topbar-divider d-none d-sm-block"></div>
							
						
                        <!-- Nav Item - User Information -->
                        <li class="nav-item dropdown no-arrow">
                        	
                            	
                            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                 <span class="mr-2 d-none d-lg-inline text-gray-600 small">Douglas McGee</span>                              
                            </a>
                            <!-- Dropdown - User Information -->
                            
                        </li>

                    </ul>

                </nav>
                <!-- End of Topbar -->
                
          		<!---------Colocar contenido ------------------->      
          		<h1>Cursos</h1>
          		<form method="post" action="<%=request.getContextPath()%>/ServletPostCursos">
          		<input type="text" name="cadena">
          		<input type="submit" value="Buscar">
          		</form>
          		<table class="table">
				  <thead>
				    <tr>
				      <th scope="col">#</th>
				      <th scope="col">Nombre</th>
				      <th scope="col">Precio</th>
				      <th scope="col">Descripcion</th>
				      <!-- <th scope="col">Categoria</th>
				      <th scope="col">Url</th> -->
				      <th scope="col"><button class="btn btn-success">Agregar</button></th>
				    </tr>
				  </thead>
				  <tbody>
				  <c:forEach items ="${listaCurso}" var="e">
				  	<tr>  
				  	  <td> <c:out value="${e.idCurso }"></c:out>  </td>  
				  	  <td> <c:out value="${e.nombreCurso }"></c:out>  </td>
				  	  <td> <c:out value="${e.precioCurso }"></c:out>  </td>
				  	  <td> <c:out value="${e.descripcion }"></c:out>  </td>  
				  	  <td> <c:out value="${e.nombreCategoria }"></c:out>  </td> 
				  	  <td> <c:out value="${e.urlTemario }"></c:out>  </td>				  	    
				  	</tr> 	
				  </c:forEach>
				  
				     <!-- <%
				            for (Curso c : lst) {
				        %>
				        <tr>
				            <td><%=c.getIdCurso()%></td>
				            <td><%=c.getNombre()%> </td>
				            <td><%=c.getPrecio()%> </td>	
				            <td><%=c.getDescripcion()%></td>
				            <td><%=c.getCategoria().getNombre()%></td>
				            <td><%=c.getTemario().getUrl()%></td>
				            <td><button class="btn btn-danger">Eliminar</button><button class="btn btn-info">Editar</button></td>				            
				            					            				            				            
				        </tr>
				        <%
				            }
				        %> -->
				  </tbody>
				</table>
                <!-- <form action="<%=request.getContextPath()%>/loginServlet" method="get">
                <button type="submit">oprimir</button>
                </form> -->
                
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
                        <span aria-hidden="true">×</span>
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