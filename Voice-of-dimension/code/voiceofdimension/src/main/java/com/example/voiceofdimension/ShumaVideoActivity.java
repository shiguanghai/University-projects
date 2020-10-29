package com.example.voiceofdimension;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.voiceofdimension.util.OkHttpUtils;
import com.example.voiceofdimension.modal.Video;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ShumaVideoActivity extends Activity {
    private String path = "http://shiguanghai.top/video_home_mobile.action";
    private ListView mListView;
    private List<Video> mList = new ArrayList<>();
    private VideoAdapter adapter;
    private List<String> urlList = new ArrayList<String>();
    private List<String> videoNameList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_list);
        initView();

    }

    private void initView() {
        mListView = (ListView)findViewById(R.id.mListView);
        OkHttpUtils okHttp = OkHttpUtils.getInstance();
        okHttp.syncJsonStringByURL(path, new OkHttpUtils.FuncJsonString() {
            @Override
            public void onResponse(String result) {
                Log.i("json", result);
                getJson(result);
            }
        });
        //监听
        mListView.setOnScrollListener(new ListScroller());
        //跳转
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ShumaVideoActivity.this,
                        "点击视频"+videoNameList.get(position)+"跳转到"+urlList.get(position), Toast.LENGTH_LONG).show();

            }
        });

    }
    /**
     * 解析Json
     *
     * @param json
     */
    private void getJson(String json) {
        try {
            JSONArray jArray  = new JSONArray(json);
            for (int i = 0; i < jArray.length(); i++) {
                JSONObject jb = (JSONObject) jArray.get(i);
                Video bean = new Video();
                bean.setVideoName(jb.getString("video_name"));
                bean.setCover("http://shiguanghai.top/"+jb.getString("url"));
                mList.add(bean);
                //存起来现在没用
                videoNameList.add(jb.getString("video_name"));
                urlList.add(jb.getString("address"));
            }
            adapter = new VideoAdapter(this, mList);
            mListView.setAdapter(adapter);

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 滚动监听
     */
    public class ListScroller implements AbsListView.OnScrollListener {

        @Override
        public void onScrollStateChanged(AbsListView view, int scrollState) {
            final Picasso picasso = Picasso.with(ShumaVideoActivity.this);
            if (scrollState == SCROLL_STATE_IDLE || scrollState == SCROLL_STATE_TOUCH_SCROLL) {
                //重置
                picasso.resumeTag(ShumaVideoActivity.this);
            } else {
                //暂停
                picasso.pauseTag(ShumaVideoActivity.this);
            }
        }

        @Override
        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

        }
    }
}
