package scoremanager.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.School;
import bean.Subject;
import bean.Teacher;
import dao.ClassNumDao;
import dao.SubjectDao;
import tool.Action;

public class SubjectUpdateExecuteAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		//ローカル変数の宣言 1

		School school = new School();
		school.setCd("oom");
		school.setName("学校名");

		Teacher teacher = new Teacher();
		teacher.setId("admin");
		teacher.setName("大原花子");
		teacher.setPassword("password");
		teacher.setSchool(school);

		//HttpSession session = req.getSession();//セッション
		SubjectDao sDao = new SubjectDao();//学生Dao
		String cd = "";//科目コード
		String name = "";//科目名
		Subject subject = null;//科目
		List<Subject> subjects = null;// 学生リスト
		Map<String, String> errors = new HashMap<>();// エラーメッセージ
		ClassNumDao cNumDao = new ClassNumDao();// クラス番号Daoを初期化
		//Teacher teacher = (Teacher) session.getAttribute("user");// ログインユーザーを取得

		//リクエストパラメータ―の取得 2
		cd = req.getParameter("cd");//学生番号
		name = req.getParameter("name");

		subject = new Subject();
		subject.setCd(cd);
		subject.setName(name);
		subject.setSchool(school);
		//student.setSchool(((Teacher)session.getAttribute("user")).getSchool());
		sDao.save(subject);


		req.getRequestDispatcher("subject_update_done.jsp").forward(req, res);
	}
}