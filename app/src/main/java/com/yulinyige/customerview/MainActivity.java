package com.yulinyige.customerview;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.yulinyige.customerview.startup.StartupActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Main Activity
 * Created by yulinyige on 2021.09.06
 */
public class MainActivity extends ListActivity {

    public static final String TITLE = "title";
    public static final String SUBTITLE = "subtitle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new SimpleAdapter(this, createData(),
                android.R.layout.simple_list_item_2, new String[]{TITLE,
                SUBTITLE}, new int[]{android.R.id.text1,
                android.R.id.text2}));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        switch (position) {
            case 0:
                startActivity(StartupActivity.class);
                break;
            default:
                break;
        }
    }

    private void startActivity(Class<?> cls) {
        startActivity(new Intent(this, cls));
    }

    private List<Map<String, String>> createData() {
        List<Map<String, String>> data = new ArrayList<Map<String, String>>();
        data.add(createItem("StartUp", "入门,体验自定义 View 的快乐!"));
        return data;
    }

    private Map<String, String> createItem(String title, String subtitle) {
        Map<String, String> item = new HashMap<>();
        item.put(TITLE, title);
        item.put(SUBTITLE, subtitle);
        return item;
    }

}