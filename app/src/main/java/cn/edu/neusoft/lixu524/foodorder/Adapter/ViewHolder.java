package cn.edu.neusoft.lixu524.foodorder.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import cn.edu.neusoft.lixu524.foodorder.R;

/**
 * Created by www44 on 2017/12/3.
 */

public class ViewHolder extends RecyclerView.ViewHolder{

    ImageView img;
    TextView tv_name;
    TextView address;
    TextView price;

    public ViewHolder(View itemView) {
        super(itemView);

        img=itemView.findViewById(R.id.imageView_card);
        tv_name=itemView.findViewById(R.id.tv_shopname);
        address=itemView.findViewById(R.id.tv_address);
        price=itemView.findViewById(R.id.tv_price);
    }
}
