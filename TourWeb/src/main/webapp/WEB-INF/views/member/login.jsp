<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<title> 로그인 | 투어리스트인투어 </title>
<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common.css">
<script src="${pageContext.request.contextPath}/resources/js/jquery-1.11.3.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/common.js"></script>  
<script src="${pageContext.request.contextPath}/resources/js/jquery.smooth-scroll.min.js"></script> 
<!--[if lte IE 9]>
    <script src="js/html5shiv.js"></script>
	<script src="js/placeholders.min.js"></script>
<![endif]-->
</head>

<body>
<ul class="skipnavi">
    <li><a href="#container">본문내용</a></li>
</ul>
<!-- wrap -->
<div id="wrap">

<jsp:include page="../inc/top.jsp" />
	
	<div id="container">
	
			<!-- location_area -->
		<div class="location_area member">
			<div class="box_inner">
				<h2 class="tit_page">TOURIST <span class="in">in</span> TOUR</h2>
				<p class="location">MEMBER <span class="path">/</span> 로그인</p>
				<ul class="page_menu clear">
					<li><a href="javascript:;" class="on">로그인</a></li>
				</ul>
			</div>
		</div>	
		<!-- //location_area -->
		
		
		<!-- bodytext_area -->
		<div class="bodytext_area box_inner">
					<!-- appForm -->
			<form action="${pageContext.request.contextPath}/member/loginPro" class="appForm" method="post" name="fr">
				<fieldset>
					<legend>로그인 입력 양식</legend>
					<p class="info_pilsoo pilsoo_item">필수입력</p>
					<ul class="app_list">
						<li class="clear">
							<label for="id_lbl" class="tit_lbl pilsoo_item">아이디</label>
							<div class="app_content"><input type="text" name="id" class="w100p" id="id_lbl" placeholder="아이디 입력해주세요"/></div>
						</li>
						<li class="clear">
							<label for="pwd_lbl" class="tit_lbl pilsoo_item">비밀번호</label>
							<div class="app_content"><input type="password" name="pass" class="w100p" id="pwd_lbl" placeholder="비밀번호를 입력해주세요"/></div>
						</li>
						
					</ul>
					<p class="btn_line"><a href="javascript:document.fr.submit();" class="btn_baseColor">로그인</a></p>	
				</fieldset>
			</form>
			<!-- //appForm -->

		</div>
		<!-- //bodytext_area -->

	</div>
	<!-- //container -->

<jsp:include page="../inc/bottom.jsp" />

</div>
<!-- //wrap -->

<jsp:include page="../inc/popup.jsp" />

</body>
</html>
    