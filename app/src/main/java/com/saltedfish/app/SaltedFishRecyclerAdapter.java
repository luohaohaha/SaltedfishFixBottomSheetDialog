package com.saltedfish.app;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Project: SaltedfishFixBottomSheetDialog<br/>
 * Package: com.saltedfish.app<br/>
 * ClassName: SaltedFishRecyclerAdapter<br/>
 * Description: TODO<br/>
 * Date: 2018-02-08 下午12:58 <br/>
 * <p>
 * Author luohao<br/>
 * Version 1.0<br/>
 * since JDK 1.6<br/>
 * <p>
 */


public class SaltedFishRecyclerAdapter extends RecyclerView.Adapter<SaltedFishRecyclerAdapter.SaltedFisHolder> {
    private SparseArray<String> mData;
    private Context mContext;

    public SaltedFishRecyclerAdapter(Context mContext,SparseArray<String> mData) {
        this.mData = mData;
        this.mContext = mContext;
    }

    @Override
    public SaltedFishRecyclerAdapter.SaltedFisHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SaltedFisHolder(View.inflate(mContext,android.R.layout.simple_list_item_1,null));
    }

    @Override
    public void onBindViewHolder(SaltedFishRecyclerAdapter.SaltedFisHolder holder, int position) {

        holder.bindData(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class SaltedFisHolder extends RecyclerView.ViewHolder{

        public SaltedFisHolder(View itemView) {
            super(itemView);
        }

        void bindData(final String s){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, s, Toast.LENGTH_SHORT).show();
                }
            });
            TextView textView = itemView.findViewById(android.R.id.text1);
            textView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            textView.setText(s);
        }
    }
}
