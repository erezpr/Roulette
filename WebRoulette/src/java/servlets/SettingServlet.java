package servlets;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import wsdl.DuplicateGameName_Exception;
import wsdl.InvalidParameters_Exception;
import wsdl.RouletteType;
import wsdl.RouletteWebService;
import wsdl.RouletteWebServiceService;

/**
 *
 * @author Erez
 */
@WebServlet(name = "SettingServlet", urlPatterns = {"/settings"})
public class SettingServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doGet(req, res);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            res.setContentType("text/html");
            RouletteWebServiceService service = new RouletteWebServiceService();
            RouletteWebService rouletteWebService = service.getRouletteWebServicePort();
            
            String gameName = req.getParameter("gameName");
            int numberOfHumanPlayer = Integer.valueOf(req.getParameter("numberOfHumanPlayer"));
            int numberOfComputerPlayer = Integer.valueOf(req.getParameter("numberOfComputerPlayer"));
            String minBets[] = req.getParameterValues("minBets");
            int maxBets = Integer.valueOf(req.getParameter("maxBets"));
            int startingCapital = Integer.valueOf(req.getParameter("startingCapital"));
            String american[] = req.getParameterValues("rouletteType");
            
            RouletteType rouletteType;
            int minB;
            if (minBets == null)
                minB = 1;
            else
                minB = 0;
            
            if (american[0].equals("American"))
                rouletteType = RouletteType.AMERICAN;
            else
                rouletteType = RouletteType.FRENCH;
            
            rouletteWebService.createGame(numberOfComputerPlayer, numberOfHumanPlayer, startingCapital, maxBets, minB, gameName, rouletteType);
            
            res.sendRedirect("room.html");
            
        } catch (DuplicateGameName_Exception ex) {
        } catch (InvalidParameters_Exception ex) {
        }
    }

}
