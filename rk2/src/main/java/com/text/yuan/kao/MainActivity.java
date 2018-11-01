package com.text.yuan.kao;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.gson.Gson;

import java.util.List;

import me.maxwin.view.XListView;

public class MainActivity extends AppCompatActivity {
    XListView xlv;
    NewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        xlv = findViewById(R.id.xListView);


        adapter = new NewAdapter(this);

        xlv.setAdapter(adapter);

        initData();
    }
 String url = "http://www.xieast.com/api/banner.php";
    private void initData() {
        new AsyncTask<String,String,List<NewResponse.NewItemBean>>(){

            @Override
            protected List<NewResponse.NewItemBean> doInBackground(String... strings) {
                HttpUtil util = new HttpUtil(url);
                String work = util.getRequest();
                Gson gson = new Gson();
                NewResponse json = gson.fromJson(work, NewResponse.class);
                return json.getData();
            }

            @Override
            protected void onPostExecute(List<NewResponse.NewItemBean> newResponses) {
                adapter.setData(newResponses);
            }
        }.execute(url);
    }
}
