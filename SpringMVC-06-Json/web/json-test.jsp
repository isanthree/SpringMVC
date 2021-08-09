<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <%--script 标签不要用单闭合--%>
    <script type="text/javascript">
        // 编写一个 JavaScript 对象 ES6
        const user = {
            name: "黄",
            age: 3,
            sex: "男"
        };
        console.log(user);

        // 将 js 对象转化为 json 对象
        var json = JSON.stringify(user);
        console.log(json);

        // 将 JSON 对象转换为 JavaScript 对象
        var obj = JSON.parse(json);
        console.log(obj);

    </script>

</head>
<body>

</body>
</html>
