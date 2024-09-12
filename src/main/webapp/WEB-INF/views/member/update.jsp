<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<title> MYPAGE | 투어리스트인투어 </title>
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

	<jsp:include page="../inc/top.jsp"/>
	
	<div id="container">
		<!-- location_area -->
		<div class="location_area member">
			<div class="box_inner">
				<h2 class="tit_page">TOURIST <span class="in">in</span> TOUR</h2>
				<p class="location">MYPAGE <span class="path">/</span> 개인 정보 수정</p>
				<ul class="page_menu clear">
					<li><a href="#" class="on">개인 정보 수정</a></li>
				</ul>
			</div>
		</div>	
		<!-- //location_area -->

		<!-- bodytext_area -->
		<div class="bodytext_area box_inner">
			<!-- myinfo -->
			<dl class="myinfo">
				<dt>내 정보</dt>
				<dd>
					<!-- appForm -->
					<form action="${pageContext.request.contextPath}/member/updatePro" class="regForm" method="post" name="fr">
						<fieldset>
							<legend>내정보 입력 양식</legend>
							<ul class="reg_list">
								<li class="clear">
									<span class="tit_lbl">아이디</span>
									<div class="reg_content">
									<input type="text" name="id" value="${memberDTO.id }" readonly></div>
								</li>
								<li class="clear">
									<span class="tit_lbl">비밀번호</span>
									<div class="reg_content">
									<input type="password" name="pass"></div>
								</li>
								<li class="clear">
									<span class="tit_lbl">이름</span>
									<div class="reg_content">
									<input type="text" name="name" value="${memberDTO.name }" ></div>
								</li>
								<li class="clear">
									<span class="tit_lbl">핸드폰</span>
									<div class="reg_content">
									<input type="text" name="phone" value="${memberDTO.phone }" ></div>
								</li>
								<li class="clear">
									<span class="tit_lbl">이메일</span>
									<div class="reg_content">
									<input type="text" name="email" value="${memberDTO.email }" ></div>
								</li>	
								
<!-- 								<li class="clear"> -->
<!-- 									<label class="tit_lbl">생년월일</label> -->
<!-- 									<div class="reg_content">19910327</div> -->
<!-- 								</li> -->
								<li class="clear">
									<span class="tit_lbl">성별</span>
									<div class="reg_content radio_area">
									<c:if test="${memberDTO.gender eq '남' }">
										<input type="radio" class="css-radio" id="mmm_lbl" name="gender" value="남" checked><label for="mmm_lbl">남</label>
										<input type="radio" class="css-radio" id="www_lbl" name="gender" value="여"><label for="www_lbl">여</label>
									</c:if>
										
									<c:if test="${memberDTO.gender eq '여' }">
										<input type="radio" class="css-radio" id="mmm_lbl" name="gender" value="여" checked><label for="www_lbl">여</label>
										<input type="radio" class="css-radio" id="www_lbl" name="gender" value="남"><label for="mmm_lbl">남</label>
									</c:if>
									</div>
								</li>
<!-- 								<li class="clear"> -->
<!-- 									<span class="tit_lbl">주소</span> -->
<!-- 									<div class="reg_content">서울시 종로구 인사동 111-35 오리엔트파빌리온 1024호</div> -->
<!-- 								</li> -->
								<li class="clear">
									<span class="tit_lbl">개인정보 활용동의</span>
									<div class="reg_content radio_area">
									<c:if test="${memberDTO.agree eq 'agree' }">
										<input type="radio" class="css-radio" id="smsyes_lbl" name="agree" value="agree" checked><label for="smsyes_lbl">동의</label>
										<input type="radio" class="css-radio" id="smsno_lbl" name="agree" value="disagree"><label for="smsno_lbl">동의안함</label>
									</c:if>
									
									<c:if test="${memberDTO.agree eq 'disagree' }">
										<input type="radio" class="css-radio" id="smsyes_lbl" name="agree" value="disagree" checked><label for="smsno_lbl">동의안함</label>
										<input type="radio" class="css-radio" id="smsno_lbl" name="agree" value="agree"><label for="smsyes_lbl">동의</label>
									</c:if>	
										<p class="info_line">(고객님의 편의를 위해 알림, 공지사항, 이벤트 등의 내용을 제공하고자 합니다.)</p>
									</div>
								</li>
<!-- 								<li class="clear"> -->
<!-- 									<span class="tit_lbl">이메일 수신동의</span> -->
<!-- 									<div class="reg_content radio_area"> -->
<!-- 										<input type="radio" class="css-radio" id="emailyes_lbl" name="emailyesno" checked><label for="emailyes_lbl">허용</label> -->
<!-- 										<input type="radio" class="css-radio" id="emailno_lbl" name="emailyesno"><label for="emailno_lbl">거부</label> -->
<!-- 										<p class="info_line">(고객님의 편의를 위해 알림, 공지사항, 이벤트 등의 내용을 제공하고자 합니다.)</p> -->
<!-- 									</div> -->
<!-- 								</li> -->
							</ul>
							<p class="btn_line"><a href="javascript:document.fr.submit();" class="btn_baseColor">회원정보수정</a></p>	
						</fieldset>
					</form>
					<!-- //appForm -->
				</dd>
			</dl>
			<!-- //myinfo -->			
			
		</div>
		<!-- //bodytext_area -->

	</div>
	<!-- //container -->

	<jsp:include page="../inc/bottom.jsp"/>

</div>
<!-- //wrap -->

<jsp:include page="../inc/bottom.jsp"/>
</div>

</body>
</html>
