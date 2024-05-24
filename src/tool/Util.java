package tool;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import bean.Teacher;
import dao.ClassNumDao;

public class Util {

	public Teacher getUser(HttpServletRequest req) throws Exception {
		HttpSession session = req.getSession();
		Teacher teacher = (Teacher)session.getAttribute("user");
		return teacher;
	}

	public void setClassNumSet(HttpServletRequest req) throws Exception {
		Teacher teacher = getUser(req);
		ClassNumDao cNumDao = new ClassNumDao();

		// ログインユーザーの学校コードをもとにクラス番号の一覧を取得
		List<String> classNumSet = cNumDao.filter(teacher.getSchool());
		// レスポンス値をセット
		req.setAttribute("class_num_set", classNumSet);
	}

	public void setEntYearSet(HttpServletRequest req) throws Exception {
		LocalDate todaysDate = LocalDate.now();
		int year = todaysDate.getYear();
		// リストを初期化
		List<Integer> entYearSet = new ArrayList<>();
		// 10年前から１年後までの年をリストに追加
		for (int i = year - 10; i < year + 1; i++) {
			entYearSet.add(i);
		}

		// レスポンス値をセット
		req.setAttribute("ent_year_set", entYearSet);
	}

//	public void setSubjects(HttpServletRequest req) throws Exception {
//		Teacher teacher = getUser(req);
//		School school = teacher.getSchool();
//		SubjectDao subjectDao = new SubjectDao();
//		List<Subject> subjectSet = subject.filter(school);
//
//		req.setAttribute("subject_set", subjectSet);
//	}

	public void setNumSet(HttpServletRequest req) {

	}
}