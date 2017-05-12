package ren.test.realnews.http.api;

import java.util.Map;

import ren.test.realnews.beans.ResultBean;
import ren.test.realnews.beans.YiYuanResultBean;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by Administrator on 2017/5/12
 */

public interface HttpApi {
    @Headers("Authorization:APPCODE 9c85f51a00bb4985a9d1dd99062afe3e")
    @GET("index")
    Observable<ResultBean> getAllNews(@Query("type") String type);

    @GET("170-47")
    Observable<YiYuanResultBean> getLocalNews(@QueryMap Map<String, String> map);
}
