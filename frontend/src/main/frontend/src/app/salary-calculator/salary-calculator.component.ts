import { Component, OnInit } from '@angular/core';
import { SalaryCalculatorService } from "./service/salary-calculator.service"
import { CountriesService } from "./service/countries.service"

@Component({
  selector: 'salary-calculator',
  templateUrl: './salary-calculator.component.html',
  styleUrls: ['./salary-calculator.component.css']
})
export class SalaryCalculatorComponent implements OnInit {
 plnSalary = 0;
  dailySalary: number;
  countries: string[];
  country: string;
  error: boolean = false;
  calculated: boolean = false;
  noSalary: boolean = false;

  constructor(private calculatorService : SalaryCalculatorService, private countriesService : CountriesService) { }

  setDailySalary(salary: number) {
    this.dailySalary = salary;
  }

  ngOnInit() {
    this.countriesService.get().subscribe(response => {
        this.countries = response.countries;
        this.country = response.countries[0];
      })
  }

  calculate() {
  if(this.dailySalary==null || this.dailySalary<=0){
  this.noSalary=true;
  this.calculated=false;
  return;
  }
  this.noSalary=false;
    this.calculatorService.calculate(this.dailySalary, this.country).subscribe(
    response => {
      this.plnSalary = response.salary
      this.error=false;
      this.calculated=true;
    },
    err => {
    this.error=true;
	this.calculated=false;
    this.plnSalary = 0;
    }
    )
  }
}
