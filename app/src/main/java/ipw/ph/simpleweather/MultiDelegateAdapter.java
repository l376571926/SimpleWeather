package ipw.ph.simpleweather;

import android.content.res.Resources;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.util.MultiTypeDelegate;

/**
 * 数据显示适配器
 */
public class MultiDelegateAdapter extends BaseQuickAdapter<WeatherData.DataBean.ForecastBean, BaseViewHolder> {

    public MultiDelegateAdapter() {
        super(null);
        setMultiTypeDelegate(new MultiTypeDelegate<WeatherData.DataBean.ForecastBean>() {
            @Override
            protected int getItemType(WeatherData.DataBean.ForecastBean forecastBean) {
                if (forecastBean.getCity() != null) {
                    return WeatherData.DataBean.ForecastBean.CURRENT_DATA;
                }
                return WeatherData.DataBean.ForecastBean.FORECAST_DATA;
            }
        });
        getMultiTypeDelegate()
                .registerItemType(WeatherData.DataBean.ForecastBean.CURRENT_DATA, R.layout.list_item_forecast_weather_current_city)
                .registerItemType(WeatherData.DataBean.ForecastBean.FORECAST_DATA, R.layout.list_item_forecast_weather);
    }

    @Override
    protected void convert(BaseViewHolder helper, WeatherData.DataBean.ForecastBean item) {
        Resources resources = helper.itemView.getResources();
        switch (helper.getItemViewType()) {
            case WeatherData.DataBean.ForecastBean.CURRENT_DATA:
                helper.setText(R.id.city_tv, resources.getString(R.string.city_place_holder, item.getCity()));
                helper.setText(R.id.date_tv, resources.getString(R.string.update_date_place_holder, item.getDate()));
                helper.setText(R.id.shidu_tv, resources.getString(R.string.shi_du_place_holder, item.getShidu()));
                helper.setText(R.id.pm25_tv, resources.getString(R.string.aqi_place_holder, item.getPm25()));
                helper.setText(R.id.pm10_tv, resources.getString(R.string.pm10_place_holder, item.getPm10()));
                helper.setText(R.id.quality_tv, resources.getString(R.string.quality_place_holder, item.getQuality()));
                helper.setText(R.id.wen_du_tv, resources.getString(R.string.wen_du_place_holder, item.getWendu()));
                helper.setText(R.id.gan_mao_tv, resources.getString(R.string.notice_place_holder, item.getGanmao()));
                break;
            case WeatherData.DataBean.ForecastBean.FORECAST_DATA:
                helper.setText(R.id.date_tv, item.getDate());
                helper.setText(R.id.sunrise_tv, resources.getString(R.string.sunrise_place_holder, item.getSunrise()));
                helper.setText(R.id.high_tv, item.getHigh());
                helper.setText(R.id.low_tv, item.getLow());
                helper.setText(R.id.sunset_tv, resources.getString(R.string.sunset_place_holder, item.getSunset()));
                helper.setText(R.id.aqi_tv, resources.getString(R.string.aqi_place_holder, item.getAqi()));
                helper.setText(R.id.fx_tv, resources.getString(R.string.fx_place_holder, item.getFx()));
                helper.setText(R.id.fl_tv, resources.getString(R.string.fl_place_holder, item.getFl()));
                helper.setText(R.id.type_tv, resources.getString(R.string.type_place_holder, item.getType()));
                helper.setText(R.id.notice_tv, resources.getString(R.string.notice_place_holder, item.getNotice()));
                break;
        }
    }
}
