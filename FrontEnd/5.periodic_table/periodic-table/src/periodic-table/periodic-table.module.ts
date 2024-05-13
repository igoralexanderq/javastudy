import { BrowserModule } from "@angular/platform-browser";
import { PeriodicTableComponent } from "./periodic-table.component";
import { HttpClientModule } from "@angular/common/http";
import { PeriodicTableService } from "./services/periodic-table.service";
import { NgModule } from "@angular/core";
import { ElementComponent } from "./element/element.component";

@NgModule({
  declarations: [    
    PeriodicTableComponent,
    ElementComponent   
  ],
  imports: [
    BrowserModule,
    HttpClientModule   
  ],  
  
  providers: [PeriodicTableService],
  bootstrap: [PeriodicTableComponent]
})
export class PeriodicTableModule { }