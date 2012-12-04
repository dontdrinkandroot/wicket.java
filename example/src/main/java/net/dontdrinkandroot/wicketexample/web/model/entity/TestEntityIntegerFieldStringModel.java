package net.dontdrinkandroot.wicketexample.web.model.entity;

import net.dontdrinkandroot.wicket.model.AbstractChainedModel;
import net.dontdrinkandroot.wicketexample.entity.TestEntity;

import org.apache.wicket.model.IModel;


public class TestEntityIntegerFieldStringModel extends AbstractChainedModel<TestEntity, String> {

	public TestEntityIntegerFieldStringModel(IModel<? extends TestEntity> parent) {

		super(parent);
	}


	@Override
	public String getObject() {

		return this.getParentObject().getIntegerField().toString();
	}

}
