package com.boot.security.server.api.ctms.reply;

import java.util.List;

public class CxQueryCinemaInfoResult {

    /**
     * res : {"status":1,"errorMessage":null,"errorCode":null,"data":[{"cinemaId":"11","cinemaName":"测试-81","validPeriod":"2022-04-18","cinemaNumber":"10088888"},{"cinemaId":"31","cinemaName":"电商平台测试影院电商平台测试影院电商平台测试影院172.16.9.87","validPeriod":"2022-04-18","cinemaNumber":"11088777"}]}
     * RES:{"Cinemas":[{"Cinema":[{"CinemaCode":"62549174"},{"CinemaName":"130影院"},{"Province":"广东省"},{"City":"广州市"},{"CreateDate":"2015-03-19"},{"PriceType":"0"}]}]
     * ,"Message":"成功","ResultCode":"0"}
     */
    private ResBean QueryCinemaInfoResult;

    public ResBean getQueryCinemaInfoResult() {
        return QueryCinemaInfoResult;
    }

    public void setQueryCinemaInfoResult(ResBean queryCinemaInfoResult) {
        QueryCinemaInfoResult = queryCinemaInfoResult;
    }

    public static class ResBean {

        private String ResultCode;
        private String Message;
        private CinemaBean Cinema;

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

        public CinemaBean getCinema() {
            return Cinema;
        }

        public void setCinema(CinemaBean cinema) {
            Cinema = cinema;
        }

        public static class CinemaBean{
        	private String CinemaCode;
        	private String CinemaName;
            private String Address;
            private String ScreenCount;
            private ScreensBean Screens;

            public String getCinemaCode() {
				return CinemaCode;
			}

			public void setCinemaCode(String cinemaCode) {
				CinemaCode = cinemaCode;
			}

			public String getCinemaName() {
				return CinemaName;
			}

			public void setCinemaName(String cinemaName) {
				CinemaName = cinemaName;
			}

			public String getAddress() {
                return Address;
            }

            public void setAddress(String address) {
                Address = address;
            }

            public String getScreenCount() {
                return ScreenCount;
            }

            public void setScreenCount(String screenCount) {
                ScreenCount = screenCount;
            }

            public ScreensBean getScreens() {
                return Screens;
            }

            public void setScreens(ScreensBean screens) {
                Screens = screens;
            }

            public static class ScreensBean{
                private List<ScreenVOBean> ScreenVO;

                public List<ScreenVOBean> getScreenVO() {
                    return ScreenVO;
                }

                public void setScreenVO(List<ScreenVOBean> screenVO) {
                    ScreenVO = screenVO;
                }
                public static class ScreenVOBean{
                	private String ScreenCode;
                	private String ScreenName;
                	private String SeatCount;
                	private String Type;
					public String getScreenCode() {
						return ScreenCode;
					}
					public void setScreenCode(String screenCode) {
						ScreenCode = screenCode;
					}
					public String getScreenName() {
						return ScreenName;
					}
					public void setScreenName(String screenName) {
						ScreenName = screenName;
					}
					public String getSeatCount() {
						return SeatCount;
					}
					public void setSeatCount(String seatCount) {
						SeatCount = seatCount;
					}
					public String getType() {
						return Type;
					}
					public void setType(String type) {
						Type = type;
					}
                }
            }
        }
    }
}
