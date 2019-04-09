package com.boot.security.server.api.ctms.reply;

import java.util.List;

public class CxQueryCinemaListResult {

    /**
     * res : {"status":1,"errorMessage":null,"errorCode":null,"data":[{"cinemaId":"11","cinemaName":"测试-81","validPeriod":"2022-04-18","cinemaNumber":"10088888"},{"cinemaId":"31","cinemaName":"电商平台测试影院电商平台测试影院电商平台测试影院172.16.9.87","validPeriod":"2022-04-18","cinemaNumber":"11088777"}]}
     * RES:{"Cinemas":[{"Cinema":[{"CinemaCode":"62549174"},{"CinemaName":"130影院"},{"Province":"广东省"},{"City":"广州市"},{"CreateDate":"2015-03-19"},{"PriceType":"0"}]}]
     * ,"Message":"成功","ResultCode":"0"}
     */
    private ResBean QueryCinemaListResult;

    public ResBean getQueryCinemaListResult() {
        return QueryCinemaListResult;
    }

    public void setQueryCinemaListResult(ResBean queryCinemaListResult) {
        QueryCinemaListResult = queryCinemaListResult;
    }

    public static class ResBean {

        private String ResultCode;
        private String Message;
        private CinemasBean Cinemas;

        public CinemasBean getCinemas() {
            return Cinemas;
        }

        public void setCinemas(CinemasBean cinemas) {
            Cinemas = cinemas;
        }

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

        public static class CinemasBean{
            private List<CinemaBean> Cinema;

            public List<CinemaBean> getCinema() {
                return Cinema;
            }

            public void setCinema(List<CinemaBean> cinema) {
                Cinema = cinema;
            }
            public static class CinemaBean{
            	private String CinemaCode;
            	private String CinemaName;
            	private String Province;
            	private String City;
            	private String CreateDate;
            	private String PriceType;
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
				public String getProvince() {
					return Province;
				}
				public void setProvince(String province) {
					Province = province;
				}
				public String getCity() {
					return City;
				}
				public void setCity(String city) {
					City = city;
				}
				public String getCreateDate() {
					return CreateDate;
				}
				public void setCreateDate(String createDate) {
					CreateDate = createDate;
				}
				public String getPriceType() {
					return PriceType;
				}
				public void setPriceType(String priceType) {
					PriceType = priceType;
				}
            }
        }
    }
}
