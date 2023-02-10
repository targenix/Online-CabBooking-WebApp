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
            <span style="padding-bottom: 6px;">
              Urotaxi
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
                  <a class="nav-link" href="/customer.html">Home</a>
                </li>

                <li class="nav-item">
                  <a class="nav-link" href="/customer/updatedetails">Edit Profile</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="/customer/deldetails">Delete Account</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="/tripbooking/viewalltrips">My TripBookingList</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="/tripbooking/getcabs">Book Trip</a>
                </li>
                <!-- <li class="nav-item">
                  <a class="nav-link" href="/tripbooking/deletetrip">Cancel Trip</a>
                </li> -->
                <li class="nav-item">
                  <a class="nav-link" href="/index.html">Logout</a>
                </li>
              </ul>
            </div>
          </div>
        </nav>
      </div>
    </header>
    <!-- end header section -->
  </div>  
  <div class="container" style= "background-color:white; margin: auto; padding-top: 20px;padding-bottom:100px; width:700px;">
    <div class="card card-body" style="background-color:cornflowerblue;">
      <h3 style="font-family:'Times New Roman', Times, serif ;text-align:center; color:aliceblue">Trip Details</h3>
    <form:form action="booktrip" modelAttribute="trip" method="post">
        <form:hidden path="customer" value="${trip.customer.customerId}"/>
        <form:hidden path="cab" value="${trip.cab.cabId}"/>
        <!-- <div class="form-group">
          <label for="customer">CustomerId</label>
          <form:input path="customer" value="${trip.customer.customerId}"
            class="form-control" name="" id="customer"/>
        </div> -->
        <!-- <div class="form-group">
          <label for="date"style="font-family:'Times New Roman', Times, serif ;text-align:center; color:aliceblue">Date Of Booking</label>
          <form:input path="date" value="${trip.date}"
            class="form-control" name="" id="date"/>
        </div> -->
  <div class="form-group">
    <label for="fromLocation"style="font-family:'Times New Roman', Times, serif ;text-align:center; color:aliceblue">PickUp</label>
    <form:input path="fromLocation" value="${trip.fromLocation}"
      class="form-control" name="" id="fromLocation"/>
  </div>
  <div class="form-group">
      <label for="toLocation"style="font-family:'Times New Roman', Times, serif ;text-align:center; color:aliceblue">Drop</label>
      <form:input path="toLocation" value="${trip.toLocation}"
        class="form-control" name="" id="toLocation"/>
    </div>
    <div class="form-group">
      <label for="fromDateTime"style="font-family:'Times New Roman', Times, serif ;text-align:center; color:aliceblue">FromDate</label>
      <form:input path="fromDateTime" value="${trip.fromDateTime}"
        class="form-control" name="" id="fromDateTime"/>
    </div>
    <div class="form-group">
        <label for="toDateTime"style="font-family:'Times New Roman', Times, serif ;text-align:center; color:aliceblue">Todate</label>
        <form:input path="toDateTime" value="${trip.toDateTime}"
          class="form-control" name="" id="toDateTime"/>
      </div>
      <div class="form-group">
          <label for="status"style="font-family:'Times New Roman', Times, serif ;text-align:center; color:aliceblue">Status</label>
          <form:input path="status" value="${trip.status}"
            class="form-control" name="" id="status"/>
        </div>
        <div class="form-group">
            <label for="distanceInKm"style="font-family:'Times New Roman', Times, serif ;text-align:center; color:aliceblue">Distance(inKm)</label>
            <form:input path="distanceInKm" value="${trip.distanceInKm}"
              class="form-control" name="" id="distanceInKm"/>
          </div>
          <div class="form-group">
              <label for="bill"style="font-family:'Times New Roman', Times, serif ;text-align:center; color:aliceblue">Charges</label>
              <form:input path="bill" value="${trip.bill}"
                class="form-control" name="" id="bill"/>
            </div>
            <div class="form-group">
                <label for="driver"style="font-family:'Times New Roman', Times, serif ;text-align:center; color:aliceblue">DriverId</label>
                <form:input path="driver" value="${trip.driver.driverId}"
                  class="form-control" name="" id="driver"/>
              </div>
        <div class="form-group"style="text-align:center">
          <button onclick="alert('Your Trip will be booked')" type="submit" class="btn btn-primary">Book Now</button>
        </div>
  </form:form>
  </div>
  </div>
  <section  class="info_section layout_padding-top layout_padding2-bottom">
    <div  class="container" >
      <div class="box">
        <div class="info_form">
          <h4>
            Subscribe Our Newsletter
          </h4>
          <!-- <form action="">
            <input type="text" placeholder="Enter your email">
            <div class="d-flex justify-content-end">
              <button>

              </button> -->
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
            <!-- <li class="">
              <a class="" href="../../contact.html">Contact Us</a>
            </li> -->
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








