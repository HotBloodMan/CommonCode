package startimes.com.radiobuttondemo;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.RadioGroup;

public class MainActivity extends Activity implements RadioGroup.OnCheckedChangeListener {

    private RadioGroup rg;
    private int mIndex=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg = (RadioGroup) findViewById(R.id.radioGroup1);
        initFragment();
        rg.setOnCheckedChangeListener(this);
    }

    Fragment[] mFragments;
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        int radioButtonId = radioGroup.getCheckedRadioButtonId();
        switch (radioButtonId){
            case R.id.radio0:
                setIndexSelected(0);
            break;
            case R.id.radio1:
                setIndexSelected(1);
            break;
        }
    }
    private void initFragment(){
        //航班
        FlightFragment flighFrg=new FlightFragment();
        //费用
        CostFragment costFrg=new CostFragment();
        //添加到数组中
        mFragments=new Fragment[]{flighFrg,costFrg};

        //开启事务
        FragmentTransaction ft =getFragmentManager().beginTransaction();
        ft.add(R.id.content,flighFrg).commit();
        System.out.println("1111111111111 ");
        //默认设置为第0个
       // setIndexSelected(0);

    }


    private void setIndexSelected(int i) {
        System.out.println("22222222222222 ");
        if(mIndex==i){
            return;
        }
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        //隐藏
        ft.hide(mFragments[mIndex]);
        System.out.println("yyyyyyyyyyy-->i== "+i);
        System.out.println("yyyyyyyyyyy-->mIndex== "+mIndex);
        //判断是否添加
        if(!mFragments[i].isAdded()){
            System.out.println("&&& Not isAdded");
//            ft.add(R.id.content,mFragments[i]).show(mFragments[i]);
            ft.add(R.id.content,mFragments[i]);
        }else{
            System.out.println("&&& isAdded");
            ft.show(mFragments[i]);
        }
        ft.commit();
        //再次赋值
        mIndex=i;
        System.out.println("33333333333333 ");
    }


}
