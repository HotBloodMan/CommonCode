package startimes.com.servicedemo1;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class MyBindService extends Service {
    public MyBindService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("onCreate");
    }

    @Override
    public IBinder onBind(Intent intent) {
        System.out.println("onBind");
        return new MsgBinder();
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        System.out.println("onRebind");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        System.out.println("onUnbind");
        return true;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("onDestroy");
    }
    class MsgBinder extends Binder implements IMessage{

        @Override
        public String obtain() {
            return "msg001";
        }
    }
}
