package net.dontdrinkandroot.wicket.bootstrap.component.item;

import net.dontdrinkandroot.wicket.bootstrap.behavior.IconBehavior;
import net.dontdrinkandroot.wicket.css.CssClass;

import org.apache.wicket.Component;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;


public abstract class AbstractLinkItem extends AbstractItem<String> {

	private IModel<CssClass> beforeIconModel;

	private IModel<CssClass> afterIconModel;


	public AbstractLinkItem(String id, IModel<String> labelModel) {

		super(id, labelModel);
	}


	public AbstractLinkItem(String id, String label) {

		super(id, Model.of(label));
	}


	public AbstractLinkItem setBeforeIcon(CssClass beforeIcon) {

		if (beforeIcon == null) {
			this.beforeIconModel = null;
		} else {
			this.beforeIconModel = Model.of(beforeIcon);
		}

		return this;
	}


	public AbstractLinkItem setAfterIcon(CssClass afterIcon) {

		if (afterIcon == null) {
			this.afterIconModel = null;
		} else {
			this.afterIconModel = Model.of(afterIcon);
		}

		return this;
	}


	public IModel<CssClass> getBeforeIconModel() {

		return this.beforeIconModel;
	}


	public IModel<CssClass> getAfterIconModel() {

		return this.afterIconModel;
	}


	@Override
	protected void onInitialize() {

		super.onInitialize();

		Component link = this.createLink("link");
		link.add(new IconBehavior() {

			@Override
			public IModel<CssClass> getPrependIconModel() {

				return AbstractLinkItem.this.getBeforeIconModel();
			};


			@Override
			public IModel<CssClass> getAppendIconModel() {

				return AbstractLinkItem.this.getAfterIconModel();
			};
		});
		this.add(link);
	}


	protected abstract Component createLink(String id);
}
