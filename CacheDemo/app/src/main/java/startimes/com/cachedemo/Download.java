package startimes.com.cachedemo;

import android.os.Handler;
import android.os.Message;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by 1 on 2016/11/29.
 */
public class Download extends Thread {
    private String mUrl;
    private CacheAdapter mCacheAdapter;
    private String mFilename;
    private HttpURLConnection conn;

    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            mCacheAdapter.notifyDataSetChanged();
            System.out.println("success 77777");
        }
    };

    public Download(CacheAdapter adapter,String url) {
        mCacheAdapter=adapter;
        mUrl=url;
        mFilename="/sdcard/"+url.hashCode();
    }
    @Override
    public void run() {
        super.run();
        try {
            System.out.println("666666");
            URL url = new URL(mUrl);
            conn = (HttpURLConnection) url.openConnection();
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod("GET");
            conn.connect();
            InputStream is = conn.getInputStream();
            FileOutputStream out;
            System.out.println("mFilename====>>"+mFilename.toString());
            out=new FileOutputStream(mFilename);
            byte[] bit=new byte[8192];
            int len=0;
            while((len=is.read(bit))>-1){
                if(out!=null){
                    out.write(bit,0,len);
                }
            }
            out.close();;
            is.close();
            conn.disconnect();
            handler.sendEmptyMessage(0);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
