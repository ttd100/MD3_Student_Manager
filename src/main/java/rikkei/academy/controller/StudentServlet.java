package rikkei.academy.controller;

import rikkei.academy.model.Student;
import rikkei.academy.service.IStudentService;
import rikkei.academy.service.StudentServiceIMPL;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(value ={"/","/students"})
public class StudentServlet extends HttpServlet {
    private IStudentService studentService = new StudentServiceIMPL();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showFormCreate(request, response);
                break;
            case "edit":
                showFormEdit(request, response);
            case "delete":
                formDeleteStudent(request, response);
                break;
            case "detail":
                formDetailStudent(request, response);
                break;
            default:
                showListStudent(request, response);
        }

    }

    private void formDetailStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = studentService.findById(id);
        request.setAttribute("student", student);
        RequestDispatcher dispatcher = request.getRequestDispatcher("students/detail.jsp");
        dispatcher.forward(request, response);
    }


    private void formDeleteStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = studentService.findById(id);
        request.setAttribute("student", student);
        RequestDispatcher dispatcher = request.getRequestDispatcher("students/delete.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                actionCreate(request, response);
                break;
            case "edit":
                actionEdit(request, response);
            case "delete":
                actionDelete(request, response);
        }
    }


    private void actionDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        studentService.delete(id);
        request.setAttribute("message", "delete success");
        request.setAttribute("listStudent",studentService.findAll());
        RequestDispatcher dispatcher = request.getRequestDispatcher("students/list.jsp");
        dispatcher.forward(request, response);
    }

    private void actionCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = studentService.findAll().get(studentService.findAll().size()-1).getId()+1;
        String name = request.getParameter("name");

        int age = Integer.parseInt(request.getParameter("age"));
        Student student = new Student(id, name, age);
        studentService.save(student);
        request.setAttribute("message","create student success!");
        RequestDispatcher dispatcher = request.getRequestDispatcher("students/create.jsp");
        dispatcher.forward(request,response);
    }

    private void showListStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        List<Student> studentList = studentService.findAll();
        request.setAttribute("listStudent", studentList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("students/list.jsp");
        dispatcher.forward(request,response);
    }
    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("students/create.jsp");
        dispatcher.forward(request,response);
    }
    public  void showFormEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = studentService.findById(id);
        request.setAttribute("student", student);
        RequestDispatcher dispatcher = request.getRequestDispatcher("students/edit.jsp");
        dispatcher.forward(request,response);
    }
    public void actionEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = studentService.findById(id);
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        student.setName(name);
        student.setAge(age);
        request.setAttribute("message","update success");
        RequestDispatcher dispatcher = request.getRequestDispatcher("students/edit.jsp");
        dispatcher.forward(request,response);
        System.out.println("list Student sau khi sửa---->"+studentService.findAll());

    }
}
