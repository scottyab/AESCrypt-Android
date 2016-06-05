package com.scottyab.aescrypt;


import android.content.Context;
import android.content.ContextWrapper;
import android.util.Log;

import java.security.GeneralSecurityException;

public class Crypter extends ContextWrapper{

    private static String staticEncryptedMsg , staticmessageAfterDecrypt;
    String encryptedMsg , messageAfterDecrypt , password;

    public Crypter(Context context) {
        super(context);
        //
//        password = SharedPrefsManager.getDefaults("randomHashCode" , this);
    }

    //this method takes the password from the password variable in this class,
    // which you can initialize from the SharedPrefsManager, a database, network or something else
    public String encryptString (String plainString){

        try {
            encryptedMsg = AESCrypt.encrypt(password, plainString);
        }catch (GeneralSecurityException e){
            //handle error
            Log.d("EncryptionError" , e.toString());
        }

        return encryptedMsg;
    }

    //this method takes the password variable as a parameter given from the user, when
    // he calls the method , and it is static so no need for creating an instance of the class
    public static String encryptString (String plainString , String password){

        try {
            staticEncryptedMsg = AESCrypt.encrypt(password, plainString);
        }catch (GeneralSecurityException e){
            //handle error
            Log.d("EncryptionError" , e.toString());
        }

        return staticEncryptedMsg;
    }


    //this method takes the password from the password variable in this class,
    // which you can initialize from the SharedPrefsManager, a database, network or something else
    public String decryptString (String encryptedString){
        try {
            messageAfterDecrypt = AESCrypt.decrypt(password, encryptedString);
        }catch (GeneralSecurityException e){
            //handle error - could be due to incorrect password or tampered encryptedMsg
            Log.d("DecryptionError" , e.toString());
        }

        return messageAfterDecrypt;
    }

    //this method takes the password variable as a parameter given from the user, when
    // he calls the method , and it is static so no need for creating an instance of the class
    public static String decryptString (String encryptedString , String password){
        try {
            staticmessageAfterDecrypt = AESCrypt.decrypt(password, encryptedString);
        }catch (GeneralSecurityException e){
            //handle error - could be due to incorrect password or tampered encryptedMsg
            Log.d("DecryptionError" , e.toString());
        }

        return staticmessageAfterDecrypt;
    }

}
