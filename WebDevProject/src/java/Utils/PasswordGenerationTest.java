/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hash;

/**
 *
 * @author tom
 */
public class PasswordGenerationTest {
    
    public static void main(String[] args) {
        String pass = "abc123'";
        
        MD5 hasher = new MD5(pass);
        
        String hash = hasher.getHash();
        
        System.out.println(hash);
    }
}
