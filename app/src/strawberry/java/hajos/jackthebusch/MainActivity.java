package hajos.jackthebusch;



import android.os.Bundle;
import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import java.lang.Override;

/**
 * Created by Daniel Hajos on 31.01.2016.
 */
public class MainActivity extends FragmentActivity {
    ViewPager tab;
    TabPagerAdapter tabAdapter;
    ActionBar actionBar;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabAdapter = new TabPagerAdapter(getSupportFragmentManager());
        tab = (ViewPager) findViewById(R.id.viewpager);
        tab.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                actionBar = getActionBar();
                actionBar.setSelectedNavigationItem(position);
            }
        });
        tab.setAdapter(tabAdapter);

        actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        ActionBar.TabListener tabListener = new ActionBar.TabListener(){
            @Override
            public void onTabReselected(android.app.ActionBar.Tab tabA, FragmentTransaction ft){

            }
             @Override
            public void onTabSelected(ActionBar.Tab tabA, FragmentTransaction ft){
                 tab.setCurrentItem(tabA.getPosition());
             }

            @Override
            public void onTabUnselected(android.app.ActionBar.Tab tab, FragmentTransaction ft){

            }
        };
        actionBar.addTab(actionBar.newTab().setText("Bio").setTabListener(tabListener));
        actionBar.addTab(actionBar.newTab().setText("Fan Wall").setTabListener(tabListener));
        actionBar.addTab(actionBar.newTab().setText("Auftritte").setTabListener(tabListener));
        actionBar.addTab(actionBar.newTab().setText("Social Media").setTabListener(tabListener));
    }
}
