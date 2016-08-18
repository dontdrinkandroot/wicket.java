package net.dontdrinkandroot.wicket.bootstrap.component.pagination;

import java.util.List;

import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.markup.html.navigation.paging.IPageable;
import org.apache.wicket.util.tester.TagTester;
import org.junit.Assert;
import org.junit.Test;

import net.dontdrinkandroot.wicket.bootstrap.AbstractWicketTest;
import net.dontdrinkandroot.wicket.bootstrap.component.pagination.PaginationPanel;


/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class PaginationPanelTest extends AbstractWicketTest
{

	@Test
	public void testDefaultMarkup()
	{
		IPageable pageable = new IPageable() {

			private long page = 0;

			private long pageCount = 20;


			@Override
			public void setCurrentPage(long page)
			{
				this.page = page;
			}

			@Override
			public long getPageCount()
			{
				return this.pageCount;
			}

			@Override
			public long getCurrentPage()
			{
				return this.page;
			}
		};
		PaginationPanel component = new PaginationPanel("id", pageable);
		String componentMarkup = ComponentRenderer.renderComponent(component).toString();

		TagTester componentTester = TagTester.createTagByAttribute(componentMarkup, "wicket:id", "id");
		Assert.assertTrue(componentTester.getAttributeContains("class", "pagination"));

		TagTester firstItemTester = TagTester.createTagByAttribute(componentMarkup, "wicket:id", "firstItem");
		Assert.assertTrue(firstItemTester.getAttributeContains("class", "disabled"));

		TagTester prevItemTester = TagTester.createTagByAttribute(componentMarkup, "wicket:id", "prevItem");
		Assert.assertTrue(prevItemTester.getAttributeContains("class", "disabled"));

		List<TagTester> pageTesters = TagTester.createTagsByAttribute(componentMarkup, "wicket:id", "pageItem", false);
		Assert.assertEquals(component.getViewSize(), pageTesters.size());

		TagTester currentPageTester = pageTesters.get(0);
		Assert.assertTrue(currentPageTester.getAttributeContains("class", "active"));

		TagTester nextItemTester = TagTester.createTagByAttribute(componentMarkup, "wicket:id", "nextItem");

		TagTester lastItemTester = TagTester.createTagByAttribute(componentMarkup, "wicket:id", "lastItem");
	}

}
