package net.dontdrinkandroot.wicket.javascript

import net.dontdrinkandroot.wicket.test.AbstractWicketTest
import org.apache.wicket.markup.html.WebMarkupContainer
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.time.Duration
import java.util.*

class JQueryScriptTest : AbstractWicketTest() {

    @Test
    fun testComponentConstructor() {
        val container = WebMarkupContainer("test")
        container.markupId = "test"
        val jQueryScript = JQueryScript(container)
        Assertions.assertEquals("jQuery('#test')", jQueryScript.toString())
        Assertions.assertTrue(container.outputMarkupId)
    }

    @Test
    fun testCharSequenceImplementstion() {
        val jQueryScript = JQueryScript()
        Assertions.assertEquals('Q', jQueryScript[1])
        Assertions.assertEquals(12, jQueryScript.length)
        Assertions.assertEquals("Qu", jQueryScript.subSequence(1, 3))
    }

    @Test
    fun testShow() {
        val jQueryScript = JQueryScript()
        jQueryScript.show()
        Assertions.assertEquals("jQuery(this).show()", jQueryScript.toString())
    }

    @Test
    fun testShowCustomNoParams() {
        val jQueryScript = JQueryScript()
        jQueryScript.show(null, null, null)
        Assertions.assertEquals("jQuery(this).show(0, 'swing', function() {})", jQueryScript.toString())
    }

    @Test
    fun testShowCustom() {
        val jQueryScript = JQueryScript()
        jQueryScript.show(Duration.ofMillis(200), JQueryEasingFunction.LINEAR, "console.log('test');")
        Assertions.assertEquals(
            "jQuery(this).show(200, 'linear', function() {console.log('test');})",
            jQueryScript.toString()
        )
    }

    @Test
    fun testShowCustomNullDuration() {
        val jQueryScript = JQueryScript()
        jQueryScript.show(null, JQueryEasingFunction.LINEAR, "console.log('test');")
        Assertions.assertEquals(
            "jQuery(this).show(0, 'linear', function() {console.log('test');})",
            jQueryScript.toString()
        )
    }

    @Test
    fun testHide() {
        val jQueryScript = JQueryScript()
        jQueryScript.hide()
        Assertions.assertEquals("jQuery(this).hide()", jQueryScript.toString())
    }

    @Test
    fun testHideCustom() {
        val jQueryScript = JQueryScript()
        jQueryScript.hide(Duration.ofMillis(200), JQueryEasingFunction.LINEAR, "console.log('test');")
        Assertions.assertEquals(
            "jQuery(this).hide(200, 'linear', function() {console.log('test');})",
            jQueryScript.toString()
        )
    }

    @Test
    fun testToggle() {
        val jQueryScript = JQueryScript()
        jQueryScript.toggle()
        Assertions.assertEquals("jQuery(this).toggle()", jQueryScript.toString())
    }

    @Test
    fun testToggleCustom() {
        val jQueryScript = JQueryScript()
        jQueryScript.toggle(Duration.ofMillis(200), JQueryEasingFunction.LINEAR, "console.log('test');")
        Assertions.assertEquals(
            "jQuery(this).toggle(200, 'linear', function() {console.log('test');})",
            jQueryScript.toString()
        )
    }

    @Test
    fun testFadeIn() {
        val jQueryScript = JQueryScript()
        jQueryScript.fadeIn()
        Assertions.assertEquals("jQuery(this).fadeIn()", jQueryScript.toString())
    }

    @Test
    fun testFadeInCustom() {
        val jQueryScript = JQueryScript()
        jQueryScript.fadeIn(Duration.ofMillis(200), JQueryEasingFunction.LINEAR, "console.log('test');")
        Assertions.assertEquals(
            "jQuery(this).fadeIn(200, 'linear', function() {console.log('test');})",
            jQueryScript.toString()
        )
    }

    @Test
    fun testFadeOut() {
        val jQueryScript = JQueryScript()
        jQueryScript.fadeOut()
        Assertions.assertEquals("jQuery(this).fadeOut()", jQueryScript.toString())
    }

    @Test
    fun testFadeOutCustom() {
        val jQueryScript = JQueryScript()
        jQueryScript.fadeOut(Duration.ofMillis(200), JQueryEasingFunction.LINEAR, "console.log('test');")
        Assertions.assertEquals(
            "jQuery(this).fadeOut(200, 'linear', function() {console.log('test');})",
            jQueryScript.toString()
        )
    }

