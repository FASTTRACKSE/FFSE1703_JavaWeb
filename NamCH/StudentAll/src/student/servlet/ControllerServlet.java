package student.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import student.bean.Student;
import student.bean.StudentDb;

/**
 * Servlet implementation class ControllerServlet
 */

@WebServlet("/SinhVien/*")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerServlet() {
        super();
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getPathInfo();	
		System.out.println(action);
        switch (action) {	
        case "/add":
		    ShowAddStudent(request, response);
		    break;
		case "/insert":
		    insertStudent(request, response);
		    break;	            
		case "/edit":
		    showEditForm(request, response);
		    break;
		case "/update":
			showUpdateForm(request, response);
		    break;
		case "/view":
			showViewForm(request, response);
		    break;
		case "/delete":
		    deleteStudent(request, response);
		    break;
		default:
			String message = "";
			
		    studentList(request, response ,message);
		    break;
		}
	}	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void ShowAddStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("/AddStudent.jsp");
        dispatcher.forward(request, response);
	}
	
	private void insertStudent(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
        MultipartRequest m = new MultipartRequest(request, "D:\\Java EE\\NamCH\\StudenManager\\WebContent\\image", 100000000, new DefaultFileRenamePolicy());
        String code = m.getParameter("code");
		String fullname = m.getParameter("fullname");
		String classStudent = m.getParameter("classStudent");		
        float pointLp1 = Float.parseFloat(m.getParameter("pointLp1"));
        float pointLp2 = Float.parseFloat(m.getParameter("pointLp2"));
        String image = m.getFilesystemName("image");
        Student std = new Student(code, fullname,image, classStudent, pointLp1, pointLp2);
        int check =StudentDb.addStudent(std);
        if(check==-1) {     
        	String message = "<script type=\"text/javascript\">" + "alert('Thêm Thất Bại Sinh Viên');" +"</script>";
        	studentList(request,response,message);
        }else {        	
        	String message = "<script type=\"text/javascript\">" + "alert('Thêm Thành Công Sinh Viên');" +"</script>";
        	studentList(request,response,message);       	
        }
			
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String code = request.getParameter("code");
		List<Student> listStudent = StudentDb.searchCode(code);
        request.setAttribute("listStu", listStudent);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/EditStudent.jsp");
        dispatcher.forward(request, response);
	}
	
	private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		MultipartRequest m = new MultipartRequest(request, "D:\\Java EE\\NamCH\\StudenManager\\WebContent\\image", 100000000, new DefaultFileRenamePolicy());        
		String code = m.getParameter("code");
		String fullname = m.getParameter("fullname");
		String classStudent = m.getParameter("classStudent");		
        float pointLp1 = Float.parseFloat(m.getParameter("pointLp1"));
        float pointLp2 = Float.parseFloat(m.getParameter("pointLp2"));
        String image = m.getFilesystemName("image");
        Student std = new Student(code, fullname,image, classStudent, pointLp1, pointLp2);
		int check = StudentDb.updateStudent(std);
		if(check==-1) {     
        	String message = "<script type=\"text/javascript\">" + "alert('Sửa Thất Bại Sinh Viên');" +"</script>";
        	studentList(request,response,message);
        }else {        	
        	String message = "<script type=\"text/javascript\">" + "alert('Sửa Thành Công Sinh Viên');" +"</script>";
        	studentList(request,response,message);       	
        }		
	}

	private void showViewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String code = request.getParameter("code");
		List<Student> listStudent = StudentDb.searchCode(code);
        request.setAttribute("listStu", listStudent);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ViewStudent.jsp");
        dispatcher.forward(request, response);
	}

	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String code = request.getParameter("code");
		int check = StudentDb.delStudent(code);	
		if(check==-1) {     
        	String message = "<script type=\"text/javascript\">" + "alert('Xóa Thất Bại Sinh Viên');" +"</script>";
        	studentList(request,response,message);
        }else {        	
        	String message = "<script type=\"text/javascript\">" + "alert('Xóa Thành Công Sinh Viên');" +"</script>";
        	studentList(request,response,message);       	
        }
				
	}

	private void studentList(HttpServletRequest request, HttpServletResponse response,String message) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getPathInfo();
		String lang="";
		lang = request.getParameter("lang");
		if(lang==null) {
			lang="";
		}
		if(lang.equals("en")) {
			request.setAttribute("lang", lang);
		}else {
			request.setAttribute("lang", lang);
		}
		if(action.indexOf("page")>-1) {
			int id = Integer.parseInt(request.getParameter("id"));
			ArrayList<String> pagi = pagination(id);
			List<Student> listStudent = StudentDb.getStudentList(id);
	        request.setAttribute("listStu", listStudent);
	        request.setAttribute("message", message);
	        request.setAttribute("pagi", pagi);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ShowList.jsp");
	        dispatcher.forward(request, response);
		}else {
			ArrayList<String> pagi = pagination(1);
			List<Student> listStudent = StudentDb.getStudentList(1);
	        request.setAttribute("listStu", listStudent);
	        request.setAttribute("message", message);
	        request.setAttribute("pagi", pagi);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ShowList.jsp");
	        dispatcher.forward(request, response);
		}
		
	}
	
	
	private ArrayList<String> pagination(int id) {
		int count = StudentDb.countStudent();
		if(count == -1) {
			
		}else {
			int number = count/3;
			int odd = count%3;
			if(number>1) {
				ArrayList<String> pagi = new ArrayList<String>();
				
				if(id<=1) {
					
				}else {
					String pagiFirst ="<a href='page?id="+"1"+"'>first</a>";
					pagi.add(pagiFirst);
					String pagiBack="<a href='page?id="+(id-1)+"'><<</a>";
					pagi.add(pagiBack);
				}
				if(odd>0) {
					for(int i=0;i<(number+1);i++) {
						String pagiNumber="<a href='page?id="+(i+1)+"'>"+(i+1)+"</a>";
						pagi.add(pagiNumber);
					}
					if(id<(number+1)) {
						String pagiNext="<a href='page?id="+(id+1)+"'>>></a>";
						pagi.add(pagiNext);
						String pagiLast="<a href='page?id="+(number+1)+"'>last</a>";
						pagi.add(pagiLast);
					}
				}else {
					for(int i=0;i<number;i++) {
						String pagiNumber="<a href='page?id="+(i+1)+"'>"+(i+1)+"</a>";
						pagi.add(pagiNumber);
					}
					if(id<number) {
						String pagiNext="<a href='page?id="+(id+1)+"'>>></a>";
						pagi.add(pagiNext);
						String pagiLast="<a href='page?id="+number+"'>last</a>";
						pagi.add(pagiLast);
					}
				}																
				return pagi;
			}				
		}
		return null;
	}

}
