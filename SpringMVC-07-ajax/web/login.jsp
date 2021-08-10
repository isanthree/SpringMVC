<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Login</title>

    <script src="${pageContext.request.contextPath}/statics/js/jquery-3.6.0.js"></script>

    <script>
        function a1() {
            $.get({
                url: "${pageContext.request.contextPath}/a3",
                data: {"name": $("#name").val()},
                success: function (data) {
                    // console.log(data.toString());

                    if (data.toString() === 'ok') {
                        $("#userInfo").css("color", "green");
                    } else {
                        $("#userInfo").css("color", "red");
                    }

                    $("#userInfo").html(data);
                }
            })
        }

        function a2() {
            $.get({
                url: "${pageContext.request.contextPath}/a3",
                data: {"pwd": $("#pwd").val()},
                success: function (data) {
                    // console.log(data.toString());

                    if (data.toString() === 'ok') {
                        $("#pwdInfo").css("color", "green");
                    } else {
                        $("#pwdInfo").css("color", "red");
                    }

                    $("#pwdInfo").html(data);
                }
            })
        }
    </script>
</head>
<body>

<p>
    用户名：<input type="text" id="name" onblur="a1()"/>
    <span id="userInfo"></span>
</p>
<p>
    密码：<input type="text" id="pwd" onblur="a2()"/>
    <span id="pwdInfo"></span>
</p>

</body>
</html>
