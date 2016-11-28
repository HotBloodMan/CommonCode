package startimes.com.webviewdemo;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

@TargetApi(Build.VERSION_CODES.M)
public class MainActivity extends Activity {

    private WebView web;
    private Button btn;
    public static final String urls="http://shouji.baidu.com/";
    private Button btnNext;
    private Button btnForward;
    private int scrollY=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        web = (WebView) findViewById(R.id.web);
        btn = (Button) findViewById(R.id.loadurl);
        btnForward = (Button) findViewById(R.id.btn_forward);
        btnNext = (Button) findViewById(R.id.btn_next);

        WebSettings settings = web.getSettings();
        settings.setDefaultTextEncodingName("utf-8");
        settings.setJavaScriptEnabled(true);
        web.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        web.setDownloadListener(new MyDownload());
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                web.loadUrl(urls);
            }
        });
//        web.setOnScrollChangeListener(new ObserveWebView.OnScrollChangeListener() {
//            @Override
//            public void onPageEnd(int l, int t, int oldl, int oldt) {
//                System.out.println("onPageEnd");
//            }
//
//            @Override
//            public void onPageTop(int l, int t, int oldl, int oldt) {
//                System.out.println("onPageTop");
//            }
//
//            @Override
//            public void onScrollChanged(int l, int t, int oldl, int oldt) {
//                System.out.println("onScrollChanged");
//            }
//        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scrollY+=300;
                web.scrollTo(0,scrollY);
                isPauseWebView();
            }
        });
        btnForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scrollY-=300;
                web.scrollTo(0,scrollY);
                isPauseWebView();
            }
        });
    }
    class MyDownload implements DownloadListener{
        @Override
        public void onDownloadStart(String url, String s1, String s2, String s3, long l) {
            System.out.println(">>>>>>>>url==="+url.toString());
            if(url.endsWith(".apk")){
               new HttpThread(url).start();
//                Uri parse = Uri.parse(url);
//                Intent intent = new Intent(Intent.ACTION_VIEW,parse);
//                startActivity(intent);
            }
            System.out.println("------11111111---------");
        }
    }
    private void isPauseWebView() {
        float webcontent = web.getContentHeight() * web.getScale();// webview的高度
        float webnow =web.getHeight() +web.getScrollY();// 当前webview的高度

        if (Math.abs(web.getContentHeight() - webcontent) <30) {
            Log.d("TAG", "webview.getScrollY()=底端====>>" + web.getScrollY()+"  webcontent1-*****==="+webcontent);
            Toast.makeText(MainActivity.this,"已经处于底端",Toast.LENGTH_LONG).show();
        }else if(web.getScrollY()==0){
            Log.d("TAG", "webview.getScrollY()=顶端====>>" + web.getScrollY()+"  webcontent2=*****==="+webcontent);
            Log.d("TAG", "当前webview的高度====>>" +webnow);
            Toast.makeText(MainActivity.this,"已经处于顶端",Toast.LENGTH_LONG).show();
        }
    }
}
