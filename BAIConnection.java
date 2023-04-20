package com.eaiesb.boomi;

import com.boomi.connector.api.BrowseContext;
import com.boomi.connector.util.BaseConnection;

public class BAIConnection extends BaseConnection {
	
	private static final String BAI_HOST = "BAIhost";
	private static final String BAI_PORT = "BAIport";
	private static final String BAI_PATH = "BAIpath";
	public static String _baihost;
	public static String _baiport;
	public static String _baipath;
	
	public BAIConnection(BrowseContext context) {
		super(context);
		set_baihost(context.getConnectionProperties().getProperty(BAI_HOST));
		set_baiport(context.getConnectionProperties().getProperty(BAI_PORT));
		set_baipath(context.getConnectionProperties().getProperty(BAI_PATH));
	}
	
	public static String get_baihost() {
		return _baihost;
	}
	
	public static void set_baihost(String _baihost) {
		BAIConnection._baihost = _baihost;
		
	}
	
	public static String get_baiport() {
		return _baiport;
	}
	
	public static void set_baiport(String _baiport) {
		BAIConnection._baiport = _baiport;
	}
	
	public static String get_baipath() {
		return _baipath;
	}
	
	public static void set_baipath(String _baipath) {
		BAIConnection._baipath = _baipath;
	}
	
}
