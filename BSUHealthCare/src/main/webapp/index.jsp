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

<body>




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
                        <h1>File Upload<br></h1>
                        <p>		
			<div style="width:700px;padding:20px;S">
			<input id="fileupload" type="file" name="files[]" data-url="upload" multiple>
			<div id="dropzone" class="fade well">Drop files here</div>
			<div id="progress" class="progress">
			<div class="bar" style="width: 0%;"></div>
			</div>
			<h5 style="text-align:center"><i style="color:#ccc"><small>Max File Size: 2 Mb - Display last 20 files</small></i></h5>

			<table id="uploaded-files" class="table">
				<tr>
					<th>File Name</th>
					<th>File Size</th>
					<th>File Type</th>
					<th>Download</th>
					<th>Report</th>
				</tr>
			</table>
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
