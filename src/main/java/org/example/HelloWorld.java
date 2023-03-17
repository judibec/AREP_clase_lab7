package org.example;

import static spark.Spark.*;
public class HelloWorld {
    public static void main(String[] args) {
        //API: secure(keystoreFilePath, keystorePassword, truststoreFilePath, truststorePassword);
        secure(getKeyStore(), getPwdKeyStore(), null, null);
        port(getPort());
        get("/hello", (req, res) -> "Hello World");
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5000; //returns default port if heroku-port isn't set (i.e. on localhost)
    }

    static String getKeyStore(){
        if(System.getenv("KEYSTORE")!=null){
            return System.getenv("KEYSTORE");
        }
        return "certificados/ecikeystore.p12";
    }

    static String getPwdKeyStore(){
        if(System.getenv("PWDKEYSTORE")!=null){
            return System.getenv("PWDKEYSTORE");
        }
        return "judibec";
    }
//keytool -genkeypair -alias ecikeypair -keyalg RSA -keysize 2048 -storetype PKCS12 -keystore ecikeystore.p12 -validity 3650
}
