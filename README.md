AESCrypt-Android
================

Simple API to perform AES encryption on Android with no dependancies. This is the Android counterpart to the [AESCrypt](https://github.com/Gurpartap/aescrypt) library Ruby and [AESCrypt-ObjC](http://github.com/Gurpartap/AESCrypt-ObjC) created by [Gurpartap Singh](https://github.com/Gurpartap).  

For compatiblity with AESCrypt, AESCrypt-Android has the same defaults namely: 

 * 256-bit AES key
 * CBC mode
 * PKCS7Padding
 * Blank/Empty IV (default*)


A blank IV is not the best security but the aim here is compatibility with AESCrypt implementations. See Adv method for providing your own IV.


# Usage

## Encrypt

```java
	String password = "password";
	String message = "hello world";	
	try {
    	String encryptedMsg = AESCrypt.encrypt(password, message);
    }catch (GeneralSecurityException e){
      //handle error
	}
```

## Decrypt

```java
	String password = "password";
    String encryptedMsg = "2B22cS3UC5s35WBihLBo8w==";
	try {
        String messageAfterDecrypt = AESCrypt.decrypt(password, encryptedMsg);
    }catch (GeneralSecurityException e){
	 //handle error - could be due to incorrect password or tampered encryptedMsg
    }
```

## Advanced usage

It's possible to provide your own key, IV. 

`AESCrypt.encrypt(final SecretKeySpec key, final byte[] iv, final byte[] message)`

`AESCrypt.decrypt(final SecretKeySpec key, final byte[] iv, final byte[] decodedCipherText)`


**Note:** for flexiblity these 'adv' methods don't provide BASE64 encoding/decoding.


## Debugging/Logging

To enable logging simple change switch on the logging flag as shown below.   

`AESCrypt.DEBUG_LOG_ENABLED = true;`

*Remember to disble in Live, recommend the below snippet if possible*


```java
if (BuildConfig.DEBUG) {
           AESCrypt.DEBUG_LOG_ENABLED = true;
       }
```
       
       

To be honest it's a strech to call this a library given it's only a single util class, but I created as went through a ton of pain working out the conpatible settings for AESCrypt. I hope this will save some one time in the future. 



## Contributing

I welcome pull requests, issues and feedback.  

- Fork it
- Create your feature branch (git checkout -b my-new-feature)
- Commit your changes (git commit -am 'Added some feature')
- Push to the branch (git push origin my-new-feature)
- Create new Pull Request


#Licence

    Copyright (c) 2014 Scott Alexander-Bown
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
    
        http://www.apache.org/licenses/LICENSE-2.0
    
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.