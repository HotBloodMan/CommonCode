package startimes.com.chaptereight;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.TextView;

public class DemoActivity extends AppCompatActivity {

    private static final String TAG="DemoActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        initView();
    }

    private void initView() {
        Dialog dialog = new Dialog(this.getApplicationContext());
        TextView textView = new TextView(this);
        textView.setText("this is toast");
        dialog.setContentView(textView);
        dialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ERROR);
        dialog.show();
    }
}
