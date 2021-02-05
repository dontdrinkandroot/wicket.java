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
package net.dontdrinkandroot.wicket.javascript;

import net.dontdrinkandroot.wicket.test.AbstractWicketTest;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Properties;


public class JQueryScriptTest extends AbstractWicketTest
{
    @Test
    public void testComponentConstructor()
    {
        WebMarkupContainer container = new WebMarkupContainer("test");
        container.setMarkupId("test");
        JQueryScript jQueryScript = new JQueryScript(container);
        Assertions.assertEquals("jQuery('#test')", jQueryScript.toString());
        Assertions.assertTrue(container.getOutputMarkupId());
    }

    @Test
    public void testCharSequenceImplementstion()
    {
        JQueryScript jQueryScript = new JQueryScript();
        Assertions.assertEquals('Q', jQueryScript.charAt(1));
        Assertions.assertEquals(12, jQueryScript.length());
        Assertions.assertEquals("Qu", jQueryScript.subSequence(1, 3));
    }

    @Test
    public void testShow()
    {
        JQueryScript jQueryScript = new JQueryScript();
        jQueryScript.show();
        Assertions.assertEquals("jQuery(this).show()", jQueryScript.toString());
    }

    @Test
    public void testShowCustomNoParams()
    {
        JQueryScript jQueryScript = new JQueryScript();
        jQueryScript.show(null, null, null);
        Assertions.assertEquals("jQuery(this).show(0, 'swing', function() {})", jQueryScript.toString());
    }

    @Test
    public void testShowCustom()
    {
        JQueryScript jQueryScript = new JQueryScript();
        jQueryScript.show(Duration.ofMillis(200), JQueryEasingFunction.LINEAR, "console.log('test');");
        Assertions.assertEquals(
                "jQuery(this).show(200, 'linear', function() {console.log('test');})",
                jQueryScript.toString()
        );
    }

    @Test
    public void testShowCustomNullDuration()
    {
        JQueryScript jQueryScript = new JQueryScript();
        jQueryScript.show(null, JQueryEasingFunction.LINEAR, "console.log('test');");
        Assertions.assertEquals(
                "jQuery(this).show(0, 'linear', function() {console.log('test');})",
                jQueryScript.toString()
        );
    }

    @Test
    public void testHide()
    {
        JQueryScript jQueryScript = new JQueryScript();
        jQueryScript.hide();
        Assertions.assertEquals("jQuery(this).hide()", jQueryScript.toString());
    }

    @Test
    public void testHideCustom()
    {
        JQueryScript jQueryScript = new JQueryScript();
        jQueryScript.hide(Duration.ofMillis(200), JQueryEasingFunction.LINEAR, "console.log('test');");
        Assertions.assertEquals(
                "jQuery(this).hide(200, 'linear', function() {console.log('test');})",
                jQueryScript.toString()
        );
    }

    @Test
    public void testToggle()
    {
        JQueryScript jQueryScript = new JQueryScript();
        jQueryScript.toggle();
        Assertions.assertEquals("jQuery(this).toggle()", jQueryScript.toString());
    }

    @Test
    public void testToggleCustom()
    {
        JQueryScript jQueryScript = new JQueryScript();
        jQueryScript.toggle(Duration.ofMillis(200), JQueryEasingFunction.LINEAR, "console.log('test');");
        Assertions.assertEquals(
                "jQuery(this).toggle(200, 'linear', function() {console.log('test');})",
                jQueryScript.toString()
        );
    }

    @Test
    public void testFadeIn()
    {
        JQueryScript jQueryScript = new JQueryScript();
        jQueryScript.fadeIn();
        Assertions.assertEquals("jQuery(this).fadeIn()", jQueryScript.toString());
    }

    @Test
    public void testFadeInCustom()
    {
        JQueryScript jQueryScript = new JQueryScript();
        jQueryScript.fadeIn(Duration.ofMillis(200), JQueryEasingFunction.LINEAR, "console.log('test');");
        Assertions.assertEquals(
                "jQuery(this).fadeIn(200, 'linear', function() {console.log('test');})",
                jQueryScript.toString()
        );
    }

    @Test
    public void testFadeOut()
    {
        JQueryScript jQueryScript = new JQueryScript();
        jQueryScript.fadeOut();
        Assertions.assertEquals("jQuery(this).fadeOut()", jQueryScript.toString());
    }

    @Test
    public void testFadeOutCustom()
    {
        JQueryScript jQueryScript = new JQueryScript();
        jQueryScript.fadeOut(Duration.ofMillis(200), JQueryEasingFunction.LINEAR, "console.log('test');");
        Assertions.assertEquals(
                "jQuery(this).fadeOut(200, 'linear', function() {console.log('test');})",
                jQueryScript.toString()
        );
    }

