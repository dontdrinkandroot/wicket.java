package net.dontdrinkandroot.wicket.bootstrap.component.item;

import net.dontdrinkandroot.wicket.bootstrap.behavior.IconBehavior;
import net.dontdrinkandroot.wicket.bootstrap.css.InvertibleIconClass;

import org.apache.wicket.Component;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;


public abstract class AbstractLinkItem extends AbstractItem<String> {

	private IModel<InvertibleIconClass> beforeIconModel;

	private IModel<InvertibleIconClass> afterIconModel;


	public AbstractLinkItem(String id, IModel<String> labelModel) {

		super(id, labelModel);
	}


	public AbstractLinkItem(String id, String label) {

		super(id, Model.of(label));
	}


	public AbstractLinkItem setBeforeIcon(InvertibleIconClass beforeIcon) {

		if (beforeIcon == null) {
			this.beforeIconModel = null;
		} else {
			this.beforeIconModel = Model.of(beforeIcon);
		}

		return this;
	}


	public AbstractLinkItem setAfterIcon(InvertibleIconClass afterIcon) {

		if (afterIcon == null) {
			this.afterIconModel = null;
		} else {
			this.afterIconModel = Model.of(afterIcon);
		}

		return this;
	}


	public IModel<InvertibleIconClass> getBeforeIconModel() {

		return this.beforeIconModel;
	}


	public IModel<InvertibleIconClass> getAfterIconModel() {

		return this.afterIconModel;
	}


	@Override
	protected void onInitialize() {

		super.onInitialize();

		Component link = this.createLink("link");
		link.add(new IconBehavior() {

			@Override
			public IModel<InvertibleIconClass> getBeforeIconModel() {

				return AbstractLinkItem.this.getBeforeIconModel();
			};


			@Override
			public IModel<InvertibleIconClass> getAfterIconModel() {

				return AbstractLinkItem.this.getAfterIconModel();
			};
		});
		this.add(link);
	}


	protected abstract Component createLink(String id);
}
