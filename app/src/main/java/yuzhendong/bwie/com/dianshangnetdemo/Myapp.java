package yuzhendong.bwie.com.dianshangnetdemo;

import android.app.Application;

import com.uuzuche.lib_zxing.activity.ZXingLibrary;

import de.greenrobot.event.EventBus;

/**
 * Created by Administrator on 2017/11/8.
 */

public class Myapp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ZXingLibrary.initDisplayOpinion(this);

    }
}
