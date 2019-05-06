package com.boot.security.server.api.ctms.reply;

import java.util.List;


public class MtxGetSPInfosResult {
	//获取影院卖品信息
	private String resultCode;//返回结果号
	private String resultmsg;//返回结果描述
	private List<GetSPInfosBean> spinfos;//卖品
	
	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultmsg() {
		return resultmsg;
	}

	public void setResultmsg(String resultmsg) {
		this.resultmsg = resultmsg;
	}

	public List<GetSPInfosBean> getSpinfos() {
		return spinfos;
	}

	public void setSpinfos(List<GetSPInfosBean> spinfos) {
		this.spinfos = spinfos;
	}

	public static class GetSPInfosBean{
		private String info;//卖品说明
		private String sellprice;//卖品售价
		private String spmemo;//卖品备注
		private String spname;//卖品名称
		private String spno;//卖品编号
		private String sptype;//卖品类型
		private String unitname;//卖品单位
		private List<GetSPInfoBean> components;
		
		public String getInfo() {
			return info;
		}

		public void setInfo(String info) {
			this.info = info;
		}

		public String getSellprice() {
			return sellprice;
		}

		public void setSellprice(String sellprice) {
			this.sellprice = sellprice;
		}

		public String getSpmemo() {
			return spmemo;
		}

		public void setSpmemo(String spmemo) {
			this.spmemo = spmemo;
		}

		public String getSpname() {
			return spname;
		}

		public void setSpname(String spname) {
			this.spname = spname;
		}

		public String getSpno() {
			return spno;
		}

		public void setSpno(String spno) {
			this.spno = spno;
		}

		public String getSptype() {
			return sptype;
		}

		public void setSptype(String sptype) {
			this.sptype = sptype;
		}

		public String getUnitname() {
			return unitname;
		}

		public void setUnitname(String unitname) {
			this.unitname = unitname;
		}

		public List<GetSPInfoBean> getComponents() {
			return components;
		}

		public void setComponents(List<GetSPInfoBean> components) {
			this.components = components;
		}

		public static class GetSPInfoBean{
			private String count;//商品数量（套餐组成）
			private String spname;//商品名称（套餐组成）
			private String spno;//商品编号（套餐组成）
			private String unitname;//商品单位（套餐组成）
			public String getCount() {
				return count;
			}
			public void setCount(String count) {
				this.count = count;
			}
			public String getSpname() {
				return spname;
			}
			public void setSpname(String spname) {
				this.spname = spname;
			}
			public String getSpno() {
				return spno;
			}
			public void setSpno(String spno) {
				this.spno = spno;
			}
			public String getUnitname() {
				return unitname;
			}
			public void setUnitname(String unitname) {
				this.unitname = unitname;
			}
			
		}
	}
	
}
