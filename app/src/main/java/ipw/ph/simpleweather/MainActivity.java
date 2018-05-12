package ipw.ph.simpleweather;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.gson.Gson;
import com.orhanobut.logger.Logger;
import com.zaaach.citypicker.CityPicker;
import com.zaaach.citypicker.adapter.OnPickListener;
import com.zaaach.citypicker.model.City;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

/**
 * 主界面
 */
public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private MultiDelegateAdapter mMultiDelegateAdapter;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    /**
     * 设置默认天气数据的城市
     */
    private String mCurrentCityName = "北京";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            /**
             * 当列表下拉刷新时，会执行这个方法
             */
            @Override
            public void onRefresh() {
                mMultiDelegateAdapter.replaceData(new ArrayList<WeatherData.DataBean.ForecastBean>());
                refreshCityWeatherData();
            }
        });

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mMultiDelegateAdapter = new MultiDelegateAdapter();
        mRecyclerView.setAdapter(mMultiDelegateAdapter);

        //获取最新的天气数据
        refreshCityWeatherData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //加载右上角菜单布局
        getMenuInflater().inflate(R.menu.switch_city_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //点击了切换城市，执行这里
        if (item.getItemId() == R.id.action_switch_city) {
            CityPicker.getInstance()
                    .setFragmentManager(getSupportFragmentManager())
                    .enableAnimation(true)
                    .setOnPickListener(new OnPickListener() {
                        /**
                         * 当在城市列表中选择城市后，会回调这个方法
                         * @param position
                         * @param data
                         */
                        @Override
                        public void onPick(int position, City data) {
                            Logger.e(position + " " + data.getName());
                            mCurrentCityName = data.getName();
                            //获取最新的天气数据
                            refreshCityWeatherData();
                        }

                        @Override
                        public void onLocate() {
                            Logger.e("");
                            Toast.makeText(MainActivity.this, "定位成功", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .show();
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * 停止下拉刷新的动画
     */
    private void stopRefresh() {
        if (mSwipeRefreshLayout != null) {
            if (mSwipeRefreshLayout.isRefreshing()) {
                mSwipeRefreshLayout.setRefreshing(false);
            }
        }
    }

    /**
     * 获取最新的天气数据
     */
    private void refreshCityWeatherData() {
        OkHttpUtils.get()
                //天气API接口说明https://www.sojson.com/api/weather.html
                .url("https://www.sojson.com/open/api/weather/json.shtml?city=" + mCurrentCityName)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        //数据获取异常时，也停止下拉刷新的动画
                        stopRefresh();
                        //网络发生问题时，提示用户是什么原因导致的数据获取失败
                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Logger.e(response);
//                        Toast.makeText(MainActivity.this, response, Toast.LENGTH_SHORT).show();
                        //数据获取成功后，停止下拉刷新的动画
                        stopRefresh();

                        //解析最新的天气数据
                        WeatherData weatherData = new Gson().fromJson(response, WeatherData.class);

                        //数据状态，200为正常获取到数据，0为无该城市天气信息，其他为api接口问题
                        int status = weatherData.getStatus();
                        if (status != 200) {
                            if (status == 0) {
                                Toast.makeText(MainActivity.this, "无该城市天气信息", Toast.LENGTH_SHORT).show();
                            } else {
                                //当数据异常时，此字段提供给用户信息以使用户知道为什么接口请求数据没有成功
                                String message = weatherData.getMessage();
                                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                            }
                            return;
                        }
                        WeatherData.DataBean dataBean = weatherData.getData();
                        if (dataBean != null) {
                            List<WeatherData.DataBean.ForecastBean> forecastBeanList = dataBean.getForecast();

                            //添加当日最新天气数据
                            WeatherData.DataBean.ForecastBean forecastBean = new WeatherData.DataBean.ForecastBean();
                            forecastBean.setDate(weatherData.getDate());
                            forecastBean.setCity(weatherData.getCity());
                            forecastBean.setCount(weatherData.getCount());

                            forecastBean.setShidu(dataBean.getShidu());
                            forecastBean.setPm25(dataBean.getPm25());
                            forecastBean.setPm10(dataBean.getPm10());
                            forecastBean.setQuality(dataBean.getQuality());
                            forecastBean.setWendu(dataBean.getWendu());
                            forecastBean.setGanmao(dataBean.getGanmao());
                            forecastBeanList.add(0, forecastBean);

                            //添加昨日天气数据，因为天气预报基本不看昨天的，所以这里就不把昨天的数据加入界面中显示了
//                            WeatherData.DataBean.ForecastBean yesterday = dataBean.getYesterday();
//                            forecastBeanList.add(1, yesterday);

                            //更新最新数据到界面上的列表中
                            mMultiDelegateAdapter.replaceData(forecastBeanList);
                        }
                    }
                });
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        //重写这个方法，保持app不退出的方式使其进入后台
        Intent i = new Intent(Intent.ACTION_MAIN);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.addCategory(Intent.CATEGORY_HOME);
        startActivity(i);
    }
}
