package soapOverHTTPS;

//  Created by narlah on 21.01.17.

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

public class TestWsClient {
    public static void main( final String[] args ) throws Throwable
    {
        String url = ( args.length > 0 ) ? args[0] : "https://127.0.0.1:4434/soapOverHTTPS";
        Service service = Service.create(
                new URL( url + "?wsdl" ),
                new QName( "https://127.0.0.1:4434/soapOverHTTPS/", "HelloInterfaceImplService" ) );
        HelloInterface helloWho = service.getPort( HelloInterface.class );
        System.out.println( "\n" + helloWho.hello( args.length > 1 ? args[1] : "niki" ) );
    }
}
