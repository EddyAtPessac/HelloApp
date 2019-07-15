package org.wcs.hello;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "SimpleHelloServlet", urlPatterns = {"/hello-form"})
public class SimpleHelloServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Prepare messages.
        Map<String, String> messages = new HashMap<>();
        request.setAttribute("messages", messages);

        // Get and validate name.
        String name = request.getParameter("name");

        String lastname = request.getParameter("lastname");
        String firstname = request.getParameter("firstname");
        String time = request.getParameter("daytime");
        Integer hour=Integer.parseInt(time.substring(0,2));
        String welcome="Good ";
        if (hour > 20 ) welcome+="night";
        else if (hour > 12) welcome+="afternoon";
        else welcome+="morning";
             messages.put("success", String.format("%s, %s %s ", welcome, firstname, lastname));

        request.getRequestDispatcher("/custom-hello.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/Hello-form.jsp").forward( request, response);

    }
}
