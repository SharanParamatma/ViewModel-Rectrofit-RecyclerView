package com.vama.hidoc;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

public class AdapterData extends RecyclerView.Adapter<AdapterData.SingleItemRowHolder> {
    private List<Resultarray> itemsList;
    private Context mContext;
    public AdapterData(Context context, List<Resultarray> itemsList) {
        this.itemsList = itemsList;
        this.mContext = context;
    }
    @Override
    public SingleItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_single_card, null);
        SingleItemRowHolder mh = new SingleItemRowHolder(v);
        return mh;
    }
    @Override
    public void onBindViewHolder(SingleItemRowHolder holder, int i) {

        Resultarray  sublist= itemsList.get(i);
        holder.tvTitle.setText(sublist.getTitle());
        holder.tv_url.setText(sublist.getPagelink());
        Glide.with(mContext).load(sublist.getImage())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .error(R.mipmap.ic_launcher)
                .into(holder.itemImage);
        holder.tv_des.setText(Html.fromHtml(sublist.getDescription()));

    }


    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    public class SingleItemRowHolder extends RecyclerView.ViewHolder {

        private TextView tvTitle;
        private ImageView itemImage;
        private TextView tv_des;
        private TextView tv_url;

        public SingleItemRowHolder(View view) {
            super(view);

            tvTitle =  view.findViewById(R.id.tv_name);
            tv_des = view.findViewById(R.id.tv_des);
            itemImage = view.findViewById(R.id.img_android);
            tv_url= view.findViewById(R.id.tv_url);

        }

    }

}