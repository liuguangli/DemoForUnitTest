package com.dalimao.demoforunittest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;

import java.util.List;


public class MainActivity extends AppCompatActivity implements IGameListView {

    private ListView mListView;
    private GameListAdapter mAdapter;

    private IGamePresenter mGamePresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.gameList);
        mAdapter = new GameListAdapter(this);
        mListView.setAdapter(mAdapter);
        mGamePresenter = new GamePresenter(this, new GameManager());
        EventBus.getDefault().register(mGamePresenter);
        mGamePresenter.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(mGamePresenter);
    }

    @Override
    public void showData(List<String> gameList) {
        mAdapter.setData(gameList);
        mListView.setAdapter(mAdapter);
    }

    @Override
    public void showNoData() {

        Toast.makeText(this, "no data!", Toast.LENGTH_LONG);
    }

    @Override
    public void showError() {
        Toast.makeText(this, "error!", Toast.LENGTH_LONG);
    }

    @Override
    public void showLoading() {
        Toast.makeText(this,"loading!",Toast.LENGTH_LONG);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
