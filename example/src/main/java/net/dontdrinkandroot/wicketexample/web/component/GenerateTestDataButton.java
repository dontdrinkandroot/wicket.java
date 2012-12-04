package net.dontdrinkandroot.wicketexample.web.component;

import net.dontdrinkandroot.wicket.bootstrap.component.button.ButtonLink;
import net.dontdrinkandroot.wicketexample.dao.TestEntityDao;

import org.apache.wicket.spring.injection.annot.SpringBean;


public class GenerateTestDataButton extends ButtonLink<Void> {

	@SpringBean
	private TestEntityDao testEntityDao;


	public GenerateTestDataButton(String id) {

		super(id);
	}


	@Override
	public void onClick() {

		this.testEntityDao.initTestData();
	}

}
