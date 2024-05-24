package tool;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontController
 */
//@WebServlet("/FrontController")
@WebServlet(urlPatterns = {"*.action"})
public class FrontController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//パスを取得
			String path = request.getServletPath().substring(1);
			//ファイル名を取得しクラス名に変換
			String name = path.replace(".a", "A").replace('/', '.');

			System.out.println("★ servlet path ->" + request.getServletPath());
			System.out.println("★ class name ->" + name);

			//アクションクラスのインスタンスを返却
			Action action = (Action) Class.forName(name).getDeclaredConstructor().newInstance();

			//遷移先URLを取得
			action.execute(request,  response);
			//String url = action.execute(req, res);
			//req.getRequestDispatcher(url).forward(req, res);

		} catch (Exception e) {
			e.printStackTrace();
			//エラーページへリダイレクト
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
}