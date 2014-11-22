

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
 * Servlet implementation class course
 */
public class course extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	public static Connection conn1 =null;
	Statement st=null;
	public void init() throws ServletException {
		String dbURL2 = "jdbc:postgresql://localhost/cs387";
		String user = "deepanjan";
		String pass = "najnapeed";

		try {
			System.out.println("vikasgarg");
			Class.forName("org.postgresql.Driver");
			conn1 = DriverManager.getConnection(dbURL2, user, pass);
			st = conn1.createStatement();
			System.out.println("init"+conn1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public course() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String bool_course=null;
		String retval="";
		try{
			bool_course=request.getParameter("select_dept").toString();
			if(bool_course.equals("course")){
				String department=request.getParameter("Departments");
				ResultSet rs;
				rs=st.executeQuery("Select course_id,title from department natural join course where dept_name='"+department+"';");
				retval="<form action=\"course\" method=\"get\" style=\"float:left;margin-left:100px\"> <div style=\"width:1200px\"><div style=\"float:left; margin-left:200px;width:200px\">Select the course:</div><div style=\"float:left;margin-left:40px;width:300px\"><select name=\"Courses\">\n";
				while(rs.next()){
					System.out.println("Comeon");
					retval+="<option value=\""+rs.getString(1)+" : "+rs.getString(2)+"\">"+rs.getString(1)+" : "+rs.getString(2)+"</option>\n";
				}
				retval+="</select></div><div style=\"margin-left:300px\"><input type=\"submit\" value=\"Select\"><input type=\"hidden\" name=\"select_dept\" value=\"course_page\"></div></div></form>";
				session.setAttribute("courses",retval);
				
				//System.out.println(retval);
				response.sendRedirect("course.jsp");
			}
			else if(bool_course.equals("course_page")){
				
				String course_name=(String)request.getParameter("Courses");
				
				ResultSet rs;
				if(course_name.equals("deepanjan")){
					course_name=session.getAttribute("course_name").toString();
				}
				int count =0;
				for(int i = 0; i < course_name.length(); i++){
		            if(Character.isWhitespace(course_name.charAt(i))){
		                count++;
		                if(count==2){
		                	count = i;
		                	break;
		                }
		            }
		        }
				String course_id = course_name.toString().substring(0,6);
				rs=st.executeQuery("Select review_text from coursereview where course_id='"+
						course_id+"';");
				String query = "Select * from follow where course_id='"+course_id+
						"' and user_id='"+session.getAttribute("Username")+"';";
				System.out.println(query);
				
				int i=0;
				String review_text="";
				System.out.println("dfghj "+count);
				while(rs.next() && i<=10){
					review_text+="<br><br><br><div style=\"float:left;margin-left:125px; width: " +
							"1000px;padding: 25px;text-align: left;font-size: 100%;color:" +
							"black;border: 1px solid navy;border-radius:25px;background-color:" +
							"#ffe4b5\">"+rs.getString(1)+"</div><br><br><br>";
					i++;
				}
				System.out.println("aaaaa");
				rs=st.executeQuery(query);
				if (!rs.next()){
					session.setAttribute("follow", "Follow");
					System.out.println("we don't have a follow");
				}
				else{
					session.setAttribute("follow","Following");
					System.out.println("Now we have a follow");
				}
				session.setAttribute("course_review_code", review_text);
				session.setAttribute("course_name",course_name);
				session.setAttribute("course_id",course_id);
				session.setAttribute("jsp", "course_review");
				response.sendRedirect("coursereview.jsp");
			}
			else if(bool_course.equals("follow")){
				System.out.println("Reached here");
				String follow = (String) session.getAttribute("follow");
				String course = (String) session.getAttribute("course_id");
				String user = (String) session.getAttribute("Username");
				String jsp = (String) session.getAttribute("jsp");
				System.out.println("here is "+course);
				if(follow == "Follow"){
					System.out.println("changing");
					st.executeUpdate("insert into follow values('"+user+"','"+course+"');");
					session.setAttribute("follow","Following");
				}
				else{
					System.out.println("again changing");
					String str = "delete from follow where user_id = '"+user+"' and course_id = '"+course+"';";
					System.out.println(str);
					st.executeUpdate(str);
					
					session.setAttribute("follow","Follow");
				}
				System.out.println("Finally");
				response.sendRedirect("coursereview.jsp");
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
				session.setAttribute("courses","");
				response.sendRedirect("course.jsp");
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
		
	}

}
