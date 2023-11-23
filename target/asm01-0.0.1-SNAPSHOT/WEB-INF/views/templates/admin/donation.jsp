<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
  <meta name="description" content="" />
  <meta name="author" content="" />
  <title>Quản trị</title>
  <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
  <link href="${pageContext.request.contextPath}/static/admin1/assets/css/styles.css" rel="stylesheet" />
  <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js"
          crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
          crossorigin="anonymous"></script>
  <script src="${pageContext.request.contextPath}/static/admin1/assets/js/scripts.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest"></script>

  <script src="${pageContext.request.contextPath}/static/admin1/assets/js/datatables-simple-demo.js"></script>

  <script src="https://cdn.ckeditor.com/ckeditor5/29.0.0/classic/ckeditor.js"></script>
</head>
<body class="sb-nav-fixed">
  <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
    <nav th:fragment="html_nav" class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
      <!-- Navbar Brand-->
      <a class="navbar-brand ps-3" href=/PRJ321_ASM01_4.0/admin>QUẢN TRỊ</a>
      <!-- Sidebar Toggle-->
      <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!"><i
              class="fas fa-bars"></i></button>
      <!-- Navbar Search-->
      <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
  
      </form>
      <!-- Navbar-->
          <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
              <li class="nav-item dropdown">
                  <a th:if="${session.admin}" class="nav-link dropdown-toggle" href="/PRJ321_ASM01_4.0/admin/login" role="button" ><i class="fas fa-user fa-fw"></i><span> Logout</span></a>
                  <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown1">
                      <li><a class="dropdown-item" href="#">Settings</a></li>
                      <li><a class="dropdown-item" href="#">Activity Log</a></li>
                      <li>
                          <hr class="dropdown-divider" />
                      </li>
                      <li><a class="dropdown-item" href="/login">Logout</a></li>
                  </ul>
              </li>
          </ul>
  </nav>
  </nav>

