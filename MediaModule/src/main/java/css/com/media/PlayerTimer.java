package css.com.media;

import android.content.Context;
import android.os.Handler;

import java.util.Timer;
import java.util.TimerTask;

public class PlayerTimer {
	private static final int TIMER_INTERVAL = 1000;
	protected Context mContext;
	protected Handler mHandler;
	protected int mTimeInterval = 1000;
	protected MyTimeTask mTimeTask;
	private Timer mTimer;
	protected int msgID;

	public PlayerTimer(Context paramContext) {
		mContext = paramContext;
		mTimer = new Timer();
	}

	public void setHandler(Handler paramHandler, int msgId) {
		mHandler = paramHandler;
		msgID = msgId;
	}

	public void setTimeInterval(int paramInt) {
		mTimeInterval = paramInt;
	}

	public void startTimer() {
		if (mTimeTask != null) {
			return;
		}
		mTimeTask = new MyTimeTask();
		mTimer.schedule(mTimeTask, 0L, mTimeInterval);
	}

	public void stopTimer() {
		if (mTimeTask == null) {
			return;
		}
		mTimeTask.cancel();
		mTimeTask = null;
	}

	class MyTimeTask extends TimerTask {
		
		MyTimeTask() {
		}

		public void run() {
			if (mHandler == null) {
				return;
			}
			mHandler.obtainMessage(msgID).sendToTarget();
		}
	}
}