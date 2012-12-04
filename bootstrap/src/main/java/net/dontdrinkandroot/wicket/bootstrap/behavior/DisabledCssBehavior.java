package net.dontdrinkandroot.wicket.bootstrap.behavior;

import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.ComponentTag;


public class DisabledCssBehavior extends Behavior {

	@Override
	public void onComponentTag(Component component, ComponentTag tag) {

		super.onComponentTag(component, tag);

		if (!component.isEnabledInHierarchy()) {

			String classAttribute = tag.getAttribute("class");

			if (classAttribute != null) {

				String[] parts = classAttribute.split(" ");
				for (String part : parts) {
					if (part.equalsIgnoreCase(BootstrapCssClass.DISABLED.getClassString())) {
						return;
					}
				}

				classAttribute += " " + BootstrapCssClass.DISABLED.getClassString();
				tag.put("class", classAttribute);

			} else {

				tag.put("class", BootstrapCssClass.DISABLED.getClassString());
			}
		}
	}

}
