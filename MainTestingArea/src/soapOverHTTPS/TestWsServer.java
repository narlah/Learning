package soapOverHTTPS;
//  Created by narlah on 21.01.17.

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpsConfigurator;
import com.sun.net.httpserver.HttpsServer;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import javax.xml.ws.Endpoint;
import java.io.*;
import java.net.InetSocketAddress;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;

public class TestWsServer {
    public static void main(final String[] args) {
        try {
            String url = (args.length > 0) ? args[0] : "https://127.0.0.1:4434/soapOverHTTPS";
            //Endpoint.publish(url, new soapOverHTTPS.HelloInterfaceImpl());

            Endpoint endpoint = Endpoint.create(new soapOverHTTPS.HelloInterfaceImpl());

            HttpsConfigurator configurator = getHttpsConfigurator();

            HttpsServer httpsServer = HttpsServer.create(new InetSocketAddress("127.0.0.1", 4434), 4434);
            httpsServer.setHttpsConfigurator(configurator);

            HttpContext httpContext = httpsServer.createContext("/soapOverHTTPS");

            httpsServer.start();
            endpoint.publish(httpContext);

        } catch (NoSuchAlgorithmException | KeyStoreException | KeyManagementException | IOException | UnrecoverableKeyException | CertificateException e) {
            e.printStackTrace();
        }
    }

    private static HttpsConfigurator getHttpsConfigurator() throws NoSuchAlgorithmException, KeyStoreException, IOException, CertificateException, UnrecoverableKeyException, KeyManagementException {
        SSLContext ssl = SSLContext.getInstance("TLS");
        char[] keyPass = "changeit".toCharArray();
        KeyManagerFactory keyFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        KeyStore keyStore = loadKeystore(keyPass);
        keyFactory.init(keyStore, keyPass);

        //setGivenCertificate(keyPass, keyStoreFile, keyStore);

        TrustManagerFactory trustFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustFactory.init(keyStore);

        ssl.init(keyFactory.getKeyManagers(),
                trustFactory.getTrustManagers(), new SecureRandom());

        return new HttpsConfigurator(ssl);
    }

    private static KeyStore loadKeystore(char[] keyPass) throws KeyStoreException, IOException, NoSuchAlgorithmException, CertificateException {
        File keyStoreFile = new File("/tmp/ssl/keystore.jks");
        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        FileInputStream in = new FileInputStream(keyStoreFile);
        keyStore.load(in, keyPass);
        in.close();
        return keyStore;
    }

    private static void setGivenCertificate(char[] keyPass, File keyStoreFile, KeyStore keyStore) throws IOException, CertificateException, KeyStoreException, NoSuchAlgorithmException {
        //set certificate
        String alias = "selfsigned";
        String certfile = "/tmp/ssl/X509_certificate.cer";
        InputStream certstream = fullStream(certfile);
        CertificateFactory cf = CertificateFactory.getInstance("X.509");
        Certificate certs = cf.generateCertificate(certstream);

        //keyFactory.init(store, keypas);
        keyStore.setCertificateEntry(alias, certs);
        FileOutputStream out = new FileOutputStream(keyStoreFile);
        keyStore.store(out, keyPass);
        out.close();
    }

    private static InputStream fullStream(String fname) throws IOException {
        FileInputStream fis = new FileInputStream(fname);
        DataInputStream dis = new DataInputStream(fis);
        byte[] bytes = new byte[dis.available()];
        dis.readFully(bytes);
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        return bais;
    }
}


//String uri = "https://localhost:4434/soapOverHTTPS";