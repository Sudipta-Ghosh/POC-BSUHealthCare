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
<link href="css/form.css" type="text/css" rel="stylesheet" />
<script src="js/myuploadfunction.js"></script>

<!-- header style ignore it -->
<link href="css/mystyle.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">

<script language="javascript" type="text/javascript">
 function addRow(tableID) {
 		
 	 	
            var table = document.getElementById(tableID);
 
            var rowCount = table.rows.length;
            var row = table.insertRow(rowCount);
             
 
            var cell1 = row.insertCell(0);
            var element1 = document.createElement("input");
            element1.type = "checkbox";
            cell1.align = "center";
            element1.name="chkbox[]";
            cell1.appendChild(element1);
 		
            
            var cell2 = row.insertCell(1);
            var element2 = document.createElement("input");
	    element2.type = "text";
            cell2.align = 'center';
            cell2.className = 'form_field_txt1';
	    element2.name = "pSourceName";
            cell2.appendChild(element2);
 		
 
            var cell3 = row.insertCell(2);
            var element3 = document.createElement("input");
            element3.type = "text";
            element3.name = "pInputField";
            cell3.appendChild(element3);
 		
            
	    var cell4 = row.insertCell(3);
	    var element4 = document.createElement("input");
	    element4.type = "text";
	    element4.name = "pProbableName";
	    cell4.appendChild(element4);
 		
 
 
        }
 
        function deleteRow(tableID) {
        
            try {
            var table = document.getElementById(tableID);
            var rowCount = table.rows.length;
 
            for(var i=0; i<rowCount; i++) {
                var row = table.rows[i];
                var chkbox = row.cells[0].childNodes[0];
                if(null != chkbox && true == chkbox.checked) {
                    table.deleteRow(i);
                    rowCount--;
                    i--;
                }
 
 
            }
            }catch(e) {
                alert(e);
            }
        }
 function savePage(){
 document.forms[0].action="SaveDictionaryServlet";
 document.forms[0].submit();
 
 }
</script>

</head>

<body >




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
                         <form method="post" name="Form1" action="">
		                
			<table class="formtable" align="center" border=1 width="95%" cellspacing="1" cellpadding="0">
			<tr>
			<td class="formtable_cel">
			<table width="50%" align="center" border=0 cellspacing="1" cellpadding="0">
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<p></p>

			<tr>
			<td align="left"valign="middle"width="20%"nowrap class="mandatoryTextStyle"><%="Dictionary"%>
			</td>
			<td align="left"class="form_field_txt1"valign="top"width="35%"nowrap>
			<input type="text"class="fieldSCls" onmousedown="this.className='fieldSClsClick'" onblur="this.className='fieldSCls'" name="pAttributeGroupCode" size="30"maxlength="30" onBlur="this.value = trim(this.value.toUpperCase());" onKeyPress="makeUpper()" onChange="changeUpper(this)" style="text-transform:uppercase;" value="Patient Attribute" >
			</td>
			</tr>

			<tr>
			<td align="left"valign="middle"width="20%"nowrap class="mandatoryTextStyle">
			<%="Dictionary Location"%>
			</td>
			<td align="left"class="form_field_txt1"valign="top"width="35%"nowrap >
			<input type="text"class="fieldSCls" onmousedown="this.className='fieldSClsClick'" onblur="this.className='fieldSCls'" name="pAttributeGroupName" size="30"maxlength="30" onKeyPress="makeUpper()" onChange="changeUpper(this)" style="text-transform:uppercase;" value="" >
			</td>
			</tr>       
		                
			

		
			<table id="dataTable" cellspacing="1"cellpadding="0"align="center" border=0 width="100%">
			<tr class="table_head">
			<td nowrap></td>
			<td nowrap><%="Source Name"%></td>
			<td nowrap><%="Update String"%></td>			
			<td nowrap><%="Probable Name"%></td>
			</tr>	
			<p></p>			
			
			<table  align="center" border="0" width="100%">
			<div class="actionbtns">
			<div id="btn" class="btn_blue">
			<ul>
			
			<li><a href="#null" onclick="addRow('dataTable')"><span><%="Add Row"%></span></a></li>
			 <li><a href="#null" onclick="deleteRow('dataTable')"><span><%="Delete Row"%></span></a></li>			
			
			</ul>
			</div>
			</div>
			</table>

			
			</table>
			<table  align="center" border="0" width="100%">
			<div class="actionbtns">
			<div id="btn" class="btn_blue">
			<ul>

			<li><a href="#null" onclick="savePage()"><span><%="Save"%></span></a></li>		

			</ul>
			</div>
			</div>
			</table>
			</td></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			</table>
			</form>
		      
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
