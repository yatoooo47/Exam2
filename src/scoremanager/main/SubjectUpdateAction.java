package scoremanager.main;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.School;
import bean.Teacher;
import dao.SubjectDao;
import tool.Action;

public class SubjectUpdateAction extends Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession(); // セッション
        //Teacher teacher = (Teacher)session.getAttribute("user");

        // 学校情報を作成
        School school = new School();
        school.setCd("oom"); // 学校コードをセット
        school.setName("学校名"); // 学校名をセット

        // 教師情報を作成
        Teacher teacher = new Teacher();
        teacher.setId("admin");
        teacher.setName("大原花子");
        teacher.setPassword("password");
        teacher.setSchool(school);

        // エラーメッセージのマップ
        Map<String, String> errors = new HashMap<>();

        // リクエストから科目コードを取得
        String cd = request.getParameter("cd");

        // 科目DAOを作成し、指定された科目コードに対応する科目名を取得
        SubjectDao dao = new SubjectDao();
        String name = dao.get(cd, teacher.getSchool()).getName();

        // リクエストに科目コードと科目名をセット
        request.setAttribute("cd", cd);
        request.setAttribute("name", name);

        // JSPへフォワード
        request.getRequestDispatcher("subject_update.jsp").forward(request, response);
    }

}