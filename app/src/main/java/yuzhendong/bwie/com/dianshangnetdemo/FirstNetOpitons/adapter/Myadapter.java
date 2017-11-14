package yuzhendong.bwie.com.dianshangnetdemo.FirstNetOpitons.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import yuzhendong.bwie.com.dianshangnetdemo.FirstNetOpitons.bean.Bean;
import yuzhendong.bwie.com.dianshangnetdemo.R;

/**
 * Created by Administrator on 2017/11/9.
 */

public class Myadapter extends RecyclerView.Adapter<Myadapter.ViewHolder> {

    public Context context;
    public List<Bean.TuijianBean.ListBean> list;

    public Myadapter(Context context, List<Bean.TuijianBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }


    @Override
    public Myadapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.firstadapteritem,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(Myadapter.ViewHolder holder, int position) {
        String images = list.get(position).getImages();
        String[] split = images.split("\\|");
        Glide.with(context).load(split[0]).into(holder.img1);

        holder.tv1.setText(list.get(position).getTitle()+"");
        holder.tv2.setText(list.get(position).getPrice()+"");
    }

    @Override
    public int getItemCount() {
        return list == null ? 0:list.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView img1;
        public TextView tv1,tv2;

        public ViewHolder(View itemView) {
            super(itemView);
            img1 = (ImageView) itemView.findViewById(R.id.ima_f1);
            tv1 = (TextView) itemView.findViewById(R.id.tv1_f1);
            tv2 = (TextView) itemView.findViewById(R.id.tv2_f1);
        }
    }
}
