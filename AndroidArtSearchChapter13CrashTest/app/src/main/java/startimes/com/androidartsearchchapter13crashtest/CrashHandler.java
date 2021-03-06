package startimes.com.androidartsearchchapter13crashtest;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.util.Log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 1 on 2016/9/23.
 */
public class CrashHandler implements Thread.UncaughtExceptionHandler{
    private static final String TAG="CrashHandler";
    private static final boolean DEBUG=true;

    private static final String PATH= Environment.getExternalStorageDirectory().getPath()+"/CrashTest/log";
    private static final String FILE_NAME="crash";
    private static final String FILE_NAME_SUFFIX=".trace";

    private static CrashHandler sInstance=new CrashHandler();
    private Thread.UncaughtExceptionHandler mDefaultCrashHandler;
    private Context mContext;

    private CrashHandler(){}

    public static CrashHandler getsInstance(){
        return sInstance;
    }

    public void init(Context context){
        mDefaultCrashHandler=Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
        mContext=context.getApplicationContext();
    }
    //这个是最关键的函数，当程序中有未被捕获的异常，系统将会自动调用#uncaughtException方法
    //thread为出现未捕获的线程，ex为未捕获的异常，有了这个ex,我们就得到异常信息
    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        try {
            dumpExceptionToSDCard(ex);
            uploadExceptionToServer();
            //这里可以通过网络上传异常信息到服务器，便于开发人员分析日志从而解决bug
        }catch (Exception e){
          e.printStackTrace();
        }
    }
    private void dumpExceptionToSDCard(Throwable ex) throws IOException{
        if(!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
            if(DEBUG){
                Log.w(TAG,"sdcard unmounted,skip dump exception");
                return;
            }
        }
        File dir = new File(PATH);
        if(!dir.exists()){
            dir.mkdirs();
        }
        long current = System.currentTimeMillis();
        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(current));
        File file = new File(PATH + FILE_NAME + time + FILE_NAME_SUFFIX);
        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
            pw.print(time);
            dumpPhoneInfo(pw);
            pw.println();
            ex.printStackTrace();
            pw.close();
        }catch (Exception e){
            Log.e(TAG,"dump crash info failed");
        }
    }
    private void dumpPhoneInfo(PrintWriter pw) throws PackageManager.NameNotFoundException{
        PackageManager pm = mContext.getPackageManager();
        PackageInfo pi = pm.getPackageInfo(mContext.getPackageName(), PackageManager.GET_ACTIVITIES);
        pw.print("App Version");
        pw.print(pi.versionName);
        pw.print('_');
        pw.println(pi.versionCode);

        //android版本号
        pw.print("OS Version:");
        pw.print(Build.VERSION.RELEASE);
        pw.print('_');
        pw.print(Build.VERSION.SDK_INT);

        //手机制造商
        pw.print("Vendor:");
        pw.println(Build.MANUFACTURER);

        //手机型号
        pw.print("Model");
        pw.print(Build.MODEL);

        //cpu架构
        pw.print("CPU ABI:");
        pw.println(Build.CPU_ABI);
    }
    private void uploadExceptionToServer(){

    }

}
