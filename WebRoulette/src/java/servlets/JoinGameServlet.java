package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import wsdl.GameDoesNotExists_Exception;
import wsdl.InvalidParameters_Exception;
import wsdl.RouletteWebService;
import wsdl.RouletteWebServiceService;

@WebServlet(name = "JoinGameServlet", urlPatterns = {"/joinGame"})
public class JoinGameServlet extends HttpServlet {

    private static final String PLAYER_PARAMETER_NAME = "playerName";
    private static final String PLAYER_PARAMETER_ID = "playerId";
    private static final String GAME_PARAMETER_NAME = "gameName";
    private static final String LAST_EVET_ID = "lastEventId";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            if (request.getSession(false) != null) {
                int playerId;
                RouletteWebServiceService service = new RouletteWebServiceService();
                RouletteWebService rouletteWebService = service.getRouletteWebServicePort();

                String gameName = request.getParameter(GAME_PARAMETER_NAME);
                String playerName = (String) request.getSession().getAttribute(PLAYER_PARAMETER_NAME);

                try {
                    playerId = rouletteWebService.joinGame(gameName, playerName);
                    request.getSession().setAttribute(PLAYER_PARAMETER_ID, playerId);
                    request.getSession().setAttribute(GAME_PARAMETER_NAME, gameName);
                    request.getSession().setAttribute(LAST_EVET_ID, 0);
                    response.sendRedirect("game.html");

                } catch (GameDoesNotExists_Exception ex) {
                } catch (InvalidParameters_Exception ex) {
                    out.print("InvalidParameters_Exception");
                }
            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods">
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
