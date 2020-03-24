package com.ssr.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssr.dao.GoodsDao;
import com.ssr.model.Goods;

/**
 * Servlet implementation class GoodsDeleteCheck
 */
@WebServlet("/GoodsDeleteCheck")
public class GoodsDeleteCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodsDeleteCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		Goods goods = new Goods(name);
		GoodsDao goodsDao = new GoodsDao();
		if(goodsDao.delete(goods)) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else {
			request.setAttribute("flag3", "0");
			request.getRequestDispatcher("goodsDelete.jsp").forward(request, response);
		}
	}

}
