package soapOverHTTPS;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
interface HelloInterface {

    String hello(@WebParam(name = "who") String who);
}
