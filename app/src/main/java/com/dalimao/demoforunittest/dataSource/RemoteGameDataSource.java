package com.dalimao.demoforunittest.dataSource;

import com.dalimao.demoforunittest.utils.LogUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liuguangli on 16/8/11.
 * 本地数据源(database/sp/sdcard)
 */
public class RemoteGameDataSource {
    private static final String TAG = "RemoteGameDataSource";
    private static RemoteGameDataSource instance;
    private RemoteGameDataSource(){};
    public static RemoteGameDataSource getInstance(){
        if (null == instance) {
            instance = new RemoteGameDataSource();
        }
        return instance;
    }

    public static void setInstance(RemoteGameDataSource instance) {
        RemoteGameDataSource.instance = instance;
    }

    public List<String> getData() {
        //模拟数据
        List<String> gameList  = new ArrayList<>();
        gameList.add("大话西游");
        gameList.add("无间道");
        gameList.add("修仙");
        //模拟网络获取数据延时

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            LogUtil.d(TAG,e.toString());
        }

        return gameList;
    }
}
