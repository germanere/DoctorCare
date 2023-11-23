<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
        <title>Donation website &mdash; Website Donation</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="" />
        <meta name="keywords" content="" />
        <meta name="author" content="Free-Template.co" />
        <link rel="shortcut icon" href="ftco-32x32.png">
        
        <link rel="stylesheet" href="static/user/assets/css/custom-bs.css">
        <link rel="stylesheet" href="static/user/assets/css/jquery.fancybox.min.css">
        <link rel="stylesheet" href="static/user/assets/css/bootstrap-select.min.css">
        <link rel="stylesheet" href="static/user/assets/fonts/icomoon/style.css">
        <link rel="stylesheet" href="static/user/assets/fonts/line-icons/style.css">
        <link rel="stylesheet" href="static/user/assets/css/owl.carousel.min.css">
        <link rel="stylesheet" href="static/user/assets/css/animate.min.css">
      
        <!-- MAIN CSS -->
        <link rel="stylesheet" href="static/user/assets/css/style.css">
        
        <script src="static/user/assets/js/jquery.min.js"></script>
        <script src="static/user/assets/js/bootstrap.bundle.min.js"></script>
        <script src="static/user/assets/js/isotope.pkgd.min.js"></script>
        <script src="static/user/assets/js/stickyfill.min.js"></script>
        <script src="static/user/assets/js/jquery.fancybox.min.js"></script>
        <script src="static/user/assets/js/jquery.easing.1.3.js"></script>
    
        <script src="static/user/assets/js/jquery.waypoints.min.js"></script>
        <script src="static/user/assets/js/jquery.animateNumber.min.js"></script>
        <script src="static/user/assets/js/owl.carousel.min.js"></script>
        <script src="static/user/assets/js/bootstrap-select.min.js"></script>
        <script src="static/user/assets/js/custom.js"></script>
    
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
      
    </head>
<body id="top">

<div id="overlayer"></div>
<div class="loader">
    <div class="spinner-border text-primary" role="status">
        <span class="sr-only">Loading...</span>
    </div>
</div>
<div th:if="${msg}" class="toast" data-delay="1000" style="position:fixed; top: 100PX; left: 40PX;z-index: 2000;width: 300px">

    <script>
        // swal({
        //     title: 'Donate Successfully!',
        //     /* text: 'Redirecting...', */
        //     icon: 'success',
        //     timer: 3000,
        //     buttons: true,
        //     type: 'success'
        // })
    </script>
</div>

