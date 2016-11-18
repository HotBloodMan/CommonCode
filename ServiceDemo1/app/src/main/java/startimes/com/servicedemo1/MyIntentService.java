package startimes.com.servicedemo1;

import android.app.IntentService;
import android.content.Intent;
import android.os.IBinder;

public class MyIntentService extends IntentService {


    public MyIntentService() {
        super("MyIntentService");
        System.out.println("11111111");
    }
    public MyIntentService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
    System.out.println("onHandleIntent");
        String name = Thread.currentThread().getName();
        System.out.println("name== "+name.toString());
    }

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("onCreate");
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        System.out.println("onStart");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.println("onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("onDestroy");
    }

    @Override
    public IBinder onBind(Intent intent) {
        System.out.println("onBind");
        return super.onBind(intent);
    }
}
