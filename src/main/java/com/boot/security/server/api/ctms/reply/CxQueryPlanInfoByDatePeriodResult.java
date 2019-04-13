package com.boot.security.server.api.ctms.reply;

import java.util.Date;
import java.util.List;

/**
 * 按时间查询影院放映计划
 */
public class CxQueryPlanInfoByDatePeriodResult {

    private ResBean QueryPlanInfoByDatePeriodResult;

    public ResBean getQueryPlanInfoByDatePeriodResult() {
        return QueryPlanInfoByDatePeriodResult;
    }

    public void setQueryPlanInfoByDatePeriodResult(ResBean queryPlanInfoByDatePeriodResult) {
        QueryPlanInfoByDatePeriodResult = queryPlanInfoByDatePeriodResult;
    }

    public static class ResBean {

        private	String  ResultCode;//	返回结果号，详细见附录A
        private	String  Message;//	返回信息，详细见附录A
        private CinemaPlansBean CinemaPlans;

        public String getResultCode() {
            return ResultCode;
        }

        public void setResultCode(String resultCode) {
            ResultCode = resultCode;
        }

        public String getMessage() {
            return Message;
        }

        public void setMessage(String message) {
            Message = message;
        }

        public CinemaPlansBean getCinemaPlans() {
            return CinemaPlans;
        }

        public void setCinemaPlans(CinemaPlansBean cinemaPlans) {
            CinemaPlans = cinemaPlans;
        }

        public static class CinemaPlansBean{
            private List<CinemaPlanBean> CinemaPlan;

            public List<CinemaPlanBean> getCinemaPlan() {
                return CinemaPlan;
            }

            public void setCinemaPlan(List<CinemaPlanBean> cinemaPlan) {
                CinemaPlan = cinemaPlan;
            }

            public static class CinemaPlanBean{
                private	String  ScreenCode;//	    影厅编码
                private	String  FeatureAppNo;//	    放映计划编码
                private	Date  StartTime;//	    放映计划开始时间(YYYY-MM-DD hh:mm:ss)
                private	String  PlaythroughFlag;//  连场标志：Yes，连场 No，非连场
                private	String  MarketingCode;//    活动标识
                private	String  MarketingName;//	活动名称
                private FilmsBean Films;
                private PriceBean Price;
                public static class FilmsBean{
                    private FilmBean Film;
                    public static class FilmBean{
                        private	String  FilmCode;//	影片编码
                        private	String  FilmName;//	影片名称
                        private	String  Lang;//	    语种
                        private	Integer  Duration;//影片时长，以分钟为单位
                        private	Integer  Sequence;//连场中的序号

                        public String getFilmCode() {
                            return FilmCode;
                        }

                        public void setFilmCode(String filmCode) {
                            FilmCode = filmCode;
                        }

                        public String getFilmName() {
                            return FilmName;
                        }

                        public void setFilmName(String filmName) {
                            FilmName = filmName;
                        }

                        public String getLang() {
                            return Lang;
                        }

                        public void setLang(String lang) {
                            Lang = lang;
                        }

                        public Integer getDuration() {
                            return Duration;
                        }

                        public void setDuration(Integer duration) {
                            Duration = duration;
                        }

                        public Integer getSequence() {
                            return Sequence;
                        }

                        public void setSequence(Integer sequence) {
                            Sequence = sequence;
                        }
                    }

                    public FilmBean getFilm() {
                        return Film;
                    }

                    public void setFilm(FilmBean film) {
                        Film = film;
                    }
                }
                public static class PriceBean{
                    private Double LowestPrice;//最低票价
                    private Double StandardPrice;//	标准票价（上报票房价格）
                    private Double ListingPrice;//	成人票价（影院成人票价，仅参考用，不作为结算依据）划掉的价格
                    private Double ServiceAddFee;//	增值服务费
                    private Double CinemaAllowance;//影院补贴

                    public Double getLowestPrice() {
                        return LowestPrice;
                    }

                    public void setLowestPrice(Double lowestPrice) {
                        LowestPrice = lowestPrice;
                    }

                    public Double getStandardPrice() {
                        return StandardPrice;
                    }

                    public void setStandardPrice(Double standardPrice) {
                        StandardPrice = standardPrice;
                    }

                    public Double getListingPrice() {
                        return ListingPrice;
                    }

                    public void setListingPrice(Double listingPrice) {
                        ListingPrice = listingPrice;
                    }

                    public Double getServiceAddFee() {
                        return ServiceAddFee;
                    }

                    public void setServiceAddFee(Double serviceAddFee) {
                        ServiceAddFee = serviceAddFee;
                    }

                    public Double getCinemaAllowance() {
                        return CinemaAllowance;
                    }

                    public void setCinemaAllowance(Double cinemaAllowance) {
                        CinemaAllowance = cinemaAllowance;
                    }
                }

                public String getScreenCode() {
                    return ScreenCode;
                }

                public void setScreenCode(String screenCode) {
                    ScreenCode = screenCode;
                }

                public String getFeatureAppNo() {
                    return FeatureAppNo;
                }

                public void setFeatureAppNo(String featureAppNo) {
                    FeatureAppNo = featureAppNo;
                }

                public Date getStartTime() {
                    return StartTime;
                }

                public void setStartTime(Date startTime) {
                    StartTime = startTime;
                }

                public String getPlaythroughFlag() {
                    return PlaythroughFlag;
                }

                public void setPlaythroughFlag(String playthroughFlag) {
                    PlaythroughFlag = playthroughFlag;
                }

                public String getMarketingCode() {
                    return MarketingCode;
                }

                public void setMarketingCode(String marketingCode) {
                    MarketingCode = marketingCode;
                }

                public String getMarketingName() {
                    return MarketingName;
                }

                public void setMarketingName(String marketingName) {
                    MarketingName = marketingName;
                }

                public FilmsBean getFilms() {
                    return Films;
                }

                public void setFilms(FilmsBean films) {
                    Films = films;
                }

                public PriceBean getPrice() {
                    return Price;
                }

                public void setPrice(PriceBean price) {
                    Price = price;
                }
            }

        }
    }
}
