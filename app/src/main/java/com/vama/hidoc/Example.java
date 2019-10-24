package com.vama.hidoc;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Example {
    @SerializedName("success")
    @Expose
    private Integer success;
    @SerializedName("resultarray")
    @Expose
    private List<Resultarray> resultarray = null;

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public List<Resultarray> getResultarray() {
        return resultarray;
    }

    public void setResultarray(List<Resultarray> resultarray) {
        this.resultarray = resultarray;
    }

    @Override
    public String toString() {
        return "Example{" +
                "success=" + success +
                ", resultarray=" + resultarray +
                '}';
    }
}
