package yuzhendong.bwie.com.dianshangnetdemo.SecondNetOpitons.contract;

import java.util.List;
import yuzhendong.bwie.com.dianshangnetdemo.SecondNetOpitons.bean.MyDataBean;

/**
 * Created by Administrator on 2017/11/9.
 */

public class Contract {
                public interface IdataModel{
                    void getData(String url, OnRequest2Listener onRequest2Listener);
                }
                public interface IdataView{
                    void setData(List<MyDataBean.DataBean> beanList);
                    void setError(String e);
                }
                public interface IdataPresenter{
                    void showData(String url);
                }
}
