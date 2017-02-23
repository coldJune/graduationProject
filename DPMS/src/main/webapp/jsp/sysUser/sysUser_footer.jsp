<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../css/font-awesome.min.css" rel="stylesheet">
<link href="../css/templatemo-style-show.css" rel="stylesheet">

<title>Insert title here</title>
</head>
<body>
<div class="pagination-wrap">
 <ul class="pagination">
	<li><a href="findAll?currentPage=1">首页</a></li>
	<c:choose>
		<c:when test="${page.currentPage>5}">
			<li><a href="findAll?currentPage=${page.currentPage-5 }">&lt;&lt;</a></li>
		</c:when>
		<c:otherwise>
			<li><a href="findAll?currentPage=1">&lt;&lt;</a></li>
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${page.currentPage>1}">
			<li><a href="findAll?currentPage=${page.currentPage-1 }">&lt;</a></li>
		</c:when>
		<c:otherwise>
			<li><a href="javascript:alert('已经是第一页')">&lt;</a></li>
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${page.totalPage<=5}">
			<c:forEach var="x" begin="1" end="${page.totalPage }">
				<c:choose>
					<c:when test="${x==page.currentPage}">
						<li><a href="findAll?currentPage=${x}" id="c1" class="active">${x}</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="findAll?currentPage=${x}">${x}</a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</c:when>
		<c:when test="${page.currentPage<4}">
			<c:forEach var="x" begin="1" end="${page.totalPage }">
				<c:choose>
					<c:when test="${x==page.currentPage}">
						<li><a href="findAll?currentPage=${x}" id="c1" class="active">${x}</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="findAll?currentPage=${x}">${x}</a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</c:when>
		<c:when test="${page.currentPage+1>=page.totalPage}">
			<c:forEach var="x" begin="${page.totalPage-4}" end="${page.totalPage}">
				<c:choose>
					<c:when test="${x==page.currentPage}">
						<li><a href="findAll?currentPage=${x}" id="c1" class="active">${x}</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="findAll?currentPage=${x}">${x}</a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<c:forEach var="x" begin="${page.currentPage-2}" end="${page.currentPage+2}">
				<c:choose>
					<c:when test="${x==page.currentPage}">
						<li><a href="findAll?currentPage=${x}" id="c1">${x}</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="findAll?currentPage=${x}">${x}</a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</c:otherwise>
	</c:choose>	
	<c:choose>
		<c:when test="${page.currentPage<page.totalPage}">
			<li><a href="findAll?currentPage=${page.currentPage+1 }">&gt;</a></li>
		</c:when>
		<c:otherwise>
			<li><a href="javascript:alert('已经是最末页')">&gt;</a></li>
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${page.totalPage<=5}">
			<li><a href="findAll?currentPage=${page.totalPage }">&gt;&gt;</a></li>
		</c:when>
		<c:when test="${page.currentPage<=5}">
			<li><a href="findAll?currentPage=${page.currentPage+5 }">&gt;&gt;</a></li>
		</c:when>
		<c:otherwise>
			<li><a href="findAll?currentPage=${page.totalPage}">&gt;&gt;</a></li>
		</c:otherwise>
	</c:choose>
	<li><a href="findAll?currentPage=${page.totalPage}">末页</a></li>
	</ul>
	</div>
</body>
</html>