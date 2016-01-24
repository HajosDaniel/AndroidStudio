package hajos.jackthebusch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Daniel Hajos on 29.12.2015.
 */

public class TabBio extends Fragment {
    private Button btt_Post;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        btt_Post = (Button) getActivity().findViewById(R.id.bttPost);

        btt_Post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), WallEintrag.class));
            }
        });
       return inflater.inflate(R.layout.tab_bio, container, false);
    }

}