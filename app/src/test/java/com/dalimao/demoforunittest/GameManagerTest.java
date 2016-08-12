package com.dalimao.demoforunittest;

import com.dalimao.demoforunittest.dataSource.LocalGameDataSource;
import com.dalimao.demoforunittest.dataSource.RemoteGameDataSource;
import com.dalimao.demoforunittest.utils.LogUtil;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by liuguangli on 16/8/11.
 */
public class GameManagerTest {


    private GameManager gameManager;
    @Mock
    private LocalGameDataSource localGameDataSource;
    @Mock
    RemoteGameDataSource remoteGameDataSource;
    /**
     * 测试用例运行之前,系统先执行这个方法
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {

        LogUtil.setDebug(false);
        MockitoAnnotations.initMocks(this);
        LocalGameDataSource.setInstance(localGameDataSource);
        RemoteGameDataSource.setInstance(remoteGameDataSource);
        gameManager = new GameManager();
    }

    /**
     * 测试用例跑完之后,最好会执行这个方法
     * @throws Exception
     */
    @After
    public void tearDown() throws Exception {
        gameManager = null;
    }

    @Test
    public void testGetData() throws Exception {
        //更改方法执行结果:当 localGameDataSource.getData() 执行时,返回 null.
        when(localGameDataSource.getData()).thenReturn(null);
        // 测试getData方法
        List data = gameManager.getData(true);
        /**
         *  预期: localGameDataSource.getData() 方法会先执行,若返回数据为空,
         *  remoteGameDataSource.getData() 方法会执行.
         */
        //验证 localGameDataSource.getData() 方法是否执行
        verify(localGameDataSource).getData();
        if (data == null) {
            //缓存为空,验证 remoteGameDataSource.getData() 方法是否执行
           verify(remoteGameDataSource).getData();
        }
    }

    @Test
    public void testGetDataFromLocal() throws Exception {
        gameManager.getDataFromLocal();
    }

    @Test
    public void testFetchDataFromServer() throws Exception {
        gameManager.fetchDataFromServer();
    }
}