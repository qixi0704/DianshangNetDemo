package yuzhendong.bwie.com.dianshangnetdemo.SecondNetOpitons.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import yuzhendong.bwie.com.dianshangnetdemo.R;
import yuzhendong.bwie.com.dianshangnetdemo.SecondNetOpitons.bean.MyDataBean;

/**
 * Created by Administrator on 2017/11/14.
 */

public class Myadapter4 extends RecyclerView.Adapter<Myadapter4.ViewHolder> {
    public Context context;
    public List<MyDataBean.DataBean> dlist;

    public Myadapter4(Context context, List<MyDataBean.DataBean> dlist) {
        this.context = context;
        this.dlist = dlist;
    }

    @Override
    public Myadapter4.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.detilsadapteritem,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(Myadapter4.ViewHolder holder, int position) {

        Glide.with(context).load(dlist.get(position).getIcon()).into(holder.img1);
        holder.tv1.setText(dlist.get(position).getName());
        holder.tv2.setText(dlist.get(position).getCreatetime());
    }

    @Override
    public int getItemCount() {
        return dlist == null ? 0:dlist.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView img1;
        public TextView tv1,tv2;

        public ViewHolder(View itemView) {
            super(itemView);
            img1 = (ImageView) itemView.findViewById(R.id.detils_i1);
            tv1 = (TextView) itemView.findViewById(R.id.detils_t1);
            tv2 = (TextView) itemView.findViewById(R.id.detils_t2);
        }


    }
}
