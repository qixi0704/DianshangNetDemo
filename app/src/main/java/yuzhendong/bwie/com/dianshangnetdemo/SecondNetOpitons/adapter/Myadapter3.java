package yuzhendong.bwie.com.dianshangnetdemo.SecondNetOpitons.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;
import yuzhendong.bwie.com.dianshangnetdemo.R;
import yuzhendong.bwie.com.dianshangnetdemo.SecondNetOpitons.bean.MyRigthBean;

/**
 * Created by Administrator on 2017/10/19.
 */

public class Myadapter3 extends RecyclerView.Adapter<Myadapter3.ViewHolder3> {

    public Context context;
    public List<MyRigthBean.DataBean.ListBean> been;

    public Myadapter3(Context context, List<MyRigthBean.DataBean.ListBean> been) {
        this.context = context;
        this.been = been;
    }

    @Override
    public Myadapter3.ViewHolder3 onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.netright, parent, false);
        final ViewHolder3 holder=new ViewHolder3(v);
        if(listner!=null){
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //holder.getLayoutPosition()获取点击的条目位置；
                    listner.onItemClick(view,holder.getLayoutPosition());
                }
            });
            v.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    listner.onLongItemClick(view,holder.getLayoutPosition());
                    //防止与click事件冲突
                    return true;
                }
            });
        }
        return new Myadapter3.ViewHolder3(v);

    }


    @Override
    public void onBindViewHolder(final ViewHolder3 holder3, int position) {
//       holder3.fenlei2_item_tv1.setText(been.get(position).getPcid());
        holder3.fenlei2_item_tv2.setText(been.get(position).getName());
        holder3.itemView.setTag(position);





    }





    @Override
    public int getItemCount() {
        return been.size();
    }
    //点击事件；
    private OnClickRecyclerListner listner;
    //设置点击事件；
    public void setLisner(OnClickRecyclerListner lisner){
        this.listner=lisner;
    }



    class ViewHolder3 extends RecyclerView.ViewHolder {

        public TextView fenlei2_item_tv1, fenlei2_item_tv2;

        public ViewHolder3(View itemView) {
            super(itemView);

            fenlei2_item_tv1 = (TextView) itemView.findViewById(R.id.fenlei2_item_tv1);
            fenlei2_item_tv2 = (TextView) itemView.findViewById(R.id.fenlei2_item_tv2);


        }
    }
}
