package startimes.com.servicedemo1;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {

    private Button start;
    private Button stop;
    private Button getInfo;
    private Button btnIntentService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start = (Button) findViewById(R.id.start_main);
        stop = (Button) findViewById(R.id.stop_main);
        getInfo = (Button) findViewById(R.id.info_main);
        btnIntentService = (Button) findViewById(R.id.intentService_main);
        start.setOnClickListener(this);
        stop.setOnClickListener(this);
        getInfo.setOnClickListener(this);
        btnIntentService.setOnClickListener(this);
    }
    private IMessage msg;
    private ServiceConnection con=new ServiceConnection(){

        //此service绑定被异常终止时执行
        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            System.out.println("onServiceDisconnected");

        }
        //service绑定OK以后执行
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            System.out.println("onServiceConnected");
            msg= (IMessage) iBinder;
        }

    };

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.start_main:
//                //1 启动模式的服务
//                Intent intent = new Intent(MainActivity.this,MyStartService.class);
//                intent.putExtra("A","play");
//                startService(intent);
                //2 绑定模式的服务
                Intent intent = new Intent(MainActivity.this,MyBindService.class);
               
                bindService(intent,con,BIND_AUTO_CREATE);

            break;
            case R.id.stop_main:
//                //1 启动模式的服务
//                Intent intent2 = new Intent(MainActivity.this,MyStartService.class);
//                intent2.putExtra("A","pause");
//                startService(intent2);
                //2 绑定模式的服务
                unbindService(con);
                break;
            //绑定模式下收消息
            case R.id.info_main:
                System.out.println("收到消息："+msg.obtain());
                break;
            //intentservice的使用
            case R.id.intentService_main:
                startService(new Intent(MainActivity.this,MyIntentService.class));
                break;
        }
    }
}
