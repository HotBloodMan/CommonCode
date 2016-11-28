package startimes.com.fragmentcallbackdemo;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;

public class MainActivity extends Activity implements TopsFragment.OnTopButtonClickedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(String name) {
        BottomsFragment fragment = (BottomsFragment) getFragmentManager().findFragmentByTag("bottom_fragment");
        fragment.updateText("onClick:"+name);
    }
}
