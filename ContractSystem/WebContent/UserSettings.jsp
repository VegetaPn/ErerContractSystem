<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>合同管理系统</title>
    <!-- Bootstrap Core CSS -->
    <link href="bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>

   <div id="wrapper">
 <%String name1 = (String)session.getAttribute("username"); %>
   
        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">合同管理系统</a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-envelope fa-fw"></i>  <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-messages">
                        <li>
                            <a href="#">
                                <div>
                                    <strong>孔祥远</strong>
                                    <span class="pull-right text-muted">
                                        <em>昨天</em>
                                    </span>
                                </div>
                                <div>我起草了一个合同，希望可以尽快分配</div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <strong>延昊南</strong>
                                    <span class="pull-right text-muted">
                                        <em>昨天</em>
                                    </span>
                                </div>
                                <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <strong>管理员</strong>
                                    <span class="pull-right text-muted">
                                        <em>昨天</em>
                                    </span>
                                </div>
                                <div>我分配了3个合同</div>
                            </a>
                        </li>
                        
                    </ul>
                    <!-- /.dropdown-messages -->
                </li>
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-tasks fa-fw"></i>  <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-tasks">
                        <li>
                            <a href="#">
                                <div>
                                    <p>
                                        <strong>合同1</strong>
                                        <span class="pull-right text-muted">40% Complete</span>
                                    </p>
                                    <div class="progress progress-striped active">
                                        <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%">
                                            <span class="sr-only">40% Complete (success)</span>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <p>
                                        <strong>合同2</strong>
                                        <span class="pull-right text-muted">20% Complete</span>
                                    </p>
                                    <div class="progress progress-striped active">
                                        <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" style="width: 20%">
                                            <span class="sr-only">20% Complete</span>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <p>
                                        <strong>合同3</strong>
                                        <span class="pull-right text-muted">60% Complete</span>
                                    </p>
                                    <div class="progress progress-striped active">
                                        <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%">
                                            <span class="sr-only">60% Complete (warning)</span>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <p>
                                        <strong>合同 4</strong>
                                        <span class="pull-right text-muted">80% Complete</span>
                                    </p>
                                    <div class="progress progress-striped active">
                                        <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%">
                                            <span class="sr-only">80% Complete (danger)</span>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a class="text-center" href="StateServlet?type=before">
                                <strong>查看我的所有合同状态</strong>
                                <i class="fa fa-angle-right"></i>
                            </a>
                        </li>
                    </ul>
                    <!-- /.dropdown-tasks -->
                </li>
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-bell fa-fw"></i>  <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-alerts">
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-comment fa-fw"></i> 新消息
                                    <span class="pull-right text-muted small">4分钟之前</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-twitter fa-fw"></i> 新消息
                                    <span class="pull-right text-muted small">12分钟之前</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-envelope fa-fw"></i> 消息已发送
                                    <span class="pull-right text-muted small">4分钟之前</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-tasks fa-fw"></i>新任务
                                    <span class="pull-right text-muted small">4分钟之前</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                    
                    </ul>
                    <!-- /.dropdown-alerts -->
                </li>
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                  
                        <li><a href="UserProfile.jsp"><i class="fa fa-user fa-fw"></i> <%=name1 %></a>
                        </li>
                        <li><a href="UserSettings.jsp"><i class="fa fa-gear fa-fw"></i> 完善个人信息</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="login.jsp"><i class="fa fa-sign-out fa-fw"></i> 注销用户</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        
                         
                        <li>
                            <a href="#"><i class="fa fa-dashboard fa-fw"></i> 起草合同<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="Draft.jsp">进行起草</a>
                                </li>
                               
                            </ul>
                        </li>
                        
                        <li>
                            <a href="#"><i class="fa fa-table fa-fw"></i> 会签合同<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="CounterSignServlet?type=before">待会签合同</a>
                                </li>
                                <li>
                                    <a href="CounterSignServlet?type=after">已会签合同</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-edit fa-fw"></i>定稿合同<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="FinalizedServlet?type=before">待定稿合同</a>
                                    <a href="FinalizedServlet?type=after">已定稿合同 </a>
                                    
                                </li>
                               
                            </ul>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-wrench fa-fw"></i>审批合同<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="ApproveServlet?type=before">待审批合同</a>
                                    <a href="ApproveServlet?type=after">已审批合同 </a>
                                    
                                </li>
                               
                            </ul>
                        <li>
                            <a href="#"><i class="fa fa-sitemap fa-fw"></i> 签订合同<span class="fa arrow"></span></a>
                           <ul class="nav nav-second-level">
                                <li>
                                    <a href="SignServlet?type=before">待签订合同</a>
                                    <a href="SignServlet?type=after">已签订合同 </a>
                                    
                                </li>
                               
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        
                       <li>
                            <a href="#"><i class="fa fa-sitemap fa-fw"></i> 我的合同<span class="fa arrow"></span></a>
                           <ul class="nav nav-second-level">
                                <li>
                                    <a href="StateServlet?type=before">查看我起草合同的状态</a>
                                </li>
                               
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>

        <!-- Page Content -->
        
        <%String name = (String)session.getAttribute("username"); %>
        <%int id = (int)session.getAttribute("userid"); %>
        <%String rolename = (String)session.getAttribute("rolename"); %>
        <%String roledesc = (String)session.getAttribute("roledesc"); %>
         <div id="page-wrapper" class="panel panel-default">
        <form method="post" action="UserProfileServlet">
                        <div class="panel-body">
                        	<h3>用户名:
                        	<input id="upname" name="upname" type="text" value=<%=name %> /> 
                            </h3>
                            <h3>更新密码(可选):
                        	<input id="uppwd" name="uppwd" type="password" /> 
                            </h3>
                            <button type="submit" class="btn btn-default">保存</button>
                        </div>
                        </form>
                        <form method="post" action="../PermissionServlet">
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th>#ID</th>
                                            <th>用户名</th>
                                            <th>角色</th>
                                            <th>角色描述</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <%@page import="java.util.*,java.sql.*"%>
                                    <%@page import="java.io.*,service.UserService,model.Role"%>
                                    <%UserService us = new UserService();
                                      ResultSet ids = us.getids();
                                      ResultSetMetaData m = ids.getMetaData();
                                      int col = m.getColumnCount();
                                      String select1 = "",select2 = "", idnum = "id", rolenum = "role";
                                      String[] thisid = new String[10];
                                      int n = 1;
                                      while(ids.next()) {
                                    	  for(int i = 1; i <= col; i++) {
                                    		  //System.out.println(ids.getString(i));
                                    		  thisid[i] = ids.getString(i);
                                    		  Role role = us.getUserRole(Integer.parseInt(thisid[i]));
                                    		  rolenum = "role"+n;
                                    		  
                                    		  if(role.getName().equals("admin")) {
                                    			  select1 = "selected='selected'";
                                    		  }else {
                                    			  select2 = "selected='selected'";
                                    		  }
                                    		  out.println(
                                    				  "<tr class='info'>"+
	                                                      "<td>"+thisid[i]+"</td>"+
	                                                      "<td>"+us.getName(thisid[i])+"</td>"+
	                                                      "<td><select name='"+rolenum+"'>"+
		                                                      "<option value ='operator'"+
	                                                      		select2+">operator</option>"+
		                                                      "<option value ='admin'"+
	                                                      		select1+">admin</option>"+
	                                                      "</select></td>"+
	                                                      "<td>"+role.getDescription()+"</td>"+
                                                  	  "</tr>");
                                    		  idnum = "id"+n;
                                    		  System.out.println("idnum:"+idnum+"id:"+thisid[i]);
                                    		  session.setAttribute(idnum, thisid[i]);
                                    		  //session.setAttribute(rolenum, role.getName());
                                    		  n++;
                                    		  select1 = "";
                                    		  select2 = "";
                                    	  }
                                    	  session.setAttribute("num", n);
                                      }
                                      int userid = (int)session.getAttribute("userid");
                                      String dis = us.getUserRole(userid).getName();
                                      %>
                                        
                                    </tbody>
                                </table>
                            </div>
                            <!-- /.table-responsive -->
                        </div>
                        <%
                        if(dis.equals("operator")) {
                        	out.println("<button type='button' class='btn btn-default'>您没有权限保存此项设置</button>");
                        } else {
                        	out.println("<button type='submit' class='btn btn-default'>保存权限分配方案</button>");
                        } %>
                        <div>
                        
                        </div>
                        </form>
            	</div>
            	
            	
            	</div>
            	
    <!-- jQuery -->
    <script src="bower_components/jquery/dist/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="bower_components/metisMenu/dist/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="dist/js/sb-admin-2.js"></script>

</body>
</body>
</html>