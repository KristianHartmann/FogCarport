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
        StringBuilder svgSb = new StringBuilder();

        String cplength = request.getParameter("cplength");
        String cpwidth = request.getParameter("cpwidth");

        svgSb.append("<svg width=\"100%\" height=\"100%\" viewBox=\"0 0 780 230\" id=\"svgSideViewPreview\"\n" +
                "                                         preserveAspectRatio=\"xMidYMid meet\">");
        svgSb.append("<rect x=\"100\" y=\"20\" height=\"210\" width=\"10\" stroke-width=\"1\"\n" +
                "                                              fill-opacity=\"0\" stroke=\"black\"></rect>");
        svgSb.append("<rect x=\"313.333\" y=\"20\" height=\"210\" width=\"10\" stroke-width=\"1\"\n" +
                "                                              fill-opacity=\"0\" stroke=\"black\"></rect>");
        svgSb.append("<rect x=\"526.666\" y=\"20\" height=\"210\" width=\"10\" stroke-width=\"1\"\n" +
                "                                              fill-opacity=\"0\" stroke=\"black\"></rect>");
        svgSb.append("<rect x=\"750\" y=\"20\" height=\"210\" width=\"10\" stroke-width=\"1\"\n" +
                "                                              stroke=\"black\" fill-opacity=\"0\"></rect>");
        svgSb.append("<rect x=\"0\" y=\"0\" height=\"30\" width=\"780\" stroke=\"black\"\n" +
                "                                              transform=\"rotate(1.28)\" stroke-width=\"1\" fill-opacity=\"1\"\n" +
                "                                              fill=\"white\"></rect>");
        svgSb.append("<rect x=\"0\" y=\"15\" height=\"1\" width=\"780\" fill-opacity=\"0\"\n" +
                "                                              stroke-width=\"0.3\" stroke=\"black\"\n" +
                "                                              transform=\"rotate(1.28)\"></rect>");
        svgSb.append("</svg>");

        String cprJson = mapper.writeValueAsString(svgSb); // vi laver en string hvor vores jackson mapper producere en json string ud fra vores carportRequest object

        PrintWriter out = response.getWriter(); // vi får fat i en writer så vi kan skrive til vores response
        response.setContentType("application/json"); // vi sørger her for at vores response kan tage og håndtere json
        response.setCharacterEncoding("UTF-8"); // siger lidt sig selv sørger for at vi kan skrive i UTF-8
        out.print(cprJson); // skriver vores string til vores response
        out.flush(); // commiter vores response
    }
}
