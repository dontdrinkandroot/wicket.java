package net.dontdrinkandroot.wicket.bootstrap.test

import org.apache.wicket.util.tester.WicketTester
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach

open class AbstractWicketTest {

    protected lateinit var tester: WicketTester

    @BeforeEach
    fun setUp() {
        tester = WicketTester(TestApplication())
    }

    @AfterEach
    fun tearDown() {
        tester.destroy()
    }
}