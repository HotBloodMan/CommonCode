package com.liu.demo;
import java.util.ArrayList;

import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fragmentdemo.R;

public class MainActivity extends FragmentActivity{
	 private ViewPager mPager;  
	    private ArrayList<Fragment> fragmentList;  
	    private TextView barText;  
	    private TextView view1, view2, view3, view4;  
	    private int currIndex;//当前页卡编号  
	    @Override  
	    protected void onCreate(Bundle savedInstanceState) {  
	        super.onCreate(savedInstanceState);  
	        setContentView(R.layout.main);  
	          
	        InitTextView();  
	        InitTextBar();  
	        InitViewPager();  
	    }  
	    /* 
	     * 初始化标签名 
	     */  
	    public void InitTextView(){  
	        view1 = (TextView)findViewById(R.id.tv_guid1);  
	        view2 = (TextView)findViewById(R.id.tv_guid2);  
	        view3 = (TextView)findViewById(R.id.tv_guid3);  
	        view4 = (TextView)findViewById(R.id.tv_guid4);  
	          
	        view1.setOnClickListener(new txListener(0));  
	        view2.setOnClickListener(new txListener(1));  
	        view3.setOnClickListener(new txListener(2));  
	        view4.setOnClickListener(new txListener(3));  
	    }  
	    public class txListener implements View.OnClickListener{  
	        private int index=0;  
	          
	        public txListener(int i) {  
	            index =i;  
	        }  
	        @Override  
	        public void onClick(View v) {  
	            mPager.setCurrentItem(index);  
	        }  
	    }  
	    /* 
	     * 初始化图片的位移像素 
	     */  
	    public void InitTextBar(){  
	    	barText = (TextView) super.findViewById(R.id.cursor);
	    	Display display = getWindow().getWindowManager().getDefaultDisplay();
	    	          // 得到显示屏宽度
	        DisplayMetrics metrics = new DisplayMetrics();
	    	display.getMetrics(metrics);
	    	          // 1/3屏幕宽度
	    	int  tabLineLength = metrics.widthPixels / 4;
	    	 LayoutParams lp = (LayoutParams) barText.getLayoutParams();
	    	 lp.width = tabLineLength;
	    	 barText.setLayoutParams(lp);
	    	        
	    }  
	    /* 
	     * 初始化ViewPager 
	     */  
	    public void InitViewPager(){  
	        mPager = (ViewPager)findViewById(R.id.viewpager);  
	        fragmentList = new ArrayList<Fragment>();  
	        Fragment btFragment= new ButtonFragment();  
	        Fragment secondFragment = TestFragment.newInstance("this is second fragment");  
	        Fragment thirdFragment = TestFragment.newInstance("this is third fragment");  
	        Fragment fourthFragment = TestFragment.newInstance("this is fourth fragment");  
	        fragmentList.add(btFragment);  
	        fragmentList.add(secondFragment);  
	        fragmentList.add(thirdFragment);  
	        fragmentList.add(fourthFragment);  
	          
	        //给ViewPager设置适配器  
	        mPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(), fragmentList));  
	        mPager.setCurrentItem(0);//设置当前显示标签页为第一页  
	        mPager.setOnPageChangeListener(new MyOnPageChangeListener());//页面变化时的监听器  
	    }  
	    public class MyOnPageChangeListener implements OnPageChangeListener{  
	          
	        @Override  
	        public void onPageScrolled(int arg0, float arg1, int arg2) {  
	            // TODO Auto-generated method stub  
	        	  // 取得该控件的实例
                LinearLayout.LayoutParams ll = (android.widget.LinearLayout.LayoutParams) barText
                        .getLayoutParams();
                
                if(currIndex == arg0){
                	 ll.leftMargin = (int) (currIndex * barText.getWidth() + arg1
                             * barText.getWidth());
                }else if(currIndex > arg0){
                	 ll.leftMargin = (int) (currIndex * barText.getWidth() - (1 - arg1)* barText.getWidth());
                }
                barText.setLayoutParams(ll);
	        }  
	        @Override  
	        public void onPageScrollStateChanged(int arg0) {  
	            // TODO Auto-generated method stub  
	        }  
	        @Override  
	        public void onPageSelected(int arg0) {  
	            // TODO Auto-generated method stub  
	            currIndex = arg0;   
	            int i = currIndex + 1;  
	            Toast.makeText(MainActivity.this, "您选择了第"+i+"个页卡", Toast.LENGTH_SHORT).show();  
	        }  
	    }  
}
