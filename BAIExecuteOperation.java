package com.eaiesb.boomi.operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.boomi.connector.api.ObjectData;
import com.boomi.connector.api.OperationResponse;
import com.boomi.connector.api.ResponseUtil;
import com.boomi.connector.api.UpdateRequest;
import com.boomi.connector.util.BaseUpdateOperation;
import com.eaiesb.boomi.BAIConnection;

public class BAIExecuteOperation extends BaseUpdateOperation {
	
	private static final Logger Log = LoggerFactory.getLogger(BAIExecuteOperation.class);
	
	public static String objectType;
	public static String key1;
	public static String value1;
	public static String key2;
	public static String value2;
	public static String key3;
	public static String value3;
	public static String payload;
	public static String errormessage;
	public static String errorname;
	public static String errorcode;
	public static String errortime;
	public static String BaiURL;
	
	public BAIExecuteOperation(BAIConnection conn) {
		super(conn);
	}
	
	@Override
	protected void executeUpdate(UpdateRequest request, OperationResponse response) {
		
		String BAIHost = BAIConnection.get_baihost();
		String BAIPort = BAIConnection.get_baiport();
		String BAIPath = BAIConnection.get_baipath();
		setObjectType(getContext().getCustomOperationType());
		for (ObjectData input : request) {
			setKey1(input.getDynamicProperties().get("key1"));
			setValue1(input.getDynamicProperties().get("value1"));
			setKey2(input.getDynamicProperties().get("key2"));
			setValue2(input.getDynamicProperties().get("value2"));
			setKey3(input.getDynamicProperties().get("key3"));
			setValue3(input.getDynamicProperties().get("value3"));
			setPayload(input.getDynamicProperties().get("payload"));
			setErrormessage(input.getDynamicProperties().get("errormessage"));
			setErrorname(input.getDynamicProperties().get("errorname"));
			setErrorcode(input.getDynamicProperties().get(errorcode));
			setErrortime(input.getDynamicProperties().get(errortime));
			if(objectType.equals("ERRORED")) {
				setObjectType(getContext().getCustomOperationType());
				try {
					BaiURL = BAIHost + ":" + BAIPort +BAIPath;
					Log.info("BAI URL : " + BaiURL);
					BAIExecuteErrorResponse errorResponse = new BAIExecuteErrorResponse(getContext());
					//errorResponse.sendPayloadToBAI(BaiURL);
					ResponseUtil.addSuccess(response, input, "200", errorResponse.getPayload());
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
			else {
				setObjectType(getContext().getCustomOperationType());
				try {
					BaiURL = BAIHost + ":" + BAIPort + BAIPath;
					Log.info("BAI URL : " + BaiURL);
					BAIExecuteAuditResponse auditResponse = new BAIExecuteAuditResponse(getContext());
					//auditResponse.sendPayloadToBAI(BaiURL);
					ResponseUtil.addSuccess(response, input, "200", auditResponse.getPayload());
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}

	public static String getObjectType() {
		return objectType;
	}

	public static void setObjectType(String objectType) {
		BAIExecuteOperation.objectType = objectType;
	}

	public static String getKey1() {
		return key1;
	}

	public static void setKey1(String key1) {
		BAIExecuteOperation.key1 = key1;
	}

	public static String getValue1() {
		return value1;
	}

	public static void setValue1(String value1) {
		BAIExecuteOperation.value1 = value1;
	}

	public static String getKey2() {
		return key2;
	}

	public static void setKey2(String key2) {
		BAIExecuteOperation.key2 = key2;
	}

	public static String getValue2() {
		return value2;
	}

	public static void setValue2(String value2) {
		BAIExecuteOperation.value2 = value2;
	}

	public static String getKey3() {
		return key3;
	}

	public static void setKey3(String key3) {
		BAIExecuteOperation.key3 = key3;
	}

	public static String getValue3() {
		return value3;
	}

	public static void setValue3(String value3) {
		BAIExecuteOperation.value3 = value3;
	}

	public static String getPayload() {
		return payload;
	}

	public static void setPayload(String payload) {
		BAIExecuteOperation.payload = payload;
	}

	public static String getErrormessage() {
		return errormessage;
	}

	public static void setErrormessage(String errormessage) {
		BAIExecuteOperation.errormessage = errormessage;
	}

	public static String getErrorname() {
		return errorname;
	}

	public static void setErrorname(String errorname) {
		BAIExecuteOperation.errorname = errorname;
	}

	public static String getErrorcode() {
		return errorcode;
	}

	public static void setErrorcode(String errorcode) {
		BAIExecuteOperation.errorcode = errorcode;
	}

	public static String getErrortime() {
		return errortime;
	}

	public static void setErrortime(String errortime) {
		BAIExecuteOperation.errortime = errortime;
	}

	public static String getBaiURL() {
		return BaiURL;
	}

	public static void setBaiURL(String baiURL) {
		BaiURL = baiURL;
	}

	@Override
	public BAIConnection getConnection() {
		return (BAIConnection) super.getConnection();
	}
	
	
}
