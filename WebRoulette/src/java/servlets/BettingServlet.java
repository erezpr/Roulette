package servlets;

import enums.BetType;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import wsdl.GameDoesNotExists_Exception;
import wsdl.InvalidParameters_Exception;
import wsdl.PlayerDetails;
import wsdl.RouletteWebService;
import wsdl.RouletteWebServiceService;

@WebServlet(name = "BettingServlet", urlPatterns = {"/betting"})
public class BettingServlet extends HttpServlet {

    BetType betTpye;
    private static final String PLAYER_PARAMETER_ID = "playerId";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            if (request.getSession(false) != null) {
                RouletteWebServiceService service = new RouletteWebServiceService();
                RouletteWebService rouletteWebService = service.getRouletteWebServicePort();

                List<Integer> numbersList = new LinkedList<>();
                for (int i = 1; i < 19; i++) {
                    if (request.getParameter("num" + i) != null) {
                        Integer number = Integer.valueOf(request.getParameter("num" + i));
                        numbersList.add(number);
                    }
                }
                Integer betMoney = Integer.valueOf(request.getParameter("moneyOnBet"));
                String betType = request.getParameter("betType");
                Integer playerId = (Integer) (request.getSession().getAttribute(PLAYER_PARAMETER_ID));
                PlayerDetails playerDetail = rouletteWebService.getPlayerDetails(playerId);
                int playerMoney = playerDetail.getMoney();
                if (betMoney <= playerMoney) {
                    rouletteWebService.makeBet(betMoney, wsdl.BetType.fromValue(betType), numbersList, playerId);
                } else {
                    out.print("NOT ENOUGH MONEY");
                }
            }
        } catch (InvalidParameters_Exception ex) {

        } catch (GameDoesNotExists_Exception ex) {
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
