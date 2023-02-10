<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<!DOCTYPE html>
<html>

<head>
  <!-- Basic -->
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <!-- Mobile Metas -->
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
  <!-- Site Metas -->
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <meta name="author" content="" />

  <title>Urotaxi</title>


  <!-- slider stylesheet -->
  <link rel="stylesheet" type="text/css" href="../../https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css" />

  <!-- bootstrap core css -->
  <link rel="stylesheet" type="text/css" href="../../css/bootstrap.css" />

  <!-- fonts style -->
  <link href="../../https://fonts.googleapis.com/css?family=Poppins:400,700&display=swap" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="../../css/style.css" rel="stylesheet" />
  <!-- responsive style -->
  <link href="../../css/responsive.css" rel="stylesheet" />
</head>

<body class="sub_page">

  <div class="hero_area">
    <!-- header section strats -->
    <header class="header_section">
      <div class="container-fluid">
        <nav class="navbar navbar-expand-lg custom_nav-container ">
          <a class="navbar-brand" href="index.html">
            <span style="padding-bottom: 6px; font-size:xx-small">
              Admin Service
            </span>
          </a>
          </a>
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>

          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <div class="d-flex ml-auto flex-column flex-lg-row align-items-center">
              <ul class="navbar-nav  ">
               
                <!-- <li class="nav-item">
                  <a class="nav-link" href="customer.html">Customer</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="driver.html">Driver</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="tripbooking.html">TripBooking</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="cab.html">Cab</a>
                </li> -->

                <li class="nav-item">
                  <a class="nav-link" href="/admin/modifyadmin">Update Account</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="/admin/tripsofcustomer">GetAllTrips</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="/admin/viewtripsdriverwise">GetTripsByDriver</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="/admin/viewtripscustomerwise">GetTripsByCustomer</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="/admin/viewtripsdatewise">GetTripsByDate</a>
                </li>
                <!--<li class="nav-item">
                  <a class="nav-link" href="#">Driver</a>
                </li>-->
                
                   
                <div class="dropdown"  >
                  <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown" style="color:black;background-color: white; size: 10px;outline: 1px solid black; border:1px solid black">DRIVER
                  </button>
                  <ul class="dropdown-menu" style="background-color:white ;border:black ;color:black;width: 50px;">
                    <li style="color:black;text-align: center; font-size:15px; border:black;" ><a href="/driver/adddriver">AddDriver</a></li>
                    <li style="color:black;text-align: center; font-size:15px; border:black;" ><a href="/driver/findalldrivers">ViewDrivers</a></li>
                    <li style=" color:black;padding :2px;text-align: center; font-size:15px; border:black;"><a href="/driver/viewbestdrivers">ViewBestDriver</a></li>
                    <li style="color:black;text-align: center; font-size:15px; border:black;" ><a href="/driver/deletedriver">DeleteDriver</a></li>
      
                  </ul>
                </div>
      
                <li class="nav-item">
                  <a class="nav-link" href="/cab.html">Cabs</a>
                </li>
                  <li class="nav-item">
                    <a class="nav-link" href="/index.html">Logout</a>
                  </li>
                </li>
              </ul>
            </div>
          </div>
        </nav>
      </div>
    </header>
    <!-- end header section -->
  </div>  
  <div class="container" style= "background-color:white; margin: auto; padding-top: 60px; width:600px;">
      <div class="alert alert-danger"><h4 style="font-family:'Times New Roman', Times, serif ;text-align:center; color:chocolate">UserName already exists!<br> Please choose different username </h4></div>
      <form:form action="adddriver" modelAttribute="driver" method="get"> 
      <div class="form-group" style="text-align:center;">
        <button type="submit" class="btn btn-primary">Add another Driver</button>
      </div>
    </form:form>
    <!-- <form:form action="login" modelAttribute="driver" method="get"> 
      <div class="form-group">
        <button type="submit" class="btn btn-primary">Login</button>
      </div>
    </form:form> -->
  </div>
  <section  class="info_section layout_padding-top layout_padding2-bottom"style="margin-top:200px">
    <div  class="container" >
      <div class="box">
        <div class="info_form">
          <h4>
            Subscribe Our Newsletter
          </h4>
          <form action="">
            <input type="text" placeholder="Enter your email">
            <div class="d-flex justify-content-end">
              <button>

              </button>
            </div>
          </form>
        </div>
        <div class="info_links">
          <ul>
            <li class=" ">
              <a class="" href="../../index.html">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="">
              <a class="" href="../../about.html"> About</a>
            </li>
            <li class="">
              <a class="" href="../../service.html"> Services </a>
            </li>
            <li class="">
              <a class="" href="../../news.html"> News</a>
            </li>
            <li class="">
              <a class="" href="../../contact.html">Contact Us</a>
            </li>
            <!-- <li class="">
              <a class="" href="#">Login</a>
            </li> -->
          </ul>
        </div>
        <div class="../../info_social">
          <div>
            <a href="">
              <img src="../../images/fb.png" alt="">
            </a>
          </div>
          <div>
            <a href="">
              <img src="../../images/twitter.png" alt="">
            </a>
          </div>
          <div>
            <a href="">
              <img src="../../images/linkedin.png" alt="">
            </a>
          </div>
          <div>
            <a href="">
              <img src="../../images/instagram.png" alt="">
            </a>
          </div>
        </div>
      </div>
    </div>

  </section>
  <section class="container-fluid footer_section">
    <div class="container">
      <p>
        &copy; 2021 All Rights Reserved By
        <a href="../../https://html.design/">Free Html Templates</a>
      </p>
    </div>
  </section>
  <!-- footer section -->

  <script type="text/javascript" src="../../js/jquery-3.4.1.min.js"></script>
  <script type="text/javascript" src="../../js/bootstrap.js"></script>
  <script type="text/javascript" src="../../https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/owl.carousel.min.js">
  </script>


  <!-- owl carousel script -->
  <script type="text/javascript">
    $(".owl-carousel").owlCarousel({
      loop: true,
      margin: 20,
      navText: [],
      autoplay: true,
      autoplayHoverPause: true,
      responsive: {
        0: {
          items: 1
        },
        768: {
          items: 2
        },
        1000: {
          items: 2
        }
      }
    });
  </script>
  <!-- end owl carousel script -->

</body>
</html>






























