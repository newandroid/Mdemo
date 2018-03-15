package css.com.testdev;

import android.Manifest;
import android.annotation.SuppressLint;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.audiofx.Equalizer;
import android.media.audiofx.Visualizer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.SeekBar;
import android.widget.TextView;


import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import css.com.media.MediaInfo;
import css.com.media.MusicListDialog;
import css.com.media.PlayerTimer;
import css.com.media.VideoList;
import css.com.widget.MySurface;
import de.hdodenhof.circleimageview.CircleImageView;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

public class MusicActivity extends AppCompatActivity implements AdapterView.OnItemClickListener,
        View.OnClickListener,
        VideoList.LoadingListCompleteListener, SeekBar.OnSeekBarChangeListener, MediaPlayer.OnSeekCompleteListener,
        MediaPlayer.OnCompletionListener, MediaPlayer.OnPreparedListener,
        MediaPlayer.OnErrorListener, EasyPermissions.PermissionCallbacks {
    private static final String TAG = "MusicActivity";
    private static final boolean DEBUG = true;
    //顺序播放
    public static final int CIRCLE_NEXT = 0;
    //单曲循环
    public static final int CIRCLE_SINGLE = 1;
    //随机播放
    public static final int CIRCLE_RANDOM = 2;
    public int CURRENT_CIRCLE_MODE = CIRCLE_NEXT;

    public static final int VALUE_TYPE_VIDEO = 0;
    public static final int VALUE_TYPE_AUDIO = 1;

    public static final int SENSOR_SHAKE = 200;

    private static final int PLAY_STATE_UNSTART = 0;
    private static final int PLAY_STATE_PLAYING = 1;
    private static final int PLAY_STATE_PAUSE = 2;
    private static final int PLAY_STATE_COMPLETE = 3;
    private static final int intervalLight = 150;


    private View mVBack;
    private MySurface mySurface;
    private MySurface mySurface2;
    private View mMusicCoreRoot;
    private CircleImageView musicIcon;
    private TextView songName;
    private TextView singerName;

    private View controlGroup;
    private TextView mCurTime;
    private SeekBar mPlaySeekBar;
    private TextView mTotalTime;

    private ImageButton circleMode;
    private ImageButton playPrevious;
    private ImageButton play;
    private ImageButton pause;
    private ImageButton playNext;
    private ImageButton playList;

    VideoList videoList;

    private MusicListDialog dialog;
    private ListView playListView;
    private int mPlayerType = VALUE_TYPE_AUDIO;
    private MediaPlayer mMediaPlayer;
    private PlayerTimer mPlayPosTimer;
    /**
     * 音乐频谱
     */
    private Visualizer mVisualizer;
    Equalizer mEqualizer;
    private long mSampLastTime = 0L;
    private PopupWindow popupWindow;


    private int mPlayerStatus = PLAY_STATE_UNSTART;
    private static final int MSG_WHAT_REFRESH_CUR_POS = 1;
    private static final int MSG_WHAT_HIDE_CONTROL_PANEL = 4;
    private static final int MSG_WHAT_REFRESH_BLE_DATA = 5;
    private boolean isSeekbarTouch;
    //    private boolean isCalculateing = false;
    private byte[] globalData;
    private int globalCmd = 1;
    private byte globalLight = 0;


    static final int SHAKE_NOTHING = 0;
    static final int SHAKE_MUSIC = 1;
    static final int SHAKE_PALY_OR_NOT = 2;
    int shakeType = SHAKE_NOTHING;

    private static class MyHandler extends Handler{
        WeakReference<MusicActivity> parentActivity;
        public MyHandler(MusicActivity activity){
            parentActivity = new WeakReference<MusicActivity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            MusicActivity musicActivity = parentActivity.get();
            if (musicActivity==null||musicActivity.isFinishing())return;
            switch (msg.what) {
                case MSG_WHAT_REFRESH_CUR_POS:
                    musicActivity.refreshCurPos();
                    break;
                case MSG_WHAT_HIDE_CONTROL_PANEL:
                    musicActivity.showControlView(false);
                    break;
                case SENSOR_SHAKE:
                    switch (musicActivity.shakeType) {
                        case SHAKE_MUSIC:
                            musicActivity.nextPlay();
                            break;
                        case SHAKE_PALY_OR_NOT:
                            if (musicActivity.mPlayerStatus == PLAY_STATE_PAUSE) {
                                musicActivity.mMediaPlayer.start();
                                musicActivity.mPlayerStatus = PLAY_STATE_PLAYING;
                                musicActivity.mPlayPosTimer.startTimer();
                                musicActivity.showPlay(false);
                                musicActivity.enableVisual(true);
                                musicActivity.mHandler.removeMessages(MSG_WHAT_REFRESH_BLE_DATA);
                                musicActivity.mHandler.sendEmptyMessageDelayed(MSG_WHAT_REFRESH_BLE_DATA, intervalLight);
                            } else if (musicActivity.mPlayerStatus == PLAY_STATE_PLAYING) {
                                musicActivity.mMediaPlayer.pause();
                                musicActivity.mPlayPosTimer.stopTimer();
                                musicActivity.showPlay(true);
                                musicActivity.mPlayerStatus = PLAY_STATE_PAUSE;
                                musicActivity.enableVisual(false);
                                musicActivity.mHandler.removeMessages(MSG_WHAT_REFRESH_BLE_DATA);
                            } else if (musicActivity.mPlayerStatus == PLAY_STATE_UNSTART) {
                                List<MediaInfo> list = musicActivity.videoList.getPlayList();
                                if (list != null && list.size() > 0) {
                                    MediaInfo mediaInfo = list.get(0);
                                    musicActivity.startPlay(mediaInfo);
                                    musicActivity.mHandler.removeMessages(MSG_WHAT_REFRESH_BLE_DATA);
                                    musicActivity.mHandler.sendEmptyMessageDelayed(MSG_WHAT_REFRESH_BLE_DATA, intervalLight);
                                }
                            }else if (musicActivity.mPlayerStatus == PLAY_STATE_COMPLETE){
                                musicActivity.mMediaPlayer.start();
                            }
                            break;
                    }
                    break;
                case MSG_WHAT_REFRESH_BLE_DATA:
//                    isCalculateing = true;
//                    lightData(globalData);
//                    musicActivity.sendToBle(globalCmd, globalLight);
//                    musicActivity.mHandler.sendEmptyMessageDelayed(MSG_WHAT_REFRESH_BLE_DATA, intervalLight);
                    break;
                default:
                    break;
            }
        }
    }

    private MyHandler mHandler = new MyHandler(this) ;
    private Vibrator vibrator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        init();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (mPlayerStatus == PLAY_STATE_PAUSE || mPlayerStatus == PLAY_STATE_COMPLETE) {
            showPlay(true);
        } else if (mPlayerStatus == PLAY_STATE_PLAYING) {
            showPlay(false);
        }
        checkPer();
    }

    @Override
    protected void onStop() {
        mHandler.removeMessages(MSG_WHAT_REFRESH_BLE_DATA);
        try {
            dismissPP();
            removeHideMessage();
            this.mPlayerStatus = PLAY_STATE_COMPLETE;
            this.mPlayPosTimer.stopTimer();
            this.mMediaPlayer.stop();
            this.mMediaPlayer.release();
            this.mEqualizer.release();
            this.mVisualizer.setEnabled(false);
            this.mVisualizer.release();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        stopDevice();
        super.onStop();
    }

    void init() {
        initViews();
    }


    protected void initViews() {
        mVBack = findViewById(R.id.back);
        mySurface = findViewById(R.id.my_view);
        mySurface2 = findViewById(R.id.my_view2);
        mMusicCoreRoot = findViewById(R.id.music_core_root);
        musicIcon = (CircleImageView) findViewById(R.id.music_icon);
        songName = (TextView) findViewById(R.id.tv_title);
        singerName = (TextView) findViewById(R.id.tv_sub_title);

        controlGroup = findViewById(R.id.down_tool_view);
        mCurTime = (TextView) findViewById(R.id.tv_curTime);
        mPlaySeekBar = (SeekBar) findViewById(R.id.playback_seeker);
        mPlaySeekBar.setOnSeekBarChangeListener(this);
        mTotalTime = (TextView) findViewById(R.id.tv_totalTime);

        circleMode = (ImageButton) findViewById(R.id.btn_circle_mode);
        playPrevious = (ImageButton) findViewById(R.id.btn_playpre);
        play = (ImageButton) findViewById(R.id.btn_play);
        pause = (ImageButton) findViewById(R.id.btn_pause);
        playNext = (ImageButton) findViewById(R.id.btn_play_next);
        playList = (ImageButton) findViewById(R.id.btn_play_list);


    }


    protected void initEvents() {
        mVBack.setOnClickListener(this);
        circleMode.setOnClickListener(this);
        playPrevious.setOnClickListener(this);
        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        playNext.setOnClickListener(this);
        playList.setOnClickListener(this);
    }

    private void initData() {
        int initMode = CIRCLE_NEXT;
    }

    void initPlayListDialog() {
        if (popupWindow != null) {
            return;
        }
        View contentView = LayoutInflater.from(this).inflate(
                R.layout.music_list_dialog, null);
        popupWindow = new PopupWindow(contentView,
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setTouchable(true);
        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });
        Button btn = (Button) contentView.findViewById(R.id.cancel);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (popupWindow != null && popupWindow.isShowing()) popupWindow.dismiss();
            }
        });
        playListView = (ListView) contentView.findViewById(R.id.list);
        popupWindow.setBackgroundDrawable(getResources().getDrawable(
                R.color.full_transparent));
        videoList = new VideoList(this, playListView, this, MusicActivity.this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onLoadingComplete() {
        if (DEBUG) Log.d(TAG, "onload complete");
    }

    void showPP() {
        popupWindow.showAtLocation(mMusicCoreRoot, Gravity.CENTER, 0, 0);
    }

    public void dismissPP() {
        if (popupWindow != null && popupWindow.isShowing())
            popupWindow.dismiss();// && popupWindow.isShowing()
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.btn_circle_mode:
                CURRENT_CIRCLE_MODE += 1;
                if (CURRENT_CIRCLE_MODE > CIRCLE_RANDOM) CURRENT_CIRCLE_MODE = CIRCLE_NEXT;
                setCircleView(CURRENT_CIRCLE_MODE);
                break;
            case R.id.btn_playpre:
                prevPlay();
                break;
            case R.id.btn_play:
                if (mPlayerStatus == PLAY_STATE_PAUSE) {
                    mMediaPlayer.start();
                    mPlayerStatus = PLAY_STATE_PLAYING;
                    mPlayPosTimer.startTimer();
                    showPlay(false);
                    enableVisual(true);
                } else if (mPlayerStatus == PLAY_STATE_COMPLETE) {
                    mMediaPlayer.start();
                } else if (mPlayerStatus == PLAY_STATE_UNSTART) {
                    List<MediaInfo> list = videoList.getPlayList();
                    if (list != null && list.size() > 0) {
                        MediaInfo mediaInfo = list.get(0);
                        startPlay(mediaInfo);
                    }
                }
                mHandler.removeMessages(MSG_WHAT_REFRESH_BLE_DATA);
                mHandler.sendEmptyMessageDelayed(MSG_WHAT_REFRESH_BLE_DATA, intervalLight);
                break;
            case R.id.btn_pause:
                mMediaPlayer.pause();
                mPlayPosTimer.stopTimer();
                showPlay(true);
                mPlayerStatus = PLAY_STATE_PAUSE;
                enableVisual(false);
                stopDevice();
                mHandler.removeMessages(MSG_WHAT_REFRESH_BLE_DATA);
                break;
            case R.id.btn_play_next:
                nextPlay();
                break;
            case R.id.btn_play_list:
                showPP();
                break;
            default:
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        this.mPlayPosTimer.stopTimer();
//        mVisualizer.setEnabled(false);
//        mVisualizer.release();
    }

    @SuppressLint("NewApi")
    @Override
    public void onPause() {
        super.onPause();
    }

    private void showPopupwindow(View view) {
        dialog.show();
    }

    private void initMediaPlayer() {
        mMediaPlayer = new MediaPlayer();
        mMediaPlayer.setOnCompletionListener(this);
        mMediaPlayer.setOnPreparedListener(this);
        mMediaPlayer.setOnSeekCompleteListener(this);
        mMediaPlayer.setOnErrorListener(this);
        mPlayPosTimer = new PlayerTimer(this);
        mPlayPosTimer.setHandler(mHandler, MSG_WHAT_REFRESH_CUR_POS);
    }

    private void initVisual(MediaPlayer paramMediaPlayer) {
        setVolumeControlStream(AudioManager.STREAM_MUSIC);//设置音频流 - STREAM_MUSIC：音乐回放即媒体音量
        //实例化Visualizer，参数SessionId可以通过MediaPlayer的对象获得
        mVisualizer = new Visualizer(paramMediaPlayer.getAudioSessionId());
        //设置需要转换的音乐内容长度，专业的说这就是采样率
        mVisualizer.setCaptureSize(Visualizer.getCaptureSizeRange()[0]);//128
        Visualizer.OnDataCaptureListener listener = new Visualizer.OnDataCaptureListener() {
            public void onFftDataCapture(Visualizer paramVisualizer,
                                         byte[] paramArrayOfByte, int paramInt) {
//                if (isCalculateing) return;
//                globalData = paramArrayOfByte;
                lightData(paramArrayOfByte);

//                getAmplitude(paramArrayOfByte);
            }

            public void onWaveFormDataCapture(Visualizer cisualizer,
                                              byte[] waveform, int samplingRate) {
//                getAmplitude(waveform);
            }
        };
        // 参数2：采样周期，参数3：iswave 是否为波形信号，参数4：isfft,是否为fft信号
        mVisualizer.setDataCaptureListener(listener,
                Visualizer.getMaxCaptureRate() / 2, false, true);

        mEqualizer = new Equalizer(0, paramMediaPlayer.getAudioSessionId());
        mEqualizer.setEnabled(true);// 启用均衡器
        // 通过均衡器得到其支持的频谱引擎
        short bands = mEqualizer.getNumberOfBands();
    }

    void setCircleView(int currentMode) {
        switch (currentMode) {
            case CIRCLE_SINGLE:
                circleMode.setBackgroundResource(R.drawable.ic_launcher_background);
                break;
            case CIRCLE_RANDOM:
                circleMode.setBackgroundResource(R.drawable.ic_launcher_background);
                break;
            case CIRCLE_NEXT:
            default:
                circleMode.setBackgroundResource(R.drawable.ic_launcher_background);
                break;
        }
    }

    //获取波形，给蓝牙发数据
    private void getAmplitude(byte[] waveform) {
        int length = waveform.length;
        if (length < 1) {
            return;
        }
        long nowTime = System.currentTimeMillis();
        if (nowTime - mSampLastTime < 1000L) {
            return;
        }
        mSampLastTime = nowTime;
        int total = 0;
        for (int j = 0; j < length; j++) {
            total += Math.abs(waveform[j]);
        }
        int average = total / length;
        Log.d("MusicActivity", "average:" + average);

        /********************** *****************/
        byte[] model = new byte[waveform.length / 2 + 1];
        model[0] = (byte) Math.abs(waveform[1]);
        int j = 1;

        for (int i = 2; i < 18; ) {
            model[j] = (byte) Math.hypot(waveform[i], waveform[i + 1]);
            i += 2;
            j++;
        }
        int moreData = 0;
        for (int k = 0; k < model.length; k++) {
            moreData += (int) model[k];
        }
        moreData /= model.length;
        Log.d("MusicActivity", "moreData:" + moreData);
        /********************** *****************/

        int level = 1;
        if (average > 90) {
            level = 2;
            if ((average > 95) && (average <= 100)) {
                level = 3;
            } else if ((average > 100) && (average <= 105)) {
                level = 4;
            } else if ((average > 105) && (average <= 110)) {
                level = 5;
            } else if ((average > 110) && (average <= 120)) {
                level = 6;
            } else if (average > 120) {
                level = 7;
            }
        }
//        sendToBle(level);
        int stall = level * (10 / 5);
        int rate = level * (255 / 5);
//        BleManager.getInstance().controlDevice("1", "2", "1", stall+"", rate+"");
    }

    void lightData(byte[] fft) {//work thread
        mySurface2.setDataSource(fft);
        byte max = Byte.MIN_VALUE;
        for (byte b : fft) {
            if (b>max)max=b;
        }
        mySurface.setMaxFloat(max);
//        int max = -254;
//        for (int i = 0; i < fft.length; i++) {
//            max = Math.max(max, fft[0] & 0xff);
//        }
//
//        double resultValue = Math.pow(10.0, max / 260.0 - 1);//Math.log10(max / 260.0 - 1);
//        double value = resultValue * 58;
////        Log.d(TAG, "onFftDataCapture max:" + max + " value:" + value + " resultValue:" + resultValue);
//        int level = 1;
//        if (value > 0 && value < 7) {
//            level = 1;
//        } else if (value > 7 && value < 14) {
//            level = 7;
//        } else if (value > 14 && value < 20) {
//            level = 2;
//        } else if (value > 20 && value < 26) {
//            level = 6;
//        } else if (value > 26 && value < 31) {
//            level = 3;
//        } else if (value > 31 && value < 36) {
//            level = 5;
//        } else if (value > 36 && value < 40) {
//            level = 4;
//        } else if (value > 40 && value < 44) {
//            level = 4;
//        } else if (value > 44 && value < 47) {
//            level = 5;
//        } else if (value > 47 && value < 50) {
//            level = 3;
//        } else if (value > 50 && value < 52) {
//            level = 6;
//        } else if (value > 52 && value < 54) {
//            level = 2;
//        } else if (value > 54 && value < 55) {
//            level = 7;
//        } else if (value > 55 && value < 56) {
//            level = 1;
//        }
//        Log.d(TAG, "level: " + level);
//        byte light = (byte) (80 * resultValue);
//        globalCmd = level;
//        globalLight = light;
//        isCalculateing = false;
    }

    //蓝牙音乐律动
    void sendToBle(int level, byte light) {
//        byte[] beforHandle = ApplicationManager.getInstance().getGlobalCmd();
//        byte[] sendCmd = LightingXDataUtil.setMusicBlingAndLight(level, beforHandle, light);
//        RxBleHelper.getInstance(getApplicationContext()).write(sendCmd);
    }

    public int getPlayerType() {
        return mPlayerType;
    }

    public void startPlay(MediaInfo mediaInfo) {
        mMediaPlayer.reset();
        try {
            mMediaPlayer.setDataSource(mediaInfo.filePath);
            mMediaPlayer.setAudioStreamType(3);
            mMediaPlayer.prepareAsync();
            if (mPlayerType == 1) {
//                mPrepareText.setText(mediaInfo.title);
            }
        } catch (Throwable exception) {
            exception.printStackTrace();
        }
    }

    private void showPlay(boolean show) {
        if (show) {
            play.setVisibility(View.VISIBLE);
            pause.setVisibility(View.INVISIBLE);
        } else {
            play.setVisibility(View.INVISIBLE);
            pause.setVisibility(View.VISIBLE);
        }
    }

    private void showControlView(boolean show) {
        if (show) {
            if (mPlayerStatus == PLAY_STATE_PLAYING) {
                mPlayPosTimer.startTimer();
                refreshCurPos();
            }
            controlGroup.setVisibility(View.VISIBLE);
            delayToHideControlPanel();
        } else {
            controlGroup.setVisibility(View.GONE);
            mPlayPosTimer.stopTimer();
        }
    }

    private void delayToHideControlPanel() {
        if (mPlayerType == VALUE_TYPE_AUDIO) {
            return;
        }
        removeHideMessage();
        mHandler.sendEmptyMessageDelayed(MSG_WHAT_HIDE_CONTROL_PANEL, 3000L);
    }

    private void removeHideMessage() {
        mHandler.removeMessages(MSG_WHAT_HIDE_CONTROL_PANEL);
    }

    private void refreshCurPos() {
        try {
            setSeekbarProgress(this.mMediaPlayer.getCurrentPosition());
            return;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    private void setSeekbarProgress(int progress) {
        if (isSeekbarTouch) {
            return;
        }
        mPlaySeekBar.setProgress(progress);
    }

    private void enableVisual(boolean enable) {
        mVisualizer.setEnabled(enable);
        if (enable) {
        } else {
            // if (paramBoolean) {
            // ClientUtils.getInstance().ctrlDev(1, 1, 1, 51);
            // ClientUtils.getInstance().ctrlDev(0, 1, 0, 0);
            // }
        }
    }

    private void stopDevice() {
//        BleManager.getInstance().controlDevice("1", "1", "0", "1", "1");
//        BleManager.getInstance().controlDevice("1", "2", "0", "1", "1");
    }

    private void nextPlay() {
        if (mPlayerType == VALUE_TYPE_AUDIO) {
            MediaInfo mediaInfo = videoList.getNextItem();
            if (mediaInfo != null) {
                startPlay(mediaInfo);
            }
            return;
        }
        int i = 5000 + mMediaPlayer.getCurrentPosition();
        if (i < 0) {
            i = 0;
        }
        mMediaPlayer.seekTo(i);
    }

    private void prevPlay() {
        if (mPlayerType == VALUE_TYPE_AUDIO) {
            MediaInfo mediaInfo = videoList.getPrevItem();
            if (mediaInfo != null) {
                startPlay(mediaInfo);
            }
            return;
        }
        int i = -10000 + mMediaPlayer.getCurrentPosition();
        if (i > mMediaPlayer.getDuration()) {
            i = mMediaPlayer.getDuration();
        }
        mMediaPlayer.seekTo(i);
    }

    private void showPrepareLoadView(boolean show) {
        if (mPlayerType == VALUE_TYPE_AUDIO) {
            return;
        }
        if (show) {
//            mPrepareView.setVisibility(View.VISIBLE);
        } else {
//            mPrepareView.setVisibility(View.GONE);
        }
    }

    public String formateTime(long time) {
        Locale locale = Locale.US;
        Object[] intValues;
        int i = (int) (time / 1000L);
        int j = i % 60;
        int k = i / 60;
        if (k >= 60) {
            int l = k / 60;
            int i1 = k % 60;
            intValues = new Object[3];
            intValues[0] = Integer.valueOf(l);
            intValues[1] = Integer.valueOf(i1);
            intValues[2] = Integer.valueOf(j);
            return String.format(locale, "%02d:%02d:%02d", intValues);
        }
        intValues = new Object[2];
        intValues[0] = Integer.valueOf(k);
        intValues[1] = Integer.valueOf(j);
        return String.format(locale, "%02d:%02d", intValues);
    }

    private void setTotalTime(int time) {
        String strTime = formateTime(time);
        mTotalTime.setText(strTime);
    }

    private void setcurTime(int curTime) {
        String str = formateTime(curTime);
        mCurTime.setText(str);
    }

    private void seek(int position) {
        mMediaPlayer.seekTo(position);
        setSeekbarProgress(position);
    }

    private void setAlumberMSG() {
        if (videoList.getMusicIcon() != null)
            musicIcon.setImageBitmap(videoList.getMusicIcon());
        songName.setText(videoList.getSongName());
        singerName.setText(videoList.getSinger());
    }

    @Override
    public boolean onError(MediaPlayer mp, int what, int extra) {
        return false;
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        mMediaPlayer.start();
        mPlaySeekBar.setMax(mMediaPlayer.getDuration());
        mPlayPosTimer.startTimer();
        showPlay(false);
        showPrepareLoadView(false);
        showControlView(true);
        setTotalTime(mp.getDuration());
//        setFitSize();
        mPlayerStatus = PLAY_STATE_PLAYING;
        enableVisual(true);
        mHandler.removeMessages(MSG_WHAT_REFRESH_BLE_DATA);
        mHandler.sendEmptyMessageDelayed(MSG_WHAT_REFRESH_BLE_DATA, intervalLight);
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        mPlayPosTimer.stopTimer();
        showPlay(true);
        showPrepareLoadView(true);
        showControlView(true);
        mPlayerStatus = PLAY_STATE_COMPLETE;
        enableVisual(false);
        nextPlay();
        mHandler.removeMessages(MSG_WHAT_REFRESH_BLE_DATA);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        setcurTime(progress);
        setAlumberMSG();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        isSeekbarTouch = true;
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        isSeekbarTouch = false;
        seek(mPlaySeekBar.getProgress());
    }

    @Override
    public void onSeekComplete(MediaPlayer mp) {

    }

    private void initShake() {
        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);

    }

    private void sendShakeMsg() {
        vibrator.vibrate(500);
        Message msg = new Message();
        msg.what = SENSOR_SHAKE;
        mHandler.removeMessages(SENSOR_SHAKE);
        mHandler.sendMessageDelayed(msg, 1 * 1000);
    }


    /**
     * 6.0检查权限
     */
    void checkPer() {
        requestPermissions();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    private static final int REQUEST_CODE_RECORD_AUDIO = 0x102;

    @AfterPermissionGranted(REQUEST_CODE_RECORD_AUDIO)
    private void requestPermissions() {
        String[] perms = {Manifest.permission.RECORD_AUDIO, Manifest.permission.MODIFY_AUDIO_SETTINGS,
                Manifest.permission.READ_EXTERNAL_STORAGE};//Manifest.permission.READ_EXTERNAL_STORAGE,   Manifest.permission.WRITE_EXTERNAL_STORAGE
        if (!EasyPermissions.hasPermissions(MusicActivity.this, perms)) {
            //请求失败的处理
            String needPermission = getResources().getString(R.string.need_audio_permission);
            EasyPermissions.requestPermissions(MusicActivity.this, needPermission, REQUEST_CODE_RECORD_AUDIO, perms);
        } else {
            initMediaPlayer();
            initVisual(mMediaPlayer);
            initPlayListDialog();
            initShake();
            initEvents();
            initData();
        }
//        runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        });
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {

    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
//        ToastUtils.showToast(R.string.refuse_storage_permission);
        if (requestCode == REQUEST_CODE_RECORD_AUDIO) {
            EasyPermissions.checkDeniedPermissionsNeverAskAgain(this,
                    getString(R.string.need_audio_permission),
                    R.string.setting, R.string.cancel, null, perms);
        }
    }
}
