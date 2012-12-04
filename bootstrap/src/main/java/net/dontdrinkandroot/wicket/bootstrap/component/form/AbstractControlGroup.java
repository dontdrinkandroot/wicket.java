package net.dontdrinkandroot.wicket.bootstrap.component.form;

import java.io.Serializable;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.feedback.FeedbackMessage;
import org.apache.wicket.feedback.FeedbackMessages;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;


public abstract class AbstractControlGroup<T, F extends FormComponent<T>> extends GenericPanel<T> {

	private final IModel<String> labelModel;

	private Label help;

	private final F formComponent;


	public AbstractControlGroup(String id, IModel<T> model, String label) {

		this(id, model, new Model<String>(label));
	}


	public AbstractControlGroup(String id, IModel<T> model, IModel<String> labelModel) {

		super(id, model);
		this.labelModel = labelModel;

		this.setOutputMarkupId(true);
		this.add(new CssClassAppender(BootstrapCssClass.CONTROL_GROUP));

		this.formComponent = this.createFormComponent("formComponent");
		this.formComponent.setOutputMarkupId(true);
		this.formComponent.setLabel(this.labelModel);
		this.add(this.formComponent);
	}


	@Override
	protected void onInitialize() {

		super.onInitialize();

		Label label = new Label("label", this.labelModel);
		label.add(new AttributeModifier("for", this.getFormComponent().getMarkupId()));
		this.add(label);

		this.help = new Label("help", new AbstractReadOnlyModel<Serializable>() {

			@Override
			public Serializable getObject() {

				if (AbstractControlGroup.this.getFormComponent().hasErrorMessage()) {

					StringBuffer messageBuffer = new StringBuffer();
					FeedbackMessages feedbackMessages =
							AbstractControlGroup.this.getFormComponent().getFeedbackMessages();
					for (FeedbackMessage feedbackMessage : feedbackMessages) {
						if (feedbackMessage.isError()) {
							feedbackMessage.markRendered();
							messageBuffer.append(feedbackMessage.getMessage().toString());
						}
					}

					return messageBuffer.toString();
				}

				return null;
			}

		});
		this.add(this.help);

		this.add(new CssClassAppender(new Model<BootstrapCssClass>(BootstrapCssClass.ERROR) {

			@Override
			public BootstrapCssClass getObject() {

				if (!AbstractControlGroup.this.getFormComponent().isValid()) {
					return super.getObject();
				}

				return null;
			}
		}));
	}


	public F getFormComponent() {

		return this.formComponent;
	}


	public void setRequired(boolean required) {

		this.getFormComponent().setRequired(required);
	}


	protected abstract F createFormComponent(String id);

}
