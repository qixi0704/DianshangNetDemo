package yuzhendong.bwie.com.dianshangnetdemo.FirstNetOpitons.model;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import yuzhendong.bwie.com.dianshangnetdemo.FirstNetOpitons.bean.Bean;
import yuzhendong.bwie.com.dianshangnetdemo.FirstNetOpitons.contract.Contract;
import yuzhendong.bwie.com.dianshangnetdemo.utils.Api;
import yuzhendong.bwie.com.dianshangnetdemo.utils.ApiServise;

/**
 * Created by Administrator on 2017/11/9.
 */

public class Model implements Contract.Imodel {
    @Override
    public void getData(String url, OnRequestListener onRequestListener) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.First)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();


        ApiServise apiServise = retrofit.create(ApiServise.class);

        Observable<Bean> getDatas = apiServise.getDatas();


        getDatas.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Bean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Bean bean) {
                        List<Bean.TuijianBean.ListBean> list = bean.getTuijian().getList();
                        onRequestListener.OnSuccess(list);
                    }
                });


    }
}
