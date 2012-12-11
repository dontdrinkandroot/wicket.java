package net.dontdrinkandroot.wicket.bootstrap.component.item;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;

import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.Model;


public class AbstractItem<T> extends GenericPanel<T> {

	public AbstractItem(String id) {

		super(id);
	}


	@Override
	protected void onInitialize() {

		super.onInitialize();

		this.add(new CssClassAppender(new Model<BootstrapCssClass>(BootstrapCssClass.ACTIVE) {

			@Override
			public BootstrapCssClass getObject() {

				if (AbstractItem.this.isActive()) {
					return super.getObject();
				}

				return null;
			}
		}));
	}


	protected boolean isActive() {

		return false;
	}

}
