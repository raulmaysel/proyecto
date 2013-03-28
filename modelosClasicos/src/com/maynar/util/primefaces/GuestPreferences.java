package com.maynar.util.primefaces;

import java.io.Serializable;
import java.util.Map;

import javax.faces.context.FacesContext;

public class GuestPreferences implements Serializable {

	private static String theme = "aristo"; //default

	public static String getTheme() {
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		if(params.containsKey("theme")) {
			theme = params.get("theme");
		}
		
		return theme;
	}

	public static void setTheme(String Eltheme) {
		theme = Eltheme;
	}
}