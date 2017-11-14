package yuzhendong.bwie.com.dianshangnetdemo.FirstNetOpitons.contract;

import java.util.List;

import yuzhendong.bwie.com.dianshangnetdemo.FirstNetOpitons.bean.Bean;
import yuzhendong.bwie.com.dianshangnetdemo.FirstNetOpitons.model.OnRequestListener;

/**
 * Created by Administrator on 2017/11/9.
 */

public class Contract {
    public interface Imodel{
        void getData(String url, OnRequestListener onRequestListener);
    }
    public interface Iview{
        void setData(List<Bean.TuijianBean.ListBean> list);
        void setError(String e);
    }
    public interface Ipresenter{
        void showData(String url);
    }
}
