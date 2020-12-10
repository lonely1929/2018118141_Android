package com.example.hhah;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class addActivity extends Activity {

    private EditText et_thing;
    private EditText et_place;
    private EditText et_time;
    private SQLiteDatabase db;
    private Bean bean;
    private long ll;
    private MyOpenHelper myOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        // 加载布局
        setContentView(R.layout.add);
        et_thing = (EditText) findViewById(R.id.et_things);
        et_place = (EditText) findViewById(R.id.et_place);
        et_time = (EditText) findViewById(R.id.et_time);
        myOpenHelper = new MyOpenHelper(getApplicationContext());
        // db = myOpenHelper.getWritableDatabase();
    }

    @SuppressLint("WrongConstant")
    public void click_add(View view) {
        db = myOpenHelper.getWritableDatabase();
        String thing = et_thing.getText().toString().trim();
        String place = et_place.getText().toString().trim();
        String time = et_time.getText().toString().trim();
        if (TextUtils.isEmpty(thing) || TextUtils.isEmpty(place) || TextUtils.isEmpty(time)) {
            Toast.makeText(getApplicationContext(), "亲输入内容不能为空哦！", 1).show();
            return;
        } else {

            bean = new Bean();
            bean.setT_name(thing);
            bean.setT_place(place);
            bean.setTime(time);
            ContentValues values = new ContentValues();
            values.put("t_name", thing);
            values.put("t_place", place);
            values.put("time", time);
            ll = db.insert("biao01", null, values);
            db.close();
            System.out.println(ll);
            if (ll > 0) {
                Toast.makeText(getApplicationContext(), "保存成功", 1).show();
                addActivity.this.finish();

            } else {
                Toast.makeText(getApplicationContext(), "系统繁忙,请稍后再试！", 1).show();
            }
        }

    }

    public void click_return(View view) {
        addActivity.this.finish();
    }
}