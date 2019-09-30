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
<section class="testimonials2 cid-rbmiuAiwEp" id="testimonials2-d">
    <div class="container">
        <div class="row justify-content-center pt-2">
            <div class="card col-12 col-md-3"></div>
             <div class="card col-12 col-md-6" id="user-profile"></div>
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
	  url:"/ajax/profile",
	  type:"POST",
	  error:function(xhr){ 
	  },
	  complete: function(xhr, textStatus) {
	     console.log(xhr.status);
	  },
	  success:function(data){
	      var str='<div class="card-box">'
          +'<div class="card-header">'
          +'<div class="card-img">'
          +'<img src="/assets/images/face1.jpg" alt="Mobirise">'
          +'</div>'
          +'<h4 class="card-title mbr-fonts-style align-center mb-0 mbr-white display-5">'+ data.name +'</h4>'
          +'</div>'
          +'<p class="mbr-text card-text mbr-fonts-style align-left m-0 display-7">'
          +'Phone : '+ data.phone
          +'</p>'
          +'<p class="mbr-text card-text mbr-fonts-style align-left m-0 display-7">'
          +'Email : '+ data.email
          +'</p>'
          +'<p class="mbr-text card-text mbr-fonts-style align-left m-0 display-7">'
          +'Address: '+ data.address
          +'</p>'
          +'</div>'
          +'<div class=""><a href="/secure/profile/download">Download</a>  </div>';
          $("#user-profile").html(str);
	  }
  })
  </script>
</body>
</html>