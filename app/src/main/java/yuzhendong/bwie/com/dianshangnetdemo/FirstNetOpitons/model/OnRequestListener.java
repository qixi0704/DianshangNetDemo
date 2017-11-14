package yuzhendong.bwie.com.dianshangnetdemo.FirstNetOpitons.model;



import java.util.List;

import yuzhendong.bwie.com.dianshangnetdemo.FirstNetOpitons.bean.Bean;


/**
 * Created by Zhang on 2017/11/6.
 */

public interface OnRequestListener {
    void OnSuccess(List<Bean.TuijianBean.ListBean> list);
    void OnError(String e);
}
