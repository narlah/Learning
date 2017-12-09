package soapOverHTTPS;

//  Created by narlah on 21.01.17.

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(endpointInterface = "soapOverHTTPS.HelloInterface")
class HelloInterfaceImpl implements HelloInterface {

    @Override
    public String hello(@WebParam(name = "who") String who) {
        return "Hello " + who;
    }
}
