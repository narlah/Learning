package soapOverHTTPS;
//  Created by narlah on 21.01.17.

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpsConfigurator;
import com.sun.net.httpserver.HttpsServer;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import javax.xml.ws.Endpoint;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.security.*;
import java.security.cert.CertificateException;

public class TestWsServer {
    public static void main(final String[] args)  {
        try {
            String url = (args.length > 0) ? args[0] : "https://localhost:4434/soapOverHTTPS";
            //Endpoint.publish(url, new soapOverHTTPS.HelloInterfaceImpl());
            char[] keypas = "changeit".toCharArray();

            Endpoint endpoint = Endpoint.create(new soapOverHTTPS.HelloInterfaceImpl());
            HttpsConfigurator configurator = getHttpsConfigurator(keypas);

            HttpsServer httpsServer = HttpsServer.create(new InetSocketAddress("localhost", 4434), 4434);
            httpsServer.setHttpsConfigurator(configurator);

            HttpContext httpContext = httpsServer.createContext(url);

            httpsServer.start();
            endpoint.publish(httpContext);

        } catch (NoSuchAlgorithmException | KeyStoreException | KeyManagementException | IOException | UnrecoverableKeyException | CertificateException e) {
            e.printStackTrace();
        }
    }

    private static HttpsConfigurator getHttpsConfigurator(char[] keypas) throws NoSuchAlgorithmException, KeyStoreException, IOException, CertificateException, UnrecoverableKeyException, KeyManagementException {
        SSLContext ssl = SSLContext.getInstance("TLS");

        KeyManagerFactory keyFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        KeyStore store = KeyStore.getInstance("JKS");

        store.load(new FileInputStream(keystoreFile), keypas);
        keyFactory.init(store, keypas);

        TrustManagerFactory trustFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustFactory.init(store);

        ssl.init(keyFactory.getKeyManagers(),
                trustFactory.getTrustManagers(), new SecureRandom());

        return new HttpsConfigurator(ssl);
    }
}

//String uri = "https://localhost:4434/soapOverHTTPS";