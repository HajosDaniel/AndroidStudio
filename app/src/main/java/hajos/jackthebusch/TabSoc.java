package hajos.jackthebusch;

import android.content.Context;
import android.content.Intent;
import android.hardware.display.DisplayManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;

/**
 * Created by Daniel Hajos on 29.12.2015.
 */

public class TabSoc extends Fragment {
    private Button btt_Facebook;
    private Button btt_Instagram;
    private Button btt_Youtube;
    private Button btt_Tunes;
    private Button btt_Home;
    private Button btt_Mail;
    private Button btt_Post;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.tab_social, container, false);
        btt_Facebook = (Button) view.findViewById(R.id.bttFB);
        btt_Instagram = (Button) view.findViewById(R.id.bttInsta);
        btt_Youtube = (Button) view.findViewById(R.id.bttYT);
        btt_Tunes = (Button) view.findViewById(R.id.bttTunes);
        btt_Home = (Button) view.findViewById(R.id.bttHome);
        btt_Mail = (Button) view.findViewById(R.id.bttMail);
        btt_Post = (Button) getActivity().findViewById(R.id.bttPost);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager wm = (WindowManager) getActivity().getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(displayMetrics);
        int screenHeight = displayMetrics.heightPixels;
        int screenWidth  = displayMetrics.widthPixels;

        RelativeLayout.LayoutParams paramsBttF = (RelativeLayout.LayoutParams) btt_Facebook.getLayoutParams();
        paramsBttF.height = (int) (screenHeight * 0.05);
        paramsBttF.width  = (int) (screenWidth  * 0.05);
        btt_Facebook.requestLayout();

        RelativeLayout.LayoutParams paramsBttI = (RelativeLayout.LayoutParams) btt_Instagram.getLayoutParams();
        paramsBttI.height = (int) (screenHeight * 0.1);
        paramsBttI.width  = (int) (screenWidth  * 0.1);
        btt_Instagram.requestLayout();

        RelativeLayout.LayoutParams paramsBttY = (RelativeLayout.LayoutParams) btt_Youtube.getLayoutParams();
        paramsBttY.height = (int) (screenHeight * 0.1);
        paramsBttY.width  = (int) (screenWidth  * 0.3);
        btt_Youtube.requestLayout();

        RelativeLayout.LayoutParams paramsBttT = (RelativeLayout.LayoutParams) btt_Tunes.getLayoutParams();
        paramsBttT.height = (int) (screenHeight * 0.1);
        paramsBttT.width  = (int) (screenWidth  * 0.3);
        btt_Tunes.requestLayout();

        RelativeLayout.LayoutParams paramsBttH = (RelativeLayout.LayoutParams) btt_Home.getLayoutParams();
        paramsBttH.height = (int) (screenHeight * 0.15);
        paramsBttH.width  = (int) (screenWidth  * 0.15);
        btt_Home.requestLayout();

        btt_Post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), WallEintrag.class));
            }
        });

        btt_Mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), BttMail.class));
            }
        });

        btt_Facebook.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.facebook.com/JACKtheBUSCH-158827090847219/?fref=ts")));
            }
        });

        btt_Instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://ink361.com/app/users/ig-1578826598/jakobbusch/photos")));
            }
        });

        btt_Youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.youtube.com/channel/UCXxv08CVwveYFVCI6ReQ8VA")));
            }
        });

        btt_Tunes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.apple.com/itunes/")));
            }
        });

        btt_Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://www.jackthebusch.com/")));
            }
        });

        return view;
    }
}