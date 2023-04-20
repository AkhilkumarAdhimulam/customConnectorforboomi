package com.eaiesb.boomi.operation;

import java.util.ArrayList;
import java.util.List;
import org.joda.time.DateTime;
import org.json.JSONObject;
import com.boomi.connector.api.JsonPayloadUtil;
import com.boomi.connector.api.OperationContext;
import com.boomi.connector.api.Payload;
import com.boomi.connector.api.PropertyMap;
import com.boomi.container.config.ContainerConfig;
import com.boomi.execution.ExecutionManager;
import com.boomi.execution.ExecutionUtil;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
public class BAIExecuteErrorResponse {
	DateTime currentTime;
	
	@JsonProperty("ApplicationName")
	public String _applicationName;
	
	@JsonProperty("ApplicationType")
	public String _applicationType;

	@JsonProperty("AtomName")
	public String _atomName;
	
	@JsonProperty("AtomId")
	public String _atomId;
	
	@JsonProperty("ProcessLocation")
	public String _processLocation;
	
	@JsonProperty("AccountId")
	public String _accountId;
	
	@JsonProperty("LogStatus")
	public String _logStatus;
	
	@JsonProperty("Key1")
	public String _key1;
	
	@JsonProperty("Value1")
	public String _value1;
	
	@JsonProperty("Key2")
	public String _key2;
	
	@JsonProperty("Value2")
	public String _value2;
	
	@JsonProperty("Key3")
	public String _key3;
	
	@JsonProperty("Value3")
	public String _value3;
	
	@JsonProperty("Payload")
	public String _payload;
	
	@JsonProperty("ErrorMessage")
	public String _errorMessage;
	
	@JsonProperty("ErrorName")
	public String _errorName;
	
	@JsonProperty("ErrorCode")
	public String _errorCode;

	@JsonProperty("ErrorTime")
	public String _errorTime;
	
	@JsonProperty("NodeId")
	public String _nodeId;
	
	@JsonProperty("ProcessId")
	public String _processId;
	
	@JsonProperty("ProcessName")
	public String _processName;
	
	@JsonProperty("RootId")
	public String _rootId;
	
	@JsonProperty("ExecutionId")
	public String _executionId;
	
	@JsonProperty("AtomLocation")
	public String _atomLocation;
	
	@JsonProperty("ExecutionTime")
	public String _executionTime;
	
	@JsonProperty("ParentProcessName")
	public String _parentProcessName;
	

	
	private List<Object> jsonArray;
	
	public BAIExecuteErrorResponse(OperationContext context) {
		PropertyMap properties=context.getOperationProperties();
		 currentTime = DateTime.now();
		_applicationType="DellBoomi";
		_applicationName=_processLocation.substring(_processLocation.lastIndexOf("/")+1).toString();
		_key1=(BAIExecuteOperation.getKey1() != null ? BAIExecuteOperation.getKey1() : properties.getProperty("key1"));
		_value1=(BAIExecuteOperation.getValue1() != null ? BAIExecuteOperation.getValue1() : properties.getProperty("value1"));
		_key2=(BAIExecuteOperation.getKey2() != null ? BAIExecuteOperation.getKey2(): properties.getProperty("key2"));
		_value2=(BAIExecuteOperation.getValue2() != null ? BAIExecuteOperation.getValue2() : properties.getProperty("value2"));
		_key3=(BAIExecuteOperation.getKey3() != null ? BAIExecuteOperation.getKey3() : properties.getProperty("key3"));
		_value3=(BAIExecuteOperation.getValue3() != null ? BAIExecuteOperation.getValue3() : properties.getProperty("value3"));
		_payload=(BAIExecuteOperation.getPayload() != null ? BAIExecuteOperation.getPayload().toString() : properties.getProperty("payload"));
		_logStatus="ERRORED";
		_errorMessage=(BAIExecuteOperation.getErrormessage() == null ? properties.getProperty("errormessage") : BAIExecuteOperation.getErrormessage());
		_errorName=(BAIExecuteOperation.getErrorname() == null ? properties.getProperty("errorname") : BAIExecuteOperation.getErrorname());
		_errorCode=(BAIExecuteOperation.getErrorcode() == null ? properties.getProperty("errorcode") : BAIExecuteOperation.getErrorcode());
		_errorTime=(BAIExecuteOperation.getErrortime() == null ? properties.getProperty("errortime") : BAIExecuteOperation.getErrortime());
		_accountId=ExecutionManager.getCurrent().getAccountId().toString();
		_executionId=ExecutionManager.getCurrent().getExecutionId().toString();
		_processLocation=ExecutionManager.getCurrent().getProcessComponent().getFolderId().getName().toString();
		_atomName=ExecutionManager.getCurrent().getContainerConfig().getContainerName().toString();
		_atomId=ContainerConfig.getContainerId();
		_processId=ExecutionManager.getCurrent().getProcessId().toString();
		_processName=ExecutionManager.getCurrent().getProcessName().toString();
		_rootId=ExecutionManager.getCurrent().getTopLevelExecutionId().toString();
		_nodeId=ExecutionUtil.getRuntimeExecutionProperty("NODE_ID") == null ? "Running in local atom" : ExecutionUtil.getRuntimeExecutionProperty("NODE_ID").toString();
		_atomLocation=ExecutionManager.getCurrent().getCurrentDirectory().getPath().toString();
		_executionTime=currentTime.toString();
		_parentProcessName=ExecutionManager.getCurrent().getParent().getName().toString();

		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("ApplicationName", get_applicationName());
		jsonObject.put("ApplicationType", get_applicationType());
		jsonObject.put("AtomName", get_atomName());
		jsonObject.put("AtomId", get_atomId());
		jsonObject.put("ProcessLocation", get_processLocation());
		jsonObject.put("AccountId", get_accountId());
		jsonObject.put("LogStatus", get_logStatus());
		jsonObject.put("Key1", get_key1());
		jsonObject.put("Value1", get_value1());
		jsonObject.put("Key2", get_key2());
		jsonObject.put("Value2", get_value2());
		jsonObject.put("Key3", get_key3());
		jsonObject.put("Value3", get_value3());
		jsonObject.put("Payload", get_payload());
		jsonObject.put("ErrorMessage", get_errorMessage());
		jsonObject.put("ErrorName", get_errorName());
		jsonObject.put("ErrorCode", get_errorCode());
		jsonObject.put("ErrorTime", get_errorTime());
		jsonObject.put("NodeId", get_nodeId());
		jsonObject.put("ProcessId", get_processId());
		jsonObject.put("ProcessName", get_processName());
		jsonObject.put("RootId", get_rootId());
		jsonObject.put("ExecutionId", get_executionId());
		jsonObject.put("AtomLocation", get_atomLocation());
		jsonObject.put("ExecutionTime", get_executionTime());
		jsonObject.put("ParentProcessName", get_parentProcessName());

		jsonArray = new ArrayList<Object>();
		jsonArray.add(jsonObject);
	}

