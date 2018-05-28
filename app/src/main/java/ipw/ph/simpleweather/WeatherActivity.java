package ipw.ph.simpleweather;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.SparseIntArray;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.chad.library.adapter.base.util.MultiTypeDelegate;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.AbsCallback;
import com.lzy.okgo.model.Response;
import com.orhanobut.logger.Logger;
import com.zaaach.citypicker.CityPicker;
import com.zaaach.citypicker.adapter.OnPickListener;
import com.zaaach.citypicker.model.City;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class WeatherActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    /**
     * 天气图标资源配置表
     */
    private static SparseIntArray mWeatherIconIdArray = new SparseIntArray();

    static {
        mWeatherIconIdArray.put(0, R.drawable.weather_sunny);//睛
        mWeatherIconIdArray.put(1, R.drawable.weather_cloudy);//多云
        mWeatherIconIdArray.put(2, R.drawable.weather_cloudy);//阴
        mWeatherIconIdArray.put(3, R.drawable.weather_rainy);//阵雨
        mWeatherIconIdArray.put(4, R.drawable.weather_rainy);//雷阵雨
        mWeatherIconIdArray.put(5, 0);//待确认天气
        mWeatherIconIdArray.put(6, 0);//待确认天气
        mWeatherIconIdArray.put(7, R.drawable.weather_rainy);//小雨
        mWeatherIconIdArray.put(8, R.drawable.weather_pouring);//中雨
        mWeatherIconIdArray.put(9, R.drawable.weather_pouring);//大雨
        mWeatherIconIdArray.put(10, 0);//待确认天气
        mWeatherIconIdArray.put(11, 0);//待确认天气
        mWeatherIconIdArray.put(12, 0);//待确认天气
        mWeatherIconIdArray.put(13, 0);//待确认天气
    }

    private RecyclerView mRecyclerView;
    private CustomAdapter mCustomAdapter;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private String mCurrentCityName = "北京";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getCityWeatherData();
            }
        });

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mCustomAdapter = new CustomAdapter();
        mRecyclerView.setAdapter(mCustomAdapter);

        mCurrentCityName = PreferenceManager.getDefaultSharedPreferences(this).getString("lastCity", mCurrentCityName);
        setTitle(mCurrentCityName);
        getCityWeatherData();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.weather, menu);
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
            CityPicker.getInstance()
                    .setFragmentManager(getSupportFragmentManager())
                    .setOnPickListener(new OnPickListener() {
                        @Override
                        public void onPick(int position, City data) {
                            if (data == null) {
                                return;
                            }
                            String code = data.getCode();//101280601
                            String name = data.getName();//深圳
                            String pinyin = data.getPinyin();//热门城市
                            String province = data.getProvince();//广东
                            Logger.e("" + name);
                            mCurrentCityName = name;

                            PreferenceManager.getDefaultSharedPreferences(WeatherActivity.this)
                                    .edit()
                                    .putString("lastCity", name)
                                    .apply();
                            getCityWeatherData();
                            setTitle(mCurrentCityName);
                        }

                        @Override
                        public void onLocate() {

                        }
                    })
                    .show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
            Toast.makeText(this, "功能待实现", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_gallery) {
            Toast.makeText(this, "功能待实现", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_slideshow) {
            Toast.makeText(this, "功能待实现", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_manage) {
            Toast.makeText(this, "功能待实现", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_share) {
            Toast.makeText(this, "功能待实现", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_send) {
            Toast.makeText(this, "功能待实现", Toast.LENGTH_SHORT).show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public class CustomAdapter extends BaseQuickAdapter<MultiItemEntity, BaseViewHolder> {

        public CustomAdapter() {
            super(null);
            setMultiTypeDelegate(new MultiTypeDelegate<MultiItemEntity>() {
                @Override
                protected int getItemType(MultiItemEntity multiItemEntity) {
                    return multiItemEntity.getItemType();
                }
            });
            getMultiTypeDelegate()
                    .registerItemType(AvatarWeather.VIEW_TYPE_REALTIME, R.layout.list_item_avatar_realtime)
                    .registerItemType(AvatarWeather.VIEW_TYPE_LIFE, R.layout.list_item_avatar_life)
                    .registerItemType(AvatarWeather.VIEW_TYPE_WEATHER, R.layout.list_item_avatar_forecast_weather);
        }

        private String getWeekStr(int week) {
            String weekStr = "";
            switch (week) {
                case 0:

                    break;
                case 1:
                    weekStr = "周一";
                    break;
                case 2:
                    weekStr = "周二";
                    break;
                case 3:
                    weekStr = "周三";
                    break;
                case 4:
                    weekStr = "周四";
                    break;
                case 5:
                    weekStr = "周五";
                    break;
                case 6:
                    weekStr = "周六";
                    break;
                case 7:
                    weekStr = "周日";
                    break;
            }
            return weekStr;
        }

        @Override
        protected void convert(BaseViewHolder helper, MultiItemEntity item) {
            switch (item.getItemType()) {
                case AvatarWeather.VIEW_TYPE_REALTIME:
                    AvatarWeather.ResultBean.RealtimeBean realtimeBean = (AvatarWeather.ResultBean.RealtimeBean) item;
                    helper.setText(R.id.city_name, realtimeBean.getCity_name());
                    helper.setText(R.id.week, getWeekStr(realtimeBean.getWeek()));
                    helper.setText(R.id.moon, "农历：" + realtimeBean.getMoon());
                    helper.setText(R.id.date, "当前时间：" + realtimeBean.getDate());
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
                    helper.setText(R.id.data_up_time, "数据更新时间：" + format.format(new Date(Long.parseLong(realtimeBean.getDataUptime()) * 1000)));
                    helper.setImageResource(R.id.weather_image, mWeatherIconIdArray.get(Integer.parseInt(realtimeBean.getWeather().getImg())));
                    helper.setText(R.id.info, realtimeBean.getWeather().getInfo() );
                    helper.setText(R.id.temperature, realtimeBean.getWeather().getTemperature()+ "℃");
                    break;
                case AvatarWeather.VIEW_TYPE_LIFE:
                    AvatarWeather.ResultBean.LifeBean lifeBean = (AvatarWeather.ResultBean.LifeBean) item;
                    helper.setText(R.id.date, lifeBean.getDate());

                    //空调指数
                    if (lifeBean.getInfo().getKongtiao() != null) {
                        if (lifeBean.getInfo().getKongtiao().size() > 1) {
                            helper.setText(R.id.kong_tiao_1, lifeBean.getInfo().getKongtiao().get(0));
                            helper.setText(R.id.kong_tiao_1, lifeBean.getInfo().getKongtiao().get(1));
                        }
                    }

                    //运动指数
                    if (lifeBean.getInfo().getYundong() != null) {
                        if (lifeBean.getInfo().getYundong().size() > 1) {
                            helper.setText(R.id.yun_dong_1, lifeBean.getInfo().getYundong().get(0));
                            helper.setText(R.id.yun_dong_2, lifeBean.getInfo().getYundong().get(1));
                        }
                    }

                    //紫外线强度
                    if (lifeBean.getInfo().getZiwaixian() != null) {
                        if (lifeBean.getInfo().getZiwaixian().size() > 1) {
                            helper.setText(R.id.zi_wai_xian_1, lifeBean.getInfo().getZiwaixian().get(0));
                            helper.setText(R.id.zi_wai_xian_2, lifeBean.getInfo().getZiwaixian().get(1));
                        }
                    }

                    //感冒指数
                    if (lifeBean.getInfo().getGanmao() != null) {
                        if (lifeBean.getInfo().getGanmao().size() > 1) {
                            helper.setText(R.id.gan_mao_1, lifeBean.getInfo().getGanmao().get(0));
                            helper.setText(R.id.gan_mao_2, lifeBean.getInfo().getGanmao().get(1));
                        }
                    }

                    //洗车指数
                    if (lifeBean.getInfo().getXiche() != null) {
                        if (lifeBean.getInfo().getXiche().size() > 1) {
                            helper.setText(R.id.xi_che_1, lifeBean.getInfo().getXiche().get(0));
                            helper.setText(R.id.xi_che_2, lifeBean.getInfo().getXiche().get(1));
                        }
                    }

                    //污染指数
//                    if (lifeBean.getInfo().getWuran() != null) {
//                        if (lifeBean.getInfo().getWuran().size() > 1) {
//                            helper.setText(R.id.wu_ran_1, lifeBean.getInfo().getWuran().get(0));
//                            helper.setText(R.id.wu_ran_2, lifeBean.getInfo().getWuran().get(1));
//                        }
//                    }

                    //穿衣指数
//                    if (lifeBean.getInfo().getWuran() != null) {
//                        if (lifeBean.getInfo().getWuran().size() > 1) {
//                            helper.setText(R.id.chuan_yi_1, lifeBean.getInfo().getWuran().get(0));
//                            helper.setText(R.id.chuan_yi_2, lifeBean.getInfo().getChuanyi().get(1));
//                        }
//                    }
                    break;
                case AvatarWeather.VIEW_TYPE_WEATHER:
                    AvatarWeather.ResultBean.WeatherBeanX weatherBeanX = (AvatarWeather.ResultBean.WeatherBeanX) item;
                    helper.setText(R.id.date, weatherBeanX.getDate());
                    helper.setText(R.id.week, weatherBeanX.getWeek());
                    helper.setText(R.id.nongli, weatherBeanX.getNongli());

                    AvatarWeather.ResultBean.WeatherBeanX.InfoBeanX infoBeanX = weatherBeanX.getInfo();
                    List<String> dawnInfoList = infoBeanX.getDawn();
                    List<String> dayInfoList = infoBeanX.getDay();
                    List<String> nightInfoList = infoBeanX.getNight();

                    RecyclerView recyclerView = (RecyclerView) helper.getView(R.id.item_recycler_view);
                    BaseQuickAdapter<List<String>, BaseViewHolder> adapter = new BaseQuickAdapter<List<String>, BaseViewHolder>(R.layout.list_item_avatar_item) {
                        @Override
                        protected void convert(BaseViewHolder helper, List<String> item) {
                            int position = helper.getAdapterPosition();
                            if (position == 0) {
                                helper.setText(R.id.title, "黎明");
                            } else if (position == 1) {
                                helper.setText(R.id.title, "白天");
                            } else {
                                helper.setText(R.id.title, "晚上");
                            }
                            helper.setImageResource(R.id.weather_image, mWeatherIconIdArray.get(Integer.parseInt(item.get(0))));
                            helper.setText(R.id.dawn_2, item.get(1));
                            helper.setText(R.id.dawn_3, item.get(2) + "℃");
                            helper.setText(R.id.dawn_4, item.get(3));
                            helper.setText(R.id.dawn_5, item.get(4));
                            helper.setText(R.id.dawn_6, item.get(5));
                            if (item.size() > 6) {
                                helper.setText(R.id.dawn_notice, item.get(6));
                            }
                        }
                    };
                    recyclerView.setAdapter(adapter);

                    adapter.addData(dawnInfoList);
                    adapter.addData(dayInfoList);
                    adapter.addData(nightInfoList);
                    break;
                default:
                    break;
            }
        }
    }

    private void getCityWeatherData() {
        mCustomAdapter.replaceData(new ArrayList<MultiItemEntity>());
        OkGo.<AvatarWeather>get("http://api.avatardata.cn/Weather/Query")
                .params("key", "97064e29a1584bdfa90038c4914c6378")
                .params("cityname", mCurrentCityName)
                .execute(new AbsCallback<AvatarWeather>() {
                    @Override
                    public void onSuccess(Response<AvatarWeather> response) {
                        mSwipeRefreshLayout.setRefreshing(false);
                        AvatarWeather avatarWeather = response.body();
                        if (avatarWeather.getError_code() == 0) {
                            AvatarWeather.ResultBean resultBean = avatarWeather.getResult();
                            List<AvatarWeather.ResultBean.WeatherBeanX> weatherBeanXList = resultBean.getWeather();
                            mCustomAdapter.addData(resultBean.getRealtime());
                            mCustomAdapter.addData(resultBean.getLife());
                            mCustomAdapter.addData(weatherBeanXList);
                        } else {
                            Toast.makeText(WeatherActivity.this, avatarWeather.getReason(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public AvatarWeather convertResponse(okhttp3.Response response) throws Throwable {
                        String json = response.body().string();
                        Logger.e(json);
                        return new Gson().fromJson(json, AvatarWeather.class);
                    }
                });
    }
}
