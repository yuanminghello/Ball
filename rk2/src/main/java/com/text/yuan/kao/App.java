package com.text.yuan.kao;

import android.app.Application;
import android.graphics.Bitmap;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .cacheOnDisk(true)
                .cacheInMemory(true)

                .showImageOnLoading(R.mipmap.ic_launcher)
                .showImageForEmptyUri(R.mipmap.ic_launcher)
                .showImageOnFail(R.mipmap.ic_launcher)

                .displayer(new RoundedBitmapDisplayer(10,10))
                .bitmapConfig(Bitmap.Config.RGB_565)
                .imageScaleType(ImageScaleType.EXACTLY_STRETCHED)
                .build();

        ImageLoaderConfiguration build = new ImageLoaderConfiguration.Builder(this)
                .memoryCacheSizePercentage(13)
                .memoryCacheSize(50*1024*1024)

                .writeDebugLogs()
                .defaultDisplayImageOptions(options)
                .build();

        ImageLoader.getInstance().init(build);
    }
}
