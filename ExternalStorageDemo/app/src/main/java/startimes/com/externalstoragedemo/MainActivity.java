package startimes.com.externalstoragedemo;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class MainActivity extends Activity {

    private ProgressBar pBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pBar = (ProgressBar) findViewById(R.id.progressBar1);
        //getExternalStates();
        getExternalDir();
    }
    //获得外部存储的存储状态
    public void getExternalStates() {
        String state = Environment.getExternalStorageState();
        System.out.println("--1--state=="+state.toString());
        if(state.equals(Environment.MEDIA_MOUNTED)){
            System.out.println("设备已经挂载...");
        }
        //判断外存储是否被移除
        if(!Environment.isExternalStorageRemovable()){
            System.out.println("设备没有被移除");
        }
    }

    //获得外部存储的存储目录
    public void getExternalDir(){
        File root = Environment.getExternalStorageDirectory();
        System.out.println("root=="+root.toString());
        File pic = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        System.out.println("---pic--="+pic.getPath().toString());
        File filesDir = getExternalFilesDir(Environment.DIRECTORY_MUSIC);
        System.out.println("***__*** filesDir=="+filesDir.toString());
        File cacheDir = getExternalCacheDir();
        System.out.println("cacheDir==="+cacheDir.toString());
    }

    public void getExternalSize(){
        File root = Environment.getExternalStorageDirectory();
        System.out.println("root--->>"+root.toString());

        //通过此类读取相关路径下的磁盘信息
        StatFs s = new StatFs(root.getPath());
        System.out.println("s=="+s.toString());
        //总大小
        int totalSize = s.getBlockCount() * s.getBlockSize() / 1024 / 1024;
        System.out.println("totalSize=="+totalSize);
        //可用
        int aSize = s.getAvailableBlocks() * s.getBlockSize()/1024/1024;
        System.out.println("--aSize--="+aSize);
        System.out.println("SDK_INT运行版本是="+ Build.VERSION.SDK_INT);
    }


public void onClick(View v){
    down();
}

    private void down() {
        //1获得raw目录文件
        InputStream in = getResources().openRawResource(R.raw.ic_launcher);
        //2获得sdcard状态
        if (!Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            Toast.makeText(MainActivity.this, "请确认你的sdcard是否已经挂载", Toast.LENGTH_SHORT).show();
            return;
        }
        //3获得下载位置（路径）
        File picFile = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        //4判定可用空间
        StatFs fs = new StatFs(picFile.getPath());
        System.out.println("---fs--=" + fs.toString());
        int aSize = fs.getAvailableBlocks() * fs.getBlockSize();
        System.out.println("aSize===" + aSize);
        OutputStream out = null;
        int len = -1;
        byte buf[] = new byte[10];
        try {
            if (aSize < in.available()) {
                System.out.println("空间不足...");
                return;
            }
            //设置进度的最大值
            pBar.setMax(in.available());
            out = new FileOutputStream(new File(picFile, "a1.png"));
            while ((len = in.read(buf)) != -1) {
                out.write(buf, 0, len);
                pBar.incrementProgressBy(len);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "下载错误！！！", Toast.LENGTH_SHORT).show();
        } finally {
            //释放资源
            if (in != null) try {
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (out != null) try {
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}