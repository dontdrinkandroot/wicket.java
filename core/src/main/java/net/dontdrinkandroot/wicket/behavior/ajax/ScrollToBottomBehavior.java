package net.dontdrinkandroot.wicket.behavior.ajax;

import org.apache.wicket.Component;
import org.apache.wicket.Page;
import org.apache.wicket.WicketRuntimeException;
import org.apache.wicket.ajax.AbstractDefaultAjaxBehavior;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.OnDomReadyHeaderItem;


//TODO: This works only for pages at the moment
public abstract class ScrollToBottomBehavior extends AbstractDefaultAjaxBehavior {

	private final int offset;


	public ScrollToBottomBehavior(int offset) {

		this.offset = offset;
	}


	@Override
	public void renderHead(Component component, IHeaderResponse response) {

		super.renderHead(component, response);

		String componentSelector;
		if (component instanceof Page) {
			componentSelector = "window";
		} else {
			componentSelector = String.format("'#%s'", component.getMarkupId());
		}

		StringBuffer scriptBuffer = new StringBuffer();
		// scriptBuffer.append(String.format("console.log($(%s));", componentSelector));
		scriptBuffer.append(String.format("$(%s).scroll(function () {", componentSelector));
		// scriptBuffer.append(String.format(
		// "console.log('scrollTop: ' + $(%s).scrollTop(), 'documentHeight: ' + $(document).height(), 'windowHeight: ' + $(%s).height());",
		// componentSelector,
		// componentSelector));
		scriptBuffer.append(String.format(
				"if ($(%s).scrollTop() >= $(document).height() - $(%s).height() - %d) {",
				componentSelector,
				componentSelector,
				this.offset));
		scriptBuffer.append(this.getCallbackScript());
		scriptBuffer.append("}");
		scriptBuffer.append("});");

		response.render(new OnDomReadyHeaderItem(scriptBuffer));
	}


	@Override
	public void onConfigure(Component component) {

		super.onConfigure(component);

		if (!(component instanceof Page)) {
			throw new WicketRuntimeException("Behavior can only be bound to a Page");
		}
	}
}
