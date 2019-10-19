<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/taglib/taglibs.jsp"%>
<section class="menu cid-rbmbAelA8q" once="menu" id="menu1-0">
    <nav class="navbar navbar-dropdown navbar-fixed-top navbar-expand-lg">
        <div class="navbar-brand">
        	<span class="navbar-caption-wrap">
            	<a class="navbar-caption text-white display-4" href="/home">Home</a>
        	</span>
        </div>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <div class="hamburger">
                <span>1</span>
                <span>2</span>
                <span>3</span>
                <span>4</span>
            </div>
        </button>
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav nav-dropdown" data-app-modern-menu="true">
            	 <li class="nav-item">
                    <a class="nav-link link text-white display-4" href="/secure/upload" >Upload</a>
                </li>
            	<li class="nav-item">
                    <a class="nav-link link text-white display-4" href="/secure/notification" >Notifications</a>
                </li>
             </ul>
          <c:choose>   
            <c:when test="${user!=null}">
            	<div class="navbar-buttons mbr-section-btn"><a class="btn btn-sm btn-white display-4" href="/secure/profile" >${user.name}</a></div>	
			    <a class="nav-link link text-white display-4" href="/logout" title="Logout"><img src="/assets/images/logout.png"></a>
			</c:when>
			<c:otherwise>
				<div class="navbar-buttons mbr-section-btn"><a class="btn btn-sm btn-white display-4" href="/login" >Login</a></div>	
			</c:otherwise>
		  </c:choose>
      </div>
    </nav>
</section>