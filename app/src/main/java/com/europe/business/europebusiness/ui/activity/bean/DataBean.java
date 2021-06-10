package com.europe.business.europebusiness.ui.activity.bean;

import java.util.List;

public class DataBean {
    private List<Cls> cls;

    public List<Cls> getCls() {
        return cls;
    }

    public void setCls(List<Cls> cls) {
        this.cls = cls;
    }

    public class Cls{
        private String clsId;
        private String clsName;

        public String getClsId() {
            return clsId;
        }

        public void setClsId(String clsId) {
            this.clsId = clsId;
        }

        public String getClsName() {
            return clsName;
        }

        public void setClsName(String clsName) {
            this.clsName = clsName;
        }
    }
}
