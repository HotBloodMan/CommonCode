package startimes.com.jsondemo;

import java.util.List;

/**
 * Created by liufh on 2016/10/25.
 */
public class Bean {

    /**
     * artist : 多多儿歌
     * cateid : 15
     * downurl : http://bbhlt.shoujiduoduo.com/bb/video/10000048/343684955v2.mp4
     * duration : 96.66
     * filesize : 4432242
     * id : 343684955
     * ismusic : 4
     * method : 16
     * name : 不怕不怕
     * pic : http://cdnbbvfw.shoujiduoduo.com/bb/video/pic/955/343684955.jpg
     * playcnt : 22943269
     * restype : duoduo
     */

    private List<ListBean> list;
    /**
     * curpage : 1
     * hasmore : 0
     */

    private List<NavBean> nav;

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public List<NavBean> getNav() {
        return nav;
    }

    public void setNav(List<NavBean> nav) {
        this.nav = nav;
    }

    public static class ListBean {
        private String area;
        private int curpage;
        private int hasmore;

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public int getCurpage() {
            return curpage;
        }

        public void setCurpage(int curpage) {
            this.curpage = curpage;
        }

        public int getHasmore() {
            return hasmore;
        }

        public void setHasmore(int hasmore) {
            this.hasmore = hasmore;
        }
        private String artist;
        private int cateid;
        private String downurl;
        private double duration;
        private int filesize;
        private String id;
        private int ismusic;
        private int method;
        private String name;
        private String pic;
        private int playcnt;
        private String restype;

        public String getArtist() {
            return artist;
        }

        public void setArtist(String artist) {
            this.artist = artist;
        }

        public int getCateid() {
            return cateid;
        }

        public void setCateid(int cateid) {
            this.cateid = cateid;
        }

        public String getDownurl() {
            return downurl;
        }

        public void setDownurl(String downurl) {
            this.downurl = downurl;
        }

        public double getDuration() {
            return duration;
        }

        public void setDuration(double duration) {
            this.duration = duration;
        }

        public int getFilesize() {
            return filesize;
        }

        public void setFilesize(int filesize) {
            this.filesize = filesize;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getIsmusic() {
            return ismusic;
        }

        public void setIsmusic(int ismusic) {
            this.ismusic = ismusic;
        }

        public int getMethod() {
            return method;
        }

        public void setMethod(int method) {
            this.method = method;
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

        public int getPlaycnt() {
            return playcnt;
        }

        public void setPlaycnt(int playcnt) {
            this.playcnt = playcnt;
        }

        public String getRestype() {
            return restype;
        }

        public void setRestype(String restype) {
            this.restype = restype;
        }
    }

    public static class NavBean {
        private int curpage;
        private int hasmore;

        public int getCurpage() {
            return curpage;
        }

        public void setCurpage(int curpage) {
            this.curpage = curpage;
        }

        public int getHasmore() {
            return hasmore;
        }

        public void setHasmore(int hasmore) {
            this.hasmore = hasmore;
        }
    }
}
