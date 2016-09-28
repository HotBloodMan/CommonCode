package startimes.com.androidartsearchchapter13crashtest;

import android.app.Application;

/**
 * Created by 1 on 2016/9/23.
 */
public class TestApp extends Application{

    private static TestApp sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance=this;

        //在这里为应用设置异常处理程序，然后我们的程序才能捕获未处理的异常
        CrashHandler crashHandler=CrashHandler.getsInstance();
        crashHandler.init(this);
    }

    public static TestApp getsInstance(){
        return sInstance;
    }
}
