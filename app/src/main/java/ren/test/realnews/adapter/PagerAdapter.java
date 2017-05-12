package ren.test.realnews.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import ren.test.realnews.beans.NewsType;

/**
 * Created by Administrator on 2017/5/12
 */

public class PagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;
    private List<NewsType> types;

    public PagerAdapter(FragmentManager fm, List<Fragment> fragments, List<NewsType> types) {
        super(fm);
        this.fragments = fragments;
        this.types = types;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return types.get(position).getTittle();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        super.destroyItem(container, position, object);
    }

}
