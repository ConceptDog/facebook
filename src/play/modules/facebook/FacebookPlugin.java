package play.modules.facebook;

import play.PlayPlugin;
import play.mvc.Http;
import play.mvc.Router;

public class FacebookPlugin extends PlayPlugin {
  private ThreadLocal<FacebookSession> session_;
  private static ThreadLocal<FacebookSettings> settings_;


  @Override
  public boolean rawInvocation(Http.Request request, Http.Response response) throws Exception {
    return super.rawInvocation(request, response);    //To change body of overridden methods use File | Settings | File Templates.
  }

  @Override
  public void onApplicationStart() {
    settings_ = new ThreadLocal<FacebookSettings>();
    FacebookSettings settings = new FacebookSettings();
    settings.init();
    settings_.set( new FacebookSettings() );
  }

  @Override
  public void onRoutesLoaded(){
    Router.addRoute("*", "/auth/callback", "Facebook.callback" );
  }

}
