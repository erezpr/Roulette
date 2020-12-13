package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import wsdl.GameDoesNotExists_Exception;
import wsdl.PlayerDetails;
import wsdl.RouletteWebService;
import wsdl.RouletteWebServiceService;

@WebServlet(name = "PlayerInfoServlet", urlPatterns = {"/playerInfo"})
public class PlayerInfoServlet extends HttpServlet {

    private static final String GAME_PARAMETER_NAME = "gameName";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            if (request.getSession(false) != null) {
                RouletteWebServiceService service = new RouletteWebServiceService();
                RouletteWebService rouletteWebService = service.getRouletteWebServicePort();
                String gameName = (String) request.getSession().getAttribute(GAME_PARAMETER_NAME);
                out.println("<table>");
                out.println("<tr><td>Player&nbspName</td><td>Money</td></tr>");
                try {
                    List<PlayerDetails> playersDetails = rouletteWebService.getPlayersDetails(gameName);
                    for (PlayerDetails player : playersDetails) {
                        out.println("<tr><td>" + player.getName() + "</td><td>" + player.getMoney() + "</td></tr>");
                    }
                    out.println("</table>");
                } catch (GameDoesNotExists_Exception ex) {
                    out.print("GameDoesNotExists_Exception");
                }
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
