package com.daxie.daxie_api.core;

import java.util.Random;

public class Code {
    public static int getCode(){
        int flag = new Random().nextInt(999999);
        flag+=1;
        return flag;
    }

}
