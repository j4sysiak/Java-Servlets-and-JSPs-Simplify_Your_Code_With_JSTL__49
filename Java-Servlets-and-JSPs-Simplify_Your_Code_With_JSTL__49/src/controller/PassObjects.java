package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.User;

/**
 * Servlet implementation class PassObjects
 */
public class PassObjects extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PassObjects() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		
		
		//1
		User user1 = new User("request scope", 1);
		User user2 = new User("session scope", 2);
		User user3 = new User("application scope", 3);
		
		/*request scope*/
		request.setAttribute("user1", user1);
		
		/*session scope*/
		HttpSession session = request.getSession();
		session.setAttribute("user2", user2);
		
		/*application scope*/
		ServletContext context = getServletContext();
		context.setAttribute("user3", user3); 
		
		
		
		//2
		Map<String, String> map = new HashMap<>();
		
		map.put("fruit", "apple");
		map.put("car", "volvo");
		request.setAttribute("map1", map);
		
		//3
		request.setAttribute("link", "<a href='something.com'>Click here</a>");
		
		
		//4
		List<User> list1 = new ArrayList<>();
		list1.add(new User("fox", 1));
		list1.add(new User("bear", 2));
		list1.add(new User("cat", 3));
		
		session.setAttribute("list1", list1);
		 
		request.getRequestDispatcher("/receiveObjects.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}














































