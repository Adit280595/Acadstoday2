

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class instructor
 */
public class instructor extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	public static Connection conn1 =null;
	Statement st=null;
	public void init() throws ServletException {
		String dbURL2 = "jdbc:postgresql://localhost/cs387";
		String user = "deepanjan";
		String pass = "najnapeed";

		try {
			Class.forName("org.postgresql.Driver");
			conn1 = DriverManager.getConnection(dbURL2, user, pass);
			st = conn1.createStatement();
			System.out.println("init"+conn1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public instructor() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String bool_instructor=null;
		String retval="";
		try{
			bool_instructor=request.getParameter("select_dept").toString();
			if(bool_instructor.equals("instructor")){
				String department=request.getParameter("Departments");
				ResultSet rs;
				rs=st.executeQuery("Select name from department natural join instructor where dept_name='"+department+"';");
				retval="<form action=\"instructor\" method=\"get\" style=\"float:left;margin-left:100px\"> <div style=\"width:1200px\"><div style=\"float:left; margin-left:200px;width:200px\">Select the instructor:</div><div style=\"float:left;margin-left:40px;width:300px\"><select name=\"instructors\">\n";
				while(rs.next()){
					System.out.println("Comeon");
					retval+="<option value=\""+rs.getString(1)+"\">"+rs.getString(1)+"</option>\n";
				}
				retval+="</select></div><div style=\"margin-left:300px\"><input type=\"submit\" value=\"Select\"><input type=\"hidden\" name=\"select_dept\" value=\"instructor_page\"></div></div></form>";
				session.setAttribute("instructors",retval);
				//System.out.println(retval);
				response.sendRedirect("instructor.jsp");
			}
			else if(bool_instructor.equals("instructor_page")){
				String instructor_name=(String)request.getParameter("instructors");
				session.setAttribute("instructor_name",instructor_name);
				ResultSet rs;
				rs=st.executeQuery("Select instructor_id from instructor where name='"+instructor_name+"';");
				rs.next();
				String instructor_id=rs.getString(1);
				session.setAttribute("instructor_id",instructor_id);
				rs=st.executeQuery("Select review_text from instructorreview where instructor_id='"+
						instructor_id.toString()+"';");
				int i=0;
				String review_text="";
				while(rs.next() && i<=10){
					review_text+="<br><br><br><div style=\"float:left;margin-left:125px; width: " +
							"1000px;padding: 25px;text-align: left;font-size: 100%;color:" +
							"black;border: 1px solid navy;border-radius:25px;background-color:" +
							"#ffe4b5\">"+rs.getString(1)+"</div><br><br><br>";
					i++;
				}
				session.setAttribute("instructor_review_code", review_text);
				response.sendRedirect("instructorreview.jsp");
			}
		}
		catch(NullPointerException e)
		{
			try{
				ResultSet rs;
				rs=st.executeQuery("Select dept_name from department;");
				retval="<select name=\"Departments\">\n";
				while(rs.next()){
					retval+="<option value=\""+rs.getString(1)+"\">"+rs.getString(1)+"</option>\n";
				}
				retval+="</select>";
				session.setAttribute("departments",retval);
				session.setAttribute("instructors","");
				response.sendRedirect("instructor.jsp");
			}
			catch(Exception e1){
				e1.printStackTrace();
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
