package yuzhendong.bwie.com.dianshangnetdemo.FourNetOpitons.view;



import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import yuzhendong.bwie.com.dianshangnetdemo.R;

/**
 * Created by Administrator on 2017/11/8.
 */

public class Fragment4 extends Fragment {


    private View v;
    private TextView my_login;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = View.inflate(getActivity(), R.layout.fragment4, null);

        initview();
            my_login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(),LoginActivity.class);
                    startActivity(intent);
                }
            });

        return v;
    }

    private void initview() {
        my_login = (TextView) v.findViewById(R.id.my_login);
    }


}
