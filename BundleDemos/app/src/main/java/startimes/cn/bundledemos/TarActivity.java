package startimes.cn.bundledemos;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class TarActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tar);
        Bundle bundle = getIntent().getExtras();
        String data = bundle.getString("Data");
        Log.d("TAG","cccc data***===>"+data.toString());
        setTitle(data);

    }
}
