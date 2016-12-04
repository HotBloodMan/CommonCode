package startimes.com.externalstoragedemo;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class ComplexStorageActivity extends Activity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complex_storage);
        imageView = (ImageView) findViewById(R.id.imgId);
        //先从缓存中读
       File file=getDiskCacheDir(this,"a1.png");
        System.out.println("1111 file=="+file.toString());
        if(!file.exists()){
            //缓存数据（从网络读取文件，将其写到本地sdcard）
            cacheFileToDisk(this,"t1.png");
            //显示图片
        }
        imageView.setImageURI(Uri.fromFile(file));
    }
    //点击图片时记录访问次数
    public void onClick(View v){
        SharedPreferences sp = getPreferences(0);
        int n = sp.getInt("t1.png", 0);
        Toast.makeText(ComplexStorageActivity.this,"第"+(++n)+"次访问",Toast.LENGTH_SHORT).show();
        System.out.println("22222vvn==="+n);
        SharedPreferences.Editor et=sp.edit();
        et.putInt("t1.png",n);
        et.commit();
    }
    public void cacheFileToDisk(Context context,String fileName) {
        //假设pictures目录为网络图片
        File picDir = Environment.getExternalStorageDirectory();
        System.out.println("3333 picDir===>" + picDir.toString());

        File cacheDir = getExternalCacheDir();
        System.out.println("4444 cacheDir==" + cacheDir.toString());
        File srcFile = new File(picDir, "t1.png");
        System.out.println("55555 srcFile==" + srcFile.toString());
        File destFile = new File(cacheDir, "t1.png");
        System.out.println("66666 destFile==" + destFile.toString());

        InputStream in = null;
        OutputStream out = null;
        int len = -1;
        byte buf[] = new byte[1024];
        try {
            in = new BufferedInputStream(new FileInputStream(srcFile));
            out = new BufferedOutputStream(new FileOutputStream(destFile));
            while ((len = in.read(buf)) != -1) {
                out.write(buf, 0, len);
            }
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null) try {
            } catch (Exception e) {
            }
            if (out != null) try {
            } catch (Exception e) {
            }
        }
    }
    //从缓存中读取图片
    private File getDiskCacheDir(Context context, String s) {
       final String cachePath = Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState()) ||
                !Environment.isExternalStorageRemovable()
                ? context.getExternalCacheDir().getPath()
                : context.getCacheDir().getPath();
        File fileName = new File(cachePath + File.separator + s);
        System.out.println("7777 fileName=="+fileName.toString());
        return fileName;
    }
}
