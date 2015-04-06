/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.hash;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author tom
 */
public class MD5 {
    
    private final String md5pass;
    
    public MD5(String pass) throws NoSuchAlgorithmException, UnsupportedEncodingException
    {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(pass.getBytes("UTF-8"),0,pass.length());
        md5pass = new BigInteger(1, md5.digest()).toString(16);
    }
    
    public String getHash()
    {
        return md5pass;
    }
}
