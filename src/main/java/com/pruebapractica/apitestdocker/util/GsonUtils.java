package com.pruebapractica.apitestdocker.util;

import com.google.gson.Gson;

public class GsonUtils {
	
	public static String serializae(Object src) {
		Gson gson = new Gson();
		return gson.toJson(src);
	}
	
	public static <D> D toObject(String json, Class<D> dClasss) {
		Gson gson = new Gson();
		return gson.fromJson(json, dClasss);
	}
	
	public static <D> D Object(String src, Class<D> dClasss) {
		Gson gson = new Gson();
		String srcJson = gson.toJson(src);
		return gson.fromJson(srcJson, dClasss);
	}

}
