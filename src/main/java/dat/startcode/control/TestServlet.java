package dat.startcode.control;

import dat.startcode.model.config.ApplicationStart;
import dat.startcode.model.entities.CarportRequest;
import dat.startcode.model.entities.PartsList;
import dat.startcode.model.entities.User;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.services.PartslistGenerator;
import dat.startcode.model.services.SideView;
import dat.startcode.model.services.TopView;
import lombok.SneakyThrows;
import org.json.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TestServlet", value = "/TestServlet")
public class TestServlet extends HttpServlet {

    private ConnectionPool connectionPool;

    public TestServlet() {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // no caching
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setDateHeader("Expires", 0); // Proxies.

        JSONObject jsonObject = new JSONObject();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        PartslistGenerator generator = new PartslistGenerator(connectionPool);

        int cplength = Integer.parseInt(request.getParameter("cplength"));
        int cpwidth = Integer.parseInt(request.getParameter("cpwidth"));
        boolean isShed = request.getParameterMap().containsKey("isShed");
        int toolLength = ((isShed) ? Integer.parseInt(request.getParameter("cpshedlength")) : 0);
        int toolWidth = Integer.parseInt(request.getParameter("cpshedwidth"));
        int roofPitch = 0;
        String roofType = "plast";
        CarportRequest carportRequest = new CarportRequest(cplength, cpwidth, roofType, roofPitch, toolLength, toolWidth, user);
        PartsList list = generator.generateFlatroofPartsList(carportRequest);
        SideView sideView = new SideView(list, cplength, toolLength, isShed);
        TopView topview = new TopView(cplength, cpwidth, toolLength, toolWidth, list);


        jsonObject.put("sideview", sideView.svgSideGen());
        jsonObject.put("topview", topview.svgTopViewGen());

        PrintWriter out = response.getWriter(); // vi får fat i en writer så vi kan skrive til vores response
        response.setContentType("application/json"); // vi sørger her for at vores response kan tage og håndtere json
        response.setCharacterEncoding("UTF-8"); // siger lidt sig selv sørger for at vi kan skrive i UTF-8
        out.print(jsonObject); // skriver vores string til vores response
        out.flush(); // commiter vores response
    }
}
