<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html lang="ko">
<head>
<title> 공지사항 | 고객센터 | 투어리스트인투어 </title>
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
		<div class="location_area customer">
			<div class="box_inner">
				<h2 class="tit_page">TOURIST <span class="in">in</span> TOUR</h2>
				<p class="location">고객센터 <span class="path">/</span> 공지사항</p>
				<ul class="page_menu clear">
					<li><a href="#" class="on">공지사항</a></li>
					<li><a href="#">문의하기</a></li>
				</ul>
			</div>
		</div>	
		<!-- //location_area -->

		<!-- bodytext_area -->
		<div class="bodytext_area box_inner">
			<form action="${pageContext.request.contextPath}/board/list" name="fr" class="minisrch_form">
				<fieldset>
					<legend>검색</legend>
					<input type="text" class="tbox" name="search" title="검색어를 입력해주세요" placeholder="검색어를 입력해주세요">
					<a href="javascript:document.fr.submit();" class="btn_srch">검색</a>
					
					<c:if test="${ ! empty sessionScope.id }">
						<a href="${pageContext.request.contextPath}/board/write" class="btn_srch">글쓰기</a>
					</c:if>
					
				</fieldset>
			</form>
			<table class="bbsListTbl" summary="번호,제목,조회수,작성일 등을 제공하는 표">
				<caption class="hdd">공지사항  목록</caption>
				<thead>
					<tr>
						<th scope="col">번호</th>
						<th scope="col">제목</th>
						<th scope="col">조회수</th>
						<th scope="col">작성일</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="boardDTO" items="${boardList }">
					<tr>
						<td>${boardDTO.num }</td>
						<td class="tit_notice"><a href="javascript:;">${boardDTO.subject }</a> </td>
						<td>${boardDTO.readcount }</td>
						<td><fmt:formatDate value="${boardDTO.date}" pattern="yyyy-MM-dd"/>  </td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			<!-- pagination -->
			<div class="pagination">
				<a href="${pageContext.request.contextPath}/board/list?pageNum=1&search=${pageDTO.search}" class="firstpage  pbtn"><img src="${pageContext.request.contextPath}/resources/img/btn_firstpage.png" alt="첫 페이지로 이동"></a>
<!-- 				처음 페이지 아닌 경우 => 이전 버튼 보이기 -->
				<c:if test="${pageDTO.currentPage ne 1}">
					<a href="${pageContext.request.contextPath}/board/list?pageNum=${pageDTO.currentPage-1}&search=${pageDTO.search}" class="prevpage  pbtn"><img src="${pageContext.request.contextPath}/resources/img/btn_prevpage.png" alt="이전 페이지로 이동"></a>
				</c:if>
				
				<c:forEach var="i" begin="${pageDTO.startPage}" end="${pageDTO.endPage}" step="1">
					<c:if test="${pageDTO.currentPage eq i}">
						<a href="${pageContext.request.contextPath}/board/list?pageNum=${i}&search=${pageDTO.search}"><span class="pagenum currentpage">${i}</span></a>
					</c:if>
					<c:if test="${pageDTO.currentPage ne i}">
						<a href="${pageContext.request.contextPath}/board/list?pageNum=${i}&search=${pageDTO.search}"><span class="pagenum">${i}</span></a>
					</c:if>
				</c:forEach>
<!-- 				마지막 페이지 아닌 경우 => 다음 버튼 보이기 -->
				<c:if test="${pageDTO.currentPage ne pageDTO.pageCount}">
					<a href="${pageContext.request.contextPath}/board/list?pageNum=${pageDTO.currentPage+1}&search=${pageDTO.search}" class="nextpage  pbtn"><img src="${pageContext.request.contextPath}/resources/img/btn_nextpage.png" alt="다음 페이지로 이동"></a>
				</c:if>
				
				<a href="${pageContext.request.contextPath}/board/list?pageNum=${pageDTO.pageCount}&search=${pageDTO.search}" class="lastpage  pbtn"><img src="${pageContext.request.contextPath}/resources/img/btn_lastpage.png" alt="마지막 페이지로 이동"></a>
			</div>
			<!-- //pagination -->
			
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
    