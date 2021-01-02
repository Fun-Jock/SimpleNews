package com.lauren.simplenews.holiday;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lauren.simplenews.R;
import com.lauren.simplenews.beans.HolidayBean;
import com.lauren.simplenews.utils.ToolsUtil;

import java.util.List;


public class HolidayAdapter extends RecyclerView.Adapter<HolidayAdapter.ItemViewHolder> {

    private List<HolidayBean> mData;
    private Context mContext;
    private int mMaxWidth;
    private int mMaxHeight;

    private OnItemClickListener mOnItemClickListener;

    public HolidayAdapter(Context context) {
        this.mContext = context;
        mMaxWidth = ToolsUtil.getWidthInPx(mContext) - 20;
        mMaxHeight = ToolsUtil.getHeightInPx(mContext) - ToolsUtil.getStatusHeight(mContext) -
                ToolsUtil.dip2px(mContext, 96);
    }

    public void setmDate(List<HolidayBean> data) {
        this.mData = data;
        this.notifyDataSetChanged();
    }

    @Override
    public HolidayAdapter.ItemViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_image, parent, false);
        ItemViewHolder vh = new ItemViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(HolidayAdapter.ItemViewHolder holder, int position) {
        HolidayBean imageBean = mData.get(position);
        if(imageBean == null) {
            return;
        }
        holder.mTitle.setText(imageBean.getName());
        holder.mContent.setText(imageBean.getStartday());
//        float scale = (float)imageBean.getWidth() / (float) mMaxWidth;
//        int height = (int)(imageBean.getHeight() / scale);
//        if(height > mMaxHeight) {
//            height = mMaxHeight;
//        }
//        holder.mImage.setLayoutParams(new LinearLayout.LayoutParams(mMaxWidth, height));
//        ImageLoaderUtils.display(mContext, holder.mImage, imageBean.getThumburl());
    }

    @Override
    public int getItemCount() {
        if(mData == null) {
            return 0;
        }
        return mData.size();
    }

    public HolidayBean getItem(int position) {
        return mData == null ? null : mData.get(position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView mTitle;
        public TextView mContent;

        public ItemViewHolder(View v) {
            super(v);
            mTitle = (TextView) v.findViewById(R.id.tvTitle);
            mContent = (TextView) v.findViewById(R.id.tvContent);
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(mOnItemClickListener != null) {
                mOnItemClickListener.onItemClick(view, this.getPosition());
            }
        }
    }

}
