package com.dalimao.demoforunittest;

import com.dalimao.demoforunittest.message.GameDataSucMsg;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

/**
 * Created by liuguangli on 16/8/11.
 */
public class GamePresenter implements IGamePresenter {
    private IGameListView mGameListView;
    private IGameManager mGameManager;

    public GamePresenter(IGameListView mGameListView, IGameManager mGameManager) {
        this.mGameListView = mGameListView;
        this.mGameManager = mGameManager;
    }

    @Override
    public void start() {

        mGameListView.showLoading();
        List data = mGameManager.getData(true);
        if (data != null && !data.isEmpty()) {
            mGameListView.showData(data);
        } else {
            mGameManager.fetchDataFromServer();
        }
    }

    @Override
    public void refresh() {
        mGameManager.fetchDataFromServer();
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onDataSuc(GameDataSucMsg msg) {
        mGameListView.showData(msg.getData());
    }

}