    @Test
    fun testFadeToggle() {
        val jQueryScript = JQueryScript()
        jQueryScript.fadeToggle()
        Assertions.assertEquals("jQuery(this).fadeToggle()", jQueryScript.toString())
    }

    @Test
    fun testFadeToggleCustom() {
        val jQueryScript = JQueryScript()
        jQueryScript.fadeToggle(Duration.ofMillis(200), JQueryEasingFunction.LINEAR, "console.log('test');")
        Assertions.assertEquals(
            "jQuery(this).fadeToggle(200, 'linear', function() {console.log('test');})",
            jQueryScript.toString()
        )
    }

    @Test
    fun testAnimate() {
        val jQueryScript = JQueryScript()
        val properties = Properties()
        properties.setProperty("height", "100px")
        properties.setProperty("width", "50px")
        jQueryScript.animate(properties)
        Assertions.assertEquals(
            "jQuery(this).animate({'width': '50px', 'height': '100px'}, 400, 'swing', function() {})",
            jQueryScript.toString()
        )
    }

    @Test
    fun testSlideDown() {
        val jQueryScript = JQueryScript()
        jQueryScript.slideDown()
        Assertions.assertEquals("jQuery(this).slideDown()", jQueryScript.toString())
    }

    @Test
    fun testSlideDownCustom() {
        val jQueryScript = JQueryScript()
        jQueryScript.slideDown(Duration.ofMillis(200), JQueryEasingFunction.LINEAR, "alert('test');")
        Assertions.assertEquals(
            "jQuery(this).slideDown(200, 'linear', function() {alert('test');})",
            jQueryScript.toString()
        )
    }

    @Test
    fun testSlideUp() {
        val jQueryScript = JQueryScript()
        jQueryScript.slideUp()
        Assertions.assertEquals("jQuery(this).slideUp()", jQueryScript.toString())
    }

    @Test
    fun testSlideUpCustom() {
        val jQueryScript = JQueryScript()
        jQueryScript.slideUp(Duration.ofMillis(200), JQueryEasingFunction.LINEAR, "alert('test');")
        Assertions.assertEquals(
            "jQuery(this).slideUp(200, 'linear', function() {alert('test');})",
            jQueryScript.toString()
        )
    }

    @Test
    fun testSlideToggle() {
        val jQueryScript = JQueryScript()
        jQueryScript.slideToggle()
        Assertions.assertEquals("jQuery(this).slideToggle()", jQueryScript.toString())
    }

    @Test
    fun testSlideToggleCustom() {
        val jQueryScript = JQueryScript()
        jQueryScript.slideToggle(Duration.ofMillis(200), JQueryEasingFunction.LINEAR, "alert('test');")
        Assertions.assertEquals(
            "jQuery(this).slideToggle(200, 'linear', function() {alert('test');})",
            jQueryScript.toString()
        )
    }

    @Test
    fun testChildren() {
        val jQueryScript = JQueryScript()
        jQueryScript.children(".test")
        Assertions.assertEquals("jQuery(this).children('.test')", jQueryScript.toString())
    }

    @Test
    fun testSiblings() {
        val jQueryScript = JQueryScript()
        jQueryScript.siblings(".test")
        Assertions.assertEquals("jQuery(this).siblings('.test')", jQueryScript.toString())
    }

    @Test
    fun testSiblingsEmpty() {
        val jQueryScript = JQueryScript()
        jQueryScript.siblings(null)
        Assertions.assertEquals("jQuery(this).siblings()", jQueryScript.toString())
    }

    @Test
    fun testAddClass() {
        val jQueryScript = JQueryScript()
        jQueryScript.addClass(".test")
        Assertions.assertEquals("jQuery(this).addClass('.test')", jQueryScript.toString())
    }

    @Test
    fun testRemoveClass() {
        val jQueryScript = JQueryScript()
        jQueryScript.removeClass(".test")
        Assertions.assertEquals("jQuery(this).removeClass('.test')", jQueryScript.toString())
    }

    @Test
    fun testClick() {
        val jQueryScript = JQueryScript()
        jQueryScript.click(null)
        Assertions.assertEquals("jQuery(this).click(function(event) {})", jQueryScript.toString())
    }

    @Test
    fun testClickCustom() {
        val jQueryScript = JQueryScript()
        jQueryScript.click("alert('test');")
        Assertions.assertEquals("jQuery(this).click(function(event) {alert('test');})", jQueryScript.toString())
    }

    @Test
    fun testAppend() {
        val jQueryScript = JQueryScript()
        jQueryScript.append(".test()")
        Assertions.assertEquals("jQuery(this).test()", jQueryScript.toString())
    }
}