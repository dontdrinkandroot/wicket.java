package net.dontdrinkandroot.wicketexample.web.model.entity;

import net.dontdrinkandroot.wicket.model.AbstractInjectedLoadableDetachableModel;
import net.dontdrinkandroot.wicketexample.dao.TestEntityDao;
import net.dontdrinkandroot.wicketexample.entity.TestEntity;

import org.apache.wicket.spring.injection.annot.SpringBean;


public class TestEntityLoadableDetachableModel extends AbstractInjectedLoadableDetachableModel<TestEntity> {

	@SpringBean
	private TestEntityDao testEntityDao;

	private final Long id;


	public TestEntityLoadableDetachableModel(TestEntity testEntity) {

		super(testEntity);
		this.id = testEntity.getId();
	}


	@Override
	protected TestEntity load() {

		return this.testEntityDao.find(this.id);
	}


	@Override
	public int hashCode() {

		final int prime = 31;
		int result = 1;
		result = prime * result + (this.id == null ? 0 : this.id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		TestEntityLoadableDetachableModel other = (TestEntityLoadableDetachableModel) obj;
		if (this.id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!this.id.equals(other.id)) {
			return false;
		}
		return true;
	}

}
