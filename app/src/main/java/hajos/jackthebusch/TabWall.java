package hajos.jackthebusch;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * Created by Daniel Hajos on 29.12.2015.
 */

public class TabWall extends Fragment {
    private Button btt_Post;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.tab_wall, container, false);
        final LinearLayout lin = (LinearLayout) view.findViewById(R.id.linLayout);
        btt_Post = (Button) getActivity().findViewById(R.id.bttPost);

        btt_Post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), WallEintrag.class));
            }
        });

        ParseQuery<TableWall> query = new ParseQuery<>("Gaestebuch");
        query.findInBackground(new FindCallback<TableWall>() {
            @Override
            public void done(List<TableWall> list, ParseException e) {
                if (e != null) {
                    Toast.makeText(getActivity(), "Error " + e, Toast.LENGTH_SHORT).show();
                }
                int counter = 0;
                String[] namen = new String[list.size()];
                String[] nachrichten = new String[list.size()];
                for (TableWall post : list) {
                    TableWall newPost = new TableWall();
                    newPost.setName(post.getName());
                    newPost.setNachricht(post.getNachricht());

                    namen[counter] = post.getName();
                    nachrichten[counter] = post.getNachricht();
                    counter++;
                }
                int i;
                Collections.reverse(Arrays.asList(namen));
                Collections.reverse(Arrays.asList(nachrichten));
                for (i = 0; i < namen.length; i++){
                    TextView txtName = new TextView(view.getContext());
                    TextView txtNachricht = new TextView(view.getContext());

                    txtName.setTypeface(null, Typeface.BOLD);
                    txtName.setTextSize(20);

                    txtNachricht.setTextSize(15);
                    txtNachricht.setPadding(0, 0, 0, 10);

                    txtName.setText(namen[i]);
                    txtNachricht.setText(nachrichten[i]);

                    lin.addView(txtName);
                    lin.addView(txtNachricht);
                }
            }
        });

        return view;
    }
}
