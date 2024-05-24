<%-- 学生登録JSP --%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/common/base.jsp">
	<c:param name="title">
		得点管理システム
	</c:param>

	<c:param name="scripts"></c:param>

	<c:param name="content">
		<section class="me-4">
			<h2 class="h3 mb-3 fw-norma bg-secondary bg-opacity-10 px-2 px-4">科目情報登録</h2>
			<form action="SubjectCreateExecute.action" method="post">
				<label>科目コード</label>
				<input type="text" name="cd" value="${cd}" maxlength="3" required placeholder="科目コードを入力してください">
				<label>科目名</label>
				<input type="text" name="name" value="${name}" maxlength="20" required placeholder="科目名を入力してください">
				<button type="submit" name="end">登録</button>
			</form>
			<a href="SubjectList.action">戻る</a>
		</section>
	</c:param>
</c:import>