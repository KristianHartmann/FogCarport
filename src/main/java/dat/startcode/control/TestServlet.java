package dat.startcode.control;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "TestServlet", value = "/TestServlet")
public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().print("cplength:"+request.getParameter("cplength"));
        response.getWriter().print("cpwidth:"+request.getParameter("cpwidth"));
        response.getWriter().print("shedlength:"+request.getParameter("cpshedlength"));
        response.getWriter().print("shedwidth:"+request.getParameter("cpshedwidth"));
    }
}
