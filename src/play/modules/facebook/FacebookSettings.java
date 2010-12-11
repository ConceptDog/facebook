package play.modules.facebook;

import play.Play;
import play.exceptions.UnexpectedException;
import java.net.MalformedURLException;
import java.net.URL;


public class FacebookSettings {

  private String id;
  private String apiKey;
  private String secret;
  private URL postAuthURL;

  public String getId() {
    return id;
  }

  public String getApiKey() {
    return apiKey;
  }

  public String getSecret() {
    return secret;
  }

  public String getPostAuthURL() {
    return postAuthURL.toString();
  }

  public void init() {
    if( !Play.configuration.containsKey( "facebook.id" ) ){
      throw new UnexpectedException("Module facebook requires that you specify facebook.id in your application.conf");
    }

    if( !Play.configuration.containsKey( "facebook.apiKey" ) ){
      throw new UnexpectedException("Module facebook requires that you specify facebook.apiKey in your application.conf");
    }

    if( !Play.configuration.containsKey( "facebook.secret" ) ){
      throw new UnexpectedException("Module facebook requires that you specify facebook.secret in your application.conf");
    }

    if( !Play.configuration.containsKey( "facebook.postAuthURL" ) ){
      throw new UnexpectedException("Module facebook requires that you specify facebook.postAuthURL in your application.conf");
    }

    id = Play.configuration.getProperty( "facebook.id" );
    apiKey = Play.configuration.getProperty( "facebook.apiKey" );
    secret = Play.configuration.getProperty( "facebook.secret" );

    try{
      postAuthURL = new URL( Play.configuration.getProperty( "facebook.postAuthURL" ) );
    } catch( MalformedURLException e ){
      throw new UnexpectedException( "Module facebook requires a properly formed URL for facebook.postAuthURL" );
    }
  }
}
