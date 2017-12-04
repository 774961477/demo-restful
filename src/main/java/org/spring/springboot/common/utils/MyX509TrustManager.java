package org.spring.springboot.common.utils;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.TrustManager;


public class MyX509TrustManager implements TrustManager {
	public void checkClientTrusted(X509Certificate[] chain, String authType)  
            throws CertificateException {  
    }  
  
    public void checkServerTrusted(X509Certificate[] chain, String authType)  
            throws CertificateException {  
    }  
  
    public X509Certificate[] getAcceptedIssuers() {  
        return null;  
    }  
}
