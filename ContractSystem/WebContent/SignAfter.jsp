<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@ page import="java.util.*"%>
<%@ page import="model.*" %>
<%@ page import="dao.*" %>
<%@ page import="web.*" %>
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
	    ArrayList<Contract> contracts=(ArrayList<Contract>)request.getAttribute("final");
        //ArrayList<String> names=(ArrayList<String>)request.getAttribute("names");
        ArrayList<Integer> state=(ArrayList<Integer>)request.getAttribute("state");
       
    %>

</head>

<body>

     <div id="wrapper">
 <%String name1 = (String)session.getAttribute("username"); %>
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
                  
                        <li><a href="UserProfile.jsp"><i class="fa fa-user fa-fw"></i> <%=name1 %></a>
                        </li>
                        <li><a href="../UserSettings.jsp"><i class="fa fa-gear fa-fw"></i> 完善个人信息</a>
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
        
        <!-- /#page-wrapper -->

     <!-- Page Content -->
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">已签订合同列表</h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- /.row -->
            </div>
            <div class="dataTable_wrapper">
                                
                                <div class="dataTable_wrapper">
                                <table class="table table-striped table-bordered table-hover dataTable no-footer" id="dataTables-example" role="grid" aria-describedby="dataTables-example_info">
                                    <thead>
                                        <tr role="row">
                                        <th class="sorting_asc" tabindex="0" aria-controls="dataTables-example" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Rendering engine: activate to sort column descending" style="width: 170px;">
                                                                                                                                               合同名称</th>
                                        <th class="sorting" tabindex="0" aria-controls="dataTables-example" rowspan="1" colspan="1" aria-label="Browser: activate to sort column ascending" style="width: 207px;">合同状态</th>
                                        <th class="sorting" tabindex="0" aria-controls="dataTables-example" rowspan="1" colspan="1" aria-label="Platform(s): activate to sort column ascending" style="width: 188px;">合同客户</th>
                                      <th class="sorting" tabindex="0" aria-controls="dataTables-example" rowspan="1" colspan="1" aria-label="Engine version: activate to sort column ascending" style="width: 147px;">起草时间</th>
                                        <th class="sorting" tabindex="0" aria-controls="dataTables-example" rowspan="1" colspan="1" aria-label="CSS grade: activate to sort column ascending" style="width: 108px;">合同操作</th></tr>
                                    </thead>
                                    <tbody>
                             <% if(contracts!=null){ %>
                             <% for(int i=0;i<contracts.size();i++){%>
                             
                        <tr class="gradeA odd" role="row">
                        
                    
                        <td class="sorting_1"><%=((Contract)contracts.get(i)).getName()%></td>
                        <%if (state.get(i)==2) {%>
                        <td><span style="color: rgb(255,0,0)"> 等待其他人会签</span></td>
                        <%} %>
                         <%if (state.get(i)==3) {%>
                        <td><span style="color: rgb(0,255,0)"> 等待定稿</span></td>
                        <%} %>
                         <%if (state.get(i)==4) {%>
                        <td><span style="color: rgb(0,0,255)"> 等待审核</span></td>
                        <%} %>
                        <%if (state.get(i)==5) {%>
                        <td><span style="color: rgb(0,255,255)"> 等待其他人签订</span></td>
                        <%} %>
                         <%if (state.get(i)==6) {%>
                        <td><span style="color: rgb(255,0,255)"> 合同已完成</span></td>
                        <%} %>
                        <%if (state.get(i)==-1) {%>
                        <td><span style="color: rgb(0,255,255)"> 合同审核拒绝</span></td>
                        <%} %>
                        <td><%=((Contract)contracts.get(i)).getCustomer()%></td>
                        <td><%=((Contract)contracts.get(i)).getBeignTime()%></td>
                        <td class="center">
                        <button  class="btn btn-info" data-toggle="modal" data-target="#myModal<%=i %>"  >详情</button>
                        </td>
                        
                    </tr>
                    
                    <!-- 对话框里的内容 -->
                    <div class="modal fade" id="myModal<%=i %>" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            <h4 class="modal-title" id="myModalLabel">合同详情</h4>
                                        </div>
                                        <div class="modal-body">
                                            <h4>合同编号：</h4><p><%=((Contract)contracts.get(i)).getId()%></p>
                                             <h4>起草人</h4><p><%=UserDao.getNameByID(((Contract)contracts.get(i)).getUseId()) %></p>
                                            <h4>客户：</h4><p><%=((Contract)contracts.get(i)).getCustomer()%></p>
                                            <h4>开始时间：</h4><p><%=((Contract)contracts.get(i)).getBeignTime()%></p>
                                            <h4>结束时间：</h4><p><%=((Contract)contracts.get(i)).getEndTime()%></p>
                                            <h4>合同内容：</h4><p><%=((Contract)contracts.get(i)).getContent()%></p>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                            
                                        </div>
                                    </div>
                                    <!-- /.modal-content -->
                                </div>
                                <!-- /.modal-dialog -->
                            </div>
                            
                            
                   <%} %>
                     <%} %>
                                   </tbody>
                                </table></div>
    <!-- /#wrapper -->
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
    <script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
                responsive: true
        });
    });
    </script>

</body>

</html>