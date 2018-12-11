import { TestBed, inject } from '@angular/core/testing';

import { SalaryCalculatorService } from './salary-calculator.service';

describe('SalaryCalculatorService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [SalaryCalculatorService]
    });
  });

  it('should ...', inject([SalaryCalculatorService], (service: SalaryCalculatorService) => {
    expect(service).toBeTruthy();
  }));
});
