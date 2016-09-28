package startimes.com.androidartsearchchapter13crashtest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    private void initView() {
        Button mButton = (Button) findViewById(R.id.button1);
        mButton.setOnClickListener((View.OnClickListener) this);
    }
    public void onClick(View v){
        if(v==mButton){
            //在这里模拟异常抛出情况，人为抛出异常
            throw new RuntimeException("自定义异常：这是自己抛出的异常");
        }
    }
}
