import { FrontendBasicauthPage } from './app.po';

describe('frontend-basicauth App', function() {
  let page: FrontendBasicauthPage;

  beforeEach(() => {
    page = new FrontendBasicauthPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
