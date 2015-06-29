<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>ContractDelete</title>
</head>
<body>
<%out.print("正在删除..."); %>
<%@page import="service.ContractService" %>
<%ContractService cs = new ContractService(); %>
<%int con_id = Integer.parseInt(request.getParameter("cid")); %>
<%boolean ifSuccess = cs.deleteaContract(con_id); %>
<%
if (ifSuccess) {
	out.print("删除成功，即将跳转");
} else {
	out.print("删除失败，即将跳转");
}
Thread.sleep(1000);
response.sendRedirect("ContractManager.jsp");
%>
</body>
</html>