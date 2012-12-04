package net.dontdrinkandroot.wicketexample.dao;

import java.util.Random;

import net.dontdrinkandroot.persistence.dao.AbstractJpaDao;
import net.dontdrinkandroot.wicketexample.entity.TestEntity;

import org.springframework.transaction.annotation.Transactional;


public class JpaTestEntityDao extends AbstractJpaDao<TestEntity, Long> implements TestEntityDao {

	public JpaTestEntityDao() {

		super(TestEntity.class);
	}


	@Override
	@Transactional
	public void initTestData() {

		for (int i = 0; i < 10; i++) {

			Integer intField = (int) Math.round(Math.random() * 100000);
			String stringField = this.buildRandomString();

			TestEntity testEntity = new TestEntity(intField, stringField);
			this.save(testEntity);
		}

		this.logger.info("Test Entities generated");
	}


	private String buildRandomString() {

		char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < 20; i++) {
			char c = chars[random.nextInt(chars.length)];
			sb.append(c);
		}
		String output = sb.toString();

		return output;
	}

}
