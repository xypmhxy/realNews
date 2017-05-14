package ren.test.realnews.Application;

import android.app.Application;
import android.util.Log;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;

/**
 * Created by Administrator on 2017/05/14 0014
 *
 */

public class NewsApplication extends Application {
    public  AMapLocationClient mLocationClient;
//    public
//    AMapLocationListener mAMapLocationListener=new AMapLocationListener() {
//        @Override
//        public void onLocationChanged(AMapLocation aMapLocation) {
//            if (aMapLocation != null) {
//                if (aMapLocation.getErrorCode() == 0) {
//                    String provice=aMapLocation.getProvince();
//                    Log.e("aMapLocation",provice);
//                //可在其中解析amapLocation获取相应内容。
//                }else {
//                    //定位失败时，可通过ErrCode（错误码）信息来确定失败的原因，errInfo是错误信息，详见错误码表。
//                    Log.e("AmapError","location Error, ErrCode:"
//                            + aMapLocation.getErrorCode() + ", errInfo:"
//                            + aMapLocation.getErrorInfo());
//                }
//            }
//        }
//    };
    @Override
    public void onCreate() {
        mLocationClient=new AMapLocationClient(this);
        //初始化AMapLocationClientOption对象
        AMapLocationClientOption mLocationOption =new AMapLocationClientOption();
        //设置定位模式为AMapLocationMode.Hight_Accuracy，高精度模式。
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        mLocationOption.setOnceLocation(true);
        mLocationOption.setOnceLocationLatest(true);
        //设置是否返回地址信息（默认返回地址信息）
        mLocationOption.setNeedAddress(true);
        //给定位客户端对象设置定位参数
        mLocationClient.setLocationOption(mLocationOption);
//        mLocationClient.setLocationListener(mAMapLocationListener);
//        //启动定位
//        mLocationClient.startLocation();
        super.onCreate();
    }
}
