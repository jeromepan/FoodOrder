package cn.edu.neusoft.lixu524.foodorder.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.squareup.picasso.Picasso;

import java.util.List;

import cn.edu.neusoft.lixu524.foodorder.Bean.GetCollectBean;
import cn.edu.neusoft.lixu524.foodorder.Bean.ShopListBean;

/**
 * Created by www44 on 2017/9/25.
 */

public class CollectShopAdapter extends BaseAdapter<GetCollectBean>{
    private OnItemClickListener mOnItemClickListener=null;
    private Context context;
    public CollectShopAdapter(Context context, List<GetCollectBean> items, int layoutResource) {
        super(context, items, layoutResource);
        this.context=context;
    }

    public void setList(List<GetCollectBean> l){
        items=l;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final GetCollectBean bean = items.get(position);
        if(bean==null) return;
        final ViewHolder viewHolder= (ViewHolder) holder;
        viewHolder.tv_name.setText(bean.getShopname());
//        Toast.makeText(context,viewHolder.tv_name.getText().toString(),Toast.LENGTH_SHORT).show();
        viewHolder.address.setText(bean.getAddress());
        viewHolder.price.setText("地址:"+bean.getAddress());
        Picasso.with(context).load(items.get(position).getPic()).into(viewHolder.img);
        if (mOnItemClickListener!=null){
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String strid=String.valueOf(bean.getShop_id());
//                Toast.makeText(context, "您打开了第"+strid+"项", Toast.LENGTH_SHORT).show();
                    int position = viewHolder.getLayoutPosition();
                    mOnItemClickListener.onItemClick(viewHolder.itemView,position);
                }
            });
        }

    }
    public interface OnItemClickListener{
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.mOnItemClickListener=listener;
    }
}
