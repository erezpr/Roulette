package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import wsdl.DuplicateGameName_Exception;
import wsdl.InvalidParameters_Exception;
import wsdl.InvalidXML_Exception;
import wsdl.RouletteWebService;
import wsdl.RouletteWebServiceService;

@WebServlet(name = "LoadGameServlet", urlPatterns = {"/loadGame"})
public class LoadGameServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            RouletteWebServiceService service = new RouletteWebServiceService();
            RouletteWebService rouletteWebService = service.getRouletteWebServicePort();

            try {
                rouletteWebService.createGameFromXML(request.getParameter("fileContent"));
            } catch (DuplicateGameName_Exception ex) {
                out.println("DuplicateGameName_Exception");
            } catch (InvalidParameters_Exception ex) {
                out.println("InvalidParameters_Exception");
            } catch (InvalidXML_Exception ex) {
                out.println("InvalidXML_Exception");
            }

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
