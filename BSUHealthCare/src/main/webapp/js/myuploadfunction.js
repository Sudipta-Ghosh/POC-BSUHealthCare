$(function () {

    $('#fileupload').fileupload({

        dataType: 'json',

        done: function (e, data) {
        	$("tr:has(td)").remove();
            $.each(data.result, function (index, file) {


                $("#uploaded-files").append(
                		$('<tr/>')
                		.append($('<td/>').text(file.fileName))
                		.append($('<td/>').text(file.fileSize))
                		.append($('<td/>').text(file.fileType))
                		.append($('<td/>').html("<a href='upload?f="+index+"&event='GenerateFile''>Click</a>"))
                		.append($('<td/>').html("<a href='javascript:openWindowForReport("+index+")'>Report</a>"))

                		)//end $("#uploaded-files").append()
            });
        },

        progressall: function (e, data) {
	        var progress = parseInt(data.loaded / data.total * 100, 10);
	        $('#progress .bar').css(
	            'width',
	            progress + '%'
	        );
   		},

		dropZone: $('#dropzone')
    }).bind('fileuploadsubmit', function (e, data) {
        // The example input, doesn't have to be part of the upload form:
        var twitter = $('#twitter');
        data.formData = {twitter: twitter.val()};
    });

});

function openWindowForReport(vindex){
	alert(vindex);
	window.open("upload?f="+vindex+"&event=GenerateReport", "popupWindowName","dependent=yes, menubar=no, scrollbars=yes, resizable=1, toolbar=no,width800,height=600");
}