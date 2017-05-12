package ren.test.realnews.beans;

import java.util.List;

/**
 * Created by Administrator on 2017/5/12
 *
 */

public class Result {
    private String stat;

    private List<Data> data ;

    public void setStat(String stat){
        this.stat = stat;
    }
    public String getStat(){
        return this.stat;
    }
    public void setData(List<Data> data){
        this.data = data;
    }
    public List<Data> getData(){
        return this.data;
    }

}
