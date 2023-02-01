<%@page import="DAOImpl.AnimalsDAOImpl"%>
<%@page import="DAOImpl.CharacteristicsDAOImpl"%>
<%@page import="pojo.Animals"%>
<%@page import="java.util.ArrayList"%>
<%@page import="pojo.Characteristics"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
  <title>Database bindings</title>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script>
            $(document).ready(function () {
                $("#stergeConsultatie").hide();
                $("#modificaConsultatie").hide();

                $("#update").click(function () {
                    $("#modificaConsultatie").show();
                    $("#stergeConsultatie").hide();
                });
                $("#delete").click(function () {
                    $("#stergeConsultatie").show();
                    $("#modificaConsultatie").hide();
                });
            });
        </script>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
  <link rel="stylesheet" href="wireframe.css">
</head>
<body>
	<%
	AnimalsDAOImpl pacientDaoImpl = new AnimalsDAOImpl();
	CharacteristicsDAOImpl medicDaoImpl = new CharacteristicsDAOImpl();
	List<Animals> listaPacienti = new ArrayList();
	listaPacienti = pacientDaoImpl.returnAnimals();
	List<Characteristics> listaMedici = new ArrayList();
	listaMedici = medicDaoImpl.returnCharacteristics();
	request.setAttribute("listaPacienti", listaPacienti);
	request.setAttribute("listaMedici", listaMedici);
	%>
	<nav class="navbar navbar-expand-md navbar-dark bg-info">
    <div class="container">
      <a class="navbar-brand" href="#"><i class="fa d-inline fa-lg fa-bullseye"></i></a>
      <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbar2SupportedContent" aria-controls="navbar2SupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span> </button>
      <div class="collapse navbar-collapse text-center justify-content-between" id="navbar2SupportedContent">
        <ul class="navbar-nav">
          <li class="nav-item">
            <a class="nav-link mx-2" href="index.html">Home</a>
          </li>
          <li class="nav-item">
            <a class="nav-link mx-2" href="add_Animals.jsp">Add animals</a>
          </li>
          <li class="nav-item">
            <a class="nav-link mx-2" href="add_Characteristics.jsp">Add characteristics</a>
          </li>
          <li class="nav-item">
            <a class="nav-link mx-2" href="add_Junction.jsp">Add binding</a>
          </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
          <button class="btn btn-link my-2 my-sm-0" type="submit"></button>
        </form>
      </div>
    </div>
  </nav>  
  <div class="py-5 bg-light" style="background-image: url(&quot;http://wallup.net/wp-content/uploads/2016/01/136660-animals-bears-forest.jpg&quot;); background-position: left top; background-size: 100%; background-repeat: repeat;">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <h1 class="text-light"><b>Animals' characteristics database</b></h1>
        </div>
      </div>
    </div>
  </div>
  <div class="py-1">
    <div class="container">
      <div class="row">        
      </div>
    </div>
  </div>
  <div class="py-1">
    <div class="container">
      <div class="row">
        <div class="col-md-12" style="">
          <div class="table-responsive">         
            <table border="1" align="center" class="table table-striped table-borderless">
            <tr>
                <td><b>Idjunction:</b></td>
                <td><b>Idanimals:</b></td>
                <td><b>Name:</b></td>
                <td><b>Region:</b></td>
                <td><b>Idcharacteristics:</b></td>
                <td><b>Class:</b></td>
                <td><b>Order:</b></td>
                <td><b>Species:</b></td>
                <td><b>Kingdom:</b></td>
            </tr>
            <c:forEach var="consultatie" items="${listaConsultatie}">
                <tr>
                    <td>${consultatie.idjunction}</td>
                    <td>${consultatie.animals.idanimals}</td>
                    <td>${consultatie.animals.name}</td>
                    <td>${consultatie.animals.region}</td>
                    <td>${consultatie.characteristics.idcharacteristics}</td>
                    <td>${consultatie.characteristics.clas}</td>
                    <td>${consultatie.characteristics.orders}</td>
                    <td>${consultatie.characteristics.species}</td>
                    <td>${consultatie.characteristics.kingdom}</td>
                </tr>
            </c:forEach>
        </table>
        <form action="JunctionController" method="POST">
            <p align="center">
                Modify: <input type="checkbox" id="update"> Delete: <input type="checkbox" id="delete" onclick="document.getElementById('idpacient').disabled = this.checked; document.getElementById('idmedic').disabled = this.checked;"><br><br>
                idJunction:
                <select name="idconsultatie">
                    <c:forEach items="${listaConsultatie}" var="consultatie">
                        <option value="${consultatie.idjunction}">${consultatie.idjunction}</option>
                    </c:forEach>
                </select>
                <br><br>
                idanimals:
                <select name="idpacient">
                    <c:forEach items="${listaPacienti}" var="pacienti">
                        <option value="${pacienti.idanimals}">${pacienti.idanimals}, ${pacienti.name}, ${pacienti.region}</option>
                    </c:forEach>
                </select>
                <br><br>
                idcharacteristics:
                <select name="idmedic">
                    <c:forEach items="${listaMedici}" var="medici">
                        <option value="${medici.idcharacteristics}">${medici.idcharacteristics}, ${medici.clas}, ${medici.orders}, ${medici.species}, ${medici.kingdom}</option>
                    </c:forEach>
                </select>
                <br><br>
                <button class="btn btn-primary" type="submit" id="modificaConsultatie" name="modificaConsultatie"> Modify</button> <br> <br>
                <button class="btn btn-primary" type="submit" id="stergeConsultatie" name="stergeConsultatie"> Delete </button>
            </p>
        	</form>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="bg-info p-4" >
    <div class="container">
      <div class="row">
        <div class="col-md-12 align-self-center p-4 ">
          <h4>Romanian databses.inc</h4>
          <p class="mb-4 text-primary">795 Bucuresti, Ilfov</p>
          <div class="row text-center">
            <div class="col-md-2 col-3">
              <a href="#" target="_blank"><i class="fa fa-facebook text-primary fa-2x"></i></a>
            </div>
            <div class="col-md-2 col-3">
              <a href="#" target="_blank"><i class="fa fa-twitter text-primary fa-2x"></i></a>
            </div>
            <div class="col-md-2 col-3">
              <a href="#" target="_blank"><i class="fa fa-instagram text-primary fa-2x"></i></a>
            </div>
            <div class="col-md-2 col-3">
              <a href="#" target="_blank"><i class="fa text-primary fa-2x fa-pinterest-p"></i></a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="bg-dark py-3" style="">
    <div class="container">
      <div class="row d-flex justify-content-between">
        <div class="col-lg-4 col-md-6">
          <p class="text-secondary mb-0">Copyright - Romanian databses.inc</p>
        </div>
        <div class="col-lg-4 col-md-6">
          <p class="text-secondary mb-0">2023</p>
        </div>
      </div>
    </div>
  </div>
  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  <pingendo onclick="window.open('https://pingendo.com/', '_blank')" style="cursor:pointer;position: fixed;bottom: 20px;right:20px;padding:4px;background-color: #00b0eb;border-radius: 8px; width:220px;display:flex;flex-direction:row;align-items:center;justify-content:center;font-size:14px;color:white">Made with Pingendo Free&nbsp;&nbsp;<img src="https://pingendo.com/site-assets/Pingendo_logo_big.png" class="d-block" alt="Pingendo logo" height="16"></pingendo>
</body>

</html>
