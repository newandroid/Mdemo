
package css.com.applab.countrylist;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class SMSReceiver extends BroadcastReceiver {
    private static final String ACTION_SMS_RECEIVER = "android.provider.Telephony.SMS_RECEIVED";
    private VerifyCodeReadListener listener;

    public SMSReceiver(VerifyCodeReadListener verifyCodeReadListener) {
        this.listener = verifyCodeReadListener;
    }

    public SMSReceiver() {
        String msg = "Please dynamically register an instance of this class with Context.registerReceiver.\r\nIf not, the SMSSDK.VerifyCodeReadListener will be null!";
        Log.w("cn.smssdk.gui.SMSReceiver", msg);
    }

    public void onReceive(Context context, Intent intent) {
        if ("android.provider.Telephony.SMS_RECEIVED".equals(intent.getAction())) {
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                Object[] pdus = (Object[])((Object[])bundle.get("pdus"));
                SmsMessage[] smsArr = new SmsMessage[pdus.length];

                for(int i = 0; i < pdus.length; ++i) {
                    smsArr[i] = SmsMessage.createFromPdu((byte[])((byte[])pdus[i]));
                }

                SmsMessage[] var10 = smsArr;
                int var7 = smsArr.length;

                for(int var8 = 0; var8 < var7; ++var8) {
                    SmsMessage sms = var10[var8];
                    if (sms != null) {
                        SMSSDK.readVerificationCode(sms, this.listener);
                    }
                }
            }
        }

    }
}
