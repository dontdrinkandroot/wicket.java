package net.dontdrinkandroot.wicket.bootstrap.component.feedback;

import org.apache.wicket.Component;
import org.apache.wicket.feedback.FeedbackMessage;
import org.apache.wicket.feedback.IFeedbackMessageFilter;
import org.apache.wicket.markup.html.basic.Label;

import java.io.Serializable;

public class FencedFeedbackPanel extends org.apache.wicket.feedback.FencedFeedbackPanel
{
    public FencedFeedbackPanel(String id)
    {
        super(id);
    }

    public FencedFeedbackPanel(String id, Component fence)
    {
        super(id, fence);
    }

    public FencedFeedbackPanel(String id, IFeedbackMessageFilter filter)
    {
        super(id, filter);
    }

    public FencedFeedbackPanel(String id, Component fence, IFeedbackMessageFilter filter)
    {
        super(id, fence, filter);
    }

    @Override
    protected String getCSSClass(FeedbackMessage message)
    {
        return FeedbackPanel.messageToBootstrapAlertCss(message).getClassString();
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
}
