package scoremanager.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.School;
import bean.Subject;
import bean.Teacher;
import dao.SubjectDao;
import tool.Action;

public class SubjectListAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		//HttpSession session = req.getSession();  // セッション
		//Util util = (Util)session.getAttribute("user");

		School school = new School();
		school.setCd("oom"); //学校コードをセットする
		school.setName("大宮校"); //学校名をセットする

		Teacher teacher = new Teacher();
		teacher.setId("admin"); //講師IDをセット
		teacher.setName("大宮花子"); //講師名をセット
		teacher.setPassword("password"); //ログインパスワードをセット
		teacher.setSchool(school); //学校オブジェクトをセット

		String Cd = "";  // 入力された入学年度
		String Name = "";  // 入力されたクラス番号
		List<Subject> subjects = null;  // 学生リスト
		SubjectDao sDao = new SubjectDao();  // 学生Dao
		Map<String, String> errors = new HashMap<>();  // エラーメッセージ

		// DBからデータ取得
		//↓？？？
		//全学年情報を取得
		subjects = sDao.filter(school);

		// レスポンス値をセット

		// リクエストに学生リストをセット
		req.setAttribute("subjects", subjects);
		// リクエストにデータをセット

		// JSPへフォワード
		req.getRequestDispatcher("subject_list.jsp").forward(req, res);
	}

}
