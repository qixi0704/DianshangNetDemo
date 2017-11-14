package yuzhendong.bwie.com.dianshangnetdemo.FirstNetOpitons.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;
import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import yuzhendong.bwie.com.dianshangnetdemo.FirstNetOpitons.adapter.Myadapter;
import yuzhendong.bwie.com.dianshangnetdemo.FirstNetOpitons.bean.Bean;
import yuzhendong.bwie.com.dianshangnetdemo.FirstNetOpitons.contract.Contract;
import yuzhendong.bwie.com.dianshangnetdemo.FirstNetOpitons.presenter.Presenter;
import yuzhendong.bwie.com.dianshangnetdemo.R;
import yuzhendong.bwie.com.dianshangnetdemo.utils.Api;

/**
 * Created by Administrator on 2017/11/8.
 */

public class Fragment1 extends Fragment implements Contract.Iview{

    private View v;
    private Banner banner;
    private String[] path = {
            "http://img0.imgtn.bdimg.com/it/u=112585749,971980906&fm=27&gp=0.jpg"
            , "http://img.redocn.com/sheji/20151220/maijiusongtaobaolunbohaibaosheji_5623824.jpg"
            , "http://image.tupian114.com/20160909/0429212343.jpg"
            , "http://pic2.cxtuku.com/00/08/84/b801b6adf190.jpg"
    };
    private int[] icon = {R.drawable.home_top_01, R.drawable.home_top_02,
            R.drawable.home_top_03, R.drawable.home_top_04, R.drawable.home_top_05,
            R.drawable.home_top_06, R.drawable.home_top_02, R.drawable.home_top_04,
            R.drawable.home_top_06, R.drawable.home_top_01,};
    private String[] iconName = {"京东超市", "全球购", "京东服饰", "京东生鲜", "充值缴费", "领京豆", "领券", "赚钱", "PLUS会员", "京东到家"};
    private GridView gridview;
    private SimpleAdapter sim_adapter;
    private List<Map<String, Object>> data_list;
    private ViewFlipper vf;
    private Handler handler = new Handler();
    private TextView head_text1;
    final int REQUEST_CODE =11;
    private Myadapter myadapter;
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = View.inflate(getActivity(), R.layout.fragment1,null);
        initview();
        playbanner();
        mygrid();


        Presenter presenter = new Presenter(this);
        presenter.showData(Api.First);

        return v;
    }

    private void mygrid() {
        //新建List
        data_list = new ArrayList<Map<String, Object>>();
        //获取数据
        getData();
        //新建适配器
        String[] from = {"image", "text"};
        int[] to = {R.id.image, R.id.text};
        sim_adapter = new SimpleAdapter(getActivity(), data_list, R.layout.gride_item, from, to);
        //配置适配器
        gridview.setAdapter(sim_adapter);
    }

    private void playbanner() {
        int i = 0;


        List<String> list = new ArrayList<>();
        List<String> blist = new ArrayList<>();

        for (String s : path) {
            list.add(s);
            i++;
            blist.add("");
        }

        banner.setImageLoader(new Mybanner());
        banner.setBannerTitles(blist);
        banner.setImages(list);
        banner.start();
    }

    private void initview() {
        banner = (Banner) v.findViewById(R.id.banner);
        gridview = (GridView) v.findViewById(R.id.gridview);
        vf = (ViewFlipper) v.findViewById(R.id.vf);
        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerview);
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        head_text1 = (TextView) v.findViewById(R.id.head_text1);
        vf.addView(View.inflate(getActivity(), R.layout.guanggaotiaoitem, null));
        vf.addView(View.inflate(getActivity(), R.layout.guanggaotiaoitem2, null));
        vf.addView(View.inflate(getActivity(), R.layout.guanggaotiaoitem3, null));

        head_text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CaptureActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        CodeUtils.isLightEnable(true);
        if (requestCode == REQUEST_CODE) {
            //处理扫描结果（在界面上显示）
            if (null != data) {
                Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String result = bundle.getString(CodeUtils.RESULT_STRING);
                    Toast.makeText(getActivity(), "解析结果:" + result, Toast.LENGTH_LONG).show();
                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    Toast.makeText(getActivity(), "解析二维码失败", Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    @Override
    public void setData(List<Bean.TuijianBean.ListBean> list) {
                myadapter = new Myadapter(getActivity(),list);
                recyclerView.setAdapter(myadapter);

    }

    @Override
    public void setError(String e) {

    }


    public class Mybanner extends ImageLoader {

        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load(path).into(imageView);

        }
    }
    public List<Map<String, Object>> getData() {

        for (int i = 0; i < icon.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", icon[i]);
            map.put("text", iconName[i]);
            data_list.add(map);

        }
        return data_list;
    }
}
