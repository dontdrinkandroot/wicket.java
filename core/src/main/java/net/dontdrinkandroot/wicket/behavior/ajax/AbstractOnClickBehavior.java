package net.dontdrinkandroot.wicket.behavior.ajax;

import org.apache.wicket.ajax.AjaxEventBehavior;


public abstract class AbstractOnClickBehavior extends AjaxEventBehavior {

	public AbstractOnClickBehavior() {

		super("onclick");
	}

}
