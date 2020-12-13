package servlets;

import loginLogic.LoginAction;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import loginLogic.UserNameLogic;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    private static final String PLAYER_PARAMETER_NAME = "playerName";
    private final UserNameLogic nameLogic;

    public LoginServlet() {
        this.nameLogic = new UserNameLogic();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String playerNameChoice = request.getParameter(PLAYER_PARAMETER_NAME);
            String previousePlayerName = (String) request.getSession(true).getAttribute(PLAYER_PARAMETER_NAME);

            LoginAction action = LoginAction.calculateAction(playerNameChoice, previousePlayerName);
            switch (action) {
                case SHOW_LOGIN:
                    out.println("<div id=\"header\"><h1>WELCOME</h1></div>");
                    out.println("<div id=\"content\">");
                    out.println("<h2>PLEASE ENTER YOUR NAME: <input id = \"playerName\" class=\"textBox\" name=\"playerName\" placeholder=\"Username\" type=\"text\" value></h2><br>");
                    out.println("<div class=\"classname\" onclick=\"submit()\"><a>LOGIN</a></div>");
                    out.println("<h2 class=\"error\"></h2>");
                    out.println("</div>");
                    break;
                case CAST_USER_NAME:
                    if (nameLogic.addPlayerName(playerNameChoice)) {
                        request.getSession(true).setAttribute(PLAYER_PARAMETER_NAME, playerNameChoice);
                        out.println("<h2>WELCOME " + request.getSession().getAttribute(PLAYER_PARAMETER_NAME).toString().toUpperCase() + "</h2>");
                        out.println("<div id=\"header\"><h1>ROULETTE</h1></div>");
                        out.println("<div id=\"content\">");
                        out.println("<table id='mainMenuTable'>");
                        out.println("<tr><td><div class=\"classname\"><a href=\"settings.html\">NEW TABLE</a></div></td></tr>");
                        out.println("<tr><td><div class=\"classname\"><a href=\"room.html\">ROULETTE ROOM</a></div></td></tr>");
                        out.println("<tr><td><div class=\"classname\"><a href=\"loadGame.html\">LOAD GAME</a></div></td></tr>");
                        out.println("</table>");
                        out.println("</div>");
                    } else {
                        out.println("<div id=\"header\"><h1>WELCOME</h1></div>");
                        out.println("<div id=\"content\">");
                        out.println("<h2>PLEASE ENTER YOUR NAME: <input id = \"playerName\" class=\"textBox\" name=\"playerName\" placeholder=\"Username\" type=\"text\" value></h2><br>");
                        out.println("<div class=\"classname\" onclick=\"submit()\"><a>LOGIN</a></div>");
                        out.println("<h2 class=\"error\">PLAYER NAME IS ALREADY EXISTS</h2>");
                        out.println("</div>");
                    }
                    break;
                case SHOW_MAIN:
                    out.println("<h2>WELCOME " + request.getSession().getAttribute(PLAYER_PARAMETER_NAME).toString().toUpperCase() + "</h2>");
                    out.println("<div id=\"header\"><h1>ROULETTE</h1></div>");
                    out.println("<div id=\"content\">");
                    out.println("<table id='mainMenuTable'>");
                    out.println("<tr><td><div class=\"classname\"><a href=\"settings.html\">NEW TABLE</a></div></td></tr>");
                    out.println("<tr><td><div class=\"classname\"><a href=\"room.html\">ROULETTE ROOM</a></div></td></tr>");
                    out.println("<tr><td><div class=\"classname\"><a href=\"loadGame.html\">LOAD GAME</a></div></td></tr>");
                    out.println("</table>");
                    out.println("</div>");
                    break;
                case ERROR:
                    break;
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods.">
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
