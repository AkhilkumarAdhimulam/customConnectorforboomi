package com.eaiesb.boomi.operation;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.json.JSONObject;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.boomi.connector.api.OperationContext;
import com.boomi.connector.api.PropertyMap;
import com.boomi.container.config.ContainerConfig;
import com.boomi.execution.ExecutionManager;
import com.boomi.execution.ExecutionUtil;
import com.boomi.connector.api.Payload;
import com.boomi.connector.api.JsonPayloadUtil;

public class BAIExecuteAuditResponse {
	DateTime currentTime;
	
	@JsonProperty("ApplicationName")
	public String _applicationName;
	
	@JsonProperty("ApplicationType")
	public String _applicationType;
	
	@JsonProperty("ProcessLocation")
	public String _processLocation;
	
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
	
	@JsonProperty("AtomName")
	public String _atomName;
	
	@JsonProperty("AtomId")
	public String _atomId;
	
	@JsonProperty("AtomLocation")
	public String _atomLocation;
	
	@JsonProperty("AccountId")
	public String _accountId;
	
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
	
	@JsonProperty("ExecutionTime")
	public String _executionTime;
	
	@JsonProperty("ParentProcessId")
	public String _parentProcessId;
	
	@JsonProperty("ParentProcessName")
	public String _parentProcessName;
	
	@JsonProperty("ParentExecutionId")
	public String _parentExecutionId;
	
	@JsonProperty("CurrentId")
	public String _currentId;
	
	@JsonProperty("StepNumber")
	public int _stepNumber;
	
	@JsonProperty("ContainerId")
	public String _containerId;
	
	

	
	private List<Object> jsonArray;
	
	public BAIExecuteAuditResponse(OperationContext context) {
		PropertyMap properties=context.getOperationProperties();
		currentTime = DateTime.now();
		_processLocation=ExecutionManager.getCurrent().getProcessComponent().getFolderId().getName().toString();
		_applicationName=_processLocation.substring(_processLocation.lastIndexOf("/")+1).toString();
		_atomName=ExecutionManager.getCurrent().getContainerConfig().getContainerName().toString();
		_atomId=ContainerConfig.getContainerId();
		_accountId=ExecutionManager.getCurrent().getAccountId().toString();
		_applicationType="DellBoomi";
		_logStatus=BAIExecuteOperation.getObjectType();
		_key1=(BAIExecuteOperation.getKey1() != null ? BAIExecuteOperation.getKey1().toString() : properties.getProperty("key1").toString());
		_value1=(BAIExecuteOperation.getValue1() != null ? BAIExecuteOperation.getValue1().toString() : properties.getProperty("value1").toString());
		_key2=(BAIExecuteOperation.getKey2() != null ? BAIExecuteOperation.getKey2().toString(): properties.getProperty("key2").toString());
		_value2=(BAIExecuteOperation.getValue2() != null ? BAIExecuteOperation.getValue2().toString() : properties.getProperty("value2").toString());
		_key3=(BAIExecuteOperation.getKey3() != null ? BAIExecuteOperation.getKey3().toString() : properties.getProperty("key3").toString());
		_value3=(BAIExecuteOperation.getValue3() != null ? BAIExecuteOperation.getValue3().toString() : properties.getProperty("value3").toString());
		_payload=(BAIExecuteOperation.getPayload() != null ? BAIExecuteOperation.getPayload().toString() : properties.getProperty("payload").toString());
		_nodeId=ExecutionUtil.getRuntimeExecutionProperty("NODE_ID") == null ? "Running in local atom" : ExecutionUtil.getRuntimeExecutionProperty("NODE_ID").toString();
		_processId=ExecutionManager.getCurrent().getProcessId().toString();
		_processName=ExecutionManager.getCurrent().getProcessName().toString();
		_rootId=ExecutionManager.getCurrent().getTopLevelExecutionId().toString();
		_executionId=ExecutionManager.getCurrent().getExecutionId().toString();
		_atomLocation=ExecutionManager.getCurrent().getCurrentDirectory().getPath().toString();
		_executionTime=currentTime.toString();
		if(ExecutionManager.getCurrent().isNested()) {
			_parentProcessId=ExecutionManager.getCurrent().getParent().getProcessId().toString();
			_parentProcessName=ExecutionManager.getCurrent().getParent().getName().toString();
			_parentExecutionId=ExecutionManager.getCurrent().getParent().getExecutionId().toString();
		}
		else {
			_parentProcessId=_processId;
			_parentProcessName=_processName;
			_parentExecutionId=_executionId;
		}
		_currentId= _processId;
		_stepNumber=ExecutionManager.getCurrent().getCurrentStepNumber();
		_containerId=ExecutionUtil.getContainerId().toString();
		
		JSONObject jsonObject = new JSONObject();
		
		jsonObject.put("ApplicationName", get_applicationName());
		jsonObject.put("ProcessLocation", get_processLocation());
		jsonObject.put("ApplicationType", get_applicationType());
		jsonObject.put("AtomName", get_atomName());
		jsonObject.put("AtomId", get_atomId());
		jsonObject.put("AccountId", get_accountId());
		jsonObject.put("LogStatus", get_logStatus());
		jsonObject.put("Key1", get_key1());
		jsonObject.put("Value1", get_value1());
		jsonObject.put("Key2", get_key2());
		jsonObject.put("Value2", get_value2());
		jsonObject.put("Key3", get_key3());
		jsonObject.put("Value3", get_value3());
		jsonObject.put("Payload", get_payload());
		jsonObject.put("NodeId", get_nodeId());
		jsonObject.put("ProcessId", get_processId());
		jsonObject.put("ProcessName", get_processName());
		jsonObject.put("RootId", get_rootId());
		jsonObject.put("ExecutionId", get_executionId());
		jsonObject.put("AtomLocation", get_atomLocation());
		jsonObject.put("ExecutionTime", get_executionTime());
		jsonObject.put("ParentProcessId", get_parentProcessId());
		jsonObject.put("ParentProcessName", get_parentProcessName());
		jsonObject.put("ParentExecutionId", get_parentExecutionId());
		jsonObject.put("CurrentId", get_currentId());
		jsonObject.put("StepNumber", get_stepNumber());
		jsonObject.put("ContainerId", get_containerId());
		
		
		jsonArray = new ArrayList<Object>();
		jsonArray.add(jsonObject);
	}
	
	
	@JsonIgnore
	public  Payload getPayload() {
		return JsonPayloadUtil.toPayload(this);
	}
	
	@JsonGetter("ApplicationName")
	public String get_applicationName() {
		return _applicationName;
	}

	@JsonGetter("ProcessLocation")
	public String get_processLocation() {
		return _processLocation;
	}

	@JsonGetter("ApplicationType")
	public String get_applicationType() {
		return _applicationType;
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
	
	@JsonGetter("AccountId")
	public String get_accountId() {
		return _accountId;
	}

	@JsonGetter("Payload")
	public String get_payload() {
		return _payload;
	}
	
	@JsonGetter("AtomName")
	public String get_atomName() {
		return _atomName;
	}

	
	@JsonGetter("AtomId")
	public String get_atomId() {
		return _atomId;
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
	
	@JsonGetter("ParentProcessId")
	public String get_parentProcessId() {
		return _parentProcessId;
	}


	@JsonGetter("ParentProcessName")
	public String get_parentProcessName() {
		return _parentProcessName;
	}



	@JsonGetter("ParentExecutionId")
	public String get_parentExecutionId() {
		return _parentExecutionId;
	}


	@JsonGetter("CurrentId")
	public String get_currentId() {
		return _currentId;
	}


	@JsonGetter("StepNumber")
	public int get_stepNumber() {
		return _stepNumber;
	}


	@JsonGetter("ContainerId")
	public String get_containerId() {
		return _containerId;
	}





//	public List<Object> getJsonArray() {
//		return jsonArray;
//	}
//
//	public void setJsonArray(List<Object> jsonArray) {
//		this.jsonArray = jsonArray;
//	}
	
	
	
}
