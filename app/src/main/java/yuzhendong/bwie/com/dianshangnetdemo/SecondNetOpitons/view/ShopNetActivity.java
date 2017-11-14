package yuzhendong.bwie.com.dianshangnetdemo.SecondNetOpitons.view;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import yuzhendong.bwie.com.dianshangnetdemo.FirstNetOpitons.bean.Bean;
import yuzhendong.bwie.com.dianshangnetdemo.FirstNetOpitons.contract.Contract;
import yuzhendong.bwie.com.dianshangnetdemo.R;
import yuzhendong.bwie.com.dianshangnetdemo.SecondNetOpitons.adapter.Myadapter4;
import yuzhendong.bwie.com.dianshangnetdemo.SecondNetOpitons.bean.MyDataBean;
import yuzhendong.bwie.com.dianshangnetdemo.SecondNetOpitons.bean.MyRigthBean;

public class ShopNetActivity extends AppCompatActivity{

    private RecyclerView recyclerView;
    private Myadapter4 myadapter4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_net);
        initview();




    }

    private void initview() {
        recyclerView = (RecyclerView) findViewById(R.id.drecyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }



}
