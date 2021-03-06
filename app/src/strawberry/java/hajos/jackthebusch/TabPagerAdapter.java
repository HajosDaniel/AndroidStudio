package hajos.jackthebusch;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class TabPagerAdapter extends FragmentStatePagerAdapter {

    public TabPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i){
        switch (i) {
            case 0:
                return new TabBio();
            case 1:
                return new TabWall();
            case 2:
                return new TabAuf();
            case 3:
                return new TabSoc();
        }
        return null;
    }

    @Override
    public int getCount(){
        return 3;
    }
}

