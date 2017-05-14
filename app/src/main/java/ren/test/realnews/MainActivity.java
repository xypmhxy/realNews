package ren.test.realnews;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationListener;
import com.astuetz.PagerSlidingTabStrip;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ren.test.realnews.Application.NewsApplication;
import ren.test.realnews.RxJavaAdapter.RxJavaCallAdapterFactory;
import ren.test.realnews.adapter.PagerAdapter;
import ren.test.realnews.beans.NewsType;
import ren.test.realnews.beans.YiYuanResultBean;
import ren.test.realnews.fragment.FragmentLocalNews;
import ren.test.realnews.fragment.FragmentNews;
import ren.test.realnews.http.HttpConfig;
import ren.test.realnews.http.api.HttpApi;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements AMapLocationListener{

    private ViewPager viewPager;
    private PagerSlidingTabStrip tabStrip;
    private String type[] =
            {
                    "top", "shehui", "guonei", "guoji", "yule", "tiyu", "junshi", "keji", "caijing", "shishang"
            };
    private String typeCN[] =
            {
                    "头条", "社会", "国内", "国际", "娱乐", "体育", "军事", "科技", "财经", "时尚"
            };
    private List<NewsType> types = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NewsApplication application= (NewsApplication) getApplication();
        application.mLocationClient.setLocationListener(this);
        application.mLocationClient.startLocation();
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabStrip = (PagerSlidingTabStrip) findViewById(R.id.pagerStrip);
        tabStrip.setIndicatorColor(Color.parseColor("#000000"));
        tabStrip.setDividerColor(Color.TRANSPARENT);
        tabStrip.setUnderlineColor(Color.TRANSPARENT);
        tabStrip.setIndicatorHeight(5);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==KeyEvent.KEYCODE_BACK){
            moveTaskToBack(true);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onLocationChanged(AMapLocation aMapLocation) {
        for (int i = 0; i < 11; i++) {
            NewsType newsType ;
            if (i == 0) {
                newsType = new NewsType("四川", "四川");
            } else {
                newsType = new NewsType(type[i - 1], typeCN[i - 1]);
            }
            types.add(newsType);
        }
        if (aMapLocation!=null&&aMapLocation.getErrorCode()==0){
            String province=aMapLocation.getProvince();
            if (province.length()>=3)
                province= province.substring(0,2);
            types.get(0).setTittle(province);
            types.get(0).setType(province);
        }
        List<Fragment> list = new ArrayList<>();
        for (int i = 0; i < type.length; i++) {
            Fragment fragment;
            if (i == 0)
                fragment = new FragmentLocalNews();
            else
                fragment = new FragmentNews();
            Bundle bundle = new Bundle();
            bundle.putString(FragmentNews.KEY_TITTLE, types.get(i).getType());
            fragment.setArguments(bundle);
            list.add(fragment);
        }
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(), list, types);
        viewPager.setAdapter(pagerAdapter);
        tabStrip.setViewPager(viewPager);
    }
}