<div id="layoutSidenav">
  <div id="layoutSidenav_nav">
    <div th:fragment="html_menu" id="layoutSidenav_nav">
      <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
          <div class="sb-sidenav-menu">
              <div class="nav">
                  <a class="nav-link" href="${pageContext.request.contextPath}/admin/account">
                      <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                      Quản lý người dùng
                  </a>
                  <a class="nav-link" href="${pageContext.request.contextPath}/admin/donation">
                      <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                      Quản lý đợt quyên góp
                  </a>
              </div>
          </div>

      </nav>
  </div>
  </div>

  <div id="layoutSidenav_content">
    <main>
      <div class="container-fluid px-4">
        <h1 class="mt-4">Danh sách đợt quyên góp</h1>
        <div class="card mb-4">
          <div class="card-header">
            <button type="button" class="btn btn-success" data-bs-toggle="modal"
                    data-bs-target="#exampleModalAdd">
              Thêm mới
            </button>
            <!-- Modal Add-->
            <div class="modal fade" id="exampleModalAdd" tabindex="-1" aria-labelledby="exampleModalLabel"
                 aria-hidden="true">
              <div class="modal-dialog modal-lg">
                <div class="modal-content">
                  <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabelll">Thêm mới</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                            aria-label="Close"></button>
                  </div>
                  <div class="modal-body">
                    <form method="post" action="addonation">
                      <div class="row">
                        <div class="col-6">
                          <label for="adname"
                                 class="col-form-label">Mã đợt quyên góp:</label>
                          <input type="text" class="form-control"
                                 id="adname" name="code" required>
                        </div>
                        <div class="col-6">
                          <label for="addcost"
                                 class="col-form-label">Tên đợt quyên góp:</label>
                          <input type="text" class="form-control"
                                 id="addcost" name="name" required>
                        </div>
                      </div>
                      <div class="row">
                        <div class="col-6">
                          <label for="adname"
                                 class="col-form-label">Ngày bắt đầu:</label>
                          <input type="date" class="form-control"
                                 id="adname" name="dStart" required>
                        </div>
                        <div class="col-6">
                          <label for="addcost"
                                 class="col-form-label">Ngày kết thúc:</label>
                          <input type="date" class="form-control"
                                 id="addcost" name="dEnd" required>
                        </div>
                      </div>
                      <div class="row">
                        <div class="col-6">
                          <label for="adname"
                                 class="col-form-label">Tổ chức:</label>
                          <input type="text" class="form-control"
                                 id="adname" name="dOrg" required>
                        </div>
                        <div class="col-6">
                          <label for="addcost"
                                 class="col-form-label">Số điện thoại:</label>
                          <input type="number" class="form-control"
                                 id="addcost" name="dPhone" required>
                        </div>
                        <div class="col-12">
                          <label for="ct_id" class="col-form-label">Nội dung:</label>
                          <textarea name="dContain" class="form-control" cols="50" rows="5">Nhập nội dung</textarea>
                        </div>
                      </div>
                      <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Đóng</button>
                        <button type="submit" class="btn btn-primary">Thêm </button>
                      </div>
                    </form>
                  </div>

                </div>
              </div>
            </div>
            <!-- Modal Add-->
          </div>
          <div class="card-body">
            <table id="datatablesSimple">
              <thead>
              <tr style="background-color: gray !important;">
                <th>Mã</th>
                <th>Tên</th>
                <th>Ngày bắt đầu</th>
                <th>Ngày kết thúc</th>
                <th>Tổ chức</th>
                <th>Số điện thoại</th>
                <th>Tổng tiền</th>
                <th >Trạng thái</th>
                <th style="width: 220px ">Hành động</th>
              </tr>
              </thead>

              <tbody>
    			<input type="hidden" value="${donations.size()}" id="dodai" />
				<c:forEach var="dnt1" items="${donations}">
                <tr>
                  <td>${dnt1.code}</td>
                  <td>${dnt1.name}</td>
                  <td>${dnt1.dStart}</td>
                  <td>${dnt1.dEnd}</td>
                  <td>${dnt1.dOrg}</td>
                  <td>${dnt1.phonenum}</td>
                  <td>${dnt1.money}</td>
                  
				  <c:if test = "${dnt1.status==0}">
                     <td>CREATED</td>
                  </c:if>
                  <c:if test = "${dnt1.status==1}">
                     <td>PROCESSING</td>
                  </c:if>
                  <c:if test = "${dnt1.status==2}">
                     <td>END</td>
                  </c:if>
                  <c:if test = "${dnt1.status==3}">
                     <td>CLOSED</td>
                  </c:if>
           		  <td style="">
                  <!-- Khi chưa ở trạng thái đóng quyên góp mới hiển thị nút cập nhật (status != 3) -->
				  <c:if test="${dnt1.status != 3}">
					    <button type="button" style="width: 105px" class="btn btn-primary" data-bs-toggle="modal" 
					            data-bs-target="#exampleModal${dnt1.id}">Cập nhật</button>
				  </c:if>
				  <a style="width: 105px; display: block" class="btn btn-warning" href="detail/${dnt1.code}">
					    Chi tiết
				  </a>
				  
				  <!-- Khi ở trạng thái mới tạo mới hiển thị nút xóa -->
				  <c:if test="${dnt1.status == 0}">
    			 	<button type="button" style="width: 105px" class="btn btn-danger mt-1" data-bs-toggle="modal" 
           			 data-bs-target="#idModelDel${dnt1.id}">Xóa</button>
				  </c:if>
				  
				  <!-- Nếu donation mới tạo thì hiển thị nút Quyên góp -->
				  <c:if test="${dnt1.status == 0}">
    				<form action="/PRJ321_ASM01_4.0/admin/change-status" method="post" style="margin-left: 110px; margin-top: -38px">
        			<input type="hidden" class="form-control" id="id" name="donationId" value="${dnt1.id}">
        		  	<button type="submit" style="width: 105px" class="btn btn-success">Quyên góp</button>
    				</form>
				  </c:if>
				  
				  <!-- Nếu donation ở trạng thái đang quyên góp thì hiển thị nút kết thúc quyên góp -->				  
				  <c:if test="${dnt1.status == 1}">
				    <form action="/PRJ321_ASM01_4.0/admin/change-status" method="post" style="margin-top: 5px">
				    <input type="hidden" class="form-control" id="id" name="donationId" value="${dnt1.id}">
				    <button type="submit" style="width: 105px" class="btn btn-success">Kết thúc</button>
				    </form>
				 </c:if>
				 <!-- Nếu donation ở trạng thái kết thúc thì hiển thị nút Đóng quyên góp -->
				  <c:if test="${dnt1.status == 2}">
				    <form action="/PRJ321_ASM01_4.0/admin/change-status" method="post" style="margin-top: 5px">
				     <input type="hidden" class="form-control" id="id" name="donationId" value="${dnt1.id}">
				     <button type="submit" style="width: 105px" class="btn btn-success">Đóng</button>
				    </form>
				 </c:if>
				  
                      
                    <div class="modal fade" id="idModelDel${dnt1.id}" tabindex="-1"
                         aria-labelledby="exampleModalLabel" aria-hidden="true">
                      <div class="modal-dialog">
                        <div class="modal-content">
                          <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Bạn chắc chắn muốn xóa ?</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal"
                                    aria-label="Close"></button>
                          </div>
                          <div class="modal-body">
                            Đợt quyên góp : <span>${dnt1.name}</span>
                            <form method="post" action="deldonate">
                            <input type="hidden" class="form-control" id="id" name="idUser" value="${dnt1.id}">
                              <div class="modal-footer" style="margin-top: 20px">
                                <button type="button" class="btn btn-secondary"
                                        data-bs-dismiss="modal">
                                  Close
                                </button>
                                <button type="submit" class="btn btn-danger"
                                id="idModelDel${dnt1.code}">Xóa</button>

                              </div>
                            </form>
                          </div>

                        </div>
                      </div>
                    </div>
                  </td>
                </tr>
                <div class="modal fade" tabindex="-1" id="exampleModal${dnt1.id}"
                     aria-labelledby="exampleModalLabel" aria-hidden="true">
                  <div class="modal-dialog modal-lg ">
                    <div class="modal-content">
                      <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabell">Cập nhật</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal"
                                aria-label="Close"></button>
                      </div>
                      <div class="modal-body">
                        <form action="updonate" method="post">
                          <input type="hidden" name="donateid" value="${dnt1.id}">
                          <div class="row">
                            <div class="col-6">
                              <label for="adname"
                                     class="col-form-label">Mã đợt quyên góp:</label>
                              <input type="text" class="form-control"
                                     id="adname" name="code" required>
                            </div>
                            <div class="col-6">
                              <label for="addcost"
                                     class="col-form-label">Tên đợt quyên góp:</label>
                              <input type="text" class="form-control"
                                     id="addcost" name="name" required>
                            </div>
                          </div>
                          <div class="row">
                            <div class="col-6">
                              <label for="adname"
                                     class="col-form-label">Ngày bắt đầu:</label>
                              <input type="date" class="form-control"
                                     id="adname" name="start" required>
                            </div>
                            <div class="col-6">
                              <label for="addcost"
                                     class="col-form-label">Ngày kết thúc:</label>
                              <input type="date" class="form-control"
                                     id="addcost" name="end" required>
                            </div>
                          </div>
                          <div class="row">
                            <div class="col-6">
                              <label for="adname"
                                     class="col-form-label">Tổ chức:</label>
                              <input type="text" class="form-control"
                                     id="adname" name="tochuc" required>
                            </div>
                            <div class="col-6">
                              <label for="addcost"
                                     class="col-form-label">Số điện thoại:</label>
                              <input type="number" class="form-control"
                                     id="addcost" name="sdt" required>
                            </div>
                            <div class="col-12">
                              <label for="ct_id" class="col-form-label">Nội dung:</label>
                              <textarea name="noidung" class="form-control" cols="50" rows="5"></textarea>
                            </div>
                          </div>
                          <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Đóng</button>
                            <button type="submit" class="btn btn-primary">Lưu </button>
                          </div>
                        </form>
                      </div>

                    </div>
                  </div>
                </div>
				</c:forEach>
              </tbody>
            </table>
          </div>
        </div>
      </div>

    </main>

    <script>

      ClassicEditor.create(document.querySelector('#editor')).then(eidt => {
        console.log("da" + eidt);
      })
              .catch(error => {
                console.error(error);
              });

    </script>
    <script>

      var dodai = document.getElementById("dodai").value;
      var a = parseInt(dodai);
      for(var i = 1;i<=a+10;i++){
        var name = "#editor"  + i
        ClassicEditor.create(document.querySelector(name)).then(eidt => {
          console.log("da" + eidt);
        })
                .catch(error => {
                  console.error(error);
                });
      }


    </script>
    <footer replace="admin/fragments :: footer" class="py-4 bg-light mt-auto">

    </footer>
  </div>
</div>

	<script src="${pageContext.request.contextPath}/static/admin1/assets/js/JQuery3.3.1.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	        crossorigin="anonymous"></script>
	<script src="${pageContext.request.contextPath}/static/admin1/assets/js/scripts.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
	<script src="${pageContext.request.contextPath}/static/admin1/assets/js/datatables-simple-demo.js"></script>
</body>
</html>