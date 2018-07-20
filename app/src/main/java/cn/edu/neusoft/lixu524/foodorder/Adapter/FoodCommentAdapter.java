package cn.edu.neusoft.lixu524.foodorder.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import cn.edu.neusoft.lixu524.foodorder.Bean.FoodDetailBean;
import cn.edu.neusoft.lixu524.foodorder.Bean.OrderOrCommentBean;
import cn.edu.neusoft.lixu524.foodorder.Listener.TListener;
import cn.edu.neusoft.lixu524.foodorder.Modul.FoodDetailModel;

/**
 * Created by www44 on 2017/9/25.
 */

public class CommentAdapter extends BaseAdapter<OrderOrCommentBean>{
    private OnItemClickListener mOnItemClickListener=null;
    private Context context;

    public CommentAdapter(Context context, List<OrderOrCommentBean> items, int layoutResource) {
        super(context, items, layoutResource);
        this.context=context;
    }

    public void setList(List<OrderOrCommentBean> l){
        items=l;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final OrderOrCommentBean bean = items.get(position);
        if(bean==null) return;
        final ViewHolder viewHolder= (ViewHolder) holder;

        //获得订单的同时通过订单的food_id来获得菜品的图片
        TListener<FoodDetailBean> tListener = new TListener<FoodDetailBean>() {
            @Override
            public void onResponse(FoodDetailBean foodDetailBean) {
                //载入订单对应菜品的图片
                Picasso.with(context).load(foodDetailBean.getPic()).into(viewHolder.img);
            }

            @Override
            public void onFail(String msg) {
                Toast.makeText(context,"获取店铺详情失败",Toast.LENGTH_SHORT).show();
            }
        };
        FoodDetailModel foodDetailModel = new FoodDetailModel();
        foodDetailModel.getFoodMeg(bean.getFood_id(),tListener);

        viewHolder.tv_name.setText(bean.getFoodname());
        viewHolder.address.setText(bean.getContent());
        viewHolder.price.setText(bean.getOrdertime());
        if (mOnItemClickListener!=null){
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String strid=String.valueOf(bean.getFood_id());
//                    Toast.makeText(context, "您打开了第"+strid+"项", Toast.LENGTH_SHORT).show();
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
