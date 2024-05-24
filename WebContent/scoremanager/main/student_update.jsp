<%-- 学生変更JSP --%>
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
			<h2 class="h3 mb-3 fw-norma bg-secondary bg-opacity-10 py-2 px-4">学生情報変更</h2>
			<form action="StudentUpdateExecute.action" method="post">
				<div class="row border mx-3 mb-3 py-2 align-items-center rounded" id="filter">
					<div class="col-4">
						<label class="form-label" for="student-f1-select">入学年度</label>
						<input type="text" name="ent_year" value="${ent_year}" readonly>
					</div>
					<div class="col-4">
						<label class="form-label" for="student-f1-select">学生番号</label>
						<input type="text" name="no" value="${no}" readonly>
					</div>
					<div>
						<label>氏名</label>
						<input type="text" name="name" value="${name}" maxlength="30" required>
					</div>
					<div class="col-4">
						<label class="form-label" for="student-f2-select">クラス</label>
						<select class="form-select" name="class_num" name="f2">
							<option value="0">--------</option>
							<c:forEach var="num" items="${class_num_set}">
								<%-- 現在のnumと選択されていたf2が一致していた場合selectedを追記 --%>
								<option value="${num}" <c:if test="${num==f2}">selected</c:if>>${num}</option>
							</c:forEach>
						</select>
					</div>
					<div class="col-2 form-check text-center">
						<label class="form-check-laberl" for="student-f3-check">在学中
						<%-- パラメーターf3が存在している場合checkedを追記 --%>
							<input class="form-check-input" type="checkbox"
							id="student-f3-check" name="is_attend"
							<c:if test="${student.is_attend==on}">checked</c:if> />
						</label>
					</div>
					<div class="col-2 text-center">
						<button class="btn btn-secondary" id="filter-button">変更</button>
					</div>
					</div>
				</form>
			<a href="StudentList.action">戻る</a>
			<div class="mt-2 text-warning">${erros.get("f1")}</div>
		</section>
	</c:param>
</c:import>