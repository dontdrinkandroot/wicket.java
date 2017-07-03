package net.dontdrinkandroot.wicket.model.java.time.temporal;

import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.tester.WicketTestCase;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Locale;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class DateTimeFormatterModelTest extends WicketTestCase
{
    @Test
    public void testUnwrapped()
    {
        DateTimeFormatterModel model;

        model = new DateTimeFormatterModel(new Model<>());
        Assert.assertNull(model.getObject());

        model = new DateTimeFormatterModel(Model.of(LocalDateTime.of(2017, 1, 1, 12, 00)), "yyyy-MM-dd HH:mm:ss");
        Assert.assertEquals("2017-01-01 12:00:00", model.getObject());

        model = new DateTimeFormatterModel(Model.of(LocalDateTime.of(2017, 1, 1, 12, 0).toInstant(ZoneOffset.UTC)));
        Assert.assertEquals("2017-01-01T12:00:00Z", model.getObject());

        model = new DateTimeFormatterModel(
                Model.of(LocalDateTime.of(2017, 1, 1, 12, 0).toInstant(ZoneOffset.UTC)),
                "yyyy-MM-dd HH:mm:ss",
                ZoneId.of("Europe/Berlin")
        );
        Assert.assertEquals("2017-01-01 13:00:00", model.getObject());
    }

    @Test
    public void testWrapped()
    {
        DateTimeFormatterModel model =
                new DateTimeFormatterModel(Model.of(LocalDateTime.of(2017, 3, 1, 12, 00)), "d. MMM yyyy HH:mm");
        Label component = new Label("id", model)
        {
            @Override
            public Locale getLocale()
            {
                return Locale.GERMANY;
            }
        };

        String markup = ComponentRenderer.renderComponent(component).toString();
        Assert.assertEquals("<wicket:container wicket:id=\"id\">1. Mär 2017 12:00</wicket:container>", markup);

        component.detach();
    }
}
