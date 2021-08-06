<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>CRUD</title>
</head>
<body>

<%--发起图书的增删改查请求，使用 Rest 风格的 URL 地址
请求的 URL     请求方式    表示含义
/book/1        GET：      查询 1 号图书
/book/1        DELETE：   删除 1 号图书
/book/1        PUT：      更新 1 号图书
/book          POST：     添加 ? 号图书

如何从页面发起 PUT、DELETE 形式的请求？
Spring 提供了对 Rest 风格的支持：
1.SpringMVC 中有一个 Filter，它可以把普通的请求转化为规定形式的请求。filter 配置如下：
    <filter>
        <filter-name>HiddenHttpMethodFilter</filter-name>
        <filter-class>org.springframework.web.filter.HiddenHttpMethodFilter</filter-class>
    </filter>
    <filter-mapping>
        <filter-name>HiddenHttpMethodFilter</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>
2.如何发起其他形式请求？
需要满足要求：
    1）创建一个 POST 类型的表单
    2）表单项中携带一个 _method 的参数
    3）这个 _method 的值就是 DELETE、PUT
--%>
<a href="book/1">查询 1 号图书</a><br/>

<br/>

<form action="book" method="post">
    <input type="submit" value="添加图书"/>
</form><br/>

<%--发送 DELETE 请求--%>
<form action="book/1" method="post">
    <input name="_method" value="delete"/>
    <input type="submit" value="删除 1 号图书"/>
</form><br/>

<%--发送 PUT 请求--%>
<form action="book/1" method="post">
    <input name="_method" value="put"/>
    <input type="submit" value="更新 1 号图书"/>
</form><br/>

</body>
</html>
