package startimes.com.cachedemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1 on 2016/11/29.
 */
public class CacheAdapter extends BaseAdapter{

    private List<String> mUrls=new ArrayList<String>();
    private LayoutInflater mLayoutInflater;
    private Context mContext;

    public CacheAdapter(Context context) {
        mUrls.add("http://ww4.sinaimg.cn/bmiddle/84217b4fjw1e3zvdsjtupj20ih0ppn13.jpg");
        mUrls.add("http://ww2.sinaimg.cn/bmiddle/76a19fefjw1e3zr5z0zi7j20sg0fjtdg.jpg");
        mUrls.add("http://ww1.sinaimg.cn/bmiddle/475b3d56jw1e3zvdwoln1j208c08c0tr.jpg");
        mUrls.add("http://ww1.sinaimg.cn/bmiddle/6e3fa31fjw1e3zvfd6zqlj20c807fwfr.jpg");
        mUrls.add("http://ww1.sinaimg.cn/bmiddle/6adce985jw1e3zttk0v20j20b408cglh.jpg");
        mUrls.add("http://ww1.sinaimg.cn/bmiddle/63918611jw1e3ztipg4lij205r064dge.jpg");
        mUrls.add("http://ww2.sinaimg.cn/bmiddle/76a19fefjw1e3zr5z0zi7j20sg0fjtdg.jpg");
        mUrls.add("http://ww1.sinaimg.cn/bmiddle/475b3d56jw1e3zvdwoln1j208c08c0tr.jpg");
        mUrls.add("http://ww1.sinaimg.cn/bmiddle/6e3fa31fjw1e3zvfd6zqlj20c807fwfr.jpg");
        mUrls.add("http://ww1.sinaimg.cn/bmiddle/6adce985jw1e3zttk0v20j20b408cglh.jpg");
        mUrls.add("http://ww1.sinaimg.cn/bmiddle/63918611jw1e3ztipg4lij205r064dge.jpg");
        mUrls.add("http://ww2.sinaimg.cn/bmiddle/76a19fefjw1e3zr5z0zi7j20sg0fjtdg.jpg");
        mUrls.add("http://ww1.sinaimg.cn/bmiddle/475b3d56jw1e3zvdwoln1j208c08c0tr.jpg");
        mUrls.add("http://ww1.sinaimg.cn/bmiddle/6e3fa31fjw1e3zvfd6zqlj20c807fwfr.jpg");
        mUrls.add("http://ww1.sinaimg.cn/bmiddle/6adce985jw1e3zttk0v20j20b408cglh.jpg");
        mUrls.add("http://ww1.sinaimg.cn/bmiddle/63918611jw1e3ztipg4lij205r064dge.jpg");
        mUrls.add("http://ww2.sinaimg.cn/bmiddle/76a19fefjw1e3zr5z0zi7j20sg0fjtdg.jpg");
        mUrls.add("http://ww1.sinaimg.cn/bmiddle/475b3d56jw1e3zvdwoln1j208c08c0tr.jpg");
        mUrls.add("http://ww1.sinaimg.cn/bmiddle/6e3fa31fjw1e3zvfd6zqlj20c807fwfr.jpg");
        mUrls.add("http://ww1.sinaimg.cn/bmiddle/6adce985jw1e3zttk0v20j20b408cglh.jpg");
        mUrls.add("http://ww1.sinaimg.cn/bmiddle/63918611jw1e3ztipg4lij205r064dge.jpg");
        mUrls.add("http://ww2.sinaimg.cn/bmiddle/76a19fefjw1e3zr5z0zi7j20sg0fjtdg.jpg");
        mUrls.add("http://ww1.sinaimg.cn/bmiddle/475b3d56jw1e3zvdwoln1j208c08c0tr.jpg");
        mUrls.add("http://ww1.sinaimg.cn/bmiddle/6e3fa31fjw1e3zvfd6zqlj20c807fwfr.jpg");
        mUrls.add("http://ww1.sinaimg.cn/bmiddle/6adce985jw1e3zttk0v20j20b408cglh.jpg");
        mUrls.add("http://ww1.sinaimg.cn/bmiddle/63918611jw1e3ztipg4lij205r064dge.jpg");
        mUrls.add("http://ww2.sinaimg.cn/bmiddle/76a19fefjw1e3zr5z0zi7j20sg0fjtdg.jpg");
        mUrls.add("http://ww1.sinaimg.cn/bmiddle/475b3d56jw1e3zvdwoln1j208c08c0tr.jpg");
        mUrls.add("http://ww1.sinaimg.cn/bmiddle/6e3fa31fjw1e3zvfd6zqlj20c807fwfr.jpg");
        mUrls.add("http://ww1.sinaimg.cn/bmiddle/6adce985jw1e3zttk0v20j20b408cglh.jpg");
        mUrls.add("http://ww1.sinaimg.cn/bmiddle/63918611jw1e3ztipg4lij205r064dge.jpg");
        mUrls.add("http://ww2.sinaimg.cn/bmiddle/76a19fefjw1e3zr5z0zi7j20sg0fjtdg.jpg");
        mUrls.add("http://ww1.sinaimg.cn/bmiddle/475b3d56jw1e3zvdwoln1j208c08c0tr.jpg");
        mUrls.add("http://ww1.sinaimg.cn/bmiddle/6e3fa31fjw1e3zvfd6zqlj20c807fwfr.jpg");
        mUrls.add("http://ww1.sinaimg.cn/bmiddle/6adce985jw1e3zttk0v20j20b408cglh.jpg");
        mUrls.add("http://ww1.sinaimg.cn/bmiddle/63918611jw1e3ztipg4lij205r064dge.jpg");



        mLayoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return mUrls.size();
    }
    @Override
    public Object getItem(int i) {
        return null;
    }
    @Override
    public long getItemId(int i) {
        return 0;
    }
    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        if(convertView==null){
            System.out.println("2222convertView==null");
            convertView=mLayoutInflater.inflate(R.layout.item,null);
        }
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageview);
        System.out.println("33333 imageView");
        imageView.setImageBitmap(getBitmap(i));
        return convertView;
    }
    //cache
    private Bitmap getBitmap(int i) {
    Bitmap bitmap=null;
    String filename="/sdcard/"+mUrls.get(i).hashCode();
    System.out.println("44444 filename---rr->"+filename.toString());
     if(new File(filename).exists()){
         try {
             bitmap= BitmapFactory.decodeFile(filename);
         }catch(Exception e){

         }
     }else{
         BitmapFactory.decodeResource(mContext.getResources(),R.drawable.ic_launcher);
         new Download(this,mUrls.get(i)).start();
     }
        return bitmap;
    }
}
