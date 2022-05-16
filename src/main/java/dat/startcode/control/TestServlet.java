package dat.startcode.control;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import dat.startcode.model.entities.CarportRequest;
import dat.startcode.model.entities.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "TestServlet", value = "/TestServlet")
public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper(); // et object af jackson dependenies ObjectMapper, der sørger for vi kan manipulere med json
        User user = new User("admin", "1234", "1234@1234.dk"); // en instans af en test user
        CarportRequest carportRequest = new CarportRequest(Integer.parseInt(request.getParameter("cplength")), Integer.parseInt(request.getParameter("cpwidth")), "plastik", 0,
                210, 600 , user); // en instans af en test CarportRequest
        String cprJson = mapper.writeValueAsString(carportRequest); // vi laver en string hvor vores jackson mapper producere en json string ud fra vores carportRequest object

        PrintWriter out = response.getWriter(); // vi får fat i en writer så vi kan skrive til vores response
        response.setContentType("application/json"); // vi sørger her for at vores response kan tage og håndtere json
        response.setCharacterEncoding("UTF-8"); // siger lidt sig selv sørger for at vi kan skrive i UTF-8
        out.print(cprJson); // skriver vores string til vores response
        out.flush(); // commiter vores response
    }
}
