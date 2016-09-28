package activity.example.startime.lrucache;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewTreeObserver;
import android.widget.GridView;

public class MainActivity extends Activity {

    private GridView gv;
    private PhotoAdapter adapter;
    private int mImageThumbSize;
    private int mImageThumbSpacing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageThumbSize = getResources().getDimensionPixelSize(R.dimen.image_thumbnail_size);
        mImageThumbSpacing=getResources().getDimensionPixelSize(R.dimen.image_thumbnail_spacing);
        gv = (GridView) findViewById(R.id.photo_wall);
        adapter = new PhotoAdapter(this,0, Images.imageThumbUrls,gv);
        gv.setAdapter(adapter);
        gv.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                final int numColumns= (int) Math.floor(gv.getWidth()/(mImageThumbSize+mImageThumbSpacing));
                if(numColumns>0){
                    int columnWidth=(gv.getWidth()/numColumns)-mImageThumbSpacing;
                    adapter.setItemHeight(columnWidth);
                    gv.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                }
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        adapter.fluchCache();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        adapter.cancelAllTasks();
    }
}
