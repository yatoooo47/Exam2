package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Student;
import bean.Teacher;
import dao.StudentDao;
import tool.Action;
public class StudentUpdateExecuteAction extends Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		HttpSession session = request.getSession();//セッション
		Teacher teacher = (Teacher)session.getAttribute("teacher");


		Integer entyear=Integer.parseInt(request.getParameter("ent_year"));
		String no=request.getParameter("no");
		String name=request.getParameter("name");
		String classnum=request.getParameter("class_num");
		String isattend = request.getParameter("is_attend");



		Student p=new Student();

		p.setNo(no);
		p.setName(name);
		p.setEntYear(entyear);
		p.setClassNum(classnum);

		if (isattend!=null) {
			boolean is_attend = true;
			p.setAttend(is_attend);
		} else {
			boolean is_attend = false;
			p.setAttend(is_attend);
		}



		StudentDao dao=new StudentDao();
		dao.save(p);

		request.getRequestDispatcher("student_update_done.jsp").forward(request, response);
	}

}