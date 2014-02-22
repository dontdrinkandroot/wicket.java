package net.dontdrinkandroot.wicket.bootstrap.component.form;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.component.feedback.InlineFencedFeedbackPanel;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.string.Strings;


public abstract class AbstractFormGroup<T, F extends FormComponent<T>> extends GenericPanel<T> {

	private final IModel<String> labelModel;

	private F formComponent;

	protected Class<T> type = null;

	private WebMarkupContainer componentContainer;


	public AbstractFormGroup(String id, IModel<T> model, String label) {

		this(id, model, new Model<String>(label));
	}


	public AbstractFormGroup(String id, IModel<T> model, IModel<String> labelModel) {

		this(id, model, labelModel, null);

	}


	public AbstractFormGroup(String id, IModel<T> model, IModel<String> labelModel, Class<T> type) {

		super(id, model);
		this.setOutputMarkupId(true);

		this.labelModel = labelModel;
		this.type = type;
	}


	/**
	 * MUST be called as last method in children constructors.
	 */
	protected void createComponents() {

		this.componentContainer = new WebMarkupContainer("componentContainer");
		this.add(this.componentContainer);

		this.formComponent = this.createFormComponent("formComponent");
		this.formComponent.setOutputMarkupId(true);
		this.formComponent.setLabel(this.labelModel);
		this.componentContainer.add(this.formComponent);
	}


	@Override
	protected void onInitialize() {

		super.onInitialize();

		this.add(new CssClassAppender(BootstrapCssClass.FORM_GROUP));

		Label label = new Label("label", this.labelModel) {

			@Override
			public boolean isVisible() {

				return this.getDefaultModel() != null && !Strings.isEmpty(this.getDefaultModelObjectAsString());
			}
		};
		label.add(new AttributeModifier("for", this.getFormComponent().getMarkupId()));
		this.add(label);

		InlineFencedFeedbackPanel feedback = new InlineFencedFeedbackPanel("feedback", this);
		this.componentContainer.add(feedback);

		this.add(new CssClassAppender(new Model<BootstrapCssClass>(BootstrapCssClass.HAS_ERROR) {

			@Override
			public BootstrapCssClass getObject() {

				if (!AbstractFormGroup.this.getFormComponent().isValid()) {
					return super.getObject();
				}

				return null;
			}
		}));

		Form<?> form = this.getFormComponent().getForm();
		if (form instanceof FormHorizontal) {
			label.add(new CssClassAppender(((FormHorizontal<?>) form).getLabelColumnSize()));
			this.componentContainer.add(new CssClassAppender(((FormHorizontal<?>) form).getFormComponentColumnSize()));
		}
	}


	public F getFormComponent() {

		return this.formComponent;
	}


	public void setRequired(boolean required) {

		this.getFormComponent().setRequired(required);
	}


	protected abstract F createFormComponent(String id);

}
