package ren.test.realnews.beans;

import java.util.List;

/**
 * Created by Administrator on 2017/5/12
 */

public class Showapi_res_body {
    private int ret_code;

    private Pagebean pagebean;

    public void setRet_code(int ret_code){
        this.ret_code = ret_code;
    }
    public int getRet_code(){
        return this.ret_code;
    }
    public void setPagebean(Pagebean pagebean){
        this.pagebean = pagebean;
    }
    public Pagebean getPagebean(){
        return this.pagebean;
    }

}
