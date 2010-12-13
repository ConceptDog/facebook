package play.modules.facebook;

import play.PlayPlugin;
import play.mvc.Router;

public class FacebookPlugin extends PlayPlugin {

  public int index = 99;
  private static ThreadLocal<FacebookSettings> settings_;
  public static final String SESSION_PARAMETER = "signed_request";
  public static final String SESSION_KEY = "facebook_session";

  // This doesn't work. Unfortunately the request is available here, but not inside the params element for some reason.
  /* @Override
  public boolean rawInvocation(Http.Request request, Http.Response response) throws Exception {
    String facebookParameter;
    FacebookSession session;
    boolean handled = false;

    System.out.println( "Raw Invocation Fired." );
    request.params.checkAndParse();

    if( request.params._contains( SESSION_PARAMETER ) ){
      facebookParameter = request.params.get( SESSION_PARAMETER );
      session = new FacebookSession();
      session.initRequest( facebookParameter, settings_.get().getSecret() );
      handled = true;
    }

    return handled;
  }*/

  @Override
  public void onApplicationStart() {
    settings_ = new ThreadLocal<FacebookSettings>();
    FacebookSettings settings = new FacebookSettings();
    settings.init();
    settings_.set( new FacebookSettings() );
    System.out.println( "Facebook Module Started" );
  }

  @Override
  public void onRoutesLoaded(){
    Router.addRoute("*", "/auth/callback", "Facebook.callback" );
  }

  public static FacebookSession generateSessionFromRequest( String signedRequest ){
    FacebookSession session = new FacebookSession();
    session.initRequest( signedRequest, settings_.get().getSecret() );
    return session;
  }
}
