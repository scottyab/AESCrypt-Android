package com.scottyab.aescrypt;


import android.content.Context;
import android.content.ContextWrapper;
import android.util.Log;

import java.security.GeneralSecurityException;

public class Crypter extends ContextWrapper{

    String encryptedMsg , messageAfterDecrypt , password;

    public Crypter(Context context) {
        super(context);
        password = SharedPrefsManager.getDefaults("randomHashCode" , this);
    }

    public String encryptString (String plainString){

        try {
            encryptedMsg = AESCrypt.encrypt(password, plainString);
        }catch (GeneralSecurityException e){
            //handle error
            Log.d("EncryptionError" , e.toString());
        }

        return encryptedMsg;
    }

    public String decryptString (String encryptedString){
        try {
            messageAfterDecrypt = AESCrypt.decrypt(password, encryptedString);
        }catch (GeneralSecurityException e){
            //handle error - could be due to incorrect password or tampered encryptedMsg
            Log.d("DecryptionError" , e.toString());
        }

        return messageAfterDecrypt;
    }

}
