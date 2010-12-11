package play.modules.facebook;

import org.apache.commons.codec.binary.Base64;
import play.exceptions.UnexpectedException;

import java.util.Dictionary;

public class FacebookSession {
  private Dictionary<String, String> sessionData_;

  public void initRequest( String signedRequest, String applicationSecret ){
    String[] pieces = signedRequest.split( "." );

    if( pieces.length != 2 ){
      throw new UnexpectedException( "signedRequest doesn't split into the correct number of chunks" );
    }

  }

  private String decodeBase64URL( String rawInput ){
    String processedInput = rawInput.replace( '-', '+' ).replace( '_', '+' );
    Base64 base64Decoder = new Base64();

    return new String( base64Decoder.decode( processedInput ) );
  }
}
