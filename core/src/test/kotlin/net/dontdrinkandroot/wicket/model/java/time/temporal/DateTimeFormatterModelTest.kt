package net.dontdrinkandroot.wicket.model.java.time.temporal

import net.dontdrinkandroot.wicket.model.kModel
import net.dontdrinkandroot.wicket.model.time.temporal.DateTimeFormatterModel
import org.apache.wicket.core.util.string.ComponentRenderer
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.util.tester.WicketTestCase
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZoneOffset
import java.util.*

class DateTimeFormatterModelTest : WicketTestCase() {

    @Test
    fun testUnwrapped() {
        var model: DateTimeFormatterModel
//        model = DateTimeFormatterModel(null.kModel())
//        Assertions.assertNull(model.getObject())
        model = DateTimeFormatterModel(LocalDateTime.of(2017, 1, 1, 12, 0).kModel(), "yyyy-MM-dd HH:mm:ss")
        Assertions.assertEquals("2017-01-01 12:00:00", model.getObject())
        model = DateTimeFormatterModel(LocalDateTime.of(2017, 1, 1, 12, 0).toInstant(ZoneOffset.UTC).kModel())
        Assertions.assertEquals("2017-01-01T12:00:00Z", model.getObject())
        model = DateTimeFormatterModel(
            LocalDateTime.of(2017, 1, 1, 12, 0).toInstant(ZoneOffset.UTC).kModel(),
            "yyyy-MM-dd HH:mm:ss",
            ZoneId.of("Europe/Berlin")
        )
        Assertions.assertEquals("2017-01-01 13:00:00", model.getObject())
    }

    @Test
    fun testWrapped() {
        val model = DateTimeFormatterModel(LocalDateTime.of(2017, 3, 1, 12, 0).kModel(), "d. MMM yyyy HH:mm")
        val component: Label = object : Label("id", model) {
            override fun getLocale(): Locale {
                return Locale.GERMANY
            }
        }
        val markup = ComponentRenderer.renderComponent(component).toString()
        Assertions.assertEquals("<wicket:container wicket:id=\"id\">1. März 2017 12:00</wicket:container>", markup)
        component.detach()
    }
}