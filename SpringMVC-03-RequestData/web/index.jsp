<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<a href="handle01">hello</a><br/>

<a href="handle02?user=tomcat">handle02：获取请求参数测试</a><br/>

<form action="book" method="post">
    书名：<input type="text" name="bookName"/><br/>
    作者：<input type="text" name="author"/><br/>
    价格：<input type="text" name="price"/><br/>
    库存：<input type="text" name="stock"/><br/>
    销量：<input type="text" name="sales"/><br/>
    <hr/>
    （地址）省：<input type="text" name="address.province"/>
    市：<input type="text" name="address.city"/>
    街道：<input type="text" name="address.street"/><br/>
    <input type="submit"/>
</form>

<hr/>

<a href="servletAPITest">servletAPITest</a><br/>

</body>
</html>
