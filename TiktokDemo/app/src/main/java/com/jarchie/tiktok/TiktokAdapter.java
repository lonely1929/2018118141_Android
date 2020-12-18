package com.jarchie.tiktok;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TiktokAdapter extends RecyclerView.Adapter<TiktokAdapter.ViewHolder> {
    private int[] videos = {R.raw.v1, R.raw.v2};
    private int[] imgs = {R.drawable.fm1, R.drawable.fm2};
    private List<String> mTitles = new ArrayList<>();
    private List<String> mMarqueeList = new ArrayList<>();
    private Context mContext;

    public TiktokAdapter(Context context) {
        this.mContext = context;
        mTitles.add("@GZJ\nAndroid仿抖音主界面UI效果,\n一边学习一边嗨起来\n#Android仿抖音项目");
        mTitles.add("@GZJ\nAndroid RecyclerView自定义\nLayoutManager的使用方式，仿抖音效果哦");
        mMarqueeList.add("哈哈创作的原声-GGG");
        mMarqueeList.add("嘿嘿创作的原声-JJJ");
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_tiktok_layout, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int pos) {
        //第一种方式：获取视频第一帧作为封面图片
//        MediaMetadataRetriever media = new MediaMetadataRetriever();
//        media.setDataSource(mContext,Uri.parse("android.resource://" + mContext.getPackageName() + "/" + videos[pos % 2]));
//        holder.mThumb.setImageBitmap(media.getFrameAtTime());
        //第二种方式：使用固定图片作为封面图片
        holder.mThumb.setImageResource(imgs[pos % 2]);
        holder.mVideoView.setVideoURI(Uri.parse("android.resource://" + mContext.getPackageName() + "/" + videos[pos % 2]));
        holder.mTitle.setText(mTitles.get(pos % 2));
        holder.mMarquee.setText(mMarqueeList.get(pos % 2));
        holder.mMarquee.setSelected(true);
    }

    @Override
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout mRootView;
        ImageView mThumb;
        ImageView mPlay;
        TextView mTitle;
        TextView mMarquee;
        CusVideoView mVideoView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mRootView = itemView.findViewById(R.id.mRootView);
            mThumb = itemView.findViewById(R.id.mThumb);
            mPlay = itemView.findViewById(R.id.mPlay);
            mVideoView = itemView.findViewById(R.id.mVideoView);
            mTitle = itemView.findViewById(R.id.mTitle);
            mMarquee = itemView.findViewById(R.id.mMarquee);
        }
    }

}
