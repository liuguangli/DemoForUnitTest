package com.dalimao.demoforunittest;

import java.util.List;
import java.util.Map;

/**
 * Created by liuguangli on 16/8/11.
 */
public interface IGameManager {
    List<String> getData(boolean netAble);
    List<String> getDataFromLocal();
    void fetchDataFromServer();

}
