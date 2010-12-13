package play.modules.facebook;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.codec.binary.Base64;
import play.exceptions.UnexpectedException;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class FacebookSession {
  private Map<String, String> sessionData_;

  public void initRequest( String signedRequest, String applicationSecret ){
    String[] pieces = signedRequest.split( "\\." );
    Type dictionaryType = new TypeToken<HashMap<String, String>>() {}.getType();
    Gson gson = new Gson();


    if( pieces.length != 2 ){
      throw new UnexpectedException( "signedRequest doesn't split into the correct number of chunks" );
    }



    sessionData_ = gson.fromJson( decodeBase64URL( pieces[1] ), dictionaryType );
  }

  public static String decodeBase64URL( String rawInput ){
    String processedInput = rawInput.replace( '-', '+' ).replace( '_', '+' );
    Base64 base64Decoder = new Base64();

    return new String( base64Decoder.decode( processedInput ) );
  }
}
