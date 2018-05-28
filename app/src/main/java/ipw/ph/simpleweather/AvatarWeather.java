package ipw.ph.simpleweather;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

public class AvatarWeather {
    public static final int VIEW_TYPE_WEATHER = 1;
    public static final int VIEW_TYPE_LIFE = 2;
    public static final int VIEW_TYPE_REALTIME = 3;
    /**
     * result : {"realtime":{"wind":{"windspeed":"","direct":"东风","power":"1级","offset":""},"time":"22:00:00","weather":{"humidity":"100","img":"01","info":"多云","temperature":"19"},"dataUptime":"1526046528","date":"2018-05-11","city_code":"101200101","city_name":"武汉","week":"5","moon":"三月廿六"},"life":{"date":"2018-05-11","info":{"kongtiao":["较少开启","您将感到很舒适，一般不需要开启空调。"],"yundong":["较不宜","有降水，推荐您在室内进行健身休闲运动；若坚持户外运动，须注意携带雨具并注意避雨防滑。"],"ziwaixian":["最弱","属弱紫外线辐射天气，无需特别防护。若长期在户外，建议涂擦SPF在8-12之间的防晒护肤品。"],"ganmao":["少发","各项气象条件适宜，无明显降温过程，发生感冒机率较低。"],"xiche":["不宜","不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。"],"wuran":null,"chuanyi":["舒适","建议着长袖T恤、衬衫加单裤等服装。年老体弱者宜着针织长袖衬衫、马甲和长裤。"]}},"weather":[{"date":"2018-05-11","week":"五","nongli":"三月廿六","info":{"dawn":["7","小雨","18","东南风","微风","19:06"],"day":["7","小雨","24","东北风","微风","05:32","出门记得带伞，行走驾驶做好防滑准备"],"night":["7","小雨","19","东风","微风","19:07","出门记得带伞，行走驾驶做好防滑准备"]}},{"date":"2018-05-12","week":"六","nongli":"三月廿七","info":{"dawn":["7","小雨","19","东风","微风","19:07"],"day":["2","阴","28","东北风","微风","05:32"],"night":["1","多云","17","东风","微风","19:08"]}},{"date":"2018-05-13","week":"日","nongli":"三月廿八","info":{"dawn":["1","多云","17","东风","微风","19:08"],"day":["2","阴","31","东风","3-5级","05:31"],"night":["1","多云","20","东北风","微风","19:08"]}},{"date":"2018-05-14","week":"一","nongli":"三月廿九","info":{"dawn":["1","多云","20","东北风","微风","19:08"],"day":["1","多云","31","东风","3-5级","05:30"],"night":["1","多云","23","东北风","微风","19:09"]}},{"date":"2018-05-15","week":"二","nongli":"四月初一","info":{"dawn":["1","多云","23","东北风","微风","19:09"],"day":["2","阴","33","南风","3-5级","05:29"],"night":["2","阴","21","南风","微风","19:10"]}}],"pm25":{"key":"武汉","show_desc":null,"pm25":{"curPm":"76","pm25":"55","pm10":"70","level":"2","quality":"良","des":"空气良好，可以正常参加户外活动。"},"dateTime":"2018年05月11日20时","cityName":"武汉"},"isForeign":0}
     * error_code : 0
     * reason : Succes
     */

