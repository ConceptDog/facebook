package controllers;

import play.modules.facebook.FacebookPlugin;
import play.mvc.Before;
import play.mvc.Controller;

public class Facebook extends Controller {

  @Before
  static void createFacebookSession(){
    if( params.get( FacebookPlugin.SESSION_PARAMETER ) != null ){
      session.put( FacebookPlugin.SESSION_KEY, FacebookPlugin.generateSessionFromRequest( params.get( FacebookPlugin.SESSION_PARAMETER ) ) );
    }
  }
}
