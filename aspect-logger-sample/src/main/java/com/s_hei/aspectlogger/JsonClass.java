package com.s_hei.aspectlogger;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

import java.util.List;

@JsonObject
public class JsonClass {

    @JsonField
    public String s;
    @JsonField
    public int i;
    @JsonField
    public List<String> l;

}
