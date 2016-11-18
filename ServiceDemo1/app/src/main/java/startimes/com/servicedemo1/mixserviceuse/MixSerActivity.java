package startimes.com.servicedemo1.mixserviceuse;

import android.app.ListActivity;
import android.app.LoaderManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.provider.MediaStore;
import android.widget.CursorAdapter;
import android.widget.SimpleCursorAdapter;

import startimes.com.servicedemo1.MainActivity;

public class MixSerActivity extends ListActivity {
    LoaderManager loaderManager;
    private Handler handler;
    private IMusicLoader musicLoader;
    private ServiceConnection conn=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            musicLoader= (IMusicLoader) iBinder;
            musicLoader.onInit(loaderManager,handler);
            startService(new Intent(MixSerActivity.this,MusicService.class));
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };
    private SimpleCursorAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_mix_ser);
        loaderManager = getLoaderManager();
        handler=new ServiceHandler();
        Intent intent = new Intent(this,MusicService.class);
        bindService(intent,conn,BIND_AUTO_CREATE);
        adapter = new SimpleCursorAdapter(this,android.R.layout.simple_list_item_1,
                null,new String[]{MediaStore.Audio.Media.DISPLAY_NAME},new int[]{android.R.id.text1},
                CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        setListAdapter(adapter);
    }
    class ServiceHandler extends Handler{
        @Override
        public void handleMessage(Message msg) {
            System.out.println("handleMessage--msg= "+msg.obj.toString());
            adapter.swapCursor((Cursor) msg.obj);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(conn);
    }
}
