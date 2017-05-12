package ren.test.realnews.http;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/12
 */

public class HttpConfig {
    public static final String BASE_URL = "http://toutiao-ali.juheapi.com/toutiao/";
    public static final String LOCAL_NEWS_BASE_URL = "http://route.showapi.com/";
    private static final Map<String, String> baseMap = new HashMap<>();

    public static Map<String, String> getBaseMap() {
        baseMap.put("showapi_appid", "38042");
        baseMap.put("showapi_sign", "7b7a4f4290df4e0cafef177585a8c6b0");
        return baseMap;
    }
}
