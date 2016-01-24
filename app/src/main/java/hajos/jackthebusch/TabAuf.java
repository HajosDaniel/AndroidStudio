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

public class TabAuf extends Fragment {
    private Button btt_Post;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.tab_auf, container, false);
        final LinearLayout lin = (LinearLayout) view.findViewById(R.id.linLayout);
        btt_Post = (Button) getActivity().findViewById(R.id.bttPost);

        btt_Post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), WallEintrag.class));
            }
        });

        ParseQuery<TableAuf> query = new ParseQuery<>("Auftritte");
        query.findInBackground(new FindCallback<TableAuf>() {
            @Override
            public void done(List<TableAuf> list, ParseException e) {
                if (e != null) {
                    Toast.makeText(getActivity(), "Error " + e, Toast.LENGTH_SHORT).show();
                }
                int counter = 0;
                String[] namen = new String[list.size()];
                String[] adresse = new String[list.size()];
                String[] datum = new String[list.size()];
                for (TableAuf post : list) {
                    TableAuf newPost = new TableAuf();
                    newPost.setName(post.getName());
                    newPost.setJahr(post.getJahr());
                    newPost.setMonat(post.getMonat());
                    newPost.setMonat2(post.getMonat2());
                    newPost.setTag(post.getTag());
                    newPost.setZeit(post.getZeit());
                    newPost.setOrt(post.getOrt());
                    newPost.setAdresse(post.getAdresse());

                    namen[counter] = post.getName();
                    adresse[counter] = post.getOrt() + ", " + post.getAdresse();
                    datum[counter] = post.getTag() + "." + post.getMonat2() + "." + post.getJahr() + " | " + post.getZeit();
                    counter++;
                }
                int i;
                Collections.reverse(Arrays.asList(namen));
                Collections.reverse(Arrays.asList(adresse));
                Collections.reverse(Arrays.asList(datum));
                for (i = 0; i < namen.length; i++){
                    TextView txtName = new TextView(view.getContext());
                    TextView txtAdresse = new TextView(view.getContext());
                    TextView txtDatum = new TextView(view.getContext());

                    txtName.setTypeface(null, Typeface.BOLD);
                    txtName.setTextSize(20);

                    txtName.setText(namen[i]);
                    txtAdresse.setText(adresse[i]);
                    txtDatum.setText(datum[i]);

                    lin.addView(txtName);
                    lin.addView(txtAdresse);
                    lin.addView(txtDatum);
                }
            }
        });
        return view;
    }
}