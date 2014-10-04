package com.scottyab.aescrypt;

import android.app.Application;
import android.test.ApplicationTestCase;

import java.security.GeneralSecurityException;


/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }


   public void testEncryptDecrypt(){

       String password = "password";
       String message = "hello world";

       if (BuildConfig.DEBUG) {
           AESCrypt.DEBUG_LOG_ENABLED = true;
       }

       String encryptedMsg = null;
       try {
           encryptedMsg = AESCrypt.encrypt(password, message);
       }catch (GeneralSecurityException e){
           fail("error occurred during encrypt");
           e.printStackTrace();
       }

       String messageAfterDecrypt = null;
       try {
           messageAfterDecrypt = AESCrypt.decrypt(password, encryptedMsg);

       }catch (GeneralSecurityException e){
           fail("error occurred during Decrypt");
           e.printStackTrace();
       }

       if (!messageAfterDecrypt.equals(message)){
           fail("messages don't match after encrypt and decrypt");
       }
   }





    public void testEncryt(){

        String password = "password";
        String message = "hello world";

        try {
            String encryptedMsg = AESCrypt.encrypt(password, message);

        }catch (GeneralSecurityException e){
            //handle error

            fail("error occurred during encrypt");
            e.printStackTrace();
        }
    }


    public void testDecrpyt(){

        String password = "password";
        String encryptedMsg = "2B22cS3UC5s35WBihLBo8w==";

        try {

            String messageAfterDecrypt = AESCrypt.decrypt(password, encryptedMsg);

        }catch (GeneralSecurityException e){
            fail("error occurred during Decrypt");
            e.printStackTrace();
        }
    }


}