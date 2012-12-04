package net.dontdrinkandroot.wicket.behavior.ajax;

import org.apache.wicket.ajax.AjaxEventBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;


public abstract class AbstractOnClickBehavior extends AjaxEventBehavior {

	public AbstractOnClickBehavior() {

		super("onclick");
	}

}
