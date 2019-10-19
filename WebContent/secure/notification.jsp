<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="generator" content="Mobirise v4.8.8, mobirisethemes.com">
  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1">
  <link rel="shortcut icon" href="/assets/images/logo2.png" type="image/x-icon">
  <meta name="description" content="">
  <title>Profile</title>
  <link rel="stylesheet" href="/assets/web/assets/mobirise-icons/mobirise-icons.css">
  <link rel="stylesheet" href="/assets/tether/tether.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.css">
  <link rel="stylesheet" href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css">
  <link rel="stylesheet" href="/assets/bootstrap/css/bootstrap-grid.min.css">
  <link rel="stylesheet" href="/assets/bootstrap/css/bootstrap-reboot.min.css">
  <link rel="stylesheet" href="/assets/socicon/css/styles.css">
  <link rel="stylesheet" href="/assets/dropdown/css/style.css">
  <link rel="stylesheet" href="/assets/theme/css/style.css">
  <link rel="stylesheet" href="/assets/mobirise/css/mbr-additional.css" type="text/css">
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>  
<jsp:include page="/intro.jsp"></jsp:include>  
<section class="testimonials2 cid-rbmiuAiwEp" id="testimonials2-d">
    <div class="container" style="background: #a72c3d; padding: 10px;color: white;">
        <table id="notification-table" class="table table-striped table-bordered" style="width:100%">
        	<thead>
            	<tr>
                	<th>Name</th>
                	<th>Date</th>
                	<th>Activity</th>
                	<th>Action</th>
           		</tr>
        	</thead>
        	<tbody>
        	</tbody>
    	</table>
    </div>
</section>
<jsp:include page="/footer.jsp"></jsp:include> 
  <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
  <script src="/assets/popper/popper.min.js"></script>
  <script src="/assets/tether/tether.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
  <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
  <script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js"></script>
  <script src="/assets/smoothscroll/smooth-scroll.js"></script>
  <script src="/assets/dropdown/js/script.min.js"></script>
  <script src="/assets/touch-swipe/jquery.touch-swipe.min.js"></script>
  <script src="/assets/theme/js/script.js"></script>
  <script src="/assets/formoid/formoid.min.js"></script>
  <script>
  	$(document).ready(function() {
	   var table = $('#notification-table').DataTable({
	    	"data":[],
	    	"columns": [
	            {
	            	"title":"Name",
	            	"data": "name" 
	            },
	            { 
	            	"title":"Date",
	            	"data": "date"
	            },
	            {
	            	"title":"Notification",
	            	"data": "msg"
	            },
	            { 	"title":"Action",
	            	"class": "delete-row",
	              	"mRender":function(){
	              		return "<a>Delete</a>";
	            	} 
	            },
	        ]
	    });
	   
	    $("#notification-table tbody").on('click',".delete-row",function(){
	    	table.row($(this).closest("tr")).remove().draw();
	    });
	    
		var source = new EventSource("http://localhost:8080/sse/notification");
	  	source.addEventListener('message', function(e) {
	  		table.row.add(JSON.parse(e.data)).draw();
	  	}, false);

	  	source.addEventListener('open', function(e) {
	  		console.log(e);
	  	}, false);

	  	source.addEventListener('error', function(e) {
	  	  console.log(e);
	  	  if (e.readyState == EventSource.CLOSED) {
	  		   
	  	  }
	  	  source.close();
	  	}, false);
	});
 
  
  </script>
</body>
</html>