package startimes.com.externalstoragedemo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

public class InternalDemoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_demo);
        File dataDirectory = Environment.getDataDirectory();
        System.out.println("dataDirectory=="+dataDirectory.toString());

        File rootDir = Environment.getRootDirectory();
        System.out.println("rootDir=="+rootDir.toString());

        try{
            //写
            OutputStream os=openFileOutput("a1.txt", Context.MODE_APPEND);
            byte[] bytes = "hello".getBytes();
            System.out.println("bytes--->"+bytes.toString());
            os.write("hello".getBytes());
            os.close();
            //读
            byte buf[]=new byte[5];
            InputStream in = openFileInput("a1.txt");
            in.read(buf);
            System.out.println("buf3434-->"+new String(buf));

            File cacheDir =  //内部存储的缓存目录
                    this.getCacheDir();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //获得磁盘中的一个缓存目录（一般缓存都是应用程序私有存储目录）
    //1先找外置sdcard的缓存
    //2假如外置sdcard不存在，或者非挂载状态
    public static File getDiskCacheDir(Context context,String uniqueName){
        final String cachePath = Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState()) ||
                !Environment.isExternalStorageRemovable()
                ? context.getExternalCacheDir().getPath() //访问方法需要添加外置sdcard的写权限。
                : context.getCacheDir().getPath();
            return new File(cachePath+File.separator+uniqueName);
    }
}
