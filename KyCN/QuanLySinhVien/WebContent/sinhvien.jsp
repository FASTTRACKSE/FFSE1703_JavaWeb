
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New User</title>
</head>
<body>
<form method="POST" action='Main' name="frmAddUser"><input
	type="hidden" name="action" value="insert" />
<p><b>Add New Record</b></p>
<table>
	<tr>
		<td> ID</td>
		<td><input type="text" name="id" /></td>
	</tr>
	<tr>
		<td>Ho Dem</td>
		<td><input type="text" name="hoDem" /></td>
	</tr>
	<tr>
		<td>Ten</td>
		<td><input type="text" name="ten" /></td>
	</tr>
		<tr>
		<td>Ngay Sinh</td>
		<td><input type="text" name="ngaySinh" /></td>
	</tr>	<tr>
		<td>Que Quan</td>
		<td><input type="text" name="queQuan" /></td>
	</tr>	<tr>
		<td>Gioi Tinh</td>
		<td><input type="text" name="gioiTinh" /></td>
	</tr>	<tr>
		<td>Lop</td>
		<td><input type="text" name="lop" /></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="submit" value="Submit" /></td>
	</tr>
</table>
</form>
<p><a href="Menu.jsp">View-All-Records</a></p>
</body>
</html>