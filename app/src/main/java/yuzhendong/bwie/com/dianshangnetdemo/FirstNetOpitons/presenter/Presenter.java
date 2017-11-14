package yuzhendong.bwie.com.dianshangnetdemo.FirstNetOpitons.presenter;




import java.util.List;

import yuzhendong.bwie.com.dianshangnetdemo.FirstNetOpitons.bean.Bean;
import yuzhendong.bwie.com.dianshangnetdemo.FirstNetOpitons.contract.Contract;
import yuzhendong.bwie.com.dianshangnetdemo.FirstNetOpitons.model.Model;
import yuzhendong.bwie.com.dianshangnetdemo.FirstNetOpitons.model.OnRequestListener;


/**
 * Created by Administrator on 2017/11/9.
 */

public class Presenter implements Contract.Ipresenter {
    private Contract.Iview iview;
    private Contract.Imodel imodel;

    public Presenter(Contract.Iview iview) {
        this.iview = iview;
        imodel = new Model();
    }

    @Override
    public void showData(String url) {
      imodel.getData(url, new OnRequestListener() {
          @Override
          public void OnSuccess(List<Bean.TuijianBean.ListBean> list) {
              iview.setData(list);
          }

          @Override
          public void OnError(String e) {
                iview.setError(e);
          }
      });

    }
}
