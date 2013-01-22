<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>信息系统登录界面</title>
	</head>
	<body>
		<form id="loginForm" action="login.action" method="post">
			<table style="border: 1px solid #9f9f9f;">
	        <tr>
	            <td>
	                <label for="userName">登 录 名:</label>
	            </td>
	            <td>
	                <input type="text" id="loginName" name="user.loginName"/>
	            </td>
	        </tr>
	        <tr>
	            <td>
	                <label for="password">密  码:</label>
	            </td>
	            <td>
	                <input type="password" id="password" name="user.password"/>
	            </td>
	        </tr>
	        <tr>
	        	<td>
	        		<input type="submit" value="登录" />
	        	</td>
	        	 <td>
	        	 	<input type="submit" value="注册" />
	        	</td>
	        </tr>
	   	 </table>
		</form>
	</body>
</html>