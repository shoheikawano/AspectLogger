package com.s_hei.aspectlogger;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;
import com.s_hei.reveal.Reveal;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.List;

@JsonObject
public class JsonClass {

    @JsonField
    public String s;
    @JsonField
    public int i;
    @JsonField
    public List<String> l;

    @Reveal
    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
