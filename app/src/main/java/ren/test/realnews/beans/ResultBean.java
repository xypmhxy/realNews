package ren.test.realnews.beans;

/**
 * Created by Administrator on 2017/5/12
 */

public class ResultBean {
    private String reason;

    private Result result;

    private int error_code;

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getReason() {
        return this.reason;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public Result getResult() {
        return this.result;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public int getError_code() {
        return this.error_code;
    }
}
