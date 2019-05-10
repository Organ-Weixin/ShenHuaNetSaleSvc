package com.boot.security.server.model;

import java.util.List;

public class CouponsView {
	private Couponsgroup couponsgroup;
	private List<Coupons> coupons;
	public Couponsgroup getCouponsgroup() {
		return couponsgroup;
	}
	public void setCouponsgroup(Couponsgroup couponsgroup) {
		this.couponsgroup = couponsgroup;
	}
	public List<Coupons> getCoupons() {
		return coupons;
	}
	public void setCoupons(List<Coupons> coupons) {
		this.coupons = coupons;
	}
	
}
