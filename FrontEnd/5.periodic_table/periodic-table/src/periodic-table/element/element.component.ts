import { Component, Input } from '@angular/core';
import { Element } from '../models/element.model';

@Component({
  selector: 'element',  
  templateUrl: './element.component.html',
  styleUrl: './element.component.css'
})
export class ElementComponent {
  @Input() elem: any = {};
  
  element: any = {};

  ngOnInit() {
    this.element = this.elem;
  }

  bgImage(element: Element) {
    let url = element.image ? element.image.url : '';
    return {
      backgroundImage: `url(${url})`
    };
  }

  bgColor(element: Element) {
    return {
      backgroundColor: element.bgcolor
    };
  }
}
