package hajos.jackthebusch;

import com.parse.ParseClassName;
import com.parse.ParseObject;

/**
 * Created by Daniel Hajos on 27.10.2015.
 */
@ParseClassName("Auftritte")
public class TableAuf extends ParseObject{

    public String getName(){
        return getString("Name");
    }

    public void setName(String name){
        put("Name", name);
    }

    public String getJahr(){
        return getString("Jahr");
    }

    public void setJahr(String jahr){
        put("Jahr", jahr);
    }

    public String getMonat(){
        return getString("Monat");
    }

    public void setMonat(String monat){
        put("Monat", monat);
    }

    public String getMonat2(){
        return getString("Monat_ausgeschrieben");
    }

    public void setMonat2(String monat2){
        put("Monat_ausgeschrieben", monat2);
    }

    public String getTag(){
        return getString("Tag");
    }

    public void setTag(String tag){
        put("Tag", tag);
    }

    public String getZeit(){
        return getString("Zeit");
    }

    public void setZeit(String zeit){
        put("Zeit", zeit);
    }

    public String getOrt(){
        return getString("Ort");
    }

    public void setOrt(String ort){
        put("Ort", ort);
    }

    public String getAdresse(){
        return getString("Adresse");
    }

    public void setAdresse(String addresse){
        put("Adresse", addresse);
    }

    @Override
    public String toString(){
        return getString("Name")  + "\n" +
                (getString("Ort") + ", " + getString("Adresse") + "\n" +
                (getString("Tag") + "." + getString("Monat_ausgeschrieben") + "." + getString("Jahr") + " | " + getString("Zeit")));
    }
}
