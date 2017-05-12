package ren.test.realnews.beans;

/**
 * Created by Administrator on 2017/5/12
 */

public class NewsType {
    private String type;
    private String tittle;

    public NewsType(String type, String tittle) {
        this.type = type;
        this.tittle = tittle;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }
}
