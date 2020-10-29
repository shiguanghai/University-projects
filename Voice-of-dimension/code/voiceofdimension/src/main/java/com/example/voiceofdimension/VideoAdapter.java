package com.example.voiceofdimension;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.voiceofdimension.util.PicassoUtils;
import com.example.voiceofdimension.modal.Video;

import java.util.List;

public class VideoAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater inflater;
    private List<Video> mList;
    private Video bean;

    public VideoAdapter(Context mContext, List<Video> mList) {
        this.mContext = mContext;
        this.mList = mList;
        inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHoldwe vHoldwe = null;
        if (convertView == null) {
            vHoldwe = new ViewHoldwe();
            convertView = inflater.inflate(R.layout.video_list, null);
            vHoldwe.url_video_img = (ImageView) convertView
                    .findViewById(R.id.url_video_img);
            vHoldwe.videoName = (TextView) convertView
                    .findViewById(R.id.videoName);
            vHoldwe.author_video = (TextView) convertView
                    .findViewById(R.id.author_video);
            convertView.setTag(vHoldwe);
        } else {
            vHoldwe = (ViewHoldwe) convertView.getTag();
        }

        bean = mList.get(position);
        vHoldwe.videoName.setText(bean.getVideoName());
        vHoldwe.author_video.setText(bean.getVideoName());

        if(!TextUtils.isEmpty(bean.getCover())){
            PicassoUtils.loadImageViewSize(mContext, bean.getCover(),150,100, vHoldwe.url_video_img);
        }else{
            vHoldwe.url_video_img.setImageResource(R.mipmap.ic_launcher);
        }

        return convertView;
    }

    class ViewHoldwe {
        private ImageView url_video_img;
        private TextView videoName;
        private TextView author_video;
    }
}
