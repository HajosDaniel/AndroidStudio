package hajos.jackthebusch;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseObject;
import com.parse.ParseUser;


public class StarterApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();

    // Enable Local Datastore.
    Parse.enableLocalDatastore(this);

    // Add subclasses
    ParseObject.registerSubclass(TableAuf.class);
    ParseObject.registerSubclass(TableWall.class);
    
    // Add your initialization code here
    Parse.initialize(this, "4Uh1vgzx5fpWBzhGxsvMUw3otIDVnpjQT6Bqaz4n", "J7NeSjl4SydHPcaZh6O6DUwoB18inC5ni9qp7LmB");

    ParseUser.enableAutomaticUser();
    ParseACL defaultACL = new ParseACL();
    // Optionally enable public read access.
    // defaultACL.setPublicReadAccess(true);
    ParseACL.setDefaultACL(defaultACL, true);
  }
}
