import { Angular4ClientPage } from './app.po';

describe('springboot-jpa-angularjs4-client App', () => {
  let page: Angular4ClientPage;

  beforeEach(() => {
    page = new Angular4ClientPage();
  });

  it('should display welcome message', done => {
    page.navigateTo();
    page.getParagraphText()
      .then(msg => expect(msg).toEqual('Welcome to app!!'))
      .then(done, done.fail);
  });
});