<div class="site-wrap">

    <div class="site-mobile-menu site-navbar-target">
        <div class="site-mobile-menu-header">
            <div class="site-mobile-menu-close mt-3">
                <span class="icon-close2 js-menu-toggle"></span>
            </div>
        </div>
        <div class="site-mobile-menu-body"></div>
    </div> <!-- .site-mobile-menu -->


    <!-- NAVBAR -->
    <header class="site-navbar mt-3">
        <div class="container-fluid">
            <div class="row align-items-center">
              <div class="site-logo col-6"><a href="/">Website Quyên Góp</a></div>
      
            </div>
          </div>
    </header>

    <!-- HOME -->
    <section class="section-hero overlay inner-page bg-image" style="background-image: url('static/user/assests/images/hero_1.jpg');" id="home-section">
        <div class="container">
            <div class="row">
                <div class="col-md-7">
                    <h1 class="text-white font-weight-bold">Danh sách các đợt quyên góp</h1>
						
                </div>
            </div>
        </div>
    </section>
    <section class="site-section">
        <div class="container">
            <div class="row mb-5 justify-content-center">
                <div class="col-md-7 text-center">
                    <h2 class="section-title mb-2" >Các đợt quyên góp</h2>
                </div>
            </div>

            <ul class="job-listings mb-5">
					<c:forEach var="dnt1" items="${donations}">
                    <li style="margin-bottom: 20px" class="job-listing d-block d-sm-flex pb-3 pb-sm-0 align-items-center ">
                        <div class="job-listing-about d-sm-flex custom-width w-100 justify-content-between mx-4">
                            <div class="job-listing-position custom-width  mb-3 mb-sm-0" style="padding: 10px;width: 250px">
                                <h2><a style="width:200px ;height: 65px;" href="${pageContext.request.contextPath}/Detail/${dnt1.code}"></a>${dnt1.name} - ${dnt1.code}</h2>                                                                  
                            </div>
                            <div class="nut">
								 <c:if test = "${dnt1.status==0}">
                                <strong >CREATED</strong>	
                            <div class="job-listing-meta custom-width w-20" >
                                <p style="margin-top: 20px" class="btn btn-primary py-2" data-bs-toggle="modal" data-bs-target="#exampledonateModal${usd1.id}">Quyên góp</p>
                                <p style="margin-top: 20px;background-color: white !important;" class="btn py-2"><span style="color: white">Quyên góp</span></p>
                            </div>                                
                                </c:if>
                              	<c:if test = "${dnt1.status==1}">
                                <strong >PROCESSING</strong>
                            <div class="job-listing-meta custom-width w-20" >
                                <p style="margin-top: 20px" class="btn btn-primary py-2" data-bs-toggle="modal" data-bs-target="#exampledonateModal${usd1.id}">Quyên góp</p>
                                <p style="margin-top: 20px;background-color: white !important;" class="btn py-2"><span style="color: white">Quyên góp</span></p>
                            </div>	                                
                                </c:if>
                              	<c:if test = "${dnt1.status==2}">
                                <strong >END</strong>
                                </c:if> 
                              	<c:if test = "${dnt1.status==3}">
                                <strong >CLOSE</strong>
                                </c:if>
                             </div>  
                            <div class="job-listing-location mb-3 mb-sm-0 custom-width w-10" style="padding: 10px;">
                                Ngày bắt đầu<br>
                                <strong>${dnt1.dStart}</strong><br>
                            </div>
                            <div class="job-listing-location mb-3 mb-sm-0 custom-width w-10" style="padding: 10px;">
                                Ngày kết thúc<br>
                                <strong>${dnt1.dEnd}</strong><br>
                            </div>
                            <div class="job-listing-location mb-3 mb-sm-0 custom-width w-25" style="padding: 10px;">
                                <span class="icon-room"></span> <span>${dnt1.dOrg}</span><br>
                                <strong>${dnt1.phonenum}</strong><br>
                            </div>
                        </div>
                        
                         <!-- Modal -->
	
                    <div class="modal fade" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true" id="exampledonateModal${usd1.id}">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">	
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">Quyên góp: <span></span></h5>
                                    <button type="button" class="close" data-bs-dismiss="modal" aria-label="Close" data-bs-target="exampleModalLabel">
                                        <span aria-hidden="true">&times;</span>
                                    </button>	
                                </div>
                                
                                <form action="adduserdonation" method="post" modelAttribute="userdonatedto">
                                    <div class="modal-body" id="exampleModalLabel">
                                        <div class="row">
                                            <div class="col-12">
                                                <label for="addname"
                                                       class="col-form-label">Họ tên:</label>
                                                <input type="text" class="form-control"
                                                       id="addname" name="fullname" placeholder="" required>
                                                <label for="addname"
                                                       class="col-form-label">Số tiền quyên góp:</label>
                                                <input type="number" class="form-control" placeholder=""
                                                       id="addname" name="money" required>
                                                <input type="hidden" class="form-control" placeholder=""
                                                       id="addname" name="idUser" value="1" >
                                                <input type="hidden" class="form-control" placeholder=""
                                                       id="addname" name="idDonation" value ="${dnt1.id}" required>

                                                <label for="addname"
                                                       class="col-form-label">Lời nhắn:</label>
                                                    <textarea rows="10" cols="3" class="form-control" name="contain">

                                                </textarea>
                                            </div>

                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>
                                            <button type="submit" data-toggle="modal" data-target="#exampleModal" class="btn btn-primary">Quyên góp</button>

                                        </div>
                                    </div>
                                </form>

                            </div>
                        </div>
                    </div>
	                    </c:forEach>


                <script>
                    function detail(id){
                        window.location = "/donation/detail/"id;
                    }
                </script>
            </ul>

 	            <div class="row pagination-wrap">
                <div class="col-md-6 text-center text-md-left mb-4 mb-md-0">

                </div>
                <div class="col-md-6 text-center text-md-right">
                    <div class="custom-pagination ml-auto">
                        <a class="prev">Prev</a>
                        <div class="d-inline-block">
                        </div>

                        <a class="next">Next</a>
                    </div>
                </div>
            </div>

        </div>
    </section>

</div>


</body>
</html>
