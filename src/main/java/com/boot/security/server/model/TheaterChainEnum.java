package com.boot.security.server.model;

public enum TheaterChainEnum {
	WanDa("万达院线",1),
	Dadi("大地院线",2),
	LianHe("上海联和院线",3),
	ZhongYingXingMei("中影星美院线",4),
	XinganXian("中影南方新干线",5),
	ZhongShu("中数院线",6),
	JinYi("金逸珠江院线",7),
	HengDian("横店院线",8),
	Shida("时代院线",9),
	Huaxia("华夏联合院线",10),
	Xinfulanhai("江苏幸福蓝海院线",11),
	Taipingyang("四川太平洋",12),
	Xinyinglian("北京新影联院线",13),
	Wanhe("保利万和院线",14),
	Jingdian("时代华夏今典院线",15),
	Chengtian("深影橙天院线",16),
	Yinxing("湖北银兴院线",17),
	Aosika("河南奥斯卡",18),
	Zhongyingbeifang("辽宁中影北方",19),
	Hongliyu("北京红鲤鱼院线",20),
	Tianhe("武汉天河院线",21),
	Xingguang("浙江星光院线",22),
	Xiaoxiang("湖南潇湘院线",23),
	Daguangming("上海大光明院线",24),
	Zhongxing("福建中兴院线",25),
	Xingshiji("山东新世纪",26),
	Yandang("温州雁荡院线",27),
	Huanqiu("世纪环球院线",28),
	Womei("长城沃美",29),
	Dongfang("江苏东方院线",30),
	Zhongyuan("九州中原",31),
	Zhonglian("河北中联院线",32),
	Xinghe("江西星河院线",33),
	Chuxiang("湖南楚湘院线",34),
	Jiying("吉林吉影院线",35),
	Luxing("鲁信院线",36),
	Xinghuadadi("华夏新华大地院线",37),
	Zhongguang("中广院线",38),
	Ermei("四川峨眉院线",39),
	Xingkong("贵州星空院线",40),
	Huaxiatianshan("新疆华夏天山院线",41),
	Mingzhou("内蒙古民族院线",42),
	Changan("西安长安院线",43),
	Mingxingshida("北京明星时代院线",44),
	Hongge("上海弘歌院线",45),
	Yingguang("天津银光院线",46),
	Xingjiangdianying("新疆电影公司",47),
	Xinghuo("华夏星火院线",48);
	
	private String TheaterChainName;
	private int TheaterChainCode;
	TheaterChainEnum(String TheaterChainName,int TheaterChainCode){
		this.TheaterChainName=TheaterChainName;
		this.TheaterChainCode=TheaterChainCode;
	}
	public String getTheaterChainName() {
		return TheaterChainName;
	}
	public void setTheaterChainName(String theaterChainName) {
		TheaterChainName = theaterChainName;
	}
	public int getTheaterChainCode() {
		return TheaterChainCode;
	}
	public void setTheaterChainCode(int theaterChainCode) {
		TheaterChainCode = theaterChainCode;
	}
	

	
}
