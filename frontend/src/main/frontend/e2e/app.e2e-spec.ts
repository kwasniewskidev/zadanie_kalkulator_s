import { Salary-calculatorPage } from './app.po';

describe('salary-calculator App', () => {
  let page: Salary-calculatorPage;

  beforeEach(() => {
    page = new Salary-calculatorPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
