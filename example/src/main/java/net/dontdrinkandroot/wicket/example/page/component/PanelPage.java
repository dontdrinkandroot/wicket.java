package net.dontdrinkandroot.wicket.example.page.component;

import net.dontdrinkandroot.wicket.bootstrap.component.panel.PlainPanel;
import net.dontdrinkandroot.wicket.bootstrap.component.panel.SimplePanel;
import net.dontdrinkandroot.wicket.bootstrap.css.PanelStyle;
import net.dontdrinkandroot.wicket.component.basic.Heading;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class PanelPage extends ComponentPage
{
    public PanelPage(PageParameters parameters)
    {
        super(parameters);
    }

    @Override
    protected IModel<String> createPageHeadingModel()
    {
        return Model.of("Panels");
    }

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        RepeatingView panelStyleView = new RepeatingView("panelStyle");
        this.add(panelStyleView);

        for (PanelStyle panelStyle : PanelStyle.values()) {
            SimplePanel panel =
                    new SimplePanel(panelStyleView.newChildId(), Model.of(panelStyle.name()), Heading.Level.H3);
            panel.setPanelStyle(panelStyle);
            panelStyleView.add(panel);
        }

        PlainPanel panelFooter = new PlainPanel("panelFooter")
        {
            @Override
            protected Component createBody(String id)
            {
                return new Label(id, "Body");
            }

            @Override
            protected Component createFooter(String id)
            {
                return new Label(id, "Footer");
            }
        };
        this.add(panelFooter);
    }
}
