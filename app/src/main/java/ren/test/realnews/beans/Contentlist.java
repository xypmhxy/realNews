package ren.test.realnews.beans;

import java.util.List;

/**
 * Created by Administrator on 2017/5/12
 */

public class Contentlist {
    private String pubDate;

    private String title;

    private List<Imageurls> imageurls;

    private String desc;

    private String areaName;

    private String source;

    private String link;

    private String areaId;

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getPubDate() {
        return this.pubDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setImageurls(List<Imageurls> imageurls) {
        this.imageurls = imageurls;
    }

    public List<Imageurls> getImageurls() {
        return this.imageurls;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getAreaName() {
        return this.areaName;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSource() {
        return this.source;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLink() {
        return this.link;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getAreaId() {
        return this.areaId;
    }
}
