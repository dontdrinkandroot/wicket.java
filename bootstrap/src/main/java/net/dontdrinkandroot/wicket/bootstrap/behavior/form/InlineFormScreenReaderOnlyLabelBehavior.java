package net.dontdrinkandroot.wicket.bootstrap.behavior.form;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.model.AbstractReadOnlyModel;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import net.dontdrinkandroot.wicket.css.CssClass;
import net.dontdrinkandroot.wicket.utils.BehaviorUtils;


public class InlineFormScreenReaderOnlyLabelBehavior extends Behavior
{

	@Override
	public void bind(final Component component)
	{
		super.bind(component);

		component.add(new CssClassAppender(new AbstractReadOnlyModel<CssClass>() {

			@Override
			public CssClass getObject()
			{
				FormStyleBehavior formStyleBehavior =
						BehaviorUtils.findClosestBehavior(component, FormStyleBehavior.class);
				if (null != formStyleBehavior) {
					if (formStyleBehavior.isInline()) {
						return BootstrapCssClass.SR_ONLY;
					}
				}

				return null;
			}
		}));
	}

}
