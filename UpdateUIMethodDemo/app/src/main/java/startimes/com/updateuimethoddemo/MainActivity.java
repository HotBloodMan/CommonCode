package startimes.com.updateuimethoddemo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class MainActivity extends Activity {
    public static String s="Welcome to Android";
    private TextView tvShow;
    Handler h=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what==1){
               String res= (String) msg.obj;
                tvShow.setText(res);
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvShow = (TextView) findViewById(R.id.tv);
        ShowInfo();
    }
    private void ShowInfo() {
        ExecutorService es =
                //创建一个只有一个线程的线程池
                Executors.newSingleThreadExecutor();
                //创建一个有上线的线程池
               //Executors.newFixedThreadPool(2);
               //构建一个没有上限的线程池，具体上限为多少由操作而定。
               // Executors.newCachedThreadPool();
        es.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
//                    //方式（1）
//                    h.post(new Runnable() {
//                        @Override
//                        public void run() {
//                        tvShow.setText(s);
//                        }
//                    });

                    //方式（2）handler发消息
                    Message message = new Message();
                    message.what=1;//发送的标志
                    message.obj=s;//发送的信息
                    h.sendMessage(message);
                    //方式（3）runOnUiThread
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            tvShow.setText(s);
//                        }
//                    });
                    //方式（4）view.post()方式
  //                  viewUI();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        //关闭线程池(一般是停止服务时关闭线程池)
        es.shutdown();
    }
    private void viewUI() {
        tvShow.post(new Runnable() {
            @Override
            public void run() {
            tvShow.setText(s);
            }
        });
    }
}
