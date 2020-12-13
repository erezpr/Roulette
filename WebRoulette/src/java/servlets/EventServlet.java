package servlets;

import com.google.gson.Gson;
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
import wsdl.Event;
import wsdl.InvalidParameters_Exception;
import wsdl.RouletteWebService;
import wsdl.RouletteWebServiceService;

@WebServlet(name = "EventServlet", urlPatterns = {"/event"})
public class EventServlet extends HttpServlet {

    private static final String PLAYER_PARAMETER_ID = "playerId";
    private static final String LAST_EVET_ID = "lastEventId";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            if (request.getSession(false) != null) {
                RouletteWebServiceService service = new RouletteWebServiceService();
                RouletteWebService rouletteWebService = service.getRouletteWebServicePort();

                Integer playerId = (Integer) (request.getSession().getAttribute(PLAYER_PARAMETER_ID));
                Integer lastEventId = (Integer) (request.getSession().getAttribute(LAST_EVET_ID));

                List<Event> events = rouletteWebService.getEvents(lastEventId, playerId);

                Gson gson = new Gson();
                String string = gson.toJson(events);
                System.out.println(string);
                request.getSession().setAttribute(LAST_EVET_ID, lastEventId + events.size());
                out.println(string);
            }
        } catch (InvalidParameters_Exception ex) {
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
