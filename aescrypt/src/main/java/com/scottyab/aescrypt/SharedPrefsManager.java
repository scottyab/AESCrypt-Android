package com.scottyab.aescrypt;

import android.content.Context;
import android.preference.PreferenceManager;

public class SharedPrefsManager {

	public static void setDefaults(String key, String value, Context context) {
		android.content.SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
		android.content.SharedPreferences.Editor editor = prefs.edit();
		editor.putString(key, value);
		editor.apply();
	}

	public static String getDefaults(String key, Context context) {
		android.content.SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
		return preferences.getString(key, null);
	}

}
