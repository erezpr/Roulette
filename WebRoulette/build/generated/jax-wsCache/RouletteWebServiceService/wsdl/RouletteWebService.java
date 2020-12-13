
package wsdl;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "RouletteWebService", targetNamespace = "http://roulette.ws/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface RouletteWebService {


    /**
     * 
     * @param eventId
     * @param playerId
     * @return
     *     returns java.util.List<wsdl.Event>
     * @throws InvalidParameters_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getEvents", targetNamespace = "http://roulette.ws/", className = "wsdl.GetEvents")
    @ResponseWrapper(localName = "getEventsResponse", targetNamespace = "http://roulette.ws/", className = "wsdl.GetEventsResponse")
    @Action(input = "http://roulette.ws/RouletteWebService/getEventsRequest", output = "http://roulette.ws/RouletteWebService/getEventsResponse", fault = {
        @FaultAction(className = InvalidParameters_Exception.class, value = "http://roulette.ws/RouletteWebService/getEvents/Fault/InvalidParameters")
    })
    public List<Event> getEvents(
        @WebParam(name = "eventId", targetNamespace = "")
        int eventId,
        @WebParam(name = "playerId", targetNamespace = "")
        int playerId)
        throws InvalidParameters_Exception
    ;

    /**
     * 
     * @param minWages
     * @param intMaxWages
     * @param initalSumOfMoney
     * @param humanPlayers
     * @param name
     * @param rouletteType
     * @param computerizedPlayers
     * @throws DuplicateGameName_Exception
     * @throws InvalidParameters_Exception
     */
    @WebMethod
    @RequestWrapper(localName = "createGame", targetNamespace = "http://roulette.ws/", className = "wsdl.CreateGame")
    @ResponseWrapper(localName = "createGameResponse", targetNamespace = "http://roulette.ws/", className = "wsdl.CreateGameResponse")
    @Action(input = "http://roulette.ws/RouletteWebService/createGameRequest", output = "http://roulette.ws/RouletteWebService/createGameResponse", fault = {
        @FaultAction(className = DuplicateGameName_Exception.class, value = "http://roulette.ws/RouletteWebService/createGame/Fault/DuplicateGameName"),
        @FaultAction(className = InvalidParameters_Exception.class, value = "http://roulette.ws/RouletteWebService/createGame/Fault/InvalidParameters")
    })
    public void createGame(
        @WebParam(name = "computerizedPlayers", targetNamespace = "")
        int computerizedPlayers,
        @WebParam(name = "humanPlayers", targetNamespace = "")
        int humanPlayers,
        @WebParam(name = "initalSumOfMoney", targetNamespace = "")
        int initalSumOfMoney,
        @WebParam(name = "intMaxWages", targetNamespace = "")
        int intMaxWages,
        @WebParam(name = "minWages", targetNamespace = "")
        int minWages,
        @WebParam(name = "name", targetNamespace = "")
        String name,
        @WebParam(name = "rouletteType", targetNamespace = "")
        RouletteType rouletteType)
        throws DuplicateGameName_Exception, InvalidParameters_Exception
    ;

    /**
     * 
     * @param gameName
     * @return
     *     returns wsdl.GameDetails
     * @throws GameDoesNotExists_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getGameDetails", targetNamespace = "http://roulette.ws/", className = "wsdl.GetGameDetails")
    @ResponseWrapper(localName = "getGameDetailsResponse", targetNamespace = "http://roulette.ws/", className = "wsdl.GetGameDetailsResponse")
    @Action(input = "http://roulette.ws/RouletteWebService/getGameDetailsRequest", output = "http://roulette.ws/RouletteWebService/getGameDetailsResponse", fault = {
        @FaultAction(className = GameDoesNotExists_Exception.class, value = "http://roulette.ws/RouletteWebService/getGameDetails/Fault/GameDoesNotExists")
    })
    public GameDetails getGameDetails(
        @WebParam(name = "gameName", targetNamespace = "")
        String gameName)
        throws GameDoesNotExists_Exception
    ;

    /**
     * 
     * @return
     *     returns java.util.List<java.lang.String>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getWaitingGames", targetNamespace = "http://roulette.ws/", className = "wsdl.GetWaitingGames")
    @ResponseWrapper(localName = "getWaitingGamesResponse", targetNamespace = "http://roulette.ws/", className = "wsdl.GetWaitingGamesResponse")
    @Action(input = "http://roulette.ws/RouletteWebService/getWaitingGamesRequest", output = "http://roulette.ws/RouletteWebService/getWaitingGamesResponse")
    public List<String> getWaitingGames();

    /**
     * 
     * @param gameName
     * @param playerName
     * @return
     *     returns int
     * @throws GameDoesNotExists_Exception
     * @throws InvalidParameters_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "joinGame", targetNamespace = "http://roulette.ws/", className = "wsdl.JoinGame")
    @ResponseWrapper(localName = "joinGameResponse", targetNamespace = "http://roulette.ws/", className = "wsdl.JoinGameResponse")
    @Action(input = "http://roulette.ws/RouletteWebService/joinGameRequest", output = "http://roulette.ws/RouletteWebService/joinGameResponse", fault = {
        @FaultAction(className = GameDoesNotExists_Exception.class, value = "http://roulette.ws/RouletteWebService/joinGame/Fault/GameDoesNotExists"),
        @FaultAction(className = InvalidParameters_Exception.class, value = "http://roulette.ws/RouletteWebService/joinGame/Fault/InvalidParameters")
    })
    public int joinGame(
        @WebParam(name = "gameName", targetNamespace = "")
        String gameName,
        @WebParam(name = "playerName", targetNamespace = "")
        String playerName)
        throws GameDoesNotExists_Exception, InvalidParameters_Exception
    ;

    /**
     * 
     * @param playerId
     * @return
     *     returns wsdl.PlayerDetails
     * @throws GameDoesNotExists_Exception
     * @throws InvalidParameters_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getPlayerDetails", targetNamespace = "http://roulette.ws/", className = "wsdl.GetPlayerDetails")
    @ResponseWrapper(localName = "getPlayerDetailsResponse", targetNamespace = "http://roulette.ws/", className = "wsdl.GetPlayerDetailsResponse")
    @Action(input = "http://roulette.ws/RouletteWebService/getPlayerDetailsRequest", output = "http://roulette.ws/RouletteWebService/getPlayerDetailsResponse", fault = {
        @FaultAction(className = GameDoesNotExists_Exception.class, value = "http://roulette.ws/RouletteWebService/getPlayerDetails/Fault/GameDoesNotExists"),
        @FaultAction(className = InvalidParameters_Exception.class, value = "http://roulette.ws/RouletteWebService/getPlayerDetails/Fault/InvalidParameters")
    })
    public PlayerDetails getPlayerDetails(
        @WebParam(name = "playerId", targetNamespace = "")
        int playerId)
        throws GameDoesNotExists_Exception, InvalidParameters_Exception
    ;

    /**
     * 
     * @param betMoney
     * @param numbers
     * @param betType
     * @param playerId
     * @throws InvalidParameters_Exception
     */
    @WebMethod
    @RequestWrapper(localName = "makeBet", targetNamespace = "http://roulette.ws/", className = "wsdl.MakeBet")
    @ResponseWrapper(localName = "makeBetResponse", targetNamespace = "http://roulette.ws/", className = "wsdl.MakeBetResponse")
    @Action(input = "http://roulette.ws/RouletteWebService/makeBetRequest", output = "http://roulette.ws/RouletteWebService/makeBetResponse", fault = {
        @FaultAction(className = InvalidParameters_Exception.class, value = "http://roulette.ws/RouletteWebService/makeBet/Fault/InvalidParameters")
    })
    public void makeBet(
        @WebParam(name = "betMoney", targetNamespace = "")
        int betMoney,
        @WebParam(name = "betType", targetNamespace = "")
        BetType betType,
        @WebParam(name = "numbers", targetNamespace = "")
        List<Integer> numbers,
        @WebParam(name = "playerId", targetNamespace = "")
        int playerId)
        throws InvalidParameters_Exception
    ;

    /**
     * 
     * @param playerId
     * @throws InvalidParameters_Exception
     */
    @WebMethod
    @RequestWrapper(localName = "finishBetting", targetNamespace = "http://roulette.ws/", className = "wsdl.FinishBetting")
    @ResponseWrapper(localName = "finishBettingResponse", targetNamespace = "http://roulette.ws/", className = "wsdl.FinishBettingResponse")
    @Action(input = "http://roulette.ws/RouletteWebService/finishBettingRequest", output = "http://roulette.ws/RouletteWebService/finishBettingResponse", fault = {
        @FaultAction(className = InvalidParameters_Exception.class, value = "http://roulette.ws/RouletteWebService/finishBetting/Fault/InvalidParameters")
    })
    public void finishBetting(
        @WebParam(name = "playerId", targetNamespace = "")
        int playerId)
        throws InvalidParameters_Exception
    ;

    /**
     * 
     * @param playerId
     * @throws InvalidParameters_Exception
     */
    @WebMethod
    @RequestWrapper(localName = "resign", targetNamespace = "http://roulette.ws/", className = "wsdl.Resign")
    @ResponseWrapper(localName = "resignResponse", targetNamespace = "http://roulette.ws/", className = "wsdl.ResignResponse")
    @Action(input = "http://roulette.ws/RouletteWebService/resignRequest", output = "http://roulette.ws/RouletteWebService/resignResponse", fault = {
        @FaultAction(className = InvalidParameters_Exception.class, value = "http://roulette.ws/RouletteWebService/resign/Fault/InvalidParameters")
    })
    public void resign(
        @WebParam(name = "playerId", targetNamespace = "")
        int playerId)
        throws InvalidParameters_Exception
    ;

    /**
     * 
     * @param xmlData
     * @return
     *     returns java.lang.String
     * @throws DuplicateGameName_Exception
     * @throws InvalidXML_Exception
     * @throws InvalidParameters_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "createGameFromXML", targetNamespace = "http://roulette.ws/", className = "wsdl.CreateGameFromXML")
    @ResponseWrapper(localName = "createGameFromXMLResponse", targetNamespace = "http://roulette.ws/", className = "wsdl.CreateGameFromXMLResponse")
    @Action(input = "http://roulette.ws/RouletteWebService/createGameFromXMLRequest", output = "http://roulette.ws/RouletteWebService/createGameFromXMLResponse", fault = {
        @FaultAction(className = DuplicateGameName_Exception.class, value = "http://roulette.ws/RouletteWebService/createGameFromXML/Fault/DuplicateGameName"),
        @FaultAction(className = InvalidParameters_Exception.class, value = "http://roulette.ws/RouletteWebService/createGameFromXML/Fault/InvalidParameters"),
        @FaultAction(className = InvalidXML_Exception.class, value = "http://roulette.ws/RouletteWebService/createGameFromXML/Fault/InvalidXML")
    })
    public String createGameFromXML(
        @WebParam(name = "xmlData", targetNamespace = "")
        String xmlData)
        throws DuplicateGameName_Exception, InvalidParameters_Exception, InvalidXML_Exception
    ;

    /**
     * 
     * @param gameName
     * @return
     *     returns java.util.List<wsdl.PlayerDetails>
     * @throws GameDoesNotExists_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getPlayersDetails", targetNamespace = "http://roulette.ws/", className = "wsdl.GetPlayersDetails")
    @ResponseWrapper(localName = "getPlayersDetailsResponse", targetNamespace = "http://roulette.ws/", className = "wsdl.GetPlayersDetailsResponse")
    @Action(input = "http://roulette.ws/RouletteWebService/getPlayersDetailsRequest", output = "http://roulette.ws/RouletteWebService/getPlayersDetailsResponse", fault = {
        @FaultAction(className = GameDoesNotExists_Exception.class, value = "http://roulette.ws/RouletteWebService/getPlayersDetails/Fault/GameDoesNotExists")
    })
    public List<PlayerDetails> getPlayersDetails(
        @WebParam(name = "gameName", targetNamespace = "")
        String gameName)
        throws GameDoesNotExists_Exception
    ;

}