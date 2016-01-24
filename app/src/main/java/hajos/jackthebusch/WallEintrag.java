package hajos.jackthebusch;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseObject;

/**
 * Created by Daniel Hajos on 02.01.2016.
 */
public class WallEintrag extends Activity {
    private Button btt_Post;
    private EditText txtName;
    private EditText txtNachricht;
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.new_wall);

        btt_Post = (Button) findViewById(R.id.bttSubmit);
        txtName = (EditText) findViewById(R.id.editTextName);
        txtNachricht = (EditText) findViewById(R.id.editTextNachricht);

        btt_Post.setText("Posten");
        btt_Post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtName == null && txtName == null){
                    Toast.makeText(getApplicationContext(), "Bitte einen Namen und eine Nachricht eingeben", Toast.LENGTH_LONG).show();
                }
                else if(txtName == null){
                    Toast.makeText(getApplicationContext(), "Bitte einen Namen eingeben", Toast.LENGTH_LONG).show();
                }
                else if(txtNachricht == null){
                    Toast.makeText(getApplicationContext(), "Bitte eine Nachricht eingeben", Toast.LENGTH_LONG).show();
                }
                ParseObject eintrag = new ParseObject("Gaestebuch");
                eintrag.put("Name", txtName);
                eintrag.put("Nachricht", txtNachricht);
                eintrag.saveInBackground();
                NavUtils.navigateUpFromSameTask(WallEintrag.this);
            }
        });
    }
}
