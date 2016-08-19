package com.dalimao.demoforunittest;

import com.dalimao.demoforunittest.utils.LogUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Matchers.anyBoolean;
import static org.mockito.Mockito.verify;
/**
 * Created by liuguangli on 16/8/11.
 * 对 P 的单点测试
 */
public class GamePresenterTest {

    @Mock
    private IGameManager gameManager;
    @Mock
    private IGameListView gameListView;
    private GamePresenter gamePresenter;
    @Before
    public void setUp() throws Exception {
        //Log 是 Android 的 API,Unit test 模式下关闭使用
        LogUtil.setDebug(false);
        // 初始化 @Mock 注解功能,自动注入 @Mock 标记的对象
        MockitoAnnotations.initMocks(this);
        //手动创建测试对象
        gamePresenter = new GamePresenter(gameListView,gameManager);

    }

    @After
    public void tearDown() throws Exception {
        gamePresenter = null;
    }

    @Test
    public void testStart() throws Exception {

        gamePresenter.start();
        /**
         * 预期会依次执行 gameListView.showLoading()\
         * gameManager.getData(netAble) 方法
         */

        //验证 gameListView.showLoading() 是否执行
        verify(gameListView).showLoading();
        //验证 gameManager.getData(netAble) 是否执行
        verify(gameManager).getData(anyBoolean());

    }

    @Test
    public void testFresh() throws Exception {
        gamePresenter.refresh();
        /**
         * 预期会依次执行 gameManager.fetchDataFromServer() 方法
         */
        //验证 gameManager.fetchDataFromServer() 是否执行
        verify(gameManager).fetchDataFromServer();
    }

}