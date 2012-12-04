package net.dontdrinkandroot.wicketexample.dao;

import net.dontdrinkandroot.persistence.dao.Dao;
import net.dontdrinkandroot.wicketexample.entity.TestEntity;


public interface TestEntityDao extends Dao<TestEntity, Long> {

	void initTestData();
}
