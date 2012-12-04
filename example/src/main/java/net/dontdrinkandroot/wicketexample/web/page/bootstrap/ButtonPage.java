package net.dontdrinkandroot.wicketexample.web.page.bootstrap;

import net.dontdrinkandroot.wicket.bootstrap.behavior.css.BlockLevelBehavior;
import net.dontdrinkandroot.wicket.bootstrap.component.button.AjaxButtonLink;
import net.dontdrinkandroot.wicket.bootstrap.component.button.ButtonGroup;
import net.dontdrinkandroot.wicket.bootstrap.component.button.ButtonLink;
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonSize;
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonStyle;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;


public class ButtonPage extends AbstractBootstrapPage<Void> {

	public ButtonPage(PageParameters parameters) {

		super(parameters);
	}


	@Override
	protected void onInitialize() {

		super.onInitialize();

		this.add(new ButtonLink<Void>("defaultButton", null, new Model<String>("defaultButton")) {

			@Override
			public void onClick() {

				this.debug("defaultButton Clicked");
			}
		}.add(new BlockLevelBehavior()));
		this.add(new ButtonLink<Void>("primaryButton", null, new Model<String>("primaryButton")) {

			@Override
			public void onClick() {

				this.debug("primaryButton Clicked");
			}
		}.setButtonStyle(ButtonStyle.PRIMARY).add(new BlockLevelBehavior()));
		this.add(new ButtonLink<Void>("infoButton", null, new Model<String>("infoButton")) {

			@Override
			public void onClick() {

				this.info("infoButton Clicked");
			}
		}.setButtonStyle(ButtonStyle.INFO).add(new BlockLevelBehavior()));
		this.add(new ButtonLink<Void>("successButton", null, new Model<String>("successButton")) {

			@Override
			public void onClick() {

				this.success("successButton Clicked");
			}
		}.setButtonStyle(ButtonStyle.SUCCESS).add(new BlockLevelBehavior()));
		this.add(new ButtonLink<Void>("warningButton", null, new Model<String>("warningButton")) {

			@Override
			public void onClick() {

				this.success("warningButton Clicked");
			}
		}.setButtonStyle(ButtonStyle.WARNING).add(new BlockLevelBehavior()));
		this.add(new ButtonLink<Void>("dangerButton", null, new Model<String>("dangerButton")) {

			@Override
			public void onClick() {

				this.debug("dangerButton Clicked");
			}
		}.setButtonStyle(ButtonStyle.DANGER).add(new BlockLevelBehavior()));
		this.add(new ButtonLink<Void>("inverseButton", null, new Model<String>("inverseButton")) {

			@Override
			public void onClick() {

				this.debug("inverseButton Clicked");
			}
		}.setButtonStyle(ButtonStyle.INVERSE).add(new BlockLevelBehavior()));
		this.add(new ButtonLink<Void>("linkButton", null, new Model<String>("linkButton")) {

			@Override
			public void onClick() {

				this.debug("linkButton Clicked");
			}
		}.setButtonStyle(ButtonStyle.LINK).add(new BlockLevelBehavior()));

		this.add(new ButtonLink<Void>("miniButton", null, new Model<String>("miniButton")) {

			@Override
			public void onClick() {

				/* Noop */
			}
		}.setButtonSize(ButtonSize.MINI));
		this.add(new ButtonLink<Void>("smallButton", null, new Model<String>("smallButton")) {

			@Override
			public void onClick() {

				/* Noop */
			}
		}.setButtonSize(ButtonSize.SMALL));
		this.add(new ButtonLink<Void>("normalButton", null, new Model<String>("normalButton")) {

			@Override
			public void onClick() {

				/* Noop */
			}
		});
		this.add(new ButtonLink<Void>("largeButton", null, new Model<String>("largeButton")) {

			@Override
			public void onClick() {

				/* Noop */
			}
		}.setButtonSize(ButtonSize.LARGE));

		this.add(new ButtonLink<Void>("disabledInputButton", null, new Model<String>("disabledInputButton")) {

			@Override
			public void onClick() {

				/* Noop */
			}

		}.setEnabled(false));
		this.add(new ButtonLink<Void>("disabledAButton", null, new Model<String>("disabledAButton")) {

			@Override
			public void onClick() {

				/* Noop */
			}

		}.setEnabled(false));
		this.add(new AjaxButtonLink<Void>("disabledSubmitButton", null, new Model<String>("disabledSubmitButton")) {

			@Override
			public void onClick(AjaxRequestTarget target) {

				/* Noop */
			}

		}.setEnabled(false));

		this.addButtonGroupDemo();
	}


	private void addButtonGroupDemo() {

		ButtonGroup<Void> singleButtonGroup = new ButtonGroup<Void>("singleButtonGroup") {

			@Override
			protected void createButtons(RepeatingView buttonView) {

				buttonView.add(new AjaxButtonLink<Void>(buttonView.newChildId(), null, new Model<String>("Left")) {

					@Override
					public void onClick(AjaxRequestTarget target) {

						this.info("Left clicked");
						target.add(ButtonPage.this.getFeedbackPanel());
					}

				});
				buttonView.add(new AjaxButtonLink<Void>(buttonView.newChildId(), null, new Model<String>("Middle")) {

					@Override
					public void onClick(AjaxRequestTarget target) {

						this.info("Middle clicked");
						target.add(ButtonPage.this.getFeedbackPanel());
					}

				});
				buttonView.add(new AjaxButtonLink<Void>(buttonView.newChildId(), null, new Model<String>("Right")) {

					@Override
					public void onClick(AjaxRequestTarget target) {

						this.info("Right clicked");
						target.add(ButtonPage.this.getFeedbackPanel());
					}

				});
			}

		};
		this.add(singleButtonGroup);

	}


	@Override
	protected IModel<String> getPageTitleModel() {

		return new Model<String>("Button Demo");
	}

}
