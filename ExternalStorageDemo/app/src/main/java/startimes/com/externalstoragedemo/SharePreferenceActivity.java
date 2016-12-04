package startimes.com.externalstoragedemo;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SharePreferenceActivity extends AppCompatActivity {

    private EditText etNum;
    private EditText etPass;
    private Button btnPut;
    private Button btnGet;
    private TextView tvShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_preference);
        etNum = (EditText) findViewById(R.id.etNumber);
        etPass = (EditText) findViewById(R.id.etPassWord);
        btnPut = (Button) findViewById(R.id.btn_put);
        btnGet = (Button) findViewById(R.id.btn_get);
        tvShow = (TextView) findViewById(R.id.tv_Show);
        btnPut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                putData();
            }
        });
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getData();
            }
        });
    }

    private void getData() {
        SharedPreferences ss = this.getSharedPreferences("NiuBi", Context.MODE_PRIVATE);
        String number = ss.getString("Number", "fail");
        String password=ss.getString("Password","fail");
        Toast.makeText(SharePreferenceActivity.this,"拿到账号为 "+number+"和密码为 "+password,Toast.LENGTH_SHORT).show();
        System.out.println("number== "+number+" password== "+password);

    }

    public void putData(){
        String sNum = etNum.getText().toString();
        String sPass = etPass.getText().toString();
        SharedPreferences sp = this.getSharedPreferences("NiuBi", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putString("Number",sNum);
        edit.putString("Password",sPass);
        edit.commit();
    }

}
