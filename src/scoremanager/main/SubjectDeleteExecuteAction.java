package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.School;
import bean.Subject;
import bean.Teacher;
import dao.SubjectDao;
import tool.Action;
public class SubjectDeleteExecuteAction extends Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		HttpSession session = request.getSession();//セッション
		//Teacher teacher = (Teacher)session.getAttribute("user");
		School school = new School();
		school.setCd("oom");//学校コードをセットする
    	school.setName("大宮校");//学校名をセットする
//
//
		Teacher teacher = new Teacher();
		teacher.setId("admin");
		teacher.setName("大宮花子");
		teacher.setPassword("password");
		teacher.setSchool(school);


		String cd=request.getParameter("cd");

		Subject p=new Subject();
//		System.out.println("★ cd" + cd);

		p.setCd(cd);



		SubjectDao dao=new SubjectDao();
		dao.delete(p);


		request.getRequestDispatcher("subject_delete_done.jsp").forward(request, response);
	}

}