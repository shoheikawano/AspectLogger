package com.s_hei.aspectlogger;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;

import com.bluelinelabs.logansquare.LoganSquare;
import com.google.gson.Gson;
import com.s_hei.reveal.Reveal;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends ActionBarActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final Gson GSON = new Gson();
    private static final String STRING = "{\"s\":\"abcdefg\", \"i\":12345, \"l\":[\"hij\",\"klm\",\"nop\"]}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        parse();
        fromJson();
        serialize();
        toJson();

        /*
            V/MainActivity﹕ com.s_hei.aspectlogger.JsonClass@9dbab9e
            V/AspectRevealer﹕ MainActivity#parse :: [95 ms]
            V/MainActivity﹕ com.s_hei.aspectlogger.JsonClass@c6b3313
            V/AspectRevealer﹕ MainActivity#fromJson :: [107 ms]
            V/MainActivity﹕ {"i":12345,"l":["hij","klm","nop"],"s":"abcdef"}
            V/AspectRevealer﹕ MainActivity#serialize :: [90 ms]
            V/MainActivity﹕ {"l":["hij","klm","nop"],"s":"abcdef","i":12345}
            V/AspectRevealer﹕ MainActivity#toJson :: [52 ms]
        */
    }

    @Reveal
    private static void parse() {
        JsonClass jsonClass = null;
        try {
            for (int i = 0; i < 1000; i++) {
                jsonClass = LoganSquare.parse(STRING, JsonClass.class);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.v(TAG, jsonClass.toString());
    }

    @Reveal
    private static void fromJson() {
        JsonClass gsonClass = null;
        for (int i = 0; i < 1000; i++) {
            gsonClass = GSON.fromJson(STRING, JsonClass.class);
        }
        Log.v(TAG, gsonClass.toString());
    }

    @Reveal
    private static void serialize() {
        String serialized = "";
        try {
            for (int i = 0; i < 1000; i++) {
                serialized = LoganSquare.serialize(newObject());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.v(TAG, serialized);
    }

    @Reveal
    private static void toJson() {
        String json = "";
        for (int i = 0; i < 1000; i++) {
            json = GSON.toJson(newObject());
        }
        Log.v(TAG, json);
    }

    private static JsonClass newObject() {
        JsonClass object = new JsonClass();
        object.s = "abcdef";
        object.i = 12345;
        object.l = new ArrayList<>();
        object.l.add("hij");
        object.l.add("klm");
        object.l.add("nop");

        return object;
    }
}
