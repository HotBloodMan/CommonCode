package startimes.com.jsondemo;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 1 on 2016/10/25.
 */
public class WatchSongAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private List<WatchSongInfo> listWatchSong;

    public WatchSongAdapter(Context context, List<WatchSongInfo> watchSongInfosList) {
        this.context = context;
        this.listWatchSong = watchSongInfosList;
        Log.d("TAG","listWatchSong==>>> "+watchSongInfosList.toString());
        inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return listWatchSong.size();
    }

    @Override
    public Object getItem(int i) {
        return listWatchSong.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        ViewHolder vh;
        if(convertView==null){
            convertView=inflater.inflate(R.layout.item_layout,viewGroup,false);
            vh=new ViewHolder();
            vh.ivMainWatchPic = (ImageView)convertView. findViewById(R.id.iv_main_watch_song_name);
            vh.ivMainWatchRightDownLoad = (ImageView) convertView.findViewById(R.id.iv_main_watch_song_right_down);
            vh.tvWatchSongName = (TextView) convertView.findViewById(R.id.tv_main_watch_song_name);
            vh.tvMainWatchPlayCount = (TextView) convertView.findViewById(R.id.tv_main_watch_playcount);
            vh.tvMainWatchArtist = (TextView) convertView.findViewById(R.id.tv_main_watch_artist);
            convertView.setTag(vh);
        }else{
             vh= (ViewHolder) convertView.getTag();
        }

        WatchSongInfo item = listWatchSong.get(i);
        Log.d("TAG","itme***55555555555= "+item.toString());
        vh.tvWatchSongName.setText(item.getName());
        vh.tvMainWatchArtist.setText(item.getArtist());
        vh.tvMainWatchPlayCount.setText(item.getPlaycnt()+"");
        //vh.ivMainWatchPic.setImageBitmap(BitmapFactory.de);
//        vh.ivMainWatchRightDownLoad.
        return convertView;
    }

    class ViewHolder{
        ImageView ivMainWatchPic,ivMainWatchRightDownLoad;
        TextView tvWatchSongName,tvMainWatchPlayCount,tvMainWatchArtist;
    }
}
