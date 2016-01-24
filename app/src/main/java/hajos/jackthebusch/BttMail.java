package hajos.jackthebusch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Daniel Hajos on 02.01.2016.
 */
public class BttMail extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"jackthebusch@gmx.at"});
        emailIntent.setType("message/rfc822");
        startActivity(Intent.createChooser(emailIntent, "Bitte Email Client wählen :"));
    }
}
