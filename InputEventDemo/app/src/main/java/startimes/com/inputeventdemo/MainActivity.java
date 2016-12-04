package startimes.com.inputeventdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity implements ViewSwitcher.ViewFactory, View.OnTouchListener {

    private int images[]={R.drawable.png_01,R.drawable.png_02,
            R.drawable.png_03,R.drawable.png_04,R.drawable.png_05,
            R.drawable.png_06};
    private ImageSwitcher imageSwitcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher);
        imageSwitcher.setFactory(this);
        //添加动画
        imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_in));
        imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_out));
        imageSwitcher.setImageResource(images[0]);
        //设置touch事件
        imageSwitcher.setOnTouchListener(this);
    }

    @Override
    public View makeView() {
        ImageView imageView = new ImageView(this);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setLayoutParams(new ImageSwitcher.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT
        ));
        return imageView;
    }
    //事件
    private float downX,upX,distance;
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        System.out.println("acation---> "+action);
        if(action==MotionEvent.ACTION_DOWN){
            downX=motionEvent.getX();
        }else if(action==MotionEvent.ACTION_UP){
            upX=motionEvent.getX();
            distance=upX-downX;
            if(distance>50){//向右滑动
                showPre();
            }else if(distance<-50){//向左滑动
                showNext();
            }
        }
        return true;//结束事件传递（冒泡）；
    }
    private int position;
    //显示下一张
    private void showNext() {
    position++;
    if(position==images.length){
        position=0;
    }
        imageSwitcher.setImageResource(images[position]);
    }
    //显示上一张
    private void showPre() {
      position--;
      if(position<0){
        position=images.length-1;
    }
        imageSwitcher.setImageResource(images[position]);
    }

}
