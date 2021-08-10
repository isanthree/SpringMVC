<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Test2</title>

    <script src="${pageContext.request.contextPath}/statics/js/jquery-3.6.0.js"></script>

    <script>
        $(function () {
            // $.post(url, param[可以省略], success)
            $("#btn").click(function () {
                $.post("${pageContext.request.contextPath}/a2", function (data) {
                    console.log(data);
                    let html = "<>";

                    for (let i = 0; i < data.length; i++) {
                        html += "<tr>" +
                            "<td>" + data[i].name + "</td>" +
                            "<td>" + data[i].age + "</td>" +
                            "<td>" + data[i].sex + "</td>" +
                            "</tr>";
                    }

                    $("#context").html(html);
                })
            })
        });
    </script>

</head>
<body>

<input type="button" value="加载数据" id="btn"/>
<table>
    <tr>
        <td>姓名</td>
        <td>年龄</td>
        <td>性别</td>
    </tr>
    <tbody id="context">
    <%--后台数据--%>
    </tbody>
</table>

</body>
</html>
