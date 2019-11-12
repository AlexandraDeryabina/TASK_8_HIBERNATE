package ru.lanit.servlet;

import org.hibernate.Session;
import ru.lanit.entity.Person;
import ru.lanit.provider.SessionProvider;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/fullName")
public class FullNameServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try (Session session = SessionProvider.getInstance().getSession()) {
            session.beginTransaction();

            Person person = new Person(
                    request.getParameter("name") != "" ? request.getParameter("name") : null,
                    request.getParameter("surname") != "" ? request.getParameter("surname") : null,
                    LocalDate.parse(request.getParameter("dateOfBirth")));
            person.setPatronymic(request.getParameter("patronymic"));

            session.save(person);
            session.getTransaction().commit();
            response.getWriter().println("<h1>Пользователь сохранен успешно</h1>");
        }
        catch (Exception e) {
            response.getWriter().println("<h1>Ошибки</h1>");
            response.getWriter().println(e.getMessage());
        }
    }
}