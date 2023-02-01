<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
  <title>Database animals</title>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script>
            $(document).ready(function () {
                $("#stergePacient").hide();
                $("#modificaPacient").hide();

                $("#update").click(function () {
                    $("#modificaPacient").show();
                    $("#stergePacient").hide();
                });
                $("#delete").click(function () {
                    $("#stergePacient").show();
                    $("#modificaPacient").hide();
                });
            });
        </script>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
  <link rel="stylesheet" href="wireframe.css">
</head>
<body>
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
  <div class="py-5 bg-light" style="background-image: url(&quot;https://cdn.wallpapersafari.com/19/43/DJHM7R.jpg&quot;); background-position: left top; background-size: 100%; background-repeat: repeat;">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <h1 class="text-light">Animals database</h1>
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
            <table class="table table-striped table-borderless">
              <thead>
                <tr>
                  <th scope="col">IdAnimal</th>
                  <th scope="col">Name</th>
                  <th scope="col">Region</th>
                </tr>
              </thead>
              <tbody>
                <tr>                  
                </tr>
                <tr>                  
                </tr>
                <tr>                 
                </tr>
              </tbody>
              <c:forEach var="pacienti" items="${listaPacienti}">
                <tr>
                    <td>${pacienti.idanimals}</td>
                    <td>${pacienti.name}</td>
                    <td>${pacienti.region}</td>
                </tr>
            </c:forEach>            
            </table>
            <form action="AnimalsController" method="POST">
            <p align="center">
                Modify: <input type="checkbox" id="update"> Delete: <input type="checkbox" id="delete" onclick="document.getElementById('nume').disabled = this.checked;
                        document.getElementById('prenume').disabled = this.checked;
                        document.getElementById('adresa').disabled = this.checked;"><br><br>
                <select name="idpacient">
                    <c:forEach items="${listaPacienti}" var="pacienti">
                        <option value="${pacienti.idanimals}">${pacienti.idanimals}</option>
                    </c:forEach>
                </select>
                <br><br>
                Modify Name: <input id="nume" type="text" name="nume"><br><br>
                Modify Region: <input id="prenume" type="text" name="prenume"> <br><br>
                <button class="btn btn-primary" type="submit" id="modificaPacient" name="modificaPacient"> Modify</button> <br> <br>
                <button class="btn btn-primary" type="submit" id="stergePacient" name="stergePacient"> Delete </button>
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
