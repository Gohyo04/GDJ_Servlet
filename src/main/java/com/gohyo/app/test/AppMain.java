package com.gohyo.app.test;

import com.gohyo.app.util.DBConnector;

public class AppMain {
	public static void main(String[] args) {
		DBConnector dbc = new DBConnector();
		dbc.getConnector();		
	}
}
