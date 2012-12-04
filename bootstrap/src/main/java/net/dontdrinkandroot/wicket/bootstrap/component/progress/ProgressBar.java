package net.dontdrinkandroot.wicket.bootstrap.component.progress;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import net.dontdrinkandroot.wicket.bootstrap.css.ProgressBarClass;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;


public class ProgressBar extends GenericPanel<Integer> {

	private WebMarkupContainer bar;

	private boolean active = false;

	private ProgressBarClass barStyle = ProgressBarClass.INFO;


	public ProgressBar(String id, IModel<Integer> model) {

		super(id, model);
	}


	public ProgressBar(String id, IModel<Integer> model, ProgressBarClass style, boolean active) {

		super(id, model);
		this.barStyle = style;
		this.active = active;
	}


	@Override
	protected void onInitialize() {

		super.onInitialize();

		this.add(new CssClassAppender(BootstrapCssClass.PROGRESS));

		/* Style */
		this.add(new CssClassAppender(new AbstractReadOnlyModel<ProgressBarClass>() {

			@Override
			public ProgressBarClass getObject() {

				return ProgressBar.this.barStyle;
			}
		}));

		/* Active */
		this.add(new CssClassAppender(new AbstractReadOnlyModel<BootstrapCssClass>() {

			@Override
			public BootstrapCssClass getObject() {

				if (ProgressBar.this.isActive()) {
					return BootstrapCssClass.ACTIVE;
				}

				return null;
			}
		}));

		this.bar = new WebMarkupContainer("bar");
		this.bar.add(new AttributeModifier("style", new AbstractReadOnlyModel<String>() {

			@Override
			public String getObject() {

				return String.format("width: %d%%;", ProgressBar.this.getModelObject());
			}
		}));
		this.bar.setOutputMarkupId(true);
		this.add(this.bar);
	}


	public void setBarStyle(ProgressBarClass barStyle) {

		this.barStyle = barStyle;
	}


	public ProgressBarClass getBarStyle() {

		return this.barStyle;
	}


	public void setActive(boolean active) {

		this.active = active;
	}


	public boolean isActive() {

		return this.active;
	}


	public ProgressBar(String id) {

		this(id, new Model<Integer>(0));
	}


	public void update(AjaxRequestTarget target) {

		target.appendJavaScript(String.format(
				"$('#%s').css({width: '%d%%'});",
				this.bar.getMarkupId(),
				this.getModelObject()));
	}


	public WebMarkupContainer getBar() {

		return this.bar;
	}

}
