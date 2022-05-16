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
        ObjectMapper mapper = new ObjectMapper();
        User user = new User("admin", "1234", "1234@1234.dk");
        CarportRequest carportRequest = new CarportRequest(Integer.parseInt(request.getParameter("cplength")), Integer.parseInt(request.getParameter("cpwidth")), "plastik", 0,
                210, 600 , user);
        String cprJson = mapper.writeValueAsString(carportRequest);

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(cprJson);
        out.flush();
    }
}
