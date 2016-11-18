package startimes.com.servicedemo1.mixserviceuse;

import android.app.LoaderManager;
import android.app.Service;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.provider.MediaStore;

public class MusicService extends Service implements
        LoaderManager.LoaderCallbacks<Cursor>{

   private LoaderManager loaderManager;
    private Handler handler;

    public MusicService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("onCreate");
    }
    private boolean isLoader=true;
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.println("onStartCommand.loaderManager="+loaderManager);
        if(loaderManager!=null&&isLoader){
            loaderManager.initLoader(0,null,this);
            isLoader=false;
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        System.out.println("onBind");
        return new MusicLoader();
    }
    class MusicLoader extends Binder implements IMusicLoader{

        @Override
        public void onInit(LoaderManager loaderManager, Handler handler) {
            MusicService.this.loaderManager=loaderManager;
            MusicService.this.handler=handler;
        }
    }

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        if(i!=0) return null;
        return new CursorLoader(this, MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,null,null,null,null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        System.out.println("onLoadFinished");
        Message.obtain(handler,1,cursor).sendToTarget();
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}
