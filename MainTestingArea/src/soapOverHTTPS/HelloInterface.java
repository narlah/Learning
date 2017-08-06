package soapOverHTTPS;

import javax.jws.*;

@WebService
interface HelloInterface {

    String hello(@WebParam(name = "who") String who);
}
