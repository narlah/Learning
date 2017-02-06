package soapOverHTTPS;

//  Created by narlah on 21.01.17.

import javax.net.ssl.HttpsURLConnection;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;
//http://stackoverflow.com/questions/10258101/sslhandshakeexception-no-subject-alternative-names-present

public class TestWsClient {
    static {
        HttpsURLConnection.setDefaultHostnameVerifier((hostname, session) -> hostname.equals("127.0.0.1"));
    }
    public static void main( final String[] args ) throws Throwable
    {
        String url = ( args.length > 0 ) ? args[0] : "https://127.0.0.1:4434/soapOverHTTPS";

//        System.setProperty("javax.net.ssl.keyStore", "/tmp/ssl/keystore.jks");
//        System.setProperty("javax.net.ssl.keyStorePassword", "changeit");
//        System.setProperty("javax.net.ssl.keyStoreType", KeyStore.getDefaultType());

        System.setProperty("javax.net.ssl.trustStore", "/tmp/ssl/keystore.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", "changeit");

        Service service = Service.create(
                new URL( url + "?wsdl" ),
                new QName( "http://soapOverHTTPS/", "HelloInterfaceImplService" ) );
        HelloInterface helloWho = service.getPort( HelloInterface.class );

        System.out.println( "\n" + helloWho.hello( args.length > 1 ? args[1] : "nikik" ) );
    }
}
