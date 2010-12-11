package controllers;

import play.mvc.*;

public class Application extends Controller {

    public static void index() {
		//System.out.println(request.params.all().toString() );
		  System.out.println("\n" + params.toString() + "\n" );
      params.checkAndParse();
      System.out.println("\n" + params.toString() + "\n");
      render();
    }

}