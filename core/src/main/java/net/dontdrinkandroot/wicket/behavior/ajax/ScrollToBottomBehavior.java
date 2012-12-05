package net.dontdrinkandroot.wicket.behavior.ajax;

import org.apache.wicket.Component;
import org.apache.wicket.Page;
import org.apache.wicket.WicketRuntimeException;
import org.apache.wicket.ajax.AbstractDefaultAjaxBehavior;
import org.apache.wicket.ajax.attributes.AjaxCallListener;
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;


//TODO: This works only for pages at the moment
public abstract class ScrollToBottomBehavior extends AbstractDefaultAjaxBehavior {

	private final int offset;

	private static final String ACTIVE_PREFIX = "scollToBottomActive";


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
		scriptBuffer.append(String.format("var %s = true;", this.getActiveVarName(component)));
		scriptBuffer.append(String.format("$(%s).scroll(function () {", componentSelector));
		scriptBuffer.append(String.format(
				"if (%s && $(%s).scrollTop() >= $(document).height() - $(%s).height() - %d) {",
				this.getActiveVarName(component),
				componentSelector,
				componentSelector,
				this.offset));
		scriptBuffer.append(String.format("%s = false;", this.getActiveVarName(component)));
		scriptBuffer.append(this.getCallbackScript());
		scriptBuffer.append("}");
		scriptBuffer.append("});");

		response.render(JavaScriptHeaderItem.forScript(scriptBuffer, "scrollToBottom"));
	}


	@Override
	protected void updateAjaxAttributes(AjaxRequestAttributes attributes) {

		super.updateAjaxAttributes(attributes);
		attributes.getAjaxCallListeners().add(new AjaxCallListener() {

			@Override
			public CharSequence getSuccessHandler(Component component) {

				return String.format(
						"%s = true;",
						ScrollToBottomBehavior.this.getActiveVarName(ScrollToBottomBehavior.this.getComponent()));
			}
		});
	}


	private String getActiveVarName(Component component) {

		return ScrollToBottomBehavior.ACTIVE_PREFIX + "_" + component.getPath();
	}


	@Override
	public void onConfigure(Component component) {

		super.onConfigure(component);

		if (!(component instanceof Page)) {
			throw new WicketRuntimeException("Behavior can only be bound to a Page");
		}
	}
}