	@JsonIgnore
	public void sendPayloadToBAI(String url) {
		BAIExecuteHttpPost.httpPost(url,jsonArray);
	}
	
	@JsonIgnore
	public  Payload getPayload() {
		return JsonPayloadUtil.toPayload(this);
	}


	@JsonGetter("ApplicationName")
	public String get_applicationName() {
		return _applicationName;
	}

	@JsonGetter("ApplicationType")
	public String get_applicationType() {
		return _applicationType;
	}

	@JsonGetter("AtomName")
	public String get_atomName() {
		return _atomName;
	}

	@JsonGetter("AtomId")
	public String get_atomId() {
		return _atomId;
	}

	@JsonGetter("ProcessLocation")
	public String get_processLocation() {
		return _processLocation;
	}

	@JsonGetter("AccountId")
	public String get_accountId() {
		return _accountId;
	}
	
	@JsonGetter("LogStatus")
	public String get_logStatus() {
		return _logStatus;
	}

	@JsonGetter("Key1")
	public String get_key1() {
		return _key1;
	}

	@JsonGetter("Value1")
	public String get_value1() {
		return _value1;
	}

	@JsonGetter("Key2")
	public String get_key2() {
		return _key2;
	}

	@JsonGetter("Value2")
	public String get_value2() {
		return _value2;
	}

	@JsonGetter("Key3")
	public String get_key3() {
		return _key3;
	}

	@JsonGetter("Value3")
	public String get_value3() {
		return _value3;
	}

	@JsonGetter("Payload")
	public String get_payload() {
		return _payload;
	}

	@JsonGetter("ErrorMessage")
	public String get_errorMessage() {
		return _errorMessage;
	}

	@JsonGetter("ErrorName")
	public String get_errorName() {
		return _errorName;
	}

	@JsonGetter("ErrorCode")
	public String get_errorCode() {
		return _errorCode;
	}

	@JsonGetter("ErrorTime")
	public String get_errorTime() {
		return _errorTime;
	}

	@JsonGetter("NodeId")
	public String get_nodeId() {
		return _nodeId;
	}

	@JsonGetter("ProcessId")
	public String get_processId() {
		return _processId;
	}

	@JsonGetter("ProcessName")
	public String get_processName() {
		return _processName;
	}

	@JsonGetter("RootId")
	public String get_rootId() {
		return _rootId;
	}

	@JsonGetter("ExecutionId")
	public String get_executionId() {
		return _executionId;
	}
	
	@JsonGetter("AtomLocation")
	public String get_atomLocation() {
		return _atomLocation;
	}
	

	@JsonGetter("ExecutionTime")
	public String get_executionTime() {
		return _executionTime;
	}
	
	@JsonGetter("ParentProcessName")
	public String get_parentProcessName() {
		return _parentProcessName;
	}


}