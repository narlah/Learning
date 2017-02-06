package soapOverHTTPS;

import javax.jws.*;

@WebService
public interface HelloInterface {

    public String hello(@WebParam( name = "who" ) String who );
}
