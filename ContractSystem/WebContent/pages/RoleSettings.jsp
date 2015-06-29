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
    <link href="../bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="../bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="../bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>
<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">个人信息</a>
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
                                    <strong>John Smith</strong>
                                    <span class="pull-right text-muted">
                                        <em>Yesterday</em>
                                    </span>
                                </div>
                                <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <strong>John Smith</strong>
                                    <span class="pull-right text-muted">
                                        <em>Yesterday</em>
                                    </span>
                                </div>
                                <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <strong>John Smith</strong>
                                    <span class="pull-right text-muted">
                                        <em>Yesterday</em>
                                    </span>
                                </div>
                                <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a class="text-center" href="#">
                                <strong>Read All Messages</strong>
                                <i class="fa fa-angle-right"></i>
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
                            <a class="text-center" href="#">
                                <strong>See All Tasks</strong>
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
                                    <i class="fa fa-comment fa-fw"></i> New Comment
                                    <span class="pull-right text-muted small">4 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-twitter fa-fw"></i> 3 New Followers
                                    <span class="pull-right text-muted small">12 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-envelope fa-fw"></i> Message Sent
                                    <span class="pull-right text-muted small">4 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-tasks fa-fw"></i> New Task
                                    <span class="pull-right text-muted small">4 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-upload fa-fw"></i> Server Rebooted
                                    <span class="pull-right text-muted small">4 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a class="text-center" href="#">
                                <strong>See All Alerts</strong>
                                <i class="fa fa-angle-right"></i>
                            </a>
                        </li>
                    </ul>
                    <!-- /.dropdown-alerts -->
                </li>
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
                        </li>
                        <li><a href="UserSettings.jsp"><i class="fa fa-gear fa-fw"></i> Settings</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="../login.jsp"><i class="fa fa-sign-out fa-fw"></i> 注销用户</a>
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
                            <a href="ContractManager.jsp"><i class="fa fa-bar-chart-o fa-fw"></i> 查看合同</a>
                        </li>
                        <li>
                            <a href="../AllocateServlet?type=before"><i class="fa fa-table fa-fw"></i> 分配合同</a>
                        </li>
                        
                        <li>
                            <a><i class="fa fa-dashboard fa-fw"></i><b> --------系统管理-------</b></a>
                        </li>
                        <li class="active">
                            <a href="CustomerManage.jsp"><i class="fa fa-files-o fa-fw"></i> 客户管理</a>
                        </li>
                        <li class="active">
                            <a href="UserManage.jsp"><i class="fa fa-files-o fa-fw"></i> 用户管理&权限分配</a>
                        </li>
                        <li class="active">
                            <a href="RoleManage.jsp"><i class="fa fa-files-o fa-fw"></i> 角色管理</a>
                        </li>
                        
                        <li class="active">
                            <a href="LogManage.jsp"><i class="fa fa-files-o fa-fw"></i> 日志管理</a>
                        </li>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>

        <!-- Page Content -->
        <div id="page-wrapper" class="panel panel-default">
        <form method="post" action="../EditRoleServlet">
        	<input type="text" style="display:none" name="uproleid" value="<%=request.getParameter("paramid") %>" />
			<table class="update" style="width:700px;">
				<tr height="28">
					<td width="100">Role name:</td>
					<td><input type="text" name="newrolename" value="<%=request.getParameter("paramname") %>"/></td>
				</tr>
				<tr height="28">
					<td>Description：</td>
					<td>
						<textarea rows="4" cols="40" name="newroledesc" style="width:400px;height:100px;" ><%=request.getParameter("paramdesc") %></textarea>
					</td>
				</tr>
				<tr>
					<td>Configure permission:</td>	
					<td>
						<div>
							Contract Management:<br />
							<input name="QCHT" type="checkbox" value="001" />Draf Contract
							<input name="DGHT" type="checkbox" value="002" />Edit Contract
							<input name="CXHT" type="checkbox" value="003" />Query Contract
							<input name="SCHT" type="checkbox" value="004" />Delete Contract
							<br /><br />
							Process Management:<br />
							<input name="HQHT" type="checkbox" value="005" />Cuntersign
							<input name="SPHT" type="checkbox" value="006" />Approve
							<input name="QDHT" type="checkbox" value="007" />Sign
							<br />
							<input name="FPHQ" type="checkbox" value="008" />Assign countersign
							<input name="FPSP" type="checkbox" value="009" />Assign Approval
							<input name="FPQD" type="checkbox" value="010" />Assign Sign
							<br />
							<input name="LCCX" type="checkbox" value="011" />Query Process
							<br /><br />
							User Management:<br />
							<input name="XZYH" type="checkbox" value="012" />Add User
							<input name="BJYH" type="checkbox" value="013" />Edit User
							<input name="CXYH" type="checkbox" value="014" />Query User
							<input name="SCYH" type="checkbox" value="015" />Delete User
							<br /><br />
							Role Management:<br />
							<input name="XZJS" type="checkbox" value="016" />Add Role
							<input name="BJJS" type="checkbox" value="017" />Edit Role
							<input name="CXJS" type="checkbox" value="018" />Query Role
							<input name="SCJS" type="checkbox" value="019" />Delete Role
							<br /><br />
							Function Operation:<br />
							<input name="XZGN" type="checkbox" value="020" />Add Function
							<input name="BJGN" type="checkbox" value="021" />Edit Function
							<input name="CXGN" type="checkbox" value="022" />Query Function
							<input name="SCGN" type="checkbox" value="023" />Delete Function
							<br /><br />
							Authorize:<br />
							<input name="PZQX" type="checkbox" value="024" />Configure permission
							<br /><br />
							Customer Management:<br />
							<input name="XZKH" type="checkbox" value="025" />Add Customer
							<input name="BJKH" type="checkbox" value="026" />Edit Customer
							<input name="CXKH" type="checkbox" value="027" />Query Customer
							<input name="SCKH" type="checkbox" value="028" />Delete Customer
							<br /><br />
							System Log:<br />
							<input name="CXRZ" type="checkbox" value="029" />Query Log
							<input name="SCRZ" type="checkbox" value="030" />Delete Log
						</div>
					</td>
				</tr>

				<tr height="28">
					<td align="center" colspan="2">
						<input type="submit" value="Submit" class="btn btn-default"> &nbsp; &nbsp; &nbsp;
						<input type="reset" value="Reset" class="btn btn-default">
					</td>
				</tr>
			</table>
		</form>
                                
        </div>
                    
                <!-- /.col-lg-12 -->
            </div>
    <!-- jQuery -->
    <script src="../bower_components/jquery/dist/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="../bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="../bower_components/metisMenu/dist/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="../dist/js/sb-admin-2.js"></script>

</body>
</body>
</html>