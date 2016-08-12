package com.dalimao.demoforunittest;


import com.dalimao.demoforunittest.dataSource.LocalGameDataSource;
import com.dalimao.demoforunittest.dataSource.RemoteGameDataSource;
import com.dalimao.demoforunittest.message.GameDataSucMsg;
import com.dalimao.demoforunittest.utils.LogUtil;

import org.greenrobot.eventbus.EventBus;

import java.util.List;
import java.util.Map;

/**
 * Created by liuguangli on 16/8/11.
 */
public class GameManager implements IGameManager {

    private static final String TAG = "GameManager";

    @Override
    public List<String> getData(boolean netAble) {
        List<String> gameList = this.getDataFromLocal();

        if (null == gameList || gameList.isEmpty()) {
            fetchDataFromServer();
        }
        return gameList;
    }

    @Override
    public List<String> getDataFromLocal() {
        LogUtil.d(TAG, "getDataFromLocal");
        return LocalGameDataSource.getInstance().getData();
    }

    @Override
    public void fetchDataFromServer() {
        LogUtil.d(TAG,"fetchDataFromServer");
        List<String> gameList = RemoteGameDataSource.getInstance().getData();
        EventBus.getDefault().post(new GameDataSucMsg(gameList));

    }
}
