package net.dontdrinkandroot.wicketexample.web.model.entity;

import net.dontdrinkandroot.wicket.model.AbstractChainedModel;
import net.dontdrinkandroot.wicketexample.entity.TestEntity;

import org.apache.wicket.model.IModel;


public class TestEntityIdModel extends AbstractChainedModel<TestEntity, Long> {

	public TestEntityIdModel(IModel<? extends TestEntity> parent) {

		super(parent);
	}


	@Override
	public Long getObject() {

		return this.getParentObject().getId();
	}

}
