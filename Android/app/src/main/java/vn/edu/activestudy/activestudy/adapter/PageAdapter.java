package vn.edu.activestudy.activestudy.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import vn.edu.activestudy.activestudy.view.fragment.*;
import com.astuetz.PagerSlidingTabStrip;

import vn.edu.activestudy.activestudy.R;

/**
 * Created by Administrator on 30/08/2015.
 */
public class PageAdapter extends FragmentPagerAdapter implements PagerSlidingTabStrip.IconTabProvider {
    final int PAGE_COUNT = 5;
    private String[] tabs = {"Top Rated", "Games", "Movies"};
    private int tabIcons[] = {R.drawable.course, R.drawable.classroom, R.drawable.chat, R.drawable.contact, R.drawable.more};
    Context context;

    public PageAdapter(FragmentManager fm, Context context) {

        super(fm);
        this.context = context;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
//        return HomeFragment.newInstance(position + 1);
        switch (position) {
            case 0:
                // Top Rated fragment activity
                return new CourseFragment();
            case 1:
                // Games fragment activity
                return new ClassFragment();
            case 2:
                // Movies fragment activity
                return new ChatFragment();
            case 3:
                // Movies fragment activity
                return new ContactFragment();
            case 4:
                // Movies fragment activity
                return new MoreFragment();
        }

        return null;

//        return new HomeFragment();

    }

    @Override
    public int getPageIconResId(int i) {
        return tabIcons[i];
    }


//    @Override
//    public CharSequence getPageTitle(int position) {
//        // Generate title based on item position
////        return tabTitles[position];
//        return tabs[position];
//    }
}
