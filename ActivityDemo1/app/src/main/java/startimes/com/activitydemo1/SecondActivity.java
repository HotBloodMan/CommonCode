package startimes.com.activitydemo1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends Activity {

    private TextView tvs;
    private Button btnSecond;
    private Person serializable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tvs = (TextView) findViewById(R.id.tv);
        btnSecond = (Button) findViewById(R.id.btn_Second);
        //Bundle bundle = getIntent().getBundleExtra("data");
//        System.out.println("bundle= "+bundle);
//        Serializable person =bundle.getString("person");
        serializable = (Person) getIntent().getExtras().getSerializable("person");
        System.out.println("你接收的客户信息是:"+ serializable);
        tvs.setText("你接收的客户信息是:"+ serializable);
        btnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this,MainActivity.class);
                intent.putExtra("data2",serializable);
                setResult(100,intent);
                SecondActivity.this.finish();
            }
        });

    }
}
