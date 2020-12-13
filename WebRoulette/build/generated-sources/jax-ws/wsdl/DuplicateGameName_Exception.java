
package wsdl;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "DuplicateGameName", targetNamespace = "http://roulette.ws/")
public class DuplicateGameName_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private DuplicateGameName faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public DuplicateGameName_Exception(String message, DuplicateGameName faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public DuplicateGameName_Exception(String message, DuplicateGameName faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: wsdl.DuplicateGameName
     */
    public DuplicateGameName getFaultInfo() {
        return faultInfo;
    }

}
