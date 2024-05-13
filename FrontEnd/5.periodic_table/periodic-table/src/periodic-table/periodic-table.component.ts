import { Component } from '@angular/core';
import { PeriodicTableService } from './services/periodic-table.service';
import { Element } from './models/element.model';


@Component({
  selector: 'app-root',  
  templateUrl: './periodic-table.component.html',
  styleUrl: './periodic-table.component.css'  
})
export class PeriodicTableComponent {
  elements: Element[] = [];  

  constructor(private periodicTableService: PeriodicTableService) {
    this.periodicTableService.getElements().subscribe((data) => {
      this.elements = data.elements;           
    });
  }

  styleLocation(elem: Element) {    
    let x = elem.xpos || 0;
    let y = elem.ypos || 0;    
      return {
        gridColumn: x,
        gridRow: y
      }
    }
}
