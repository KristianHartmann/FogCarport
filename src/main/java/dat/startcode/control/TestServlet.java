package dat.startcode.control;

import org.json.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TestServlet", value = "/TestServlet")
public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StringBuilder svgSvSb = new StringBuilder();
        StringBuilder svgTvSb = new StringBuilder();
        JSONObject jsonObject = new JSONObject();

        String cplength = request.getParameter("cplength");
        String cpwidth = request.getParameter("cpwidth");
        // -------- Side View StringBuilder append-------
        svgSvSb.append("<svg width=\"100%\" height=\"100%\" viewBox=\"0 0 780 230\"\n" +
                "preserveAspectRatio=\"xMidYMid meet\">");
        svgSvSb.append("<rect x=\"100\" y=\"20\" height=\"210\" width=\"10\" stroke-width=\"1\"\n" +
                "fill-opacity=\"0\" stroke=\"black\"></rect>");
        svgSvSb.append("<rect x=\"313.333\" y=\"20\" height=\"210\" width=\"10\" stroke-width=\"1\"\n" +
                "fill-opacity=\"0\" stroke=\"black\"></rect>");
        svgSvSb.append("<rect x=\"526.666\" y=\"20\" height=\"210\" width=\"10\" stroke-width=\"1\"\n" +
                "fill-opacity=\"0\" stroke=\"black\"></rect>");
        svgSvSb.append("<rect x=\"750\" y=\"20\" height=\"210\" width=\"10\" stroke-width=\"1\"\n" +
                "stroke=\"black\" fill-opacity=\"0\"></rect>");
        svgSvSb.append("<rect x=\"0\" y=\"0\" height=\"30\" width=\"780\" stroke=\"black\"\n" +
                "transform=\"rotate(1.28)\" stroke-width=\"1\" fill-opacity=\"1\"\n" +
                "fill=\"white\"></rect>");
        svgSvSb.append("<rect x=\"0\" y=\"15\" height=\"1\" width=\"780\" fill-opacity=\"0\"\n" +
                "stroke-width=\"0.3\" stroke=\"black\"\n" +
                "transform=\"rotate(1.28)\"></rect>");
        svgSvSb.append("</svg>");
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
