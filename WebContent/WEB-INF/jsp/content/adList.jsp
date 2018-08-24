<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE"/>
		<title></title>
		<link rel="stylesheet" type="text/css" href="<%=basepath %>/static/css/all.css"/>
		<link rel="stylesheet" type="text/css" href="<%=basepath %>/static/css/pop.css"/>
		<link rel="stylesheet" type="text/css" href="<%=basepath %>/static/css/main.css"/>
		   <script src="<%=basepath %>/static/js/common/jquery-1.8.3.js" type="text/javascript"></script>
	 <script type="text/javascript" >
		   function shanchu(id){
			  
	
				
				 $.ajax({
			           type: "post",//使用servlet中的post方法
			           url: "shanchu",//进入那个servlet中去
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
                      
                       +"<td>序号</td>"
                        +"<td>标题</td>"
                        +"<td>链接地址</td>"
                        +"<td>操作</td>"
                        +"</tr>");	  
			   
				var id=$("#title").val();
				
				 
				 $.ajax({
			           type: "post",//使用servlet中的post方法
			           url: "chaxun",//进入那个servlet中去
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
		      +" <td>"+ list[i].link+"</td>"
		       +"<td><a id="+list[i].id+" href='#' onclick='xiugai(this.id)'>修改</a>&nbsp;&nbsp;&nbsp;<a  id="+list[i].id+" href='#' onclick='shanchu(this.id)'>删除</a></td>"
		      +" </tr> "
		            		 $(".tab2").append(tr);}
			        
			           }
			        })

		   }
		        
           
		   
		   
		   </script>

	</head>
	<body style="background: #e1e9eb;">
		<form action="" id="mainForm" method="post">

			<input type="hidden" name="page.currentPage" id="currentPage" value="1"/>
			<div class="right">
				<div class="current">当前位置：<a href="#">内容管理</a> &gt; 广告管理</div>
				<div class="rightCont">
					<p class="g_title fix">广告列表</p>
					<table class="tab1">
						<tbody>
							<tr>
								<td align="right" width="80">标题：</td>
								<td>
									<input name="title" id="title" value="" class="allInput" type="text"/>
								</td>
	                            <td style="text-align: right;" width="150">
	                            	<input class="tabSub" value="查询" onclick="chaxun()" type="button"/>&nbsp;&nbsp;&nbsp;&nbsp;
	                            	<t:auth url="/ad/addInit">
	                            		<input class="tabSub" value="添加" onclick="location.href = '${basepath}/adAdd1' " type="button"/>
	                            	</t:auth>
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
								    <th>链接地址</th>
								    <th>操作</th>
								</tr>
							
							<c:forEach items="${adlist}" var="ad" >	
							<tr>
										<td>${ad.id }</td>
										<td>${ad.title }</td>
										<td>${ad.link }</td>
								
										
										<td>
										
											<a  onclick="location.href='${basepath}/adAdd2 ?${ad.id }&${ad.imgFileName} '">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;
										
										
											<a href="javascript:void(0);" onclick="shanchu(${ad.id })">删除</a>
										
										</td>
									</tr>			
										
							</c:forEach>
							
						
							</tbody>
						</table>
<div style="text-align:center">
        <a href="?start=0">首  页</a>
        <a href="?start=${page.start-page.count}">上一页</a>
        <a href="?start=${page.start+page.count}">下一页</a>
        <a href="?start=${page.last}">末  页</a>
    </div>
					</div>
				</div>
			</div>
		</form>
	</body>

</html>