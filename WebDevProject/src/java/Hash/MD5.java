/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hash; //this package name may need to be modified to fit the correct package location in the project

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author tom
 */
public class MD5 {
    
    private String md5pass;
    
    public MD5(String pass) // throws NoSuchAlgorithmException, UnsupportedEncodingException
	// swapped out for internal handling
    {
        try {
		MessageDigest md5 = MessageDigest.getInstance("MD5");
	        md5.update(pass.getBytes("UTF-8"),0,pass.length());
        	md5pass = new BigInteger(1, md5.digest()).toString(16);
	} catch(NoSuchAlgorithmException nsa) {
		System.err.println("Algorithm doesn't exist. This should never happen because "
			+ "the algorithm is predefinied in the Java library. "
			+ "All hell must have broken loose.");
	} catch(UnsupportedEncodingException uee) { 
		System.err.println("Unsupported Encoding. Some done messed up.");
	}
    }
    
    public String getHash()
    {
        return md5pass;
    }
}
