package css.com.media;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

import css.com.testdev.MusicActivity;
import css.com.testdev.R;

public class VideoList {
    private LoadingListCompleteListener mCompleteListener;
    private Context mContext;
    private int mCurrentPlay;
    /**
     * mVideoListAdapter 通知数据改变
     */
    private Handler mHandler = new Handler() {
        public void handleMessage(Message paramMessage) {
            if ((paramMessage.what != 0)
                    || (mVideoListAdapter == null)) {
                return;
            }
            mVideoListAdapter.notifyDataSetChanged();
        }
    };
    /**
     * list view 数据
     */
    private List<MediaInfo> mListVideoInfo;
    private int mPlayerType;
    private VideoListAdapter mVideoListAdapter;
    private MusicActivity mVideoPlayer;
    private ListView mListView;

    /**
     * @param paramVideoPlayerFragment         activity
     * @param paramListView                    要填充数据的 list view
     * @param paramContext
     * @param paramLoadingListCompleteListener 数据查询完成监听
     */
    public VideoList(MusicActivity paramVideoPlayerFragment,
                     ListView paramListView, Context paramContext,
                     LoadingListCompleteListener paramLoadingListCompleteListener) {
        mVideoPlayer = paramVideoPlayerFragment;
        mListView = paramListView;
        mPlayerType = mVideoPlayer.getPlayerType();
        mContext = paramContext;
        mCompleteListener = paramLoadingListCompleteListener;
        mListVideoInfo = new ArrayList();
        getMusicList();
        paramListView
                .setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> paramAdapterView,
                                            View paramView, int paramInt, long paramLong) {
                        MediaInfo localMediaInfo = (MediaInfo) mVideoListAdapter
                                .getItem(paramInt);
                        mVideoPlayer.startPlay(localMediaInfo);
                        mCurrentPlay = paramInt;
                        mVideoPlayer.dismissPP();
                    }
                });
        this.mHandler.postDelayed(new Runnable() {
            public void run() {

                mVideoListAdapter = new VideoListAdapter();
                mListView.setAdapter(mVideoListAdapter);
            }
        }, 200L);
    }

    public List<MediaInfo> getPlayList(){
        return mListVideoInfo;
    }

    private void getMusicList() {
        new Thread() {
            public void run() {
                long l1 = System.currentTimeMillis();
                ContentResolver contentResolver = mContext
                        .getContentResolver();
                String[] arrayOfString = {"_id", "_data", "title", "artist",
                        "mime_type", "_size", "duration","album_id"};
                Cursor cursor = contentResolver.query(
                        MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                        arrayOfString, null, null, null);
                if (cursor == null) {
                    return;
                }
                while (true) {
                    if (!cursor.moveToNext()) {
                        cursor.close();
                        mCompleteListener.onLoadingComplete();
                        mHandler.sendEmptyMessage(0);
                        Log.d("VideoList", "size:" + mListVideoInfo.size());
                        long l2 = System.currentTimeMillis();
                        // Misc.logd("getMusicList costs " + (l2 - l1));
                        return;
                    }
                    MediaInfo mediaInfo = new MediaInfo();
                    mediaInfo.id = cursor.getInt(cursor
                            .getColumnIndexOrThrow("_id"));
                    mediaInfo.filePath = cursor.getString(cursor
                            .getColumnIndexOrThrow("_data"));
                    mediaInfo.title = cursor.getString(cursor
                            .getColumnIndexOrThrow("title"));
                    mediaInfo.artist = cursor.getString(cursor
                            .getColumnIndexOrThrow("artist"));
                    mediaInfo.mime_type = cursor
                            .getString(cursor
                                    .getColumnIndexOrThrow("mime_type"));
                    mediaInfo.size = cursor.getInt(cursor
                            .getColumnIndexOrThrow("_size"));
                    mediaInfo.duration = cursor.getInt(cursor
                            .getColumnIndexOrThrow("duration"));
                    mediaInfo.albumId = cursor.getInt(cursor
                            .getColumnIndexOrThrow("album_id"));
                    mListVideoInfo.add(mediaInfo);
                }
            }
        }.start();
    }

    public void delListView() {

    }

    public MediaInfo getNextItem() {
        if (mListVideoInfo.size() == 0)
            return null;
        if (mVideoPlayer.CURRENT_CIRCLE_MODE == MusicActivity.CIRCLE_NEXT) {
            mCurrentPlay = (1 + mCurrentPlay);
            if (mCurrentPlay >= mListVideoInfo.size())
                mCurrentPlay = 0;
        } else if (mVideoPlayer.CURRENT_CIRCLE_MODE == MusicActivity.CIRCLE_SINGLE) {
            //mCurrentPlay no change
        } else if (mVideoPlayer.CURRENT_CIRCLE_MODE == MusicActivity.CIRCLE_RANDOM) {
            mCurrentPlay = (int) (Math.random() * mListVideoInfo.size());
        }
        return (MediaInfo) mListVideoInfo.get(mCurrentPlay);
    }

    public MediaInfo getPrevItem() {
        if (mVideoPlayer.CURRENT_CIRCLE_MODE == MusicActivity.CIRCLE_NEXT) {
            if (mListVideoInfo.size() == 0)
                return null;
            mCurrentPlay = (-1 + mCurrentPlay);
            if (mCurrentPlay < 0)
                mCurrentPlay = (-1 + mListVideoInfo.size());
        } else if (mVideoPlayer.CURRENT_CIRCLE_MODE == MusicActivity.CIRCLE_SINGLE) {
            //mCurrentPlay no change
        } else if (mVideoPlayer.CURRENT_CIRCLE_MODE == MusicActivity.CIRCLE_RANDOM) {
            mCurrentPlay = (int) (Math.random() * mListVideoInfo.size());
        }
        return (MediaInfo) mListVideoInfo.get(mCurrentPlay);
    }

    public String getSongName(){
        if (mListVideoInfo == null || mListVideoInfo.size() == 0) return "";
        MediaInfo mInfo = mListVideoInfo.get(mCurrentPlay);
        String song = mInfo.title;
        return song;
    }
    public String getSinger() {
        if (mListVideoInfo == null || mListVideoInfo.size() == 0) return "";
        MediaInfo mInfo = mListVideoInfo.get(mCurrentPlay);
        String singer = mInfo.artist;
        return singer;
    }
    public Bitmap getMusicIcon() {
        if (mListVideoInfo == null || mListVideoInfo.size() == 0) return null;
        MediaInfo mInfo = mListVideoInfo.get(mCurrentPlay);
        Bitmap mBitMap = mInfo.bitmap;


        long songid = mInfo.id;
        long albumid = mInfo.albumId;
        return MusicUtil.getArtwork(mVideoPlayer, songid, albumid,true);
    }

    public static abstract interface LoadingListCompleteListener {
        public abstract void onLoadingComplete();
    }

    class VideoListAdapter extends BaseAdapter {
        public VideoListAdapter() {
        }

        public int getCount() {
            return mListVideoInfo.size();
        }

        public Object getItem(int paramInt) {
            return mListVideoInfo.get(paramInt);
        }

        public long getItemId(int paramInt) {
            return paramInt;
        }

        public View getView(int position, View content,
                            ViewGroup paramViewGroup) {
            if (content == null)
                content = LayoutInflater.from(mContext)
                        .inflate(R.layout.music_list_item, paramViewGroup, false);
            MediaInfo localMediaInfo = (MediaInfo) mListVideoInfo
                    .get(position);
            //
            ((TextView) content.findViewById(R.id.song_and_singer_name))
                    .setText(localMediaInfo.title + "-" + localMediaInfo.artist);

            if (mPlayerType == 0) {
                long l1 = System.currentTimeMillis();
//                if (localMediaInfo.bitmap != null)
//                    icon.setImageBitmap(localMediaInfo.bitmap);
                long l2 = System.currentTimeMillis();
                // Misc.logd("VideoList getView costs : " + (l2 - l1));
                return content;
            }
//            icon.setImageResource(R.drawable.media_music_icon);
            return content;
        }

    }
}
