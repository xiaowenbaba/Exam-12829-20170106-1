<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01Transitional//EN">

<html>

  <head>
	<script language="javascript" type="text/javascript" src="jquery-3.1.1.min.js"></script>
<script type="text/javascript">
$(function(){
	$(".input").click(function(){
		alert("点我触发!!");
	});
});
</script>
  </head>

  

  <body>
	<a href="<%=request.getContextPath()%>/loginServlet?action=entryLogin">进入登陆界面!</a><br/>
	<a href="<%=request.getContextPath()%>/FilmServlet?action=showAllFilm">显示film所有数据!</a>
	<input type="button" value="点我" class="input" >
	<select>
		<option value="2 " selected="selected">水水水水水水水</option>
		<option value="3 " >12124324325</option>
		<option value="4" >dddddsssaaa</option>
		<option value="5" >sdsdsdsadas</option>
		<option value="6 " >fffffsdsds</option>
		<option value="7" >asasasasas</option>
		<option value="8" >ffffffsass</option>
	</select>
  </body>

</html>
