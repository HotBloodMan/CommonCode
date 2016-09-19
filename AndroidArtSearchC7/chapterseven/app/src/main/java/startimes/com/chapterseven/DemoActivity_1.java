package startimes.com.chapterseven;

import android.animation.IntEvaluator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class DemoActivity_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_activity_1);
        initView();
    }

    private void initView() {
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if(hasFocus){
            Button button = (Button) findViewById(R.id.button1);
            performAnimate(button,button.getWidth(),500);
        }
    }

    private void performAnimate(final View target,final int start, final int end) {
        ValueAnimator valueAnimator = ValueAnimator.ofInt(1, 100);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            //持有一个IntEvaluator对象，方便下面估值的时候使用
            private IntEvaluator mEvaluator=new IntEvaluator();
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int currentValue= (int) valueAnimator.getAnimatedValue();
                Log.d("TAG","current value:"+currentValue);

                //获得当前进度占整个动画过程的比例，浮点型，0-1z之间
                float fraction = valueAnimator.getAnimatedFraction();

                //直接调用整形估值器通过比例计算宽度，然后再设给button
                target.getLayoutParams().width=mEvaluator.evaluate(fraction,start,end);
                target.requestLayout();
            }
        });
        valueAnimator.setDuration(5000).start();
    }
}
