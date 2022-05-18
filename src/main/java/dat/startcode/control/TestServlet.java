package dat.startcode.control;

import dat.startcode.model.config.ApplicationStart;
import dat.startcode.model.entities.CarportRequest;
import dat.startcode.model.entities.PartsList;
import dat.startcode.model.entities.User;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.services.PartslistGenerator;
import dat.startcode.model.services.SideView;
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

        StringBuilder svgTvSb = new StringBuilder();
        JSONObject jsonObject = new JSONObject();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        PartslistGenerator generator = new PartslistGenerator(connectionPool);

//        int cplength = Integer.parseInt(request.getParameter("cplength"));
//        int cpwidth = Integer.parseInt(request.getParameter("cpwidth"));
//        int toolLength = Integer.parseInt(request.getParameter("x"));
//        int toolWidth = Integer.parseInt(request.getParameter("x"));
//        int roofPitch = Integer.parseInt(request.getParameter("x"));
//        String roofType = request.getParameter("x");
//        CarportRequest carportRequest = new CarportRequest(cplength, cpwidth, roofType, roofPitch, toolLength, toolWidth, user);
//        PartsList list = generator.generateFlatroofPartsList(carportRequest);
        SideView sideView = new SideView(null, 0, 0);
        StringBuilder svgSvSb = sideView.svgSideGen();

        // -------- Side View StringBuilder append-------

        // -------- Top View StringBuilder append-------
        svgTvSb.append("<svg width=\"100%\" height=\"100%\" viewBox=\"0 0 780 600\"\n" +
                "preserveAspectRatio=\"xMidYMid meet\">");
        svgTvSb.append("<rect x=\"0\" y=\"0\" height=\"600\" width=\"780\" stroke-width=\"1\" fill-opacity=\"0\"\n" +
                "stroke=\"black\"></rect>");
        svgTvSb.append("<rect x=\"100\" y=\"35\" height=\"10\" width=\"10\" stroke-width=\"1.5\"\n" +
                "fill-opacity=\"0\" stroke=\"black\"></rect>");
        svgTvSb.append("<rect x=\"313.333\" y=\"35\" height=\"10\" width=\"10\" stroke-width=\"1.5\"\n" +
                "fill-opacity=\"0\" stroke=\"black\"></rect>");
        svgTvSb.append("<rect x=\"526.666\" y=\"35\" height=\"10\" width=\"10\" stroke-width=\"1.5\"\n" +
                "fill-opacity=\"0\" stroke=\"black\"></rect>");
        svgTvSb.append("<rect x=\"750\" y=\"35\" height=\"10\" width=\"10\" stroke-width=\"1.5\"\n" +
                "stroke=\"black\" fill-opacity=\"0\"></rect>");
        svgTvSb.append("<rect x=\"100\" y=\"565\" height=\"10\" width=\"10\" stroke-width=\"1.5\"\n" +
                "fill-opacity=\"0\" stroke=\"black\"></rect>");
        svgTvSb.append("<rect x=\"313.333\" y=\"565\" height=\"10\" width=\"10\" stroke-width=\"1.5\"\n" +
                "fill-opacity=\"0\" stroke=\"black\"></rect>");
        svgTvSb.append("<rect x=\"526.666\" y=\"565\" height=\"10\" width=\"10\" stroke-width=\"1.5\"\n" +
                "fill-opacity=\"0\" stroke=\"black\"></rect>");
        svgTvSb.append("<rect x=\"750\" y=\"565\" height=\"10\" width=\"10\" stroke-width=\"1.5\"\n" +
                "stroke=\"black\" fill-opacity=\"0\"></rect>");
        svgTvSb.append("<rect x=\"0\" y=\"35\" height=\"9\" width=\"780\" stroke=\"black\" stroke-width=\"1\"\n" +
                "fill-opacity=\"0\"></rect>");
        svgTvSb.append("<rect x=\"0\" y=\"565\" height=\"9\" width=\"780\" stroke=\"black\" stroke-width=\"1\"\n" +
                "fill-opacity=\"0\"></rect>");
        svgTvSb.append("</svg>");

        jsonObject.put("sideview", svgSvSb);
        jsonObject.put("topview", svgTvSb);

        PrintWriter out = response.getWriter(); // vi får fat i en writer så vi kan skrive til vores response
        response.setContentType("application/json"); // vi sørger her for at vores response kan tage og håndtere json
        response.setCharacterEncoding("UTF-8"); // siger lidt sig selv sørger for at vi kan skrive i UTF-8
        out.print(jsonObject); // skriver vores string til vores response
        out.flush(); // commiter vores response
    }
}
