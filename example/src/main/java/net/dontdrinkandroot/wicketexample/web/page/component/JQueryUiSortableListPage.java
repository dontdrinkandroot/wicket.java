package net.dontdrinkandroot.wicketexample.web.page.component;

import java.util.ArrayList;
import java.util.List;

import net.dontdrinkandroot.wicket.component.jqueryui.JQueryUiSortableList;
import net.dontdrinkandroot.wicketexample.web.page.DecoratorWidePage;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.util.ListModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;


public class JQueryUiSortableListPage extends DecoratorWidePage<Void> {

	public JQueryUiSortableListPage(PageParameters parameters) {

		super(parameters);
	}


	@Override
	protected void onInitialize() {

		super.onInitialize();

		List<Integer> values = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			values.add(i);
		}

		JQueryUiSortableList<Integer> jQueryUiSortableList =
				new JQueryUiSortableList<Integer>("sortableList", new ListModel<Integer>(values)) {

					@Override
					protected void onPositionChanged(AjaxRequestTarget target, int oldPosition, int newPosition) {

						this.info(String.format("old position: %d, new position: %s", oldPosition, newPosition));
						target.add(JQueryUiSortableListPage.this.getFeedbackPanel());
					}


					@Override
					protected Component createComponent(String id, IModel<Integer> model) {

						return new Label(id, model);
					}
				};
		this.add(jQueryUiSortableList);
	}


	@Override
	public void renderHead(IHeaderResponse response) {

		super.renderHead(response);
	}
}
