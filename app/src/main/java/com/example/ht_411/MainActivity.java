package com.example.ht_411;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private static final String TITLE = "TITLE";
    private static final String SUBTITLE = "SUBTITLE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Map<String, String>> lines = prepareContent();
        BaseAdapter adapter = createAdapter(lines);
        ListView list = findViewById(R.id.list);
        list.setAdapter(adapter);
    }


    public List<Map<String, String>> prepareContent() {
        String[] lines = getString(R.string.large_text).split("\n\n");
        List<Map<String, String>> list = new ArrayList<>();
        for (String string :
                lines) {
            Map<String, String> map = new HashMap<>();
            map.put(TITLE, string);
            map.put(SUBTITLE, string.length() + "");
            list.add(map);
        }
        return list;
    }

    public BaseAdapter createAdapter(List<Map<String, String>> list) {
        String[] from = {TITLE, SUBTITLE};
        int[] to = {R.id.text1, R.id.text2};
        return new SimpleAdapter(this, list, R.layout.textviews, from, to);
    }
}