<%@page import="java.awt.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page import="fjs.cs.dao.T003Dao,fjs.cs.common.Constants"%>  

<title>Search - Training</title>
</head>
<style type="text/css">
  <%@include file="/WEB-INF/css/common.css"%>
</style>
<style type="text/css">
  <%@include file="/WEB-INF/css/T002.css"%>
</style>
<body>

<style type="text/jsp">
  <%@include file="/WEB-INF/include/header.jsp"%>
</style>

<div class = "search-container">
	<div class = "search-container__dan">
		<div class = "search-container__text search-container__text_text">
			Login > Search Customer
		</div>
	<div class = "search-container__context">
				<div class = "search-container__logo">
				Welcome
					<%if (session.getAttribute("name") != null) {
						Object session2 = session.getAttribute("name");
						session.setAttribute("name1", session2);
					%>
							<div><%=session.getAttribute("name") %></div>
					<%} %>
				</div>
		
			<a href = "/CustomerSystem/T001" class = "search-container__logout search-container__text_text" onclick = "Logout() ">
    			Log Out
			</a>
			<script>
				function Logout() {
				    <% session.removeAttribute("name"); %>  // Xóa session "name"
				    location.reload();
				}
			</script>
	</div>
	
	<div class = "search-container__line"></div>
	
	
<form id = "form-Search" action ="/CustomerSystem_Servlet_Jsp/T002" method = "POST" >
	<div class = "search-container__handalSearch">
		<div class = "search-container__handalSearch--margin handalSearch-customerName">
			<div class = "handalSearch-customercommon handalSearch-customerName__text search-container__text_text">Customer Name</div>
			<input id = "txtCustomerName" name = "txtCustomerName" maxLength = "50"/>
		</div>
		
		<div class = "search-container__handalSearch--margin handalSearch-customerSex">
			<div class = "handalSearch-customercommon handalSearch-customerSex__text search-container__text_text">Sex</div>
			<select name="browser" id = "cboSex">
				<option value=""></option>
		      	<option value="0">Male</option>
		     	 <option value="1">Female</option>
			</select>
		</div>
		
		<div class = "search-container__handalSearch--margin handalSearch-BirthdayFrom">
			<div class = "handalSearch-customercommon handalSearch-BirthdayFrom__text search-container__text_text">Birthday</div>
			<input id = "txtBirthdayForm" class = "txtCustomerValidateFROM" name = "txtBirthdayFromName" maxLength = "10"/>
			<lable class = "handalSearch-BirthdayFrom__ngangcach">～</lable>
			<input id = "txtBirthdayTo" class = "txtCustomerValidateTO" name = "txtBirthdayToName" maxLength = "10"/>
		</div>
		
		<div class = "handalSearch-btnSearch">
			<button type = "submit" id = "btnSearch" onclick ="validateForm()">Search</button>
		</div>
	</div>

	
	
	<div class = "search-container__btnContext--chuyenhuong">
		<div class = "search-container__btnContext--start">
			<%
				if (request.getAttribute("listDataSearch") == null) {
			%>
			<%
				
				if (request.getAttribute("ListA") == null) {
			%>
					<button id = "btnFirst" disabled style="pointer-events: none;"><a href="#"><<</a></button>
					<button id = "btnPrevious" disabled style="pointer-events: none;"><a href="#"><</a></button>
			<%
				}
			%>
			<%
				if (request.getAttribute("ListA") != null) {
			%>
				
				<c:if test="${tag == 1}">				
					<button id = "btnFirst" disabled style="pointer-events: none;"><a href="#"><<</a></button>
					<button id = "btnPrevious" disabled style="pointer-events: none;"><a href="#"><</a></button>
				</c:if>
				<c:if test="${tag > 1 }">	
					<button id = "btnFirst"><a href="/CustomerSystem_Servlet_Jsp/T002?index=<%=1 %>"><<</a></button>			
					<button id = "btnPrevious"><a href="/CustomerSystem_Servlet_Jsp/T002?index=${tag-1}"><</a></button>
				</c:if>
			<%
				}
			%>
			
			
			<lable class = "search-container__btnContext--textstart search-container__text_text">Previous</lable>
		</div>
		
		<div class = "search-container__btnContext--end">
			<lable class = "search-container__btnContext--textend search-container__text_text">Next</lable>
			<%
				if (request.getAttribute("ListA") == null) {
			%>
				<button id = "btnNext" disabled style="pointer-events: none;"><a href="#">></a></button>
				<button id="btnPrevious" disabled style="pointer-events: none;"><a href="#">>></a></button>
			<%
				}
			%>
			
			<%
				if (request.getAttribute("ListA") != null) {
				int endP = (Integer) request.getAttribute("endP"); 
			%>
			<c:if test="${tag >= endP}">			
				<button id = "btnNext" disabled style="pointer-events: none;"><a href="#">></a></button>
				<button id="btnPrevious" disabled style="pointer-events: none;"><a href="#">>></a></button>
			</c:if>
			<c:if test="${tag < endP}">			
				<button id = "btnNext" ><a href="/CustomerSystem_Servlet_Jsp/T002?index=${tag+1}">></a></button>
				<button id="btnPrevious"><a href="/CustomerSystem_Servlet_Jsp/T002?index=<%= endP %>">>></a></button>
			</c:if>		
			<%
				}
			%>
			<%
				} 
			%>
			
			<c:if test="${requestScope.listDataSearch != null}">
    <c:choose>
        <c:when test="${requestScope.currentPage == 1}">
            <button id="btnFirst" disabled style="pointer-events: none;"><a href="#"><<</a></button>
            <button id="btnPrevious" disabled style="pointer-events: none;"><a href="#"><</a></button>
        </c:when>
        <c:otherwise>
            <button id="btnFirst" onclick="sendPostRequest(1)"><<</button>
            <button id="btnPrevious" onclick="sendPostRequest(${requestScope.currentPage - 1})"><</button>
        </c:otherwise>
    </c:choose>

    <c:choose>
        <c:when test="${requestScope.currentPage == requestScope.totalPages}">
            <button id="btnNext" disabled style="pointer-events: none;"><a href="#">></a></button>
            <button id="btnLast" disabled style="pointer-events: none;"><a href="#">>></a></button>
        </c:when>
        <c:otherwise>
            <button id="btnNext" onclick="sendPostRequest(${requestScope.currentPage + 1})">></button>
            <button id="btnLast" onclick="sendPostRequest(${requestScope.totalPages})">>></button>
        </c:otherwise>
    </c:choose>
</c:if>

				
</form>		
		</div>
	</div>
	<form action ="/CustomerSystem_Servlet_Jsp/T002" method = "POST" onsubmit = "return deleteRows();">
	<table class = "search-container__table">
        <tr class = "search-container__table--tieude">
        	<th class = "searchtable-trcheck"><input type="checkbox" id = "checkAll" name="checkboxAll" value="" onclick = "checkBox(this)"></th>
            <th class = "searchtable-trid">Customer ID</th>
            <th class = "searchtable-trname">Customer Name</th>
            <th class = "searchtable-trsex">Sex</th>
            <th class = "searchtable-trbirthday">Birthday</th>
            <th class = "searchtable-traddress">Address</th>
        </tr>

<c:choose>
    <c:when test="${not empty listDataSearch}">
        <c:forEach items="${listDataSearch}" var="dept" >
            <tr>
                <td class = "searchtable-check"><input type="checkbox" name="checkboxAll" value="${dept.CUSTOMER_ID}"></td>
                <td ><a href="/CustomerSystem/T003?id=${dept.CUSTOMER_ID}" class = "searchtable-id"> ${dept.CUSTOMER_ID} </a></td>
                <td class = "searchtable-name">${dept.CUSTOMER_NAME }</td>
                <td class = "searchtable-sex">${dept.SEX}</td>
                <td class = "searchtable-birthday">${dept.BIRTHDAY}</td>
                <td class = "searchtable-address">${dept.ADDRESS}</td>
            </tr>
        </c:forEach>
    </c:when>
    <c:when test="${not empty ListA}">
        <c:forEach items="${ListA}" var="dept">
            <tr>
                <td class = "searchtable-check"><input type="checkbox" name="checkboxAll" value="${dept.CUSTOMER_ID}"></td>
                <td ><a href="/CustomerSystem_Servlet_Jsp/T003?id=${dept.CUSTOMER_ID}" class = "searchtable-id"> ${dept.CUSTOMER_ID} </a></td>
                <td class = "searchtable-name">${dept.CUSTOMER_NAME }</td>
                <td class = "searchtable-sex">${dept.SEX}</td>
                <td class = "searchtable-birthday">${dept.BIRTHDAY}</td>
                <td class = "searchtable-address">${dept.ADDRESS}</td>
            </tr>
        </c:forEach>
    </c:when>
    <c:otherwise>
        <c:forEach items="${ListA}" var="dept">
            <tr>
                <td class = "searchtable-check"><input type="checkbox" name="checkboxAll" value="${dept.CUSTOMER_ID}"></td>
                <td ><a href="/CustomerSystem_Servlet_Jsp/T003?id=${dept.CUSTOMER_ID}" class = "searchtable-id"> ${dept.CUSTOMER_ID} </a></td>
                <td class = "searchtable-name">${dept.CUSTOMER_NAME }</td>
                <td class = "searchtable-sex">${dept.SEX}</td>
                <td class = "searchtable-birthday">${dept.BIRTHDAY}</td>
                <td class = "searchtable-address">${dept.ADDRESS}</td>
            </tr>
        </c:forEach>
    </c:otherwise>
    
</c:choose>


    </table>
    <div class = "search-btn__form">
		<button class = "search-container__nav-btnAddNew">
			<a href="/CustomerSystem_Servlet_Jsp/T003" >Add new</a>
		</button>
    		<%
				if (request.getAttribute("ListA") != null || request.getAttribute("listDataSearch") != null) {
			%>
				<button type = "submit"  class = "search-container__delete" >Delete</button>
			<%
				}
			%>
			
			<%
				if (request.getAttribute("ListA") == null && request.getAttribute("listDataSearch") == null) {
			%>
			<button type = "submit" disabled style="pointer-events: none;" onclick="deleteRows()"class = "search-container__delete" >Delete</button>
			<%
				}
			%>
    </div>
	</form>
	</div>
	<footer class="footer">
		<div class="header-br"></div>
		<div class="footer-text__copyright">Copyright (c) 2000-2008
			FUJINET, All Rights Reserved.</div>
	</footer>
</div>
</div>

<% 
    Object dataFrom = request.getAttribute("dataFrom");
    Object dataTo = request.getAttribute("dataTo");
    Object checkBirthdayFrom = request.getAttribute("messageFrom");
    Object checkBirthdayTo = request.getAttribute("messageTo");
    Object checkerrFromTo = request.getAttribute("errorFromTo");
    String messageErrorTo = Constants.MESSAGE_ERROR_TO;
    String messageErrorFrom = Constants.MESSAGE_ERROR_FROM;
    
    if (dataFrom == null) {
    	dataFrom  = request.getAttribute("dataFrom");
    }
    if (dataTo == null) {
    	dataTo  = request.getAttribute("dataTo");
    }
    if (checkBirthdayFrom == null) {
    	checkBirthdayFrom  = request.getAttribute("messageFrom");
    }
    if (checkBirthdayTo == null) {
    	checkBirthdayTo  = request.getAttribute("messageTo");
    }
    
%>
<input type="hidden" id="dataFrom" value="<%= dataFrom %>">
<input type="hidden" id="dataTo" value="<%= dataTo %>">
<input type="hidden" id="checkBirthdayFrom" value="<%= checkBirthdayFrom %>">
<input type="hidden" id="checkBirthdayTo" value="<%= checkBirthdayTo %>">
<input type="hidden" id="messageErrorTo" value="<%= messageErrorTo %>">
<input type="hidden" id="messageErrorFrom" value="<%= messageErrorFrom %>">
<input type="hidden" id="messageErrorFromBiggerTo" value="<%= checkerrFromTo %>">
<script>
	<%@include file="/WEB-INF/js/T002.js"%>
</script>
</body>
</html>