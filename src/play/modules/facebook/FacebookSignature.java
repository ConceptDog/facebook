package play.modules.facebook;

import play.Logger;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class FacebookSignature {

  private String hash;
  private static MessageDigest encoder = null;

  private FacebookSignature( String hash ){

  }

  public static FacebookSignature init( String data, String key ){
    generateEncoder();
  }

  public static FacebookSignature init( String hash ){
    generateEncoder();
  }

  private static boolean generateEncoder(){
    if( encoder == null ){
      try {
        encoder = MessageDigest.getInstance( FacebookPlugin.JAVA_CRYPTO_TYPE );
      } catch( NoSuchAlgorithmException e ){
        Logger.error("HMAC-256 Not available in this JRE. Facebook signed request will not be authenticated.");
        encoder = null;
        return false;
      }
    }

    return true;
  }
}
