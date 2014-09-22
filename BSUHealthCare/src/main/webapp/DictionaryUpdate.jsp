<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>jQuery File Upload Example</title>
<script src="js/jquery.1.9.1.min.js"></script>
<link href="css/DictionaryUpdate.css" rel="stylesheet">

<script src="js/vendor/jquery.ui.widget.js"></script>
<script src="js/jquery.iframe-transport.js"></script>
<script src="js/jquery.fileupload.js"></script>

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="css/simple-sidebar.css" rel="stylesheet">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->

<!-- bootstrap just to have good looking page -->
<script src="bootstrap/js/bootstrap.min.js"></script>
<link href="bootstrap/css/bootstrap.css" type="text/css" rel="stylesheet" />

<!-- we code these -->
<link href="css/dropzone.css" type="text/css" rel="stylesheet" />
<script src="js/myuploadfunction.js"></script>

<!-- header style ignore it -->
<link href="css/mystyle.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">

</head>

<body onload="javascript:alert("<%=request.getAttribute("pSubmitStatus")%>")">




 <div id="wrapper">

        <!-- Sidebar -->
        <div id="sidebar-wrapper">
            <ul class="sidebar-nav">
                <li class="sidebar-brand">
                    <a href="#">
			BSU Health Care
                    </a>
                </li>
                <li>
                    <a href="index.jsp">File Upload</a>
                </li>
                <li>
                    <a href="DictionaryUpdate.jsp">Dictionary Update</a>
                </li>
               
            </ul>
        </div>
        <!-- /#sidebar-wrapper -->

        <!-- Page Content -->
        <div id="page-content-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">                        
                        <a href="#menu-toggle" class="btn btn-default" id="menu-toggle">Toggle Menu</a>                        
                        <p>
		                        <div id="form-main">
		  <div id="form-div">
		    <form class="form" id="form1" action="SaveDictionaryServlet">
		      
		      <p class="Source Name">
		     	<input name="Source Name" type="text" class="feedback-input" placeholder="Source Name" id="Source Name" />
		      </p>
		      
		       <p class="Probable Name">
		      	  <input name="Probable Name" type="text" class="feedback-input" placeholder="Probable Name" id="Probable Name" />
		      </p>
		      
		      
		      
		      
		   
		      
		      <div class="submit">
		        <input type="submit" value="Save" id="button-blue"/>
		        <div class="ease"></div>
		      </div>
		    </form>
		  </div>
                        </p>
                    </div>
                </div>
            </div>
        </div>
        <!-- /#page-content-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery Version 1.11.0 -->
    <script src="js/jquery-1.11.0.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

    <!-- Menu Toggle Script -->
    <script>
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
    });
    </script>

</body> 
</html>
