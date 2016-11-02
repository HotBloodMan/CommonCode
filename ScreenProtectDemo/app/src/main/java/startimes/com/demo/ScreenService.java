package startimes.com.demo;

import android.app.KeyguardManager;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.util.Log;

public class ScreenService extends Service {
   KeyguardManager mKeyfuardManager=null;
    private KeyguardManager mKeyguardLock=null;
    BroadcastReceiver mMasterResetReceiver;

    public ScreenService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
     startScreenService();
        super.onCreate();
    }
    private void startScreenService() {
        mKeyfuardManager= (KeyguardManager) getSystemService(Context.KEYGUARD_SERVICE);
//        mKeyguardLock=mKeyfuardManager.newKeyguardLock("");
        
        mMasterResetReceiver=new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                try {
                    Intent i = new Intent();
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    i.setClass(context,ScreenSaverActivity.class);
                    context.startActivity(i);
                }catch (Exception e){
                    Log.i("TAG--ScreenService:",e.toString());
                }
            }
        };
        registerReceiver(mMasterResetReceiver,new IntentFilter(Intent.ACTION_SCREEN_OFF));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mMasterResetReceiver);
        ScreenService.this.stopSelf();
    }
}
