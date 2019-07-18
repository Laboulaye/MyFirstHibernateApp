package servlets;

import models.User;
import services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class UserSimpleServlet extends HttpServlet {

    private UserService service = new UserService();

    public void init(ServletConfig servletConfig) {
        try{
            super.init(servletConfig);
        }
        catch (ServletException se) {
            se.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //получаем список всех пользователей
        List<User> users = service.findAllUsers();
        req.setAttribute("users", users);
        //создаем диспетчер, который позволяет включать объекты в HTTP-запрос
        RequestDispatcher dispatcher = req.getRequestDispatcher("/showUsers.jsp");
        //перенаправляем на страницу /users
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        User user = new User(name, age);
        service.saveUser(user);
        resp.sendRedirect("/users");
}

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //обрабатываем HTTP-запрос и вытягиваем параметры id, name, age
        int id = Integer.parseInt(req.getParameter("id"));
        //находим пользователя по id
        User user = service.findUser(id);
        //присваеваем ему имя и возраст, полученные в запросе
        user.setName(req.getParameter("name"));
        user.setAge(Integer.parseInt(req.getParameter("age")));
        service.updateUser(user);
        //влзвращаемся на страницу /users
        resp.sendRedirect("/users");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        service.deleteUser(service.findUser(id));
        resp.sendRedirect("/users");
    }
}
