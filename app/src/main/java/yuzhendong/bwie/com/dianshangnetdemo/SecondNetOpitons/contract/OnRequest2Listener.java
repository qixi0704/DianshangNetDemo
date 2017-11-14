package yuzhendong.bwie.com.dianshangnetdemo.SecondNetOpitons.contract;

import java.util.List;

import yuzhendong.bwie.com.dianshangnetdemo.SecondNetOpitons.bean.MyDataBean;

/**
 * Created by Administrator on 2017/11/9.
 */

public interface OnRequest2Listener {
    void OnSuccess(List<MyDataBean.DataBean> beanlist);
    void OnError(String e);
}
