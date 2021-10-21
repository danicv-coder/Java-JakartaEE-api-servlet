package org.danicv.webapp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/index.html")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellido");
        DateFormat formatoFecha = new SimpleDateFormat("dd 'de' MMMM, yyyy, 'hora:' HH:mm:SS");
        Date fecha = new Date();
        String fechaString = req.getParameter("fecha");
        fechaString = formatoFecha.format(fecha);
        out.println("<!Doctype html>");
        out.println("<html>");
        out.println("    <head>");
        out.println("        <meta charset=\"UTF-8\">");
        out.println("        <title>parametros get de la url</title");
        out.println("    </head>");
        out.println("    <body>");
        out.println("        <h1>Tarea 1: enviando parametros nombre, apellido y fecha</h1>");
        if (nombre != null && apellido != null) {
            out.println("    <h2>Hola mi nombre es:" + " " + nombre + " " + apellido + "</h2>");
            out.println(     "<h3>La fecha y hora actual es:" + " " + fechaString + "</h3>");
        } else {
            out.println("    <p>no existen los datos enviados </p>");
        }
        out.println("    </body>");
        out.println("</html>");

    }
}
