import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-element',
  standalone: true,
  imports: [],
  templateUrl: './element.component.html',
  styleUrl: './element.component.css',
})
export class ElementComponent {
  @Input() e: any = {};

  number: Number = 0;
  name: String = '';
  symbol: String = '';
  mass: Number = 0;
  category: String = '';
  image: String = '';
  bgcolor: String = '';
  x: number = 0;
  y: number = 0;
  xx: number = 0;
  yy: number = 0;


  ngOnInit() {
    this.number = this.e.number ?? 0;
    this.name = this.e.name ?? '';
    this.symbol = this.e.symbol ?? '';
    this.mass = this.e.atomic_mass ?? 0;
    this.category = this.e.category ?? '';
    this.image = this.e.image.url ?? '';
    this.bgcolor = this.e.cpkhex ?? '';
    this.x = this.e.xpos ?? 0;
    this.y = this.e.ypos ?? 0;
    this.xx = this.x + 1;
    this.yy = this.y + 1;

  }
}

export interface Elem {
  number: Number
  name: String;
  symbol: String;
  mass: Number;
  category: String;
  image: String;
  bgcolor: String;
  x: number;
  y: number;
  xx: number;
  yy: number;
}