    @Test
    public void testFadeToggle()
    {
        JQueryScript jQueryScript = new JQueryScript();
        jQueryScript.fadeToggle();
        Assertions.assertEquals("jQuery(this).fadeToggle()", jQueryScript.toString());
    }

    @Test
    public void testFadeToggleCustom()
    {
        JQueryScript jQueryScript = new JQueryScript();
        jQueryScript.fadeToggle(Duration.ofMillis(200), JQueryEasingFunction.LINEAR, "console.log('test');");
        Assertions.assertEquals(
                "jQuery(this).fadeToggle(200, 'linear', function() {console.log('test');})",
                jQueryScript.toString()
        );
    }

    @Test
    public void testAnimate()
    {
        JQueryScript jQueryScript = new JQueryScript();

        Properties properties = new Properties();
        properties.setProperty("height", "100px");
        properties.setProperty("width", "50px");
        jQueryScript.animate(properties);
        Assertions.assertEquals(
                "jQuery(this).animate({'width': '50px', 'height': '100px'}, 400, 'swing', function() {})",
                jQueryScript.toString()
        );
    }

    @Test
    public void testSlideDown()
    {
        JQueryScript jQueryScript = new JQueryScript();
        jQueryScript.slideDown();
        Assertions.assertEquals("jQuery(this).slideDown()", jQueryScript.toString());
    }

    @Test
    public void testSlideDownCustom()
    {
        JQueryScript jQueryScript = new JQueryScript();
        jQueryScript.slideDown(Duration.ofMillis(200), JQueryEasingFunction.LINEAR, "alert('test');");
        Assertions.assertEquals(
                "jQuery(this).slideDown(200, 'linear', function() {alert('test');})",
                jQueryScript.toString()
        );
    }

    @Test
    public void testSlideUp()
    {
        JQueryScript jQueryScript = new JQueryScript();
        jQueryScript.slideUp();
        Assertions.assertEquals("jQuery(this).slideUp()", jQueryScript.toString());
    }

    @Test
    public void testSlideUpCustom()
    {
        JQueryScript jQueryScript = new JQueryScript();
        jQueryScript.slideUp(Duration.ofMillis(200), JQueryEasingFunction.LINEAR, "alert('test');");
        Assertions.assertEquals(
                "jQuery(this).slideUp(200, 'linear', function() {alert('test');})",
                jQueryScript.toString()
        );
    }

    @Test
    public void testSlideToggle()
    {
        JQueryScript jQueryScript = new JQueryScript();
        jQueryScript.slideToggle();
        Assertions.assertEquals("jQuery(this).slideToggle()", jQueryScript.toString());
    }

    @Test
    public void testSlideToggleCustom()
    {
        JQueryScript jQueryScript = new JQueryScript();
        jQueryScript.slideToggle(Duration.ofMillis(200), JQueryEasingFunction.LINEAR, "alert('test');");
        Assertions.assertEquals(
                "jQuery(this).slideToggle(200, 'linear', function() {alert('test');})",
                jQueryScript.toString()
        );
    }

    @Test
    public void testChildren()
    {
        JQueryScript jQueryScript = new JQueryScript();
        jQueryScript.children(".test");
        Assertions.assertEquals("jQuery(this).children('.test')", jQueryScript.toString());
    }

    @Test
    public void testSiblings()
    {
        JQueryScript jQueryScript = new JQueryScript();
        jQueryScript.siblings(".test");
        Assertions.assertEquals("jQuery(this).siblings('.test')", jQueryScript.toString());
    }

    @Test
    public void testSiblingsEmpty()
    {
        JQueryScript jQueryScript = new JQueryScript();
        jQueryScript.siblings(null);
        Assertions.assertEquals("jQuery(this).siblings()", jQueryScript.toString());
    }

    @Test
    public void testAddClass()
    {
        JQueryScript jQueryScript = new JQueryScript();
        jQueryScript.addClass(".test");
        Assertions.assertEquals("jQuery(this).addClass('.test')", jQueryScript.toString());
    }

    @Test
    public void testRemoveClass()
    {
        JQueryScript jQueryScript = new JQueryScript();
        jQueryScript.removeClass(".test");
        Assertions.assertEquals("jQuery(this).removeClass('.test')", jQueryScript.toString());
    }

    @Test
    public void testClick()
    {
        JQueryScript jQueryScript = new JQueryScript();
        jQueryScript.click(null);
        Assertions.assertEquals("jQuery(this).click(function(event) {})", jQueryScript.toString());
    }

    @Test
    public void testClickCustom()
    {
        JQueryScript jQueryScript = new JQueryScript();
        jQueryScript.click("alert('test');");
        Assertions.assertEquals("jQuery(this).click(function(event) {alert('test');})", jQueryScript.toString());
    }

    @Test
    public void testAppend()
    {
        JQueryScript jQueryScript = new JQueryScript();
        jQueryScript.append(".test()");
        Assertions.assertEquals("jQuery(this).test()", jQueryScript.toString());
    }
}
