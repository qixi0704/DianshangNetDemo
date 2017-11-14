package yuzhendong.bwie.com.dianshangnetdemo.ThirdNetOpitons.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import yuzhendong.bwie.com.dianshangnetdemo.R;

/**
 * Created by Administrator on 2017/11/8.
 */

public class Fragment3 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = View.inflate(getActivity(), R.layout.fragment3,null);
        return v;
    }
}
