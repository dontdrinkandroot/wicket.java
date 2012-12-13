package net.dontdrinkandroot.wicket.bootstrap.component.item;

import net.dontdrinkandroot.wicket.bootstrap.behavior.IconBehavior;
import net.dontdrinkandroot.wicket.bootstrap.css.IconClass;

import org.apache.wicket.Component;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;


public abstract class AbstractLinkItem extends AbstractItem<String> {

	private IModel<IconClass> beforeIconModel;

	private boolean beforeIconInverted = false;

	private IModel<IconClass> afterIconModel;

	private boolean afterIconInverted = false;


	public AbstractLinkItem(String id, IModel<String> labelModel) {

		super(id, labelModel);
	}


	public AbstractLinkItem(String id, String label) {

		super(id, Model.of(label));
	}


	public AbstractLinkItem setBeforeIcon(IconClass beforeIcon, boolean inverted) {

		this.beforeIconModel = Model.of(beforeIcon);
		this.beforeIconInverted = inverted;

		return this;
	}


	public AbstractLinkItem setAfterIcon(IconClass afterIcon, boolean inverted) {

		this.afterIconModel = Model.of(afterIcon);
		this.afterIconInverted = inverted;

		return this;
	}


	public IModel<IconClass> getBeforeIconModel() {

		return this.beforeIconModel;
	}


	public IModel<IconClass> getAfterIconModel() {

		return this.afterIconModel;
	}


	public boolean isBeforeIconInverted() {

		return this.beforeIconInverted;
	}


	public boolean isAfterIconInverted() {

		return this.afterIconInverted;
	}


	@Override
	protected void onInitialize() {

		super.onInitialize();

		Component link = this.createLink("link");
		link.add(new IconBehavior() {

			@Override
			protected IModel<IconClass> getBeforeIconModel() {

				return AbstractLinkItem.this.getBeforeIconModel();
			};


			@Override
			protected IModel<IconClass> getAfterIconModel() {

				return AbstractLinkItem.this.getAfterIconModel();
			};


			@Override
			protected boolean isBeforeIconInverted() {

				return AbstractLinkItem.this.isBeforeIconInverted();
			};


			@Override
			protected boolean isAfterIconInverted() {

				return AbstractLinkItem.this.isAfterIconInverted();
			};
		});
		this.add(link);
	}


	protected abstract Component createLink(String id);
}
