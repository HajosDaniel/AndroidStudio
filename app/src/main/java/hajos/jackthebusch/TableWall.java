package hajos.jackthebusch;

import com.parse.ParseClassName;
import com.parse.ParseObject;

/**
 * Created by Daniel Hajos on 27.10.2015.
 */
@ParseClassName("Gaestebuch")
public class TableWall extends ParseObject{

    public String getName(){
        return getString("Name");
    }

    public void setName(String name){
        put("Name", name);
    }

    public String getNachricht(){
        return getString("Nachricht");
    }

    public void setNachricht(String mess){
        put("Nachricht", mess);
    }

    @Override
    public String toString(){

        return getString("Name")  + "\n" + getString("Nachricht");
    }
}
