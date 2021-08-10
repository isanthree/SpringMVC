<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>

    <script src="${pageContext.request.contextPath}/statics/js/jquery-3.6.0.js"></script>

    <script>
        function a() {
            $.post({
                url: "${pageContext.request.contextPath}/a1",
                data: {"name" : $("#username").val()},
                success: function (data) {
                    console.log("data = " + data);
                    console.log("status = " + status);
                    // alert(data);
                },
                error: function () {

                }
            })
        }

    </script>

</head>
<body>

<a href="t1">t1</a><br/>

<%--失去焦点时，发起一个请求到后台--%>
用户名：<input type="text" id="username" onblur="a()"/><br/>

<a href="a2">a2</a><br/>

<a href="${pageContext.request.contextPath}/test2.jsp">test2</a><br/>
<a href="${pageContext.request.contextPath}/login.jsp">login</a><br/>

</body>
</html>
