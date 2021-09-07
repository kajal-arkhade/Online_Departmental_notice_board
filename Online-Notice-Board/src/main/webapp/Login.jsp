<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
* {
	box-sizing: border-box;
}

body{
			margin: 0;
			padding: 0;
			background: url(image1.jpg);
			background-size:100%;
			background-repeat: no-repeat;
			font-family: Arial, Helvetica, sans-serif;
		}

.header {
	overflow: hidden;
	background-color: #f1f1f1;
	padding: 20px 10px;
	
}

.header a {
	float: left;
	color: black;
	text-align: center;
	padding: 12px;
	text-decoration: none;
	font-size: 20px;
	line-height: 25px;
	border-radius: 4px;
}

.header {
	padding: 10px;
	text-align: center;
	background: #808080;
	color: white;
}

.header a.logo {
	font-size: 25px;
	font-weight: bold;
}

.header a:hover {
	background-color: #808080;
	color: black;
}

.header-right {
	float: right;
	
}
.button {
  background-color:#FFA07A;
  border: none;
  color: #0000FF;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}
}

</style>
</head>
<body>

	<div class="header">
		<marquee>
			<h2 style="color: DodgerBlue;">You can view daily notices here...</h2>
		</marquee>
		<h1 align=center style="color: #B22222;">
			Login
			</h2>
			<div class="header-right">
			
			</div>
	</div>


<body text="blue" >
	<form action="Login" method="post">
		<table align=center>
		<tr>
				<td><h3>Email:</h3></td>
				<td><input type="text" name="email" /></td>
		</tr><tr></tr>
		<tr>
				<td><h3>Password:</h3></td>
				<td><input type="password" name="password" /></td>
		</tr><tr></tr>
          <tr>
				
				<td><input type="submit" class="button" value="Login"></td>
			
			
			</tr>
        </form>
    </div>

</body>
</html>