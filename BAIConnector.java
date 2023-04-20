package com.eaiesb.boomi;


import com.boomi.connector.api.BrowseContext;
import com.boomi.connector.api.Browser;
import com.boomi.connector.api.Operation;
import com.boomi.connector.api.OperationContext;
import com.boomi.connector.util.BaseConnector;
import com.eaiesb.boomi.operation.BAIExecuteOperation;

public class BAIConnector extends BaseConnector {
public BAIConnector() {
// add data for testing​
}

@Override
public Browser createBrowser(BrowseContext context) {
	return new BAIBrowser(createConnection(context));
}
@Override
protected Operation createExecuteOperation(OperationContext context) {
	return new BAIExecuteOperation(createConnection(context));
}
private BAIConnection createConnection(BrowseContext context) {
	return new BAIConnection(context);
}

}

