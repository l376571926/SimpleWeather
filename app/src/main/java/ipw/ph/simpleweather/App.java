package ipw.ph.simpleweather;

import android.app.Application;

import com.lzy.okgo.OkGo;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

/**
 * 初始化
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        /** 必须在全局Application先调用，获取context上下文，否则缓存无法使用 */
        OkGo.getInstance().init(this);
        Logger.addLogAdapter(new AndroidLogAdapter());
    }
}
