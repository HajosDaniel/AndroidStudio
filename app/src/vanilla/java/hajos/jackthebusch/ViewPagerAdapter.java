package hajos.jackthebusch;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Daniel Hajos on 29.12.2015.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    int numOfTabs;

    public ViewPagerAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numOfTabs = numOfTabs;
    }


    @Override
    public Fragment getItem(int position) {
        if(position == 0) {
            return new TabBio();
        }
        else if(position == 1)
            return new TabWall();

        else if(position == 2)
            return new TabAuf();

        else 
            return new TabSoc();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return super.getPageTitle(position);
    }

    @Override
    public int getCount() {
        return 4;
    }

}