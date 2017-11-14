package yuzhendong.bwie.com.dianshangnetdemo.SecondNetOpitons.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import yuzhendong.bwie.com.dianshangnetdemo.R;
import yuzhendong.bwie.com.dianshangnetdemo.SecondNetOpitons.bean.MyDataBean;

/**
 * Created by Administrator on 2017/11/9.
 */

public class Myadapter2 extends BaseAdapter {
    public Context context;
    public List<MyDataBean.DataBean> beanlist;

    public Myadapter2(Context context, List<MyDataBean.DataBean> beanlist) {
        this.context = context;
        this.beanlist = beanlist;
    }

    @Override
    public int getCount() {
        return beanlist.size();
    }

    @Override
    public Object getItem(int position) {
        return beanlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView == null){
                    convertView = convertView.inflate(context,R.layout.secondadapteritemleft,null);
            holder = new ViewHolder();
            holder.t1 = (TextView) convertView.findViewById(R.id.tv);
            holder.i1 = (ImageView) convertView.findViewById(R.id.i1);
            convertView.setTag(holder);

        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.t1.setText(beanlist.get(position).getName());
        Glide.with(context).load(beanlist.get(position).getIcon()).into(holder.i1);
        return convertView;
    }
    class ViewHolder{
        TextView t1;
        ImageView i1;
    }
}
