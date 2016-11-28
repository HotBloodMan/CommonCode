package startimes.com.webviewdemo;

import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by 1 on 2016/11/25.
 */
public class HttpThread extends Thread{
    String urls;
    public HttpThread(String url){
        this.urls=url;
    }
    
    @Override
    public void run() {
        super.run();
        System.out.println("开始下载...");
        try {
            URL url = new URL(urls);
            HttpURLConnection con= (HttpURLConnection) url.openConnection();
            con.setDoInput(true);
            con.setDoOutput(true);
            con.connect();
            InputStream is = con.getInputStream();
            File downloadFile;
            File sdFile;


            FileOutputStream out = null;
            if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
                downloadFile=Environment.getExternalStorageDirectory();
                System.out.println("downloadFile---->"+downloadFile.toString());
                sdFile=new File(downloadFile,"test.apk");
                System.out.println("sdFile--------->"+sdFile.toString());
                out=new FileOutputStream(sdFile);
            }
                byte [] b=new byte[6*1024];
                int len;
                while((len=is.read(b))!=-1){
                    if(out!=null){
                        out.write(b,0,len);
                    }
            }
            if(out!=null){
                out.close();
            }
            if(is!=null){
                out.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
}