    private ResultBean result;
    private int error_code;
    private String reason;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public static class ResultBean {
        /**
         * realtime : {"wind":{"windspeed":"","direct":"东风","power":"1级","offset":""},"time":"22:00:00","weather":{"humidity":"100","img":"01","info":"多云","temperature":"19"},"dataUptime":"1526046528","date":"2018-05-11","city_code":"101200101","city_name":"武汉","week":"5","moon":"三月廿六"}
         * life : {"date":"2018-05-11","info":{"kongtiao":["较少开启","您将感到很舒适，一般不需要开启空调。"],"yundong":["较不宜","有降水，推荐您在室内进行健身休闲运动；若坚持户外运动，须注意携带雨具并注意避雨防滑。"],"ziwaixian":["最弱","属弱紫外线辐射天气，无需特别防护。若长期在户外，建议涂擦SPF在8-12之间的防晒护肤品。"],"ganmao":["少发","各项气象条件适宜，无明显降温过程，发生感冒机率较低。"],"xiche":["不宜","不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。"],"wuran":null,"chuanyi":["舒适","建议着长袖T恤、衬衫加单裤等服装。年老体弱者宜着针织长袖衬衫、马甲和长裤。"]}}
         * weather : [{"date":"2018-05-11","week":"五","nongli":"三月廿六","info":{"dawn":["7","小雨","18","东南风","微风","19:06"],"day":["7","小雨","24","东北风","微风","05:32","出门记得带伞，行走驾驶做好防滑准备"],"night":["7","小雨","19","东风","微风","19:07","出门记得带伞，行走驾驶做好防滑准备"]}},{"date":"2018-05-12","week":"六","nongli":"三月廿七","info":{"dawn":["7","小雨","19","东风","微风","19:07"],"day":["2","阴","28","东北风","微风","05:32"],"night":["1","多云","17","东风","微风","19:08"]}},{"date":"2018-05-13","week":"日","nongli":"三月廿八","info":{"dawn":["1","多云","17","东风","微风","19:08"],"day":["2","阴","31","东风","3-5级","05:31"],"night":["1","多云","20","东北风","微风","19:08"]}},{"date":"2018-05-14","week":"一","nongli":"三月廿九","info":{"dawn":["1","多云","20","东北风","微风","19:08"],"day":["1","多云","31","东风","3-5级","05:30"],"night":["1","多云","23","东北风","微风","19:09"]}},{"date":"2018-05-15","week":"二","nongli":"四月初一","info":{"dawn":["1","多云","23","东北风","微风","19:09"],"day":["2","阴","33","南风","3-5级","05:29"],"night":["2","阴","21","南风","微风","19:10"]}}]
         * pm25 : {"key":"武汉","show_desc":null,"pm25":{"curPm":"76","pm25":"55","pm10":"70","level":"2","quality":"良","des":"空气良好，可以正常参加户外活动。"},"dateTime":"2018年05月11日20时","cityName":"武汉"}
         * isForeign : 0
         */

        private RealtimeBean realtime;
        private LifeBean life;
        private Pm25BeanX pm25;
        private int isForeign;
        private List<WeatherBeanX> weather;

        public RealtimeBean getRealtime() {
            return realtime;
        }

        public void setRealtime(RealtimeBean realtime) {
            this.realtime = realtime;
        }

        public LifeBean getLife() {
            return life;
        }

        public void setLife(LifeBean life) {
            this.life = life;
        }

        public Pm25BeanX getPm25() {
            return pm25;
        }

        public void setPm25(Pm25BeanX pm25) {
            this.pm25 = pm25;
        }

        public int getIsForeign() {
            return isForeign;
        }

        public void setIsForeign(int isForeign) {
            this.isForeign = isForeign;
        }

        public List<WeatherBeanX> getWeather() {
            return weather;
        }

        public void setWeather(List<WeatherBeanX> weather) {
            this.weather = weather;
        }

        public static class RealtimeBean implements MultiItemEntity {
            /**
             * wind : {"windspeed":"","direct":"东风","power":"1级","offset":""}
             * time : 22:00:00
             * weather : {"humidity":"100","img":"01","info":"多云","temperature":"19"}
             * dataUptime : 1526046528
             * date : 2018-05-11
             * city_code : 101200101
             * city_name : 武汉
             * week : 5
             * moon : 三月廿六
             */

            private WindBean wind;
            private String time;
            private WeatherBean weather;
            private String dataUptime;
            private String date;
            private String city_code;
            private String city_name;
            private int week;
            private String moon;

            public WindBean getWind() {
                return wind;
            }

            public void setWind(WindBean wind) {
                this.wind = wind;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public WeatherBean getWeather() {
                return weather;
            }

            public void setWeather(WeatherBean weather) {
                this.weather = weather;
            }

            public String getDataUptime() {
                return dataUptime;
            }

            public void setDataUptime(String dataUptime) {
                this.dataUptime = dataUptime;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getCity_code() {
                return city_code;
            }

            public void setCity_code(String city_code) {
                this.city_code = city_code;
            }

            public String getCity_name() {
                return city_name;
            }

            public void setCity_name(String city_name) {
                this.city_name = city_name;
            }

            public int getWeek() {
                return week;
            }

            public void setWeek(int week) {
                this.week = week;
            }

            public String getMoon() {
                return moon;
            }

            public void setMoon(String moon) {
                this.moon = moon;
            }

            @Override
            public int getItemType() {
                return VIEW_TYPE_REALTIME;
            }

            public static class WindBean {
                /**
                 * windspeed :
                 * direct : 东风
                 * power : 1级
                 * offset :
                 */

                private String windspeed;
                private String direct;
                private String power;
                private String offset;

                public String getWindspeed() {
                    return windspeed;
                }

                public void setWindspeed(String windspeed) {
                    this.windspeed = windspeed;
                }

                public String getDirect() {
                    return direct;
                }

                public void setDirect(String direct) {
                    this.direct = direct;
                }

                public String getPower() {
                    return power;
                }

                public void setPower(String power) {
                    this.power = power;
                }

                public String getOffset() {
                    return offset;
                }

                public void setOffset(String offset) {
                    this.offset = offset;
                }
            }

            public static class WeatherBean {
                /**
                 * humidity : 100
                 * img : 01
                 * info : 多云
                 * temperature : 19
                 */

                private String humidity;
                private String img;
                private String info;
                private String temperature;

                public String getHumidity() {
                    return humidity;
                }

                public void setHumidity(String humidity) {
                    this.humidity = humidity;
                }

                public String getImg() {
                    return img;
                }

                public void setImg(String img) {
                    this.img = img;
                }

                public String getInfo() {
                    return info;
                }

                public void setInfo(String info) {
                    this.info = info;
                }

                public String getTemperature() {
                    return temperature;
                }

                public void setTemperature(String temperature) {
                    this.temperature = temperature;
                }
            }
        }

        public static class LifeBean implements MultiItemEntity {
            /**
             * date : 2018-05-11
             * info : {"kongtiao":["较少开启","您将感到很舒适，一般不需要开启空调。"],"yundong":["较不宜","有降水，推荐您在室内进行健身休闲运动；若坚持户外运动，须注意携带雨具并注意避雨防滑。"],"ziwaixian":["最弱","属弱紫外线辐射天气，无需特别防护。若长期在户外，建议涂擦SPF在8-12之间的防晒护肤品。"],"ganmao":["少发","各项气象条件适宜，无明显降温过程，发生感冒机率较低。"],"xiche":["不宜","不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。"],"wuran":null,"chuanyi":["舒适","建议着长袖T恤、衬衫加单裤等服装。年老体弱者宜着针织长袖衬衫、马甲和长裤。"]}
             */

            private String date;
            private InfoBean info;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public InfoBean getInfo() {
                return info;
            }

            public void setInfo(InfoBean info) {
                this.info = info;
            }

            @Override
            public int getItemType() {
                return VIEW_TYPE_LIFE;
            }

            public static class InfoBean {
                /**
                 * kongtiao : ["较少开启","您将感到很舒适，一般不需要开启空调。"]
                 * yundong : ["较不宜","有降水，推荐您在室内进行健身休闲运动；若坚持户外运动，须注意携带雨具并注意避雨防滑。"]
                 * ziwaixian : ["最弱","属弱紫外线辐射天气，无需特别防护。若长期在户外，建议涂擦SPF在8-12之间的防晒护肤品。"]
                 * ganmao : ["少发","各项气象条件适宜，无明显降温过程，发生感冒机率较低。"]
                 * xiche : ["不宜","不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。"]
                 * wuran : null
                 * chuanyi : ["舒适","建议着长袖T恤、衬衫加单裤等服装。年老体弱者宜着针织长袖衬衫、马甲和长裤。"]
                 */

                private List<String> wuran;
                private List<String> kongtiao;
                private List<String> yundong;
                private List<String> ziwaixian;
                private List<String> ganmao;
                private List<String> xiche;
                private List<String> chuanyi;

                public List<String> getWuran() {
                    return wuran;
                }

                public void setWuran(List<String> wuran) {
                    this.wuran = wuran;
                }

                public List<String> getKongtiao() {
                    return kongtiao;
                }

                public void setKongtiao(List<String> kongtiao) {
                    this.kongtiao = kongtiao;
                }

                public List<String> getYundong() {
                    return yundong;
                }

                public void setYundong(List<String> yundong) {
                    this.yundong = yundong;
                }

                public List<String> getZiwaixian() {
                    return ziwaixian;
                }

                public void setZiwaixian(List<String> ziwaixian) {
                    this.ziwaixian = ziwaixian;
                }

                public List<String> getGanmao() {
                    return ganmao;
                }

                public void setGanmao(List<String> ganmao) {
                    this.ganmao = ganmao;
                }

                public List<String> getXiche() {
                    return xiche;
                }

                public void setXiche(List<String> xiche) {
                    this.xiche = xiche;
                }

                public List<String> getChuanyi() {
                    return chuanyi;
                }

                public void setChuanyi(List<String> chuanyi) {
                    this.chuanyi = chuanyi;
                }
            }
        }

        public static class Pm25BeanX {
            /**
             * key : 武汉
             * show_desc : null
             * pm25 : {"curPm":"76","pm25":"55","pm10":"70","level":"2","quality":"良","des":"空气良好，可以正常参加户外活动。"}
             * dateTime : 2018年05月11日20时
             * cityName : 武汉
             */

            private String key;
            private Object show_desc;
            private Pm25Bean pm25;
            private String dateTime;
            private String cityName;

            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }

            public Object getShow_desc() {
                return show_desc;
            }

            public void setShow_desc(Object show_desc) {
                this.show_desc = show_desc;
            }

            public Pm25Bean getPm25() {
                return pm25;
            }

            public void setPm25(Pm25Bean pm25) {
                this.pm25 = pm25;
            }

            public String getDateTime() {
                return dateTime;
            }

            public void setDateTime(String dateTime) {
                this.dateTime = dateTime;
            }

            public String getCityName() {
                return cityName;
            }

            public void setCityName(String cityName) {
                this.cityName = cityName;
            }

            public static class Pm25Bean {
                /**
                 * curPm : 76
                 * pm25 : 55
                 * pm10 : 70
                 * level : 2
                 * quality : 良
                 * des : 空气良好，可以正常参加户外活动。
                 */

                private String curPm;
                private String pm25;
                private String pm10;
                private String level;
                private String quality;
                private String des;

                public String getCurPm() {
                    return curPm;
                }

                public void setCurPm(String curPm) {
                    this.curPm = curPm;
                }

                public String getPm25() {
                    return pm25;
                }

                public void setPm25(String pm25) {
                    this.pm25 = pm25;
                }

                public String getPm10() {
                    return pm10;
                }

                public void setPm10(String pm10) {
                    this.pm10 = pm10;
                }

                public String getLevel() {
                    return level;
                }

                public void setLevel(String level) {
                    this.level = level;
                }

                public String getQuality() {
                    return quality;
                }

                public void setQuality(String quality) {
                    this.quality = quality;
                }

                public String getDes() {
                    return des;
                }

                public void setDes(String des) {
                    this.des = des;
                }
            }
        }

        public static class WeatherBeanX implements MultiItemEntity {
            /**
             * date : 2018-05-11
             * week : 五
             * nongli : 三月廿六
             * info : {"dawn":["7","小雨","18","东南风","微风","19:06"],"day":["7","小雨","24","东北风","微风","05:32","出门记得带伞，行走驾驶做好防滑准备"],"night":["7","小雨","19","东风","微风","19:07","出门记得带伞，行走驾驶做好防滑准备"]}
             */

            private String date;
            private String week;
            private String nongli;
            private InfoBeanX info;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getWeek() {
                return week;
            }

            public void setWeek(String week) {
                this.week = week;
            }

            public String getNongli() {
                return nongli;
            }

            public void setNongli(String nongli) {
                this.nongli = nongli;
            }

            public InfoBeanX getInfo() {
                return info;
            }

            public void setInfo(InfoBeanX info) {
                this.info = info;
            }

            @Override
            public int getItemType() {
                return AvatarWeather.VIEW_TYPE_WEATHER;
            }

            public static class InfoBeanX {
                private List<String> dawn;
                private List<String> day;
                private List<String> night;

                public List<String> getDawn() {
                    return dawn;
                }

                public void setDawn(List<String> dawn) {
                    this.dawn = dawn;
                }

                public List<String> getDay() {
                    return day;
                }

                public void setDay(List<String> day) {
                    this.day = day;
                }

                public List<String> getNight() {
                    return night;
                }

                public void setNight(List<String> night) {
                    this.night = night;
                }
            }
        }
    }
}
