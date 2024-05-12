import { Component } from '@angular/core';
import { bootstrapApplication } from '@angular/platform-browser';
import 'zone.js';
import { TableComponent } from './app/table/table.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [TableComponent],
  /*
  template: `
    <h1>Hello from {{ name }}!</h1>
    <a target="_blank" href="https://angular.dev/overview">
      Learn more about Angular
      <app-table></app-table>
    </a>
  `,
  */
  template: `
      <app-table></app-table>    
  `,
})
export class App {
  //name = 'Angular';

  public App() {}
}

bootstrapApplication(App);
