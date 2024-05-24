
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/common/base.jsp">
	<c:param name="title">
		得点管理システム
	</c:param>

	<c:param name="scripts"></c:param>

	<c:param name="content">
		<section class="me-4">
			<h2 class="h3 mb-3 fw-norma bg-secondary bg-opacity-10 py-2 px-4">科目情報削除</h2>

			<form action ="SubjectDeleteExecute.action" method="post">

					<p></p>
					「${name}(${cd})」を削除してもよろしいですか
					<p></p>

					<div class="mt-2 text-warning">${errors.get("f1")}</div>
					<input type="hidden" id="cd" name="cd" value="${cd}" />


				<input type="submit" value="削除"style="background-color:red; border-color:red; color:white">
				<p></p>
				<a href="SubjectList.action">戻る</a>
			</form>

	</section>
</c:param>
</c:import>