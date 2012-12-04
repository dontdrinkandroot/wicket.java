package net.dontdrinkandroot.wicket.bootstrap.behavior.css;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.request.Response;


public class IconBehavior extends Behavior {

	@Override
	public void beforeRender(Component component) {

		super.beforeRender(component);

		// final Response r = component.getResponse();
		// r.write("<i class=\"icon-user\"></i>");

	}


	@Override
	public void afterRender(Component component) {

		super.afterRender(component);

		// final Response r = component.getResponse();
		// r.write("<i class=\"icon-user\"></i>");
	}


	@Override
	public void onComponentTag(Component component, ComponentTag tag) {

		final Response r = component.getResponse();
		r.write("<i class=\"icon-user\"></i>");
		super.onComponentTag(component, tag);
	}

}
