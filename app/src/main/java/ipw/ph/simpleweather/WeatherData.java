package ipw.ph.simpleweather;

import java.util.List;

/**
 * 天气数据实体
 */
public class WeatherData {
    /**
     * date : 20180506
     * message : Success !
     * status : 200
     * city : 北京
     * count : 655
     * data : {"shidu":"50%","pm25":72,"pm10":265,"quality":"中度污染","wendu":"17","ganmao":"儿童、老年人及心脏、呼吸系统疾病患者人群应减少长时间或高强度户外锻炼，一般人群适量减少户外运动","yesterday":{"date":"05日星期六","sunrise":"05:12","high":"高温 26.0℃","low":"低温 13.0℃","sunset":"19:12","aqi":180,"fx":"东北风","fl":"3-4级","type":"阴","notice":"不要被阴云遮挡住好心情"},"forecast":[{"date":"06日星期日","sunrise":"05:11","high":"高温 28.0℃","low":"低温 14.0℃","sunset":"19:13","aqi":129,"fx":"西南风","fl":"<3级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"07日星期一","sunrise":"05:09","high":"高温 29.0℃","low":"低温 13.0℃","sunset":"19:14","aqi":86,"fx":"东南风","fl":"3-4级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"08日星期二","sunrise":"05:08","high":"高温 28.0℃","low":"低温 14.0℃","sunset":"19:15","aqi":84,"fx":"东南风","fl":"<3级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"09日星期三","sunrise":"05:07","high":"高温 30.0℃","low":"低温 17.0℃","sunset":"19:16","aqi":85,"fx":"南风","fl":"3-4级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"10日星期四","sunrise":"05:06","high":"高温 29.0℃","low":"低温 18.0℃","sunset":"19:17","aqi":78,"fx":"东北风","fl":"<3级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"}]}
     */

    private String date;
    private String message;
    private int status;
    private String city;
    private int count;
    private DataBean data;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * shidu : 50%
         * pm25 : 72.0
         * pm10 : 265.0
         * quality : 中度污染
         * wendu : 17
         * ganmao : 儿童、老年人及心脏、呼吸系统疾病患者人群应减少长时间或高强度户外锻炼，一般人群适量减少户外运动
         * yesterday : {"date":"05日星期六","sunrise":"05:12","high":"高温 26.0℃","low":"低温 13.0℃","sunset":"19:12","aqi":180,"fx":"东北风","fl":"3-4级","type":"阴","notice":"不要被阴云遮挡住好心情"}
         * forecast : [{"date":"06日星期日","sunrise":"05:11","high":"高温 28.0℃","low":"低温 14.0℃","sunset":"19:13","aqi":129,"fx":"西南风","fl":"<3级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"07日星期一","sunrise":"05:09","high":"高温 29.0℃","low":"低温 13.0℃","sunset":"19:14","aqi":86,"fx":"东南风","fl":"3-4级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"08日星期二","sunrise":"05:08","high":"高温 28.0℃","low":"低温 14.0℃","sunset":"19:15","aqi":84,"fx":"东南风","fl":"<3级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"09日星期三","sunrise":"05:07","high":"高温 30.0℃","low":"低温 17.0℃","sunset":"19:16","aqi":85,"fx":"南风","fl":"3-4级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"10日星期四","sunrise":"05:06","high":"高温 29.0℃","low":"低温 18.0℃","sunset":"19:17","aqi":78,"fx":"东北风","fl":"<3级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"}]
         */

        private String shidu;
        private int pm25;
        private int pm10;
        private String quality;
        private int wendu;
        private String ganmao;
        private ForecastBean yesterday;
        private List<ForecastBean> forecast;

        public String getShidu() {
            return shidu;
        }

        public void setShidu(String shidu) {
            this.shidu = shidu;
        }

        public int getPm25() {
            return pm25;
        }

        public void setPm25(int pm25) {
            this.pm25 = pm25;
        }

        public int getPm10() {
            return pm10;
        }

        public void setPm10(int pm10) {
            this.pm10 = pm10;
        }

        public String getQuality() {
            return quality;
        }

        public void setQuality(String quality) {
            this.quality = quality;
        }

        public int getWendu() {
            return wendu;
        }

        public void setWendu(int wendu) {
            this.wendu = wendu;
        }

        public String getGanmao() {
            return ganmao;
        }

        public void setGanmao(String ganmao) {
            this.ganmao = ganmao;
        }

        public ForecastBean getYesterday() {
            return yesterday;
        }

        public void setYesterday(ForecastBean yesterday) {
            this.yesterday = yesterday;
        }

        public List<ForecastBean> getForecast() {
            return forecast;
        }

        public void setForecast(List<ForecastBean> forecast) {
            this.forecast = forecast;
        }

        public static class ForecastBean {
            public static final int CURRENT_DATA = 1;
            public static final int FORECAST_DATA = 2;
            /**
             * date : 06日星期日
             * sunrise : 05:11
             * high : 高温 28.0℃
             * low : 低温 14.0℃
             * sunset : 19:13
             * aqi : 129.0
             * fx : 西南风
             * fl : <3级
             * type : 晴
             * notice : 愿你拥有比阳光明媚的心情
             */
            private String date;

            //当前城市数据
            private String city;
            private int count;
            private String shidu;
            private int pm25;
            private int pm10;
            private String quality;
            private int wendu;
            private String ganmao;

            private String sunrise;
            private String high;
            private String low;
            private String sunset;
            private int aqi;
            private String fx;
            private String fl;
            private String type;
            private String notice;

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public String getShidu() {
                return shidu;
            }

            public void setShidu(String shidu) {
                this.shidu = shidu;
            }

            public int getPm25() {
                return pm25;
            }

            public void setPm25(int pm25) {
                this.pm25 = pm25;
            }

            public int getPm10() {
                return pm10;
            }

            public void setPm10(int pm10) {
                this.pm10 = pm10;
            }

            public String getQuality() {
                return quality;
            }

            public void setQuality(String quality) {
                this.quality = quality;
            }

            public int getWendu() {
                return wendu;
            }

            public void setWendu(int wendu) {
                this.wendu = wendu;
            }

            public String getGanmao() {
                return ganmao;
            }

            public void setGanmao(String ganmao) {
                this.ganmao = ganmao;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getSunrise() {
                return sunrise;
            }

            public void setSunrise(String sunrise) {
                this.sunrise = sunrise;
            }

            public String getHigh() {
                return high;
            }

            public void setHigh(String high) {
                this.high = high;
            }

            public String getLow() {
                return low;
            }

            public void setLow(String low) {
                this.low = low;
            }

            public String getSunset() {
                return sunset;
            }

            public void setSunset(String sunset) {
                this.sunset = sunset;
            }

            public int getAqi() {
                return aqi;
            }

            public void setAqi(int aqi) {
                this.aqi = aqi;
            }

            public String getFx() {
                return fx;
            }

            public void setFx(String fx) {
                this.fx = fx;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getNotice() {
                return notice;
            }

            public void setNotice(String notice) {
                this.notice = notice;
            }
        }
    }
}
