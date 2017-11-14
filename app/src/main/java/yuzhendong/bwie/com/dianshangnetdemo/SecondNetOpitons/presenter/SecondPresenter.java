package yuzhendong.bwie.com.dianshangnetdemo.SecondNetOpitons.presenter;

import java.util.List;

import yuzhendong.bwie.com.dianshangnetdemo.SecondNetOpitons.bean.MyDataBean;
import yuzhendong.bwie.com.dianshangnetdemo.SecondNetOpitons.contract.Contract;
import yuzhendong.bwie.com.dianshangnetdemo.SecondNetOpitons.contract.OnRequest2Listener;
import yuzhendong.bwie.com.dianshangnetdemo.SecondNetOpitons.model.SecondModel;

/**
 * Created by Administrator on 2017/11/9.
 */

public class SecondPresenter implements Contract.IdataPresenter {
    private Contract.IdataView idataView;
    private Contract.IdataModel idataModel;

    public SecondPresenter(Contract.IdataView idataView) {
        this.idataView = idataView;
        idataModel = new SecondModel();
    }

    @Override
    public void showData(String url) {
        idataModel.getData(url, new OnRequest2Listener() {
            @Override
            public void OnSuccess(List<MyDataBean.DataBean> beanlist) {
                        idataView.setData(beanlist);
            }

            @Override
            public void OnError(String e) {
                idataView.setError(e);
            }
        });

    }
}
