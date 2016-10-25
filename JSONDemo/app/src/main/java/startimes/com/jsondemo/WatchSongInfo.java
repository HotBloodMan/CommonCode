package startimes.com.jsondemo;

import java.io.Serializable;

/**
 * Created by 1 on 2016/10/25.
 */
public class WatchSongInfo implements Serializable{
    private String name;
    private String pic;
    private String artist;
    private String downurl;
    private int playcnt;

    public WatchSongInfo(String name, String pic, String artist, int playcnt, String downurl) {
        this.name = name;
        this.pic = pic;
        this.artist = artist;
        this.playcnt = playcnt;
        this.downurl = downurl;
    }

    public WatchSongInfo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getDownurl() {
        return downurl;
    }

    public void setDownurl(String downurl) {
        this.downurl = downurl;
    }

    public int getPlaycnt() {
        return playcnt;
    }

    public void setPlaycnt(int playcnt) {
        this.playcnt = playcnt;
    }
}
