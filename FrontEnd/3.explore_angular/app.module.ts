import { NgModule } from '@angular/core';
//import { BrowserModule } from '@angular/platform-browser';
//import { FormsModule } from '@angular/forms';
//import { HttpClientModule } from '@angular/common/http';
import { App } from './src/main';

@NgModule({
  declarations: [App],
  //imports: [BrowserModule, FormsModule, HttpClientModule],
  imports: [],
  providers: [],
  bootstrap: [App],
})
export class AppModule {}
