package startimes.cn.bundledemos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void doGet(View v){
        Intent intent = new Intent(MainActivity.this, TarActivity.class);
        Bundle mBundle = new Bundle();
        mBundle.putString("Data","this is data");
        intent.putExtras(mBundle);
        startActivity(intent);
    }
}
