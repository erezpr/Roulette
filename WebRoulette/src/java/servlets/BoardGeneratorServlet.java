package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "BoardGeneratorServlet", urlPatterns = {"/boardGenerator"})
public class BoardGeneratorServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<img id=\"AmericanRouletteBoardImge\" src=\"images/AmericanRouletteBoard.png\" width=\"600\" height=\"300\" alt=\"AmericanRouletteBoard\"/>");
            out.println("<table id=\"rouletteBoardTable-1\">");
            out.println("<tr><td align=\"center\" onclick=\"placeBet(this,'STRAIGHT',0)\"></td></tr>");
            out.println("</table>");
            out.println("<table id=\"rouletteBoardTable-2\">");
            out.println("<tr>");
            for (int i = 0; i < 12; i++) {
                out.println("<td align=\"center\" onclick=\"placeBet(this,'SPLIT',"+(i * 3)+","+((i * 3)+3)+")\"></td>");
                out.println("<td align=\"center\" onclick=\"placeBet(this,'STRAIGHT',"+((i * 3)+3)+")\"></td>");
            }
            out.println("<td style='cursor:default;'></td>");
            out.println("<td align=\"center\" onclick=\"placeBet(this,'COLUMN3',3,6,9,12,15,18,21,24,27,30,33,36)\"></td>");
            out.println("</tr>");
            
            out.println("<tr>");
            out.println("<td align=\"center\" onclick=\"placeBet(this,'TRIO',0,2,3)\"></td>");
            for (int i = 0; i < 11; i++) {
                out.println("<td align=\"center\" onclick=\"placeBet(this,'SPLIT'," + ((i * 3)+2) + "," + ((i * 3 )+3) + ")\"></td>");
                out.println("<td align=\"center\" onclick=\"placeBet(this,'CORNER'," + ((i * 3)+2) + "," + ((i * 3 )+3) + ","+(((i+1) * 3)+2)+","+(((i+1)*3)+3)+")\"></td>");
            }
            out.println("<td align=\"center\" onclick=\"placeBet(this,'SPLIT',35,36)\"></td>");
            out.println("</tr>");
            
            out.println("<tr>");
            out.println("<td align=\"center\" onclick=\"placeBet(this,'SPLIT',0,2)\"></td>");
            for (int i = 1; i < 12; i++) {
                out.println("<td align=\"center\" onclick=\"placeBet(this,'STRAIGHT',"+((i * 3)-1)+")\"></td>");
                out.println("<td align=\"center\" onclick=\"placeBet(this,'SPLIT',"+((i * 3)-1)+","+((i * 3)+2)+")\"></td>");
            }
            out.println("<td align=\"center\" onclick=\"placeBet(this,'STRAIGHT',35)\"></td>");
            out.println("<td style='cursor:default;'></td>");
            out.println("<td align=\"center\" onclick=\"placeBet(this,'COLUMN2',2,5,8,11,14,17,20,23,26,29,32,35)\"></td>");
            out.println("</tr>");
            
            out.println("<tr>");
            out.println("<td align=\"center\" onclick=\"placeBet(this,'TRIO',0,1,2)\"></td>");
            for (int i = 0; i < 11; i++) {
                out.println("<td align=\"center\" onclick=\"placeBet(this,'SPLIT'," + ((i * 3)+1) + "," + ((i * 3 )+2) + ")\"></td>");
                out.println("<td align=\"center\" onclick=\"placeBet(this,'CORNER'," + ((i * 3)+1) + "," + ((i * 3 )+2) + ","+(((i+1) * 3)+1)+","+(((i+1)*3)+2)+")\"></td>");
            }
            out.println("<td align=\"center\" onclick=\"placeBet(this,'SPLIT',34,35)\"></td>");
            out.println("</tr>");
            
            out.println("<tr>");
            out.println("<td align=\"center\" onclick=\"placeBet(this,'SPLIT',0,1)\"></td>");
            for (int i = 1; i < 12; i++) {
                out.println("<td align=\"center\" onclick=\"placeBet(this,'STRAIGHT',"+((i * 3)-2)+")\"></td>");
                out.println("<td align=\"center\" onclick=\"placeBet(this,'SPLIT',"+((i * 3)-2)+","+((i * 3)+1)+")\"></td>");
            }
            out.println("<td align=\"center\" onclick=\"placeBet(this,'STRAIGHT',34)\"></td>");
            out.println("<td style='cursor:default;'></td>");
            out.println("<td align=\"center\" onclick=\"placeBet(this,'COLUMN1',1,4,7,10,13,16,19,22,25,28,31,34)\"></td>");
            out.println("</tr>");
            
            out.println("<tr>");
            out.println("<td align=\"center\" onclick=\"placeBet(this,'TRIO',0,1,2,3)\"></td>");
            for (int i = 0; i < 11; i++) {
                out.println("<td align=\"center\" onclick=\"placeBet(this,'STREET'," + ((i * 3)+1) + "," + ((i * 3 )+2) + "," +((i * 3)+3)+")\"></td>");
                out.println("<td align=\"center\" onclick=\"placeBet(this,'SIX_LINE'," + ((i * 3)+1) + "," + ((i * 3 )+2) + "," +((i * 3)+3)+"," +((i * 3)+4)+"," +((i * 3)+5)+"," +((i * 3)+6)+")\"></td>");
            }
            out.println("<td align=\"center\" onclick=\"placeBet(this,'STREET',34,35,36)\"></td>");
            out.println("</tr>");
            out.println("</table>");

            out.println("<table id=\"rouletteBoardTable-3\">");
            out.println("<tr>");
            out.println("<td align=\"center\" onclick=\"placeBet(this,'PREMIERE_DOUZAINE')\"></td>");
            out.println("<td align=\"center\" onclick=\"placeBet(this,'MOYENNE_DOUZAINE')\"></td>");
            out.println("<td align=\"center\" onclick=\"placeBet(this,'DERNIERE_DOUZAINE')\"></td>");
            out.println("</tr>");
            out.println("</table>");
            
            out.println("<table id=\"rouletteBoardTable-4\">");
            out.println("<tr>");
            out.println("<td align=\"center\" onclick=\"placeBet(this,'MANQUE')\"></td>");
            out.println("<td align=\"center\" onclick=\"placeBet(this,'PAIR')\"></td>");
            out.println("<td align=\"center\" onclick=\"placeBet(this,'NOIR')\"></td>");
            out.println("<td align=\"center\" onclick=\"placeBet(this,'ROUGE')\"></td>");
            out.println("<td align=\"center\" onclick=\"placeBet(this,'IMPAIR')\"></td>");
            out.println("<td align=\"center\" onclick=\"placeBet(this,'PASSE')\"></td>");
            out.println("</tr>");
            out.println("</table>");
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
