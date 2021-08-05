<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<a href="hello">helloWorld</a><br/>

<h1>RequestMapping 测试：handle01</h1>
<a href="baseUrl/handle01">写在方法上的 RequestMapping </a><br/>

<hr/>

<h1>RequestMapping 的属性测试</h1>

<a href="baseUrl/handle02">handle02：method 属性测试，此处为 GET 请求</a><br/>
<form action="baseUrl/handle02" method="post">
    <input type="submit" value="handle02：method 属性测试，此处为 POST 请求"/>
</form><br/>

<a href="baseUrl/handle03">handle03：params 属性测试</a><br/>

<a href="baseUrl/handle04">handle04：headers 属性测试</a><br/>

<hr/>

<h1>RequestMapping-Ant 风格的 URL</h1>
<a href="antTest01">精确请求地址：antTest01</a><br/>

<br/>

<a href="user/admin">PathVariable 测试</a><br/>

</body>
</html>
