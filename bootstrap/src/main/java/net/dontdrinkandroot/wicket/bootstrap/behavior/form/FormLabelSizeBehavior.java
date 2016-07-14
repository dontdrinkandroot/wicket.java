package net.dontdrinkandroot.wicket.bootstrap.behavior.form;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.model.AbstractReadOnlyModel;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.css.CssClass;
import net.dontdrinkandroot.wicket.utils.BehaviorUtils;


public class FormLabelSizeBehavior extends Behavior
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
					if (formStyleBehavior.isHorizontal()) {
						return formStyleBehavior.getLabelSize();
					}
				}

				return null;
			}
		}));
	}

}
