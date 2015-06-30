<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@ page import="java.util.*"%>
<%@ page import="model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>合同管理系统</title>

    <!-- Bootstrap Core CSS -->
    <link href="bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
   <link href="bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.css" rel="stylesheet">
    <!-- MetisMenu CSS -->
    <link href="bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">
    <link href="bower_components/datatables-responsive/css/dataTables.responsive.css" rel="stylesheet">
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
     <%
	 ArrayList<User> couterlist=(ArrayList<User>)request.getAttribute("couterlist");
     ArrayList<User> approvelist=(ArrayList<User>)request.getAttribute("approvelist");
     ArrayList<User> signlist=(ArrayList<User>)request.getAttribute("signlist");
     String conname=(String)request.getAttribute("conname");
     String conid=(String)request.getAttribute("conid");
     ArrayList<String> name1;//存取选中的会签人
     ArrayList<String> name2;//审核人
     ArrayList<String> name3;//签订人
    %>
    <%@page import = "dao.LogDao"%>
        <%String apath = this.getServletContext().getRealPath("");
          String uname = (String) session.getAttribute("username");
          LogDao.addaLog("Allocate a contract:"+conname, apath, uname);
        %>
</head>

<body>

     <div id="wrapper">
 <%String name11 = (String)session.getAttribute("username"); %>
   <%int userid = (int)session.getAttribute("userid"); %>
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
                  
                        <li><a href="pages/UserProfile.jsp"><i class="fa fa-user fa-fw"></i> <%=name11 %></a>
                        </li>
                        <li><a href="pages/UserSettings.jsp"><i class="fa fa-gear fa-fw"></i> Settings</a>
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
                        <li class="sidebar-search">
                            <div class="input-group custom-search-form">
                                <input type="text" class="form-control" placeholder="Search...">
                                <span class="input-group-btn">
                                    <button class="btn btn-default" type="button">
                                        <i class="fa fa-search"></i>
                                    </button>
                                </span>
                            </div>
                            <!-- /input-group -->
                        </li>
                         <li>
                            <a href="#"><i class="fa fa-dashboard fa-fw"></i><b> --------合同管理-------</b></a>
                        </li>
                        <li>
                            <a href="pages/ContractManager.jsp"><i class="fa fa-bar-chart-o fa-fw"></i> 查看合同</a>
                        </li>
                        <li>
                            <a href="AllocateServlet?type=before"><i class="fa fa-table fa-fw"></i> 分配合同</a>
                        </li>
                        
                        <li>
                            <a><i class="fa fa-dashboard fa-fw"></i><b> --------系统管理-------</b></a>
                        </li>
                        <li class="active">
                            <a href="pages/CustomerManage.jsp"><i class="fa fa-files-o fa-fw"></i> 客户管理</a>
                        </li>
                        <li class="active">
                            <a href="pages/UserManage.jsp"><i class="fa fa-files-o fa-fw"></i> 用户管理&权限分配</a>
                        </li>
                        <li class="active">
                            <a href="pages/RoleManage.jsp"><i class="fa fa-files-o fa-fw"></i> 角色管理</a>
                        </li>
                        
                        <li class="active">
                            <a href="pages/LogManage.jsp"><i class="fa fa-files-o fa-fw"></i> 日志管理</a>
                        </li>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>

        <!-- Page Content -->
        
        <!-- /#page-wrapper -->

     <!-- Page Content -->
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">合同:<%=conname %>  |流程配置</h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- /.row -->
            </div>
           <!-- 从这里开始的 -->
           <div class="panel-body"><!--panel body start-->
          <form id="form1" class="form-horizontal" role="form" action="AllocateServlet?type=allocate&cid=<%=conid%>" method="post">
            <div class="form-group">
                <div class="form_group  col-sm-10 col-sm-offset-1">
                    <span class="glyphicon glyphicon-record"></span>
                    <span class="glyphicon-class">分配会签人</span>                   
                </div>
                <div class="form-group">
                <script type="text/javascript">
                 function hqleft()
                {
                    var hqleft = document.getElementById("hqleft");
                    var hqright = document.getElementById("hqright");
                    var val = hqleft.options[hqleft.selectedIndex].text;
                    
                    hqleft.remove(hqleft.selectedIndex);
                    hqright.options.add(new Option(val,val));
                    hqnames.push(val);
                    //alert(hqnames[0]);
                 }
                function hqright()
               {
                   var hqleft = document.getElementById("hqleft");
                   var hqright = document.getElementById("hqright");
                   var val = hqright.options[hqright.selectedIndex].text;
                   
                   hqright.remove(hqright.selectedIndex);
                   hqleft.options.add(new Option(val,val));
                   var arrayindex = hqnames.indexOf(val);
                   if(arrayindex >-1)
    	           hqnames.splice(arrayindex, 1);
                   //alert(hqnames[0]);
                }
              </script>
                    <div class="col-sm-4 col-sm-offset-1">
                        <select multiple class="form-control" id="hqleft">
                        <% for(int i=0;i<couterlist.size();i++)
                        {%>      
                        <option><%=(String)((User)couterlist.get(i)).getName() %></option>
                        <%} 
                        %>
                        </select>                    
                    </div>
                    <div class="col-sm-2 aCenter" align="center">
                        <div class="form-group">
                        <span class="glyphicon glyphicon-arrow-left myclickstyle" onclick="hqright()"></span>                   
                        </div>
                        <div class="form-group">
                            <span class="glyphicon glyphicon-arrow-right myclickstyle" onclick="hqleft()"></span>   
                                          
                        </div>            
                    </div>
                    <div class="col-sm-4" >
                        <select  multiple class="form-control" id="hqright" name="hqright">
                        </select>                    
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="form_group  col-sm-10 col-sm-offset-1">
                    <span class="glyphicon glyphicon-record"></span>
                    <span class="glyphicon-class">分配审批人</span>                   
                </div>
                <div class="form-group">
                <script type="text/javascript">
            function spleft()
            {
               var spleft = document.getElementById("spleft");
               var spright = document.getElementById("spright");
               var val = spleft.options[spleft.selectedIndex].text;
               spleft.remove(spleft.selectedIndex);
               spright.options.add(new Option(val,val));
               spnames.push(val);
               //alert(spnames[0]);
               }
               function spright()
               {
               var spleft = document.getElementById("spleft");
               var spright = document.getElementById("spright");
               var val = spright.options[spright.selectedIndex].text;
               spright.remove(spright.selectedIndex);
               spleft.options.add(new Option(val,val));
               var arrayindex = spnames.indexOf(val);
               if(arrayindex >-1)
    	           spnames.splice(arrayindex, 1);
               	   //alert(spnames[0]);
               }
             </script>
                    <div class="col-sm-4 col-sm-offset-1">
                        <select multiple class="form-control" id="spleft">
                        <% for(int i=0;i<approvelist.size();i++)
                        {%>      
                        <option><%=(String)((User)approvelist.get(i)).getName()%></option>
                        <%} 
                        %>
                        </select>                    
                    </div>
                    <div class="col-sm-2 aCenter" align="center">
                        <div class="form-group">
                            <span class="glyphicon glyphicon-arrow-left myclickstyle" onclick="spright()"></span>                       
                        </div>
                        <div class="form-group">
                            <span class="glyphicon glyphicon-arrow-right myclickstyle" onclick="spleft()"></span>                    
                        </div>            
                    </div>
                    <div class="col-sm-4">
                        <select multiple class="form-control" id="spright" name="spright">
                        </select>               
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="form_group  col-sm-10 col-sm-offset-1">
                    <span class="glyphicon glyphicon-record"></span>
                    <span class="glyphicon-class">分配签订人</span>                   
                </div>
                <div class="form-group">
                  <script type="text/javascript">
                  function qdleft()
                  {
                   var qdleft = document.getElementById("qdleft");
                   var qdright = document.getElementById("qdright");
                   var val = qdleft.options[qdleft.selectedIndex].text;
                   qdleft.remove(qdleft.selectedIndex);
                   qdright.options.add(new Option(val,val));
                   qdnames.push(val);
                   //alert(qdnames[0]);
                  }
                  function qdright()
                  {
                   var qdleft = document.getElementById("qdleft");
                   var qdright = document.getElementById("qdright");
                   var val = qdright.options[qdright.selectedIndex].text;
                   qdright.remove(qdright.selectedIndex);
                   qdleft.options.add(new Option(val,val));
                   var arrayindex = qdnames.indexOf(val);
                   if(arrayindex >-1)
                  	 qdnames.splice(arrayindex, 1);
                     //alert(qdnames[0]);
                   
                  }
                  </script>
                    <div class="col-sm-4 col-sm-offset-1">
                        <select multiple class="form-control" id="qdleft"  >
                        <% for(int i=0;i<signlist.size();i++)
                        {%>      
                        <option><%=(String)((User)signlist.get(i)).getName()%></option>
                        <%} 
                        %>
                        </select>                    
                    </div>
                    <div class="col-sm-2 aCenter" align="center">
                        <div class="form-group">
                           <span class="glyphicon glyphicon-arrow-left myclickstyle" onclick="qdright()"></span>                      
                        </div>
                        <div class="form-group">
                            <span class="glyphicon glyphicon-arrow-right myclickstyle" onclick="qdleft()"></span>                   
                        </div>            
                    </div>
                    <div class="col-sm-4">
                        <select multiple class="form-control" id="qdright" name="qdright">
                        </select>              
                    </div>
                </div>
            </div>
            <script>
            function sub(){
            	var qdright = document.getElementById("qdright");
            	 var spright = document.getElementById("spright");
            	 var hqright = document.getElementById("hqright");
            	 for(var i=0;i<qdright.options.length;i++){
            		// qdright.options[i].name="qdright1";
            		 qdright.options[i].selected="true";
            	 }
            	 for(var i=0;i<spright.options.length;i++){
            		 //spright.options[i].name="spright1";
            		 spright.options[i].selected="true";
            		 
            	 }
            	 for(var i=0;i<hqright.options.length;i++){
            		// hqright.options[i].name="hqright1";
            		 hqright.options[i].selected="true";
            		 
            	 }
            	 document.getElementById('form1').submit();
            }
            
            </script>
            <div class="form-group">
                <div class="col-sm-2 col-sm-offset-4">
                 <button type="button" class="btn btn-info btn-block" id="提交" onclick="sub()" >确定</button>                    
                </div>
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
    <script src="bower_components/datatables/media/js/jquery.dataTables.min.js"></script>
    <script src="bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min.js"></script>
    <!-- Custom Theme JavaScript -->
    <script src="dist/js/sb-admin-2.js"></script>
    

</body>

</html>