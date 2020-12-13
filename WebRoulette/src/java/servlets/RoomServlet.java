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
import wsdl.GameDetails;
import wsdl.GameDoesNotExists_Exception;
import wsdl.RouletteWebService;
import wsdl.RouletteWebServiceService;

@WebServlet(name = "RoomServlet", urlPatterns = {"/room"})
public class RoomServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doGet(req, res);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try (PrintWriter out = res.getWriter()) {
            res.setContentType("text/html");
            RouletteWebServiceService service = new RouletteWebServiceService();
            RouletteWebService rouletteWebService = service.getRouletteWebServicePort();
            
            List<String> gameNames = rouletteWebService.getWaitingGames();
            out.println("<table id =\"waitingGamesTable\">");
            out.println("<tr><td>Game Name</td><td></td><td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</td><td>Computer Players</td><td>Roulette Type</td></tr>");
            for (String gameName : gameNames) {
                GameDetails gameDetails = rouletteWebService.getGameDetails(gameName);
                out.println("<tr id=\"franch\">");
                out.println("<td>"+gameName+"</td>");
                out.println("<td><div id=\"joinButton\" onclick=\"join('"+gameName+"')\">JOIN GAME</div></td>");
                out.println("<td>"+(gameDetails.getJoinedHumanPlayers()+gameDetails.getComputerizedPlayers())+"/"+(gameDetails.getHumanPlayers()+gameDetails.getComputerizedPlayers())+"</td>");
                out.println("<td>"+gameDetails.getComputerizedPlayers()+"</td>");
                out.println("<td>"+gameDetails.getRouletteType().name()+"</td>");
                out.println("</tr>");
            }
            out.println("</table>");
        } catch (GameDoesNotExists_Exception ex) {
        }
    }
    

}
