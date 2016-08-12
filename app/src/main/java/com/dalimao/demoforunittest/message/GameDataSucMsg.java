package com.dalimao.demoforunittest.message;

import java.util.List;
import java.util.Map;

/**
 * Created by liuguangli on 16/8/11.
 */
public class GameDataSucMsg {
    private final List<String> data;

    public GameDataSucMsg(List<String> gameList) {
        this.data = gameList;
    }

    public List<String> getData() {
        return data;
    }
}
