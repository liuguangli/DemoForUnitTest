package com.dalimao.demoforunittest;

import java.util.List;
import java.util.Map;

/**
 * Created by liuguangli on 16/8/11.
 */
public interface IGameListView {
    void showData(List<String> gameList);
    void showNoData();
    void showError();
    void showLoading();
}
