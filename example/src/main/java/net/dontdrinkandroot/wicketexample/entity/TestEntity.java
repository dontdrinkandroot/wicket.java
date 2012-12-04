package net.dontdrinkandroot.wicketexample.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import net.dontdrinkandroot.persistence.entity.GeneratedLongIdEntity;


@Entity
public class TestEntity extends GeneratedLongIdEntity {

	@Column
	private Integer integerField;

	@Column
	private String stringField;


	protected TestEntity() {

	}


	public TestEntity(Integer integerField, String stringField) {

		this.integerField = integerField;
		this.stringField = stringField;
	}


	public String getStringField() {

		return this.stringField;
	}


	public Integer getIntegerField() {

		return this.integerField;
	}


	public void setStringField(String stringField) {

		this.stringField = stringField;
	}


	public void setIntegerField(Integer integerField) {

		this.integerField = integerField;
	}

}
