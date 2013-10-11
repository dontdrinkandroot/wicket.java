package net.dontdrinkandroot.wicket.component.basic;

import java.io.Serializable;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;


public class Heading extends Label {

	public enum Level {
		H1,
		H2,
		H3,
		H4,
		H5,
		H6;
	}


	private final Level level;


	public Heading(final String id, Level level) {

		super(id);
		this.level = level;
	}


	public Heading(final String id, Serializable label, Level level) {

		super(id, Model.of(label));
		this.level = level;
	}


	public Heading(final String id, IModel<?> model, Level level) {

		super(id, model);
		this.level = level;
	}


	public Level getLevel() {

		return this.level;
	}


	@Override
	protected void onComponentTag(ComponentTag tag) {

		tag.setName(this.level.name().toLowerCase());
		super.onComponentTag(tag);
	}

}
