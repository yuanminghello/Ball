package com.text.yuan.kao;

import android.widget.ImageView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * date:2018/11/01
 * author:袁明磊(123)
 * function:
 */
class HttpUtil {
    String urll;
    public HttpUtil(String url) {
        this.urll=url;
    }

    public String getRequest(){
        String result=null;
        try {
            URL url = new URL(urll);
            try {
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.setReadTimeout(5000);
                urlConnection.setConnectTimeout(5000);
                int responseCode = urlConnection.getResponseCode();
                if(responseCode==200){
                    result = string2String(urlConnection.getInputStream());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return result;
    }

    private String string2String(InputStream inputStream) {
        StringBuffer buffer = new StringBuffer();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            for(String temp=reader.readLine();temp!=null;temp=reader.readLine()){
                buffer.append(temp);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return buffer.toString();
    }
}
