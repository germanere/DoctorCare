<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Nhập thông tin người dùng</title>
    <style>
      .form-row {
        display: flex;
        flex-wrap: wrap;
        justify-content: space-between;
        margin-left: 10px;
        margin-right: 10px;
      }

      .form-row .form-column {
        width: calc(50% - 10px);
        margin-bottom: 20px;
        margin-top: 20px;
        margin-left: 10px;
      }
      .input {
        border: 1px solid #000;
        padding: 10px;
      }
      .space {
        margin-right: 10px;
      }
    </style>
  </head>
  <body class="input">
    <h1>Nhập thông tin người dùng</h1>
    <form action="/submit" method="post">
      <div class="form-row">
        <div class="form-column">
          <label class="space" for="name">Họ và tên:</label>
          <input type="text" id="name" name="name" required />
        </div>
        <div class="form-column">
          <label class="space" for="email">Email:</label>
          <input type="email" id="email" name="email" required />
        </div>
      </div>

      <div class="form-row">
        <div class="form-column">
          <label class="space" for="phone">Số điện thoại:</label>
          <input type="tel" id="phone" name="phone" required />
        </div>
        <div class="form-column">
          <label class="space" for="address">Địa chỉ:</label>
          <input type="text" id="address" name="address" required />
        </div>
      </div>

      <div class="form-row">
        <div class="form-column">
          <label class="space" for="username">Tài khoản:</label>
          <input type="text" id="username" name="username" required />
        </div>
        <div class="form-column">
          <label class="space" for="password">Mật khẩu:</label>
          <input type="password" id="password" name="password" required />
        </div>
      </div>

      <div class="form-row">
        <div class="form-column">
          <label for="role">Vai trò:</label>
          <select id="role" name="role" required>
            <option value="admin">Admin</option>
            <option value="user">User</option>
          </select>
        </div>
      </div>

      <input type="submit" value="Submit" />
    </form>
  </body>
</html>
