<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit - Training</title>
</head>
<body>
<%@page import="fjs.cs.dao.T003Dao,fjs.cs.dto.T003Dto"%>  
<form action = "/CustomerSystem_Servlet_Jsp/T003" method = "POST">
<div id="main">
  <h1 class="error">Thông báo</h1>
  <div class="comntent-customer_id">
    <span>Customer Id</span>
    <input type="text" name="customerId" value="${dto.CUSTOMER_ID}"/>
  </div>
  <div class="comntent-customer_name">
    <span>Customer Name</span>
    <input type="text" name="customerName" value="${dto.CUSTOMER_NAME}"/>
  </div>
  <div class="comntent-customer_sex">
    <span>Sex</span>
    <select name="sex">
      <option value=""></option>
      <option value="1" ${dto.SEX == '1' ? 'selected' : ''}>Nam</option>
		<option value="0" ${dto.SEX == '0' ? 'selected' : ''}>Nữ</option>
    </select>
  </div>
  <div class="comntent-customer_birthday">
    <span>Customer birthday</span>
    <input type="text" name="birthday" value="${dto.BIRTHDAY}"/>
  </div>
  <div class="comntent-customer_email">
    <span>Customer Email</span>
    <input id="text" name="email" value="${dto.EMAIL}"/>
  </div>
  <div class="comntent-customer_address">
    <span>Customer Address</span>
    <input type="text" name="address" value="${dto.ADDRESS}"/>
  </div>
  <button type="submit">Save</button>
</div>
</form>
</body>
</html>