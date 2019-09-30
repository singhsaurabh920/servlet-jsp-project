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
  <link rel="stylesheet" href="/assets/bootstrap/css/bootstrap.min.css">
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
<section class="form1 cid-rbmkSiAkp2">
	<div class="container" style="max-width:1300px">
		<div class="row" id="picture-list">
			<div class="col-md-12"> 
			    <span class="form-success">${successFileName}</span>
				<h2 class="mbr-fonts-style mb-3 display-2 content-panel">Upload Event Picture </h2>
				<form action="/secure/upload" method="post" enctype="multipart/form-data">
				    <div class="row input-main">
				    	<div class="col-md-12 col-lg-12 input-wrap" data-for="fileName">
							<input type="file" class="field display-7" name="fileName" size = "1" required>
							<span class="form-error">${errorFileName}</span>
						</div>
					</div>
					<div class="row input-main">
						<div class="col-md-12 col-lg-12 btn-row">
							<span class="input-group-btn">
								<button type="submit" class="btn btn-form btn-primary display-4">Upload</button>
							</span>
						</div>
					</div>
				</form>
			</div>	
		</div>
	</div>
</section>
<jsp:include page="/footer.jsp"></jsp:include> 
  <script src="/assets/web/assets/jquery/jquery.min.js"></script>
  <script src="/assets/popper/popper.min.js"></script>
  <script src="/assets/tether/tether.min.js"></script>
  <script src="/assets/bootstrap/js/bootstrap.min.js"></script>
  <script src="/assets/smoothscroll/smooth-scroll.js"></script>
  <script src="/assets/dropdown/js/script.min.js"></script>
  <script src="/assets/touch-swipe/jquery.touch-swipe.min.js"></script>
  <script src="/assets/theme/js/script.js"></script>
  <script src="/assets/formoid/formoid.min.js"></script>
  <script>
  $.ajax({
	  url:"/ajax/upload",
	  type:"POST",
	  error:function(xhr){ 
	  },
	  complete: function(xhr, textStatus) {
	     console.log(xhr.status);
	  },
	  success:function(data){
	     $.each(data,function(i,j){
	    	 var str='<div class="col-md-12">' 
			 +'<div class="mbr-fonts-style mb-3 display-2 content-panel" style="background: cyan;">'
			 +j 
			 +'<a style="float:right;" href="/secure/download?fileName='+j+'"><small>Download</small></a>'
			 +'</div></div>';
	    	 $("#picture-list").append(str);
	     })
	  }
  })
  </script>
</body>
</html>