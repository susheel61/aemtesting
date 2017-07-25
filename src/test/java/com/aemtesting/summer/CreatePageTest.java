package com.aemtesting.summer;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.aemtesting.GuiceModule;
import com.cognifide.qa.bb.aem.AemLogin;
import com.cognifide.qa.bb.aem.ui.wcm.SiteAdminPage;
import com.cognifide.qa.bb.junit.Modules;
import com.cognifide.qa.bb.junit.TestRunner;
import com.google.inject.Inject;

@RunWith(TestRunner.class)
@Modules(GuiceModule.class)
public class CreatePageTest {

  private static final String CREATE_PAGE_TEMPLATE = "Media Article";

  private static final String BASE_PARENT_URL = "/content/geometrixx-media/en/entertainment";

  private static final String CREATED_PAGE_TITLE = "What is bobcat";

  @Inject
  private SiteAdminPage page;
 
  @Inject
  private AemLogin aemLogin;

  @Before
  public void openSiteadminPage() {
    aemLogin.authorLogin();
    page.open(BASE_PARENT_URL);
  }

  @Test
  public void createPage() {
    if (!page.isPagePresent(CREATED_PAGE_TITLE)) {
      page.createNewPage(CREATED_PAGE_TITLE, CREATE_PAGE_TEMPLATE);
    }
    assertTrue(page.isPagePresent(CREATED_PAGE_TITLE));
    assertTrue(page.isTemplateOnTheList(CREATED_PAGE_TITLE, CREATE_PAGE_TEMPLATE));
  }
}