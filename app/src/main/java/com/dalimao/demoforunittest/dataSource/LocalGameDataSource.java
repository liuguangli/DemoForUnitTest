package com.dalimao.demoforunittest.dataSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liuguangli on 16/8/11.
 * 本地数据源(database/sp/sdcard)
 */
public class LocalGameDataSource {
    private static LocalGameDataSource instance;
    private LocalGameDataSource(){};
    public static LocalGameDataSource getInstance(){
        if (null == instance) {
            instance = new LocalGameDataSource();
        }
        return instance;
    }
    public static void setInstance(LocalGameDataSource localGameDataSource) {
        instance = localGameDataSource;
    }
    public List<String> getData() {
        //模拟数据
        List<String> gameList  = new ArrayList<>();

        gameList.add("大话西游");
        gameList.add("无间道");
        return gameList;
    }
}
