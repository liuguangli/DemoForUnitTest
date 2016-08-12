package com.dalimao.demoforunittest;

import com.dalimao.demoforunittest.dataSource.LocalGameDataSource;
import com.dalimao.demoforunittest.dataSource.RemoteGameDataSource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import static org.mockito.Mockito.verify;


/**
 * Created by liuguangli on 16/8/11.
 * 对 M 的单点测试
 */
public class GameManagerAndroidTest {

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
        //when(localGameDataSource.getData()).thenReturn(null);
        // 测试getData方法
        List data = gameManager.getData(true);
        // 先从缓存中取数据,getDataFromLocal 方法应该要执行
        verify(localGameDataSource).getData();
        if (data == null) {
            //缓存为空,fetchDataFromServer 方法应该要执行
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