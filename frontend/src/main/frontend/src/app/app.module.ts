import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { SalaryCalculatorService } from './salary-calculator/service/salary-calculator.service';
import { CountriesService } from './salary-calculator/service/countries.service';
import { AppComponent } from './app.component';
import { SalaryCalculatorComponent } from './salary-calculator/salary-calculator.component';

@NgModule({
  declarations: [
    AppComponent,
    SalaryCalculatorComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule
  ],
   providers: [SalaryCalculatorService, CountriesService],
  bootstrap: [AppComponent]
})
export class AppModule { }
