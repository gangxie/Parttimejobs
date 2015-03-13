package com.baiyi.parttimejobs.fragment;

import android.support.v4.app.Fragment;

public class FragmentFactory {
	public static Fragment getInstanceByIndex(int index) {
		Fragment fragment = null;
		switch (index) {
		case 1:
			fragment = new UserHomeFragment();
			break;
		default:
			fragment = new FuJinFragment();
			break;

		}
		return fragment;
	}
}