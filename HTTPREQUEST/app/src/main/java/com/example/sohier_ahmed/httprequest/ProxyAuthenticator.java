package com.example.sohier_ahmed.httprequest;

/**
 * Created by Sohier_ahmed on 03/10/2017.
 */

import java.net.Authenticator;
import java.net.PasswordAuthentication;

class ProxyAuthenticator extends Authenticator {

    private String user, password;

    public ProxyAuthenticator(String user, String password) {
        this.user = user;
        this.password = password;
    }

    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(user, password.toCharArray());
    }
}