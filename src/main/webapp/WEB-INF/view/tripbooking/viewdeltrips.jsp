<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
pageEncoding="ISO-8859-1" import="java.util.*,org.cabbookingweb.entities.*"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
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
                  <a class="nav-link" href="/customer/modifycustomer">Update Details</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="/customer/deletecustomer">Delete Account</a>
                </li>
                <!-- <li class="nav-item">
                  <a class="nav-link" href="/customer/findcustomer">View Customers</a>
                </li> -->
                <li class="nav-item">
                  <a class="nav-link" href="/tripbooking/viewalltrips">My TripBookingList</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="/tripbooking/getcabs">Book Trip</a>
                </li>
                <!-- <li class="nav-item">
                  <a class="nav-link" href="/tripbooking/deletetrip">Cancel Trip</a>
                </li> -->
      
                <!-- <li class="nav-item">
                  <a class="nav-link" href="/tripbooking/#">GetAllTripsForToday</a>
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
  <h6  style="text-align:left;padding-left:20px;padding-top:20px"><a href="/tripbooking/viewalltrips"><button type="submit"  class="btn btn-primary">Back</button></a>
  <div class="container text-align:left" style= "background-color:white; margin: auto; padding-top: 10px;width:700px">
    <div class="card card-body" style="background-color:cornflowerblue;">
    <h4 style="font-family:'Times New Roman', Times, serif ;text-align:center;color:aliceblue">Trip Details:-</h4>
    <form:form action="/tripbooking/deltrip" method="post" modelAttribute="tripss">
        <form:hidden path="tripBookingId" value="${tripss.tripBookingId}"/>
      <div class="form-group">
            <label for="tripBookingId"style="font-family:'Times New Roman', Times, serif ;text-align:center; color:aliceblue">TripBookingId</label>
            <input type="text" disabled value="${tripss.tripBookingId}" class="form-control" id="tripBookingId"/>
      </div>
      <div class="form-group">
        <label for="date"style="font-family:'Times New Roman', Times, serif ;text-align:left; color:aliceblue">Date of Booking</label>
        <input type="text" disabled value="${tripss.date}" class="form-control" id="date"/>
      </div>
      <div class="form-group">
        <label for="fromDateTime"style="font-family:'Times New Roman', Times, serif ;text-align:center; color:aliceblue">From</label>
        <input type="text" disabled value="${tripss.fromDateTime}" class="form-control" id="fromDateTime"/>
      </div>
      <div class="form-group">
        <label for="toDateTime"style="font-family:'Times New Roman', Times, serif ;text-align:center; color:aliceblue">To</label>
        <input type="text" disabled value="${tripss.toDateTime}" class="form-control" id="toDateTime"/>
      </div>
      <div class="form-group">
        <label for="fromLocation"style="font-family:'Times New Roman', Times, serif ;text-align:center; color:aliceblue">Pickup</label>
        <input type="text" disabled value="${tripss.fromLocation}" class="form-control" id="fromLocation"/>
      </div>
      <div class="form-group">
        <label for="toLocation"style="font-family:'Times New Roman', Times, serif ;text-align:center; color:aliceblue">Drop</label>
        <input type="text" disabled value="${tripss.toLocation}" class="form-control" id="toLocation"/>
      </div>
      <div class="form-group">
        <label for="status"style="font-family:'Times New Roman', Times, serif ;text-align:center; color:aliceblue">Status</label>
        <input type="text" disabled value="${tripss.status}" class="form-control" id="status"/>
      </div>
      <div class="form-group">
        <label for="distanceInKm"style="font-family:'Times New Roman', Times, serif ;text-align:center; color:aliceblue">Distance(in Km)</label>
        <input type="text" disabled value="${tripss.distanceInKm}" class="form-control" id="distanceInKm"/>
      </div>
      <div class="form-group">
        <label for="bill"style="font-family:'Times New Roman', Times, serif ;text-align:center; color:aliceblue">Charges</label>
        <input type="text" disabled value="${tripss.bill}" class="form-control" id="bill"/>
      </div>
      <div class="form-group" style="text-align:center">
        <button type="submit" onclick="alert('This trip will be cancelled')" class="btn btn-primary">Cancel</button>
      </div>
    </form:form>
        </div>
        </div>
  <section  class="info_section layout_padding-top layout_padding2-bottom"style="margin-top:100px">
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





