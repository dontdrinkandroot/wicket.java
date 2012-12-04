package net.dontdrinkandroot.wicket.bootstrap.component.nav;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import net.dontdrinkandroot.wicket.component.TypedPanel;

import org.apache.wicket.model.Model;


public class NavItemPanel<T> extends TypedPanel<T> {

	public NavItemPanel(String id) {

		super(id);
	}


	@Override
	protected void onInitialize() {

		super.onInitialize();

		this.add(new CssClassAppender(new Model<BootstrapCssClass>(BootstrapCssClass.ACTIVE) {

			@Override
			public BootstrapCssClass getObject() {

				if (NavItemPanel.this.isActive()) {
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
