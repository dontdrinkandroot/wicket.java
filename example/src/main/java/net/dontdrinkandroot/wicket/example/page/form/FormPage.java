/*
 * Copyright (C) 2012-2017 Philip Washington Sorst <philip@sorst.net>
 * and individual contributors as indicated
 * by the @authors tag.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.dontdrinkandroot.wicket.example.page.form;

import net.dontdrinkandroot.wicket.bootstrap.behavior.ButtonBehavior;
import net.dontdrinkandroot.wicket.bootstrap.behavior.IconBehavior;
import net.dontdrinkandroot.wicket.bootstrap.component.button.AjaxSubmitButton;
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.*;
import net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.addon.InputGroupLabel;
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonStyle;
import net.dontdrinkandroot.wicket.bootstrap.css.FontAwesomeIconClass;
import net.dontdrinkandroot.wicket.example.page.DecoratorPage;
import net.dontdrinkandroot.wicket.model.ConcatenatingStringModel;
import org.apache.wicket.Component;
import org.apache.wicket.ajax.attributes.ThrottlingSettings;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.time.Duration;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public abstract class FormPage extends DecoratorPage<Void>
{
    public FormPage(PageParameters parameters)
    {
        super(parameters);
    }

    @Override
    protected IModel<String> createPageTitlePrefixModel()
    {
        return new ConcatenatingStringModel(super.createPageTitlePrefixModel(), " - ", Model.of("Forms"));
    }

    protected void populateFormGroups(Form<Void> form, RepeatingView formGroupView)
    {
        List<String> choices = Arrays.asList("Apple", "Banana", "Pear");

        FormGroupStatic formGroupStatic = new FormGroupStatic(
                formGroupView.newChildId(),
                Model.of(FormGroupStatic.class.getSimpleName()),
                Model.of("A static label")
        );
        formGroupView.add(formGroupStatic);

        FormGroupInputText formGroupTextField = new FormGroupInputText(
                formGroupView.newChildId(),
                Model.of(FormGroupInputText.class.getSimpleName()),
                Model.of("")
        );
        formGroupTextField.getFormComponent().setRequired(true);
        formGroupTextField.addAjaxValidation("input", new ThrottlingSettings(Duration.milliseconds(250)));
        formGroupTextField.setHelpText(Model.of("A help text"));
        formGroupView.add(formGroupTextField);

        FormGroupInputPassword formGroupPasswordTextField = new FormGroupInputPassword(
                formGroupView.newChildId(),
                Model.of(FormGroupInputPassword.class.getSimpleName()),
                Model.of("")
        );
        formGroupView.add(formGroupPasswordTextField);

        FormGroupInputEmail formGroupEmailTextField = new FormGroupInputEmail(
                formGroupView.newChildId(),
                Model.of(FormGroupInputEmail.class.getSimpleName()),
                Model.of("")
        );
        formGroupView.add(formGroupEmailTextField);

        FormGroupInputUrl formGroupUrlTextField = new FormGroupInputUrl(
                formGroupView.newChildId(),
                Model.of(FormGroupInputUrl.class.getSimpleName()),
                Model.of("")
        );
        formGroupView.add(formGroupUrlTextField);

        FormGroupTextArea<String> formGroupTextArea = new FormGroupTextArea<String>(
                formGroupView.newChildId(),
                Model.of(FormGroupTextArea.class.getSimpleName()),
                Model.of("")
        );
        formGroupTextArea.setRequired(true);
        formGroupView.add(formGroupTextArea);

        FormGroupLocalDate formGroupLocalDate = new FormGroupLocalDate(
                formGroupView.newChildId(),
                Model.of(FormGroupLocalDate.class.getSimpleName()),
                Model.of(LocalDate.now())
        )
        {
            @Override
            protected Component createInputGroupAddonAfter(String id)
            {
                InputGroupLabel after = new InputGroupLabel(id);
                after.add(new IconBehavior(FontAwesomeIconClass.CALENDAR_O.createIcon()));

                return after;
            }
        };
        formGroupLocalDate.getFormComponent().setMin(LocalDate.now().withMonth(1).withDayOfMonth(1));
        formGroupLocalDate.getFormComponent().setMax(LocalDate.now().withMonth(12).withDayOfMonth(31));
        formGroupView.add(formGroupLocalDate);

        FormGroupLocalTime formGroupLocalTime = new FormGroupLocalTime(
                formGroupView.newChildId(),
                Model.of(FormGroupLocalTime.class.getSimpleName()),
                new Model<>()
        );
        formGroupView.add(formGroupLocalTime);

        FormGroupLocalDateTime formGroupLocalDateTime = new FormGroupLocalDateTime(
                formGroupView.newChildId(),
                Model.of(FormGroupLocalDateTime.class.getSimpleName()),
                new Model<>()
        );
        formGroupView.add(formGroupLocalDateTime);

        FormGroupCheckBox formGroupCheckBox = new FormGroupCheckBox(
                formGroupView.newChildId(),
                Model.of(FormGroupCheckBox.class.getSimpleName()),
                new Model<>()
        );
        formGroupView.add(formGroupCheckBox);

        FormGroupRadioChoice<String> formGroupRadioChoice = new FormGroupRadioChoice<String>(
                formGroupView.newChildId(),
                Model.of(FormGroupRadioChoice.class.getSimpleName()),
                Model.of(""),
                choices
        );
        formGroupView.add(formGroupRadioChoice);

        FormGroupSelect<String> formGroupSelect = new FormGroupSelect<String>(
                formGroupView.newChildId(),
                Model.of(FormGroupSelect.class.getSimpleName()),
                Model.of(""),
                choices
        );
        formGroupSelect.setRequired(false);
        formGroupSelect.setNullValid(true);
        formGroupView.add(formGroupSelect);

        FormGroupInputFile formGroupInputFile =
                new FormGroupInputFile(formGroupView.newChildId(), Model.of(FormGroupInputFile.class.getSimpleName()));
        formGroupView.add(formGroupInputFile);

        FormGroupActions<Void> formGroupActions = new FormGroupActions<Void>(formGroupView.newChildId())
        {
            @Override
            protected void populateActions(RepeatingView actionView)
            {
                AjaxSubmitButton submitButton = new AjaxSubmitButton(actionView.newChildId());
                submitButton.setBody(Model.of("Submit"));
                submitButton.setButtonStyle(ButtonStyle.PRIMARY);
                actionView.add(submitButton);

                Label cancelButton = new Label(actionView.newChildId(), "Cancel");
                cancelButton.add(new ButtonBehavior());
                actionView.add(cancelButton);
            }
        };
        formGroupView.add(formGroupActions);
    }
}
