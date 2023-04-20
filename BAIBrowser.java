package com.eaiesb.boomi;

import java.util.Collection;

import com.boomi.connector.api.ObjectDefinitionRole;
import com.boomi.connector.api.ObjectDefinitions;
import com.boomi.connector.api.ObjectTypes;
import com.boomi.connector.util.BaseBrowser;


public class BAIBrowser extends BaseBrowser{
	protected BAIBrowser(BAIConnection con) {
		super(con);
	}
	@Override
	public ObjectTypes getObjectTypes() {
		//TODO
		return null;
	}
	@Override
	public BAIConnection getConnection() {
		return (BAIConnection) super.getConnection();
	}
	@Override
	public ObjectDefinitions getObjectDefinitions(String objectTypeId, Collection<ObjectDefinitionRole> roles) {
		// TODO Auto-generated method stub
		return null;
	}
}

