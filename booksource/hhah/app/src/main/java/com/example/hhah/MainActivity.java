package com.example.hhah;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private ArrayList<Bean> list;
    private MyOpenHelper myOpenHelper;
    private SQLiteDatabase db;
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = new ArrayList<Bean>();
        lv = (ListView) this.findViewById(R.id.lv);

        myOpenHelper = new MyOpenHelper(this);
        db = myOpenHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from biao01;", null);
        while (cursor.moveToNext()) {
            String t_name = cursor.getString(cursor.getColumnIndex("t_name"));
            String t_place = cursor.getString(cursor.getColumnIndex("t_place"));
            String time = cursor.getString(cursor.getColumnIndex("time"));
            Bean bean = new Bean();
            bean.setT_name(t_name);
            bean.setT_place(t_place);
            bean.setTime(time);
            list.add(bean);
        }
        MyAdapter myAdapter = new MyAdapter(this, list, R.layout.item);
        /*
         * ArrayList<HashMap<String, Object>> yy = new
         * ArrayList<HashMap<String,Object>>(); for(Bean bean1:list) { HashMap<String,
         * Object> zzz = new HashMap<String,Object>(); zzz.put("t_name",
         * bean1.getT_name()); zzz.put("t_place", bean1.getT_place()); zzz.put("time",
         * bean1.getTime()); yy.add(zzz); } SimpleAdapter simpleAdapter=new
         * SimpleAdapter(this, yy, R.layout.item, new String[]
         * {"t_name","t_place","time"},new int[]
         * {R.id.tv_name,R.id.tv_place,R.id.tv_time});
         *
         */

        lv.setAdapter(myAdapter);
    }

    public void click1(View view) {
        // 该方法只用于跳转，实际增加步骤在增加页面
        Intent intent = new Intent();
        intent.setAction("android.intent.action.add");
        intent.addCategory("android.intent.category.DEFAULT");
        startActivity(intent);
    }

}