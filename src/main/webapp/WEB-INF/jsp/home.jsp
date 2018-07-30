<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>登录成功</title>
</head>
<body>
    你好！ <%= SecurityContextHolder.getContext().getAuthentication().getName() %>
    <a href="<%=request.getContextPath()+"/ssoclient/oauth2_logout" %>">注销</a>
</body>
</html>
