package ren.test.realnews.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.Map;

import ren.test.realnews.DetailActivity;
import ren.test.realnews.R;
import ren.test.realnews.RxJavaAdapter.RxJavaCallAdapterFactory;
import ren.test.realnews.adapter.ListAdapter;
import ren.test.realnews.adapter.ListAdapterForLocal;
import ren.test.realnews.beans.ResultBean;
import ren.test.realnews.beans.YiYuanResultBean;
import ren.test.realnews.http.HttpConfig;
import ren.test.realnews.http.api.HttpApi;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/5/12
 */

public class FragmentLocalNews extends Fragment implements AdapterView.OnItemClickListener{
    public static final String KEY_TITTLE = "type";
    private ListView listView;
    private String type;
    private ProgressBar progressBar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_news, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        listView = (ListView) view.findViewById(R.id.listview_fragment_news);
        listView.setOnItemClickListener(this);
        progressBar = (ProgressBar) view.findViewById(R.id.progress_fragment_news);
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        if (getArguments() != null && getArguments().getString(KEY_TITTLE) != null)
            type = getArguments().getString(KEY_TITTLE);
        Retrofit retrofit = new Retrofit.Builder().baseUrl(HttpConfig.LOCAL_NEWS_BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create()).build();
        Map<String, String> map = HttpConfig.getBaseMap();
        map.put("areaName", type);
        HttpApi httpApi = retrofit.create(HttpApi.class);
        Observable<YiYuanResultBean> observableLocal = httpApi.getLocalNews(map);
        observableLocal.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<YiYuanResultBean>() {
            @Override
            public void onCompleted() {
                progressBar.setVisibility(View.GONE);
                listView.setVisibility(View.VISIBLE);
                Log.d("rq", "");
            }

            @Override
            public void onError(Throwable throwable) {
                Log.d("rq", "");
            }

            @Override
            public void onNext(YiYuanResultBean resultBean) {
                ListAdapterForLocal adapter = new ListAdapterForLocal(getActivity(), resultBean.getShowapi_res_body().getPagebean().getContentlist());
                listView.setAdapter(adapter);
                Log.d("rq", "");
            }
        });
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ListAdapterForLocal adapter= (ListAdapterForLocal) listView.getAdapter();
        Intent intent=new Intent(getActivity(), DetailActivity.class);
        intent.putExtra("url",adapter.getItem(position).getLink());
        getActivity().startActivity(intent);
    }
}
