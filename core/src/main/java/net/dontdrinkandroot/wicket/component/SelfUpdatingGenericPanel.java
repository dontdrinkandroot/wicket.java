package net.dontdrinkandroot.wicket.component;

import org.apache.wicket.ajax.AjaxSelfUpdatingTimerBehavior;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.util.time.Duration;


public class SelfUpdatingGenericPanel<T> extends GenericPanel<T> {

	private static final long serialVersionUID = 1L;


	public SelfUpdatingGenericPanel(final String id, Duration updateInterval) {

		super(id);
		this.setOutputMarkupId(true);

		this.add(new AjaxSelfUpdatingTimerBehavior(updateInterval));
	}


	public SelfUpdatingGenericPanel(final String id, final IModel<T> model, Duration updateInterval) {

		super(id, model);
		this.setOutputMarkupId(true);

		this.add(new AjaxSelfUpdatingTimerBehavior(updateInterval));
	}

}
