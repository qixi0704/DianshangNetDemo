package yuzhendong.bwie.com.dianshangnetdemo.utils;

import retrofit2.http.GET;
import rx.Observable;
import yuzhendong.bwie.com.dianshangnetdemo.FirstNetOpitons.bean.Bean;
import yuzhendong.bwie.com.dianshangnetdemo.SecondNetOpitons.bean.MyDataBean;

/**
 * Created by Administrator on 2017/11/9.
 */

public interface ApiServise {
    //首页
    @GET("ad/getAd")
    Observable<Bean> getDatas();
    //一级分类
    @GET("product/getCatagory")
    Observable<MyDataBean> getMyDataresugar();
//    //二级
//    @GET("product/getProductCatagory")
//    Observable<MyRigthBean> getMyRight();
//    //商品详情
//    @GET("product/getProductDetail?pid=1")
//    Observable<MyDetails> getDetails();


}
