package startimes.com.servicedemo1;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyStartService extends Service {
    public MyStartService() {
    }

    @Override
    public IBinder onBind(Intent intent) {

        System.out.println("onBind");
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.println("onStartCommand");
        String action = intent.getStringExtra("A");
        if(action.equals("play")) {

            System.out.println("Music should be play");
        }
        if(action.equals("pause")){
            System.out.println("Music should be pause");
        }
        return START_REDELIVER_INTENT;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("onDestroy");
    }
}
