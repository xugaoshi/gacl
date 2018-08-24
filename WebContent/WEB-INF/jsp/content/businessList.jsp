<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE"/>
		<title></title>
		<link rel="stylesheet" type="text/css" href="<%=basepath %>/static/css/all.css"/>
		<link rel="stylesheet" type="text/css" href="<%=basepath %>/static/css/pop.css"/>
		<link rel="stylesheet" type="text/css" href="<%=basepath %>/static/main.css"/>
		<script type="text/javascript" src="<%=basepath %>/static/js/common/jquery-1.8.3.js"></script>
	 <script type="text/javascript" >
		   function shanchu(id){
			  
	
				
				 $.ajax({
			           type: "post",//使用servlet中的post方法
			           url: "bushanchu",//进入那个servlet中去
			           //将值传入servlet
			           data: {
			              key: id
			           },
			           success: function(data) {
			        	   alert("删除成功");
			        	   window.location.reload(); //实现刷新的功能
			           }
			        })

				}
		 
		   function chaxun(){
			   $(".tab2").html(" <tr>"
                      
                       +"<th>序号</th>"
                        +"<th>标题</th>"
                        +"<th>副标题</th>"
                        +"<th>城市</th>"
                        +"<th>类别</th>"
                        +"<th>操作</th>"
                        +"</tr>");	  
			   
				var id=$("#title").val();
				
				 
				 $.ajax({
			           type: "post",//使用servlet中的post方法
			           url: "buchaxun",//进入那个servlet中去
			           //将值传入servlet
			           data: {
			              "key":id   //key value     格式''：''
			           },
			           success: function(data) {
			        	   var list = eval("("+data+")");
		            		 for(i=0;i<list.length;i++){ 
		            			 var tr="<tr >"
		    
		      +" <td>"+ list[i].id+"</td>"
		      +" <td>"+list[i].title+"</td>"
		      +" <td>"+ list[i].subtitle+"</td>"
		      +" <td>"+ list[i].citys+"</td>"
		      +" <td>"+ list[i].categorys+"</td>"
		       +"<td><a onclick="location.href='${basepath}/xiugai ?${list.id }&${list.imgFileName} '">修改</a>&nbsp;&nbsp;&nbsp;<a  id="+list[i].id+" href='#' onclick='shanchu(this.id)'>删除</a></td>"
		      +" </tr> "
		            		 $(".tab2").append(tr);}
			        
			           }
			        })

		   }
		        
           
		   
		   
		   </script>
	
	</head>
	<body style="background: #e1e9eb;">
		<form action="" id="mainForm" method="post">
			
			<div class="right">
				<div class="current">当前位置：<a href="#">内容管理</a> &gt; 商户管理</div>
				<div class="rightCont">
					<p class="g_title fix">商户列表</p>
					<table class="tab1">
						<tbody>
							<tr>
								<td align="right" width="80">标题：</td>
								<td>
									<input name="title" id="title" value="" class="allInput" type="text"/>
								</td>
	                            <td style="text-align: right;" width="150">
	                            	<input class="tabSub" value="查询" onclick="chaxun()" type="button"/>&nbsp;&nbsp;&nbsp;&nbsp;
	                            	
	                            	<input class="tabSub" value="添加" onclick="location.href='${basepath}/buAdd1'" type="button"/>
	                            	
	                            </td>
	       					</tr>
						</tbody>
					</table>
					<div class="zixun fix">
						<table class="tab2" width="100%">
							<tbody>
								<tr>
								    <th>序号</th>
								    <th>标题</th>
								    <th>副标题</th>
								    <th>城市</th>
								    <th>类别</th>
								    <th>操作</th>
								</tr>
								
							 <c:forEach items="${bulist}" var="list"> 
							
							<tr>
										 <td>${list.id }</td>
									   <td>${list.title }</td>
										<td>${list.subtitle }</td>
										<td>${list.citys }</td>
										<td>${list.categorys }</td>
										
										<td>
											<a href="#" onclick="location.href='${basepath}/xiugai ?${list.id }&${list.imgFileName} '">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;
											<a href="#" onclick="shanchu(${list.id })">删除</a>
										</td>
										
								</tr>
							</c:forEach> 
										
							
							</tbody>
						</table>
						
			
					</div>
				</div>
			</div>
		</form>
	</body>

</html>