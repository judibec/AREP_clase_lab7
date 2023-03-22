package org.example.server1;

import org.example.URLReader;

import static spark.Spark.*;
public class HelloWorld {
    public static void main(String[] args) {
        //API: secure(keystoreFilePath, keystorePassword, truststoreFilePath, truststorePassword);
        secure(getKeyStore(), getPwdKeyStore(), null, null);
        port(getPort());
        get("/connectionlocal", (req, res) -> "Hello World 1");
        get("/connectionremote", (req,res)-> URLReader.URLReaderSecure(getUrl(),getOtherKeyStore(),getPwdKeyStore()));
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5000; //returns default port if heroku-port isn't set (i.e. on localhost)
    }

    static String getUrl(){
        if(System.getenv("URL") != null){
            return System.getenv("URL");
        }
        return "https://ec2-34-232-78-100.compute-1.amazonaws.com:5001/connectionlocal";
    }

    static String getKeyStore(){
        if(System.getenv("KEYSTORE")!=null){
            return System.getenv("KEYSTORE");
        }
        return "target/certificados/ecikeystore.p12";
    }

    static String getOtherKeyStore(){
        if(System.getenv("KEYSTORE")!=null){
            return System.getenv("KEYSTORE");
        }
        return "target/certificados/ecikeystore1.p12";
    }

    static String getPwdKeyStore(){
        if(System.getenv("PWDKEYSTORE")!=null){
            return System.getenv("PWDKEYSTORE");
        }
        return "judibec";
    }
//keytool -genkeypair -alias ecikeypair -keyalg RSA -keysize 2048 -storetype PKCS12 -keystore ecikeystore.p12 -validity 3650
}
