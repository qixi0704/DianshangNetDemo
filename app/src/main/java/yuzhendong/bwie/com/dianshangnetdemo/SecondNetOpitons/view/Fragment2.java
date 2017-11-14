package yuzhendong.bwie.com.dianshangnetdemo.SecondNetOpitons.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import yuzhendong.bwie.com.dianshangnetdemo.FirstNetOpitons.bean.Bean;
import yuzhendong.bwie.com.dianshangnetdemo.R;
import yuzhendong.bwie.com.dianshangnetdemo.SecondNetOpitons.adapter.Myadapter2;
import yuzhendong.bwie.com.dianshangnetdemo.SecondNetOpitons.adapter.Myadapter3;
import yuzhendong.bwie.com.dianshangnetdemo.SecondNetOpitons.adapter.OnClickRecyclerListner;
import yuzhendong.bwie.com.dianshangnetdemo.SecondNetOpitons.bean.MyDataBean;
import yuzhendong.bwie.com.dianshangnetdemo.SecondNetOpitons.bean.MyRigthBean;
import yuzhendong.bwie.com.dianshangnetdemo.SecondNetOpitons.contract.Contract;
import yuzhendong.bwie.com.dianshangnetdemo.SecondNetOpitons.contract.OnRequest2Listener;
import yuzhendong.bwie.com.dianshangnetdemo.SecondNetOpitons.presenter.SecondPresenter;
import yuzhendong.bwie.com.dianshangnetdemo.utils.Api;

/**
 * Created by Administrator on 2017/11/8.
 */

public class Fragment2 extends Fragment implements Contract.IdataView,OnRequest2Listener {

    private View v;
    private int sid = 1;
    private ListView lv;
    private Myadapter3 myadapter3;
    private Myadapter2 myadapter2;
    List<MyDataBean.DataBean> beanList = new ArrayList<>();
    List<MyRigthBean.DataBean.ListBean> been = new ArrayList<>();
    private String[] path = {
            "http://img0.imgtn.bdimg.com/it/u=112585749,971980906&fm=27&gp=0.jpg"
            , "http://img.redocn.com/sheji/20151220/maijiusongtaobaolunbohaibaosheji_5623824.jpg"
            , "http://image.tupian114.com/20160909/0429212343.jpg"
            , "http://pic2.cxtuku.com/00/08/84/b801b6adf190.jpg"
    };
    private String url = "http://120.27.23.105/product/getProductCatagory";
    //可见列表项的数量
    private int visibleCount = 0;
    //列表正中 占得条目数
    private int ce = 0;
    //实际列表是否超出屏幕
    private boolean isOut = true;
    List<Bean.DataBean> banner_list = new ArrayList<>();
    private Banner banner;
    private RecyclerView recyclerView2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = View.inflate(getActivity(), R.layout.fragment2,null);

        initview();
        showData();
        playbanner();
       SecondPresenter presenter = new SecondPresenter(this);
        presenter.showData(Api.First);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                been.clear();
                showData();
                myadapter3 = new Myadapter3(getActivity(),been);
                recyclerView2.setAdapter(myadapter3);

                myadapter3.setLisner(new OnClickRecyclerListner() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent intent = new Intent(getActivity(),ShopNetActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {

                    }
                });


                if (visibleCount == 0) {
                    visibleCount = lv.getChildCount();
                    if (visibleCount == beanList.size())
                        isOut = false;
                    else {
                        ce = visibleCount / 2;
                    }
                }


                //如果点击条目高于 此列表的正中 则 列表整体上移 把条目移到此正中
                if (position <= (parent.getFirstVisiblePosition() + ce)) {   //上移
                    lv.smoothScrollToPosition(position - ce);
                }
                //如果点击条目低于 此列表的正中 则 列表整体下移 把此条目移到正中
                else {   //下移
                    if ((parent.getLastVisiblePosition() + ce + 1) <= parent.getCount()) {
                        lv.smoothScrollToPosition(position + ce);
                    }
                    //如果点击条目位于底部 则 列表整不做移动操作
                    else {
                        lv.smoothScrollToPosition(parent.getCount() - 1);
                    }

                }
            }
        });




        return v;
    }
    private void showData() {
        OkHttpClient client = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(url)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                if(response.body() != null && response.isSuccessful()){
                    String string = response.body().string();
                    Gson g = new Gson();
                    MyRigthBean myRigthBean = g.fromJson(string, MyRigthBean.class);
                    been.addAll(myRigthBean.getData().get(0).getList());


                }

            }
        });
    }

    private void initview() {
        lv = (ListView) v.findViewById(R.id.lv);
        banner = (Banner) v.findViewById(R.id.banner);
        recyclerView2 = (RecyclerView) v.findViewById(R.id.recyclerview2);
        GridLayoutManager manager = new GridLayoutManager(getActivity(),3);
        recyclerView2.setLayoutManager(manager);



    }
    private void playbanner() {
        int i = 0;


        List<String> list = new ArrayList<>();
        List<String> blist = new ArrayList<>();

        for (String s : path) {
            list.add(s);
            i++;
            blist.add("");
        }

        banner.setImageLoader(new Mybanner());
        banner.setBannerTitles(blist);
        banner.setImages(list);
        banner.start();
    }

    @Override
    public void OnSuccess(List<MyDataBean.DataBean> beanlist) {

    }

    @Override
    public void OnError(String e) {

    }

    public class Mybanner extends ImageLoader {

        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load(path).into(imageView);

        }
    }
    @Override
    public void setData(List<MyDataBean.DataBean> beanList) {
            myadapter2 = new Myadapter2(getActivity(),beanList);
            lv.setAdapter(myadapter2);
    }

    @Override
    public void setError(String e) {

    }



}
