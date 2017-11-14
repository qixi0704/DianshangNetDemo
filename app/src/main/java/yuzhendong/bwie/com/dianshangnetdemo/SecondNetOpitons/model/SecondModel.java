package yuzhendong.bwie.com.dianshangnetdemo.SecondNetOpitons.model;



import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import yuzhendong.bwie.com.dianshangnetdemo.FirstNetOpitons.bean.Bean;
import yuzhendong.bwie.com.dianshangnetdemo.FirstNetOpitons.model.OnRequestListener;
import yuzhendong.bwie.com.dianshangnetdemo.SecondNetOpitons.bean.MyDataBean;
import yuzhendong.bwie.com.dianshangnetdemo.SecondNetOpitons.contract.Contract;
import yuzhendong.bwie.com.dianshangnetdemo.SecondNetOpitons.contract.OnRequest2Listener;
import yuzhendong.bwie.com.dianshangnetdemo.utils.Api;
import yuzhendong.bwie.com.dianshangnetdemo.utils.ApiServise;


/**
 * Created by Administrator on 2017/11/9.
 */

public class SecondModel implements Contract.IdataModel{

    @Override
    public void getData(String url, OnRequest2Listener onRequest2Listener) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.First)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();


        ApiServise apiServise = retrofit.create(ApiServise.class);

        Observable<MyDataBean> getMyDataresugar = apiServise.getMyDataresugar();
        getMyDataresugar.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MyDataBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(MyDataBean myDataBean) {
                        List<MyDataBean.DataBean> beanlist = myDataBean.getData();
                        onRequest2Listener.OnSuccess(beanlist);
                    }
                });
    }
}
