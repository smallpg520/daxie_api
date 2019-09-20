package com.daxie.daxie_api.core;

public enum Struts {
    SUCCESSSTRUTS(1),
    FAILSTRUTS(0),
    HOTSTRUTS(1),
    ISNOTHOTSTRUTS(0);
    private final  int struts;


    Struts(int struts) {
        this.struts = struts;
    }
    public int struts(){
       return struts;
    }
}
