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
package net.dontdrinkandroot.wicket.bootstrap.component.feedback;

import net.dontdrinkandroot.wicket.bootstrap.css.AlertStyle;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import net.dontdrinkandroot.wicket.css.CompositeCssClass;
import net.dontdrinkandroot.wicket.css.CssClass;
import org.apache.wicket.Component;
import org.apache.wicket.feedback.FeedbackMessage;
import org.apache.wicket.markup.html.basic.Label;

import java.io.Serializable;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class FeedbackPanel extends org.apache.wicket.markup.html.panel.FeedbackPanel
{
    public FeedbackPanel(String id)
    {
        super(id);
    }

    @Override
    protected String getCSSClass(FeedbackMessage message)
    {
        return messageToBootstrapAlertCss(message).getClassString();
    }

    @Override
    protected Component newMessageDisplayComponent(String id, FeedbackMessage message)
    {
        Serializable serializable = message.getMessage();
        Label label = new Label(id, serializable == null ? "" : serializable.toString());
        label.setEscapeModelStrings(this.getEscapeModelStrings());
        label.setOutputMarkupId(false);

        return label;
    }

    public static CssClass messageToBootstrapAlertCss(FeedbackMessage message)
    {
        return new CompositeCssClass(
                BootstrapCssClass.ALERT,
                levelToBootstrapAlertStyle(message.getLevel())
        );
    }

    public static CssClass levelToBootstrapAlertStyle(int level)
    {
        switch (level) {

            case FeedbackMessage.WARNING:
            case FeedbackMessage.DEBUG:
                return AlertStyle.WARNING;

            case FeedbackMessage.SUCCESS:
                return AlertStyle.SUCCESS;

            case FeedbackMessage.INFO:
                return AlertStyle.INFO;

            case FeedbackMessage.ERROR:
            case FeedbackMessage.FATAL:
                return AlertStyle.DANGER;
        }

        return null;
    }
}
