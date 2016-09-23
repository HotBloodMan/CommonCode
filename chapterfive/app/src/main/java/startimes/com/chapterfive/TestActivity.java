package startimes.com.chapterfive;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;

public class TestActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG="TestActivity";

    private Button mButton1;
    private View mButton2;

    private static int sId=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        initView();
    }

    private void initView() {
        mButton1= (Button) findViewById(R.id.button1);
        mButton1.setOnClickListener(this);
        mButton2= (Button) findViewById(R.id.button2);
        mButton2.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        if(view==mButton1){
            sId++;
            Notification notification = new Notification();
            notification.icon = R.drawable.ic_launcher;
            notification.tickerText = "hello world";
            notification.when = System.currentTimeMillis();
            notification.flags = Notification.FLAG_AUTO_CANCEL;
            Intent intent = new Intent(this, DemoActivity_2.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(this,
                    0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            //notification.setLatestEventInfo(this, "chapter_5", "this is notification.", pendingIntent);
            NotificationManager manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
            manager.notify(sId, notification);
        }else if(view==mButton2){
            sId ++;
            Notification notification = new Notification();
            notification.icon = R.drawable.ic_launcher;
            notification.tickerText = "hello world";
            notification.when = System.currentTimeMillis();
            notification.flags = Notification.FLAG_AUTO_CANCEL;
            Intent intent = new Intent(this, DemoActivity_1.class);
            intent.putExtra("sid", "" + sId);
            PendingIntent pendingIntent = PendingIntent.getActivity(this,
                    0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            System.out.println(pendingIntent);
            RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.layout_notification);
            remoteViews.setTextViewText(R.id.msg, "chapter_5: " + sId);
            remoteViews.setImageViewResource(R.id.icon, R.drawable.icon1);
            PendingIntent openActivity2PendingIntent = PendingIntent.getActivity(this,
                    0, new Intent(this, DemoActivity_2.class), PendingIntent.FLAG_UPDATE_CURRENT);
            remoteViews.setOnClickPendingIntent(R.id.open_activity2, openActivity2PendingIntent);
            notification.contentView = remoteViews;
            notification.contentIntent = pendingIntent;
            NotificationManager manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
            manager.notify(sId, notification);
        }
    }
}
