package startimes.com.webviewdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.webkit.WebView;
import android.widget.Toast;

/**
 * Created by 1 on 2016/11/22.
 */
public class ObserveWebView extends WebView{
    public OnScrollChangeListener listeners;


    public ObserveWebView(Context context) {
        super(context);
        System.out.println("ObserveWebView(Context context)");
    }

    public ObserveWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        System.out.println("ObserveWebView(Context context, AttributeSet attrs)");
    }

    public ObserveWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        System.out.println("ObserveWebView(Context context, AttributeSet attrs, int defStyleAttr)");
    }

    int i=0;
    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);

        float webcontent = getContentHeight() * getScale();// webview的高度
        float webnow = getHeight() + getScrollY();// 当前webview的高度


        if (Math.abs(webcontent - webnow) < 1) {
            Log.i("TAG1", "webview.getScrollY()=底端====>>" + getScrollY()+"  webcontent1-*****==="+webcontent);
            Toast.makeText(getContext().getApplicationContext(),"已经处于底端",Toast.LENGTH_LONG).show();
            listeners.onPageEnd(l, t, oldl, oldt);
        } else if (getScrollY() == 0) {
            Toast.makeText(getContext().getApplicationContext(),"已经处于顶端",Toast.LENGTH_LONG).show();
            Log.i("TAG1", "webview.getScrollY()=顶端====>>" + getScrollY()+"  webcontent2=*****==="+webcontent);
            Log.i("TAG1", "当前webview的高度====>>" +webnow);
            listeners.onPageTop(l, t, oldl, oldt);
        } else {
            listeners.onScrollChanged(l, t, oldl, oldt);
        }
    }
    public void setOnScrollChangeListener(OnScrollChangeListener listener){
        this.listeners=listener;
    }
    public interface  OnScrollChangeListener{
        public void onPageEnd(int l,int t,int oldl,int oldt);
        public void onPageTop(int l,int t,int oldl,int oldt);
        public void onScrollChanged(int l,int t,int oldl,int oldt);
    }
}
