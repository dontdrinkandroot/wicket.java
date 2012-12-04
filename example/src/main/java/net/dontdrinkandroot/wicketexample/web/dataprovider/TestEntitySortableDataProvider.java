package net.dontdrinkandroot.wicketexample.web.dataprovider;

import java.util.Iterator;
import java.util.List;

import javax.persistence.metamodel.SingularAttribute;

import net.dontdrinkandroot.wicketexample.dao.TestEntityDao;
import net.dontdrinkandroot.wicketexample.entity.TestEntity;
import net.dontdrinkandroot.wicketexample.web.model.entity.TestEntityLoadableDetachableModel;

import org.apache.wicket.extensions.markup.html.repeater.util.SortParam;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;


public class TestEntitySortableDataProvider
		extends SortableDataProvider<TestEntity, SingularAttribute<? super TestEntity, ?>> {

	@SpringBean
	private TestEntityDao testEntityDao;


	public TestEntitySortableDataProvider() {

		SpringComponentInjector.get().inject(this);
	}


	@Override
	public Iterator<? extends TestEntity> iterator(long first, long count) {

		SingularAttribute<? super TestEntity, ?> property = null;
		boolean ascending = true;

		SortParam<SingularAttribute<? super TestEntity, ?>> sort = this.getSort();
		if (sort != null) {
			property = sort.getProperty();
			ascending = sort.isAscending();
		}
		List<TestEntity> result = this.testEntityDao.findSorted(property, ascending, (int) first, (int) count);

		return result.iterator();
	}


	@Override
	public long size() {

		return this.testEntityDao.getCount();
	}


	@Override
	public IModel<TestEntity> model(TestEntity testEntity) {

		return new TestEntityLoadableDetachableModel(testEntity);
	}
}
