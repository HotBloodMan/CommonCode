package startimes.com.jsondemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends Activity {

    private ListView lvWatchMain;
    private List<WatchSongInfo> watchSongInfosList;
    private WatchSongAdapter adapter;
    WatchSongInfo watchSongInfo = new WatchSongInfo();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTools();
        Log.d("TAG","**************1");
        initDatas();
        Log.d("TAG","**************2");
        lvWatchMain.setAdapter(adapter);
        Log.d("TAG","**************3");
    }

    private void initDatas() {
        watchSongInfosList = new ArrayList<WatchSongInfo>();
        doClick();
        adapter = new WatchSongAdapter(MainActivity.this, watchSongInfosList);
    }

    private void initTools() {
        lvWatchMain = (ListView) findViewById(R.id.lv_watch_main);
    }

    public void doClick(){
        new Thread(){
            public void run() {
                try {
                    Log.i("TAG","run()");
//path为网络路径(查看号码归属地)
                    String path="http://bb.shoujiduoduo.com/baby/bb.php?type=getvideos&pagesize=30&collectid=29";
//网络访问部分
//                    Bean bean = new Gson().fromJson(path, Bean.class);
//                    List<Bean.ListBean> list = bean.getList();
//                    Log.d("TAG","list== "+list.toString());
//                    for(Bean.ListBean bean1 : list){
//                        String name = bean1.getName();
//                        Log.d("TAG","name== "+name.toString());
//                }

                    URL url = new URL(path);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setDoInput(true);
                    connection.setRequestMethod("GET");
                    connection.connect();
                    InputStream is = connection.getInputStream();
                    //将流转换为字符串
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));
                    String line;
                    StringBuilder sb = new StringBuilder();
                    while((line=br.readLine())!=null){
                        sb.append(line);
                    }
                    String results = sb.toString();
                    Log.d("TAG","results="+results);
                    getJsonData(results);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            };
        }.start();
    }

    private void getJsonData(String results) {
        //json解析部分
        JSONObject object = null;
        try {
            object = new JSONObject(results);
            Log.d("TAG","object="+object.toString());
            JSONArray list = object.getJSONArray("list");
            Log.d("TAG","list===8888888888 777777777*** "+list.toString());
            for(int i=1;i<list.length();i++){
                int length = list.length();
                Log.d("TAG","nav length--== "+length);
                JSONObject jsonObject = list.getJSONObject(i);
                String pic = jsonObject.getString("pic");
//                Log.d("TAG","pic***== "+pic);
                watchSongInfo.setPic(pic);
                String name = jsonObject.getString("name");
//                Log.d("TAG","name= * "+name.toString());
                watchSongInfo.setName(name);
                String downurl = jsonObject.getString("downurl");
                watchSongInfo.setDownurl(downurl);
                String artist = jsonObject.getString("artist");
                watchSongInfo.setArtist(artist);
                Log.d("TAG","pic***== "+pic+"name= * "+name.toString()+"downurl= "+downurl.toString()+"artist= "+artist.toString());
                watchSongInfosList.add(watchSongInfo);
                Log.d("TAG","watchSongInfoList****++++>>>> "+watchSongInfosList.toString());
            }
            Iterator<WatchSongInfo> iterator = watchSongInfosList.iterator();
            while(iterator.hasNext()){
                WatchSongInfo next = iterator.next();
                Log.d("TAG","next%%%%% == "+next.toString());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}