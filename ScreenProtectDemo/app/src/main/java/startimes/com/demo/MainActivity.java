package startimes.com.demo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import java.util.Date;

//需求:就是当软件在一定时间没有操作时候需要弹出广告页面，当点击广告页面时又进行软件操作，
// 也就是广告要在软件打开并且处于未操作状态才会出来。
//http://www.apkbus.com/blog-705730-62442.html
//解决方法：使用双线程实现
public class MainActivity extends AppCompatActivity {
    private Handler mHandler01=new Handler();
    private Handler mHandler02=new Handler();
    //上一次用戶动作的时间戳
    private Date lastUpdateTime;
    //计算用户有几秒没有动作
    private long timePeriod;

    private float mHoldStillTime=10;
    private boolean isRunScreenSaver;

    private long intervalScreenSaver=1000;
    private long intervalKeypadeSaver=1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((Button) findViewById(R.id.btn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mService = new Intent(MainActivity.this, ScreenService.class);
                mService.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startService(mService);
            }
        });

        lastUpdateTime = new Date(System.currentTimeMillis());
    }
    //计时线程
    private Runnable mTask1=new Runnable() {
        @Override
        public void run() {
            Date timeNow = new Date(System.currentTimeMillis());
            /* 计算User静止不动作的时间间距 */
            /**当前的系统时间 - 上次触摸屏幕的时间 = 静止不动的时间**/
            timePeriod=(long)timeNow.getTime()-(long)lastUpdateTime.getTime();
            //将静止时间毫秒换算成秒
            float timePerioSecond=((float)timePeriod/1000);
            if(timePerioSecond>mHoldStillTime){
                if(isRunScreenSaver==false){//说明没有进入屏保
                    mHandler02.postAtTime(mTask02,intervalKeypadeSaver);
                    isRunScreenSaver=true;
                }else{
                     /*屏保正在显示中*/
                }
            }else{
                isRunScreenSaver=false;
            }
            mHandler01.postDelayed(mTask1,intervalScreenSaver);
        }
    };
    //持续屏保显示线程
    private Runnable mTask02=new Runnable(){
        @Override
        public void run() {
        if(isRunScreenSaver==true){//如果屏保正在显示，就计算不断继续显示
            showScreenSaver();
            mHandler02.postDelayed(mTask02,intervalScreenSaver);
        }else{
            mHandler02.removeCallbacks(mTask02);//如果屏保没有显示则移除线程
        }
        }
    };
    //显示屏保
    private void showScreenSaver() {
        Log.d("TAG","显示屏保。。。。。。");
        Intent intent = new Intent(MainActivity.this,ScreenSaverActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        updateUserActionTime();
        return super.dispatchKeyEvent(event);
    }
    /*用户有操作的时候不断重置静止时间和上次操作的时间*/
    private void updateUserActionTime() {
        Date timeNow = new Date(System.currentTimeMillis());
        timePeriod=timeNow.getTime()-lastUpdateTime.getTime();
        lastUpdateTime.setTime(timeNow.getTime());
    }

    @Override
    protected void onResume() {
        //activity显示的时候启动线程
        mHandler01.postAtTime(mTask1,intervalKeypadeSaver);
        super.onResume();
    }

    @Override
    protected void onPause() {
        mHandler01.removeCallbacks(mTask1);
        mHandler02.removeCallbacks(mTask02);
        super.onPause();
    }
}
