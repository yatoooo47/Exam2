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
			<h2 class="h3 mb-3 fw-norma bg-secondary bg-opacity-10 py-2 px-4">科目情報変更</h2>

			<form action ="SubjectUpdateExecute.action">
				<div class="row border mx-3 mb-3 py-2 align-items-center rounded" id="filter">


					<p></p>
					<div class="col-4">
					<label></label>科目コード
					<input value="${cd}" size="84 " name="cd" readonly />
					<div class="mt-2 text-warning">${errors.get("cd")}</div>

					</div>

					<p></p>
					<div class="col-4">
					科目名
					<input type="text" size="84" name="name" value="${name}"  maxlength="20" required >
					</div>
					<p></p>


					<p></p>



					<div class="mt-2 text-warning">${errors.get("f1")}</div>
				</div>
				<input type="submit" value="変更">
				<p></p>
				<a href="SubjectList.action">戻る</a>
			</form>

	</section>
</c:param>
</c:import>
