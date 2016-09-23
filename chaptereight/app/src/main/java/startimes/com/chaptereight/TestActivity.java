package startimes.com.chaptereight;

import android.app.Activity;
import android.content.Context;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class TestActivity extends Activity implements View.OnTouchListener {

    private static final String TAG="TestActivity";

    private Button mCreateWindowButton;

    private Button mFloatingButton;
    private WindowManager.LayoutParams mLayoutParams;
    private WindowManager mWindowManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        initView();
    }
    private void initView(){
        mCreateWindowButton= (Button) findViewById(R.id.button1);
        mWindowManager= (WindowManager) getSystemService(Context.WINDOW_SERVICE);
    }
    public void onButtonClicks(View v){
        if(v==mCreateWindowButton){
            mFloatingButton=new Button(this);
            mFloatingButton.setText("click me");
            mLayoutParams=new WindowManager.LayoutParams(WindowManager.LayoutParams.WRAP_CONTENT
            , WindowManager.LayoutParams.WRAP_CONTENT,0,0, PixelFormat.TRANSPARENT);
            mLayoutParams.flags= WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                    | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                    | WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED;
            mLayoutParams.type= WindowManager.LayoutParams.TYPE_SYSTEM_ERROR;
            mLayoutParams.gravity= Gravity.LEFT|Gravity.TOP;
            mLayoutParams.x=100;
            mLayoutParams.y=300;
            mFloatingButton.setOnTouchListener(this);
            mWindowManager.addView(mFloatingButton,mLayoutParams);
        }
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int rawX= (int) motionEvent.getRawX();
        int rawY= (int) motionEvent.getRawY();
        switch (motionEvent.getAction()){
            case MotionEvent.ACTION_DOWN:{
                break;
            }
            case MotionEvent.ACTION_MOVE:{
                int x= (int) motionEvent.getRawX();
                int y= (int) motionEvent.getRawY();
                mLayoutParams.x=rawX;
                mLayoutParams.y=rawY;
                mWindowManager.updateViewLayout(mFloatingButton,mLayoutParams);
                break;
            }
            case MotionEvent.ACTION_UP:{
                break;
            }
            default:
                break;
        }
        return false;
    }

    @Override
    protected void onDestroy() {
        try {
            mWindowManager.removeView(mFloatingButton);
        }catch(IllegalArgumentException e){
            e.printStackTrace();
        }
        super.onDestroy();
    }
}
