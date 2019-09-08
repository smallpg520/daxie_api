package com.daxie.daxie_api.model.http;

import com.daxie.daxie_api.model.category.Requetvo;
import lombok.Data;

import java.util.List;

@Data
public class Categoryhttp {

    private List<Requetvo>   categoryList;

    private  String    categorykind;

    private  int         categorysale;

    private  int         categorylirun;

    private  int         categoryprice;



}
