package net.dontdrinkandroot.wicket.bootstrap.page;

import java.lang.reflect.InvocationTargetException;

import org.apache.wicket.Component;
import org.apache.wicket.WicketRuntimeException;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.event.IEvent;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.string.Strings;

import net.dontdrinkandroot.wicket.bootstrap.component.feedback.FencedFeedbackPanel;
import net.dontdrinkandroot.wicket.bootstrap.component.modal.Modal;
import net.dontdrinkandroot.wicket.bootstrap.component.navbar.NavBar;
import net.dontdrinkandroot.wicket.bootstrap.event.OpenModalRequest;


public abstract class StandardBootstrapPage<T> extends BootstrapPage<T>
{

	private FeedbackPanel feedbackPanel;


	public StandardBootstrapPage()
	{
		super();
	}

	public StandardBootstrapPage(PageParameters parameters)
	{
		super(parameters);
	}

	public StandardBootstrapPage(IModel<T> model)
	{
		super(model);
	}

	@Override
	protected void onInitialize()
	{
		super.onInitialize();

		this.add(this.createModal("modal"));

		Component navBar = this.createNavBar("navBar");
		this.add(navBar);

		Label pageHeading = new Label("pageHeading", this.pageHeadingModel);

		final RepeatingView primaryActionView = new RepeatingView("primaryAction");
		this.populatePrimaryActions(primaryActionView);

		WebMarkupContainer pageHeader = new WebMarkupContainer("pageHeader") {

			@Override
			protected void onConfigure()
			{
				super.onConfigure();
				boolean hasHeading = (null != StandardBootstrapPage.this.pageHeadingModel)
						&& !Strings.isEmpty(StandardBootstrapPage.this.pageHeadingModel.getObject());
				boolean hasPrimaryActions = primaryActionView.size() > 0;
				this.setVisible(hasHeading || hasPrimaryActions);
			}
		};
		this.add(pageHeader);
		pageHeader.add(pageHeading);
		pageHeader.add(primaryActionView);

		this.feedbackPanel = this.createFeedbackPanel("feedback");
		this.feedbackPanel.setOutputMarkupId(true);
		this.add(this.feedbackPanel);
	}

	private Component createModal(String id)
	{
		WebMarkupContainer modalContainer = new WebMarkupContainer(id);
		modalContainer.setOutputMarkupId(true);

		return modalContainer;
	}

	protected FeedbackPanel createFeedbackPanel(String id)
	{
		return new FencedFeedbackPanel(id);
	}

	protected void populatePrimaryActions(RepeatingView primaryActionView)
	{
		/* Overwrite in order to add primary actions */
	}

	protected Component createNavBar(String id)
	{
		NavBar navBar = new NavBar(id) {

			@Override
			protected Component createBrand(String id)
			{
				return StandardBootstrapPage.this.createBrand(id);
			}

			@Override
			protected void populateNavbarLeftItems(RepeatingView navbarLeftItemView)
			{
				StandardBootstrapPage.this.populateNavbarLeftItems(navbarLeftItemView);
			}

			@Override
			protected Component createForm(String id)
			{
				return StandardBootstrapPage.this.createNavBarForm(id);
			}

			@Override
			protected void populateNavbarRightItems(RepeatingView navbarRightItemView)
			{
				StandardBootstrapPage.this.populateNavbarRightItems(navbarRightItemView);
			}
		};
		return navBar;
	}

	protected Component createBrand(String id)
	{
		WebMarkupContainer brandLink = new WebMarkupContainer(id);
		brandLink.setVisible(false);
		return brandLink;
	}

	protected void populateNavbarLeftItems(RepeatingView itemView)
	{
		/* Overwrite to populate navbar items on left side */
	}

	protected Component createNavBarForm(String id)
	{
		WebMarkupContainer navBarForm = new WebMarkupContainer(id);
		navBarForm.setVisible(false);

		return navBarForm;
	}

	protected void populateNavbarRightItems(RepeatingView itemView)
	{
		/* Overwrite to populate navbar items on right side */
	}

	public FeedbackPanel getFeedbackPanel()
	{
		return this.feedbackPanel;
	}

	@Override
	public void onEvent(IEvent<?> event)
	{
		super.onEvent(event);
		if (event.getPayload() instanceof OpenModalRequest<?>) {
			OpenModalRequest<?> openModalRequest = (OpenModalRequest<?>) event.getPayload();
			Class<? extends Modal<?>> modalClass = openModalRequest.getModalClass();
			IModel<?> model = openModalRequest.getModel();
			AjaxRequestTarget target = openModalRequest.getTarget();
			try {
				Modal<?> modal;
				if (null == model) {
					modal = modalClass.getConstructor(String.class).newInstance("modal");
				} else {
					modal = modalClass.getConstructor(String.class, IModel.class).newInstance("modal", model);
				}
				this.replace(modal);
				target.add(modal);
				target.appendJavaScript(modal.getShowScript());
			} catch (InstantiationException e) {
				throw new WicketRuntimeException(e);
			} catch (IllegalAccessException e) {
				throw new WicketRuntimeException(e);
			} catch (IllegalArgumentException e) {
				throw new WicketRuntimeException(e);
			} catch (InvocationTargetException e) {
				throw new WicketRuntimeException(e);
			} catch (NoSuchMethodException e) {
				throw new WicketRuntimeException(e);
			} catch (SecurityException e) {
				throw new WicketRuntimeException(e);
			}
		}
	}
}
