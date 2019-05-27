package com.boot.security.server.model;

import java.util.List;

public class CouponsView {
	private Coupons coupons;
	private Couponsgroup couponsgroup;
	public Coupons getCoupons() {
		return coupons;
	}
	public void setCoupons(Coupons coupons) {
		this.coupons = coupons;
	}
	public Couponsgroup getCouponsgroup() {
		return couponsgroup;
	}
	public void setCouponsgroup(Couponsgroup couponsgroup) {
		this.couponsgroup = couponsgroup;
	}
}
