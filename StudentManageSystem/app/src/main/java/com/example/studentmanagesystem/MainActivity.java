package com.example.studentmanagesystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private MyDatabaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new MyDatabaseHelper(this,"Student.db",null,1);

        // 创建数据库
        Button createDatabase = (Button)findViewById(R.id.CreateDatabase);
        createDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.getWritableDatabase();
            }
        });

        // 添加数据按钮
        Button addData = (Button)findViewById(R.id.Add);
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase(); // 用于写入数据
                ContentValues values = new ContentValues(); // 用于组装数据

                values.put("id","1");
                values.put("name","AAA");
                values.put("gender","男");
                values.put("address","南京");
                values.put("major","计算机");
                db.insert("Student",null,values);
                values.clear();

                values.put("id","2");
                values.put("name","BBB");
                values.put("gender","女");
                values.put("address","南京");
                values.put("major","计算机");
                db.insert("Student",null,values);
            }
        });

        // 更新按钮
        Button update = (Button)findViewById(R.id.Update);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                // 先组装数据，传入下面的API中
        //      db.update(); // 更新数据的API
            }
        });

        // 删除按钮
        Button delete = (Button)findViewById(R.id.Delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                //                db.delete()
            }
        });
    }
}