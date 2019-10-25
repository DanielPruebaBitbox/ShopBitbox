import { Component, OnInit } from '@angular/core';
import { Message } from '../message';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  message: string;

  constructor() { }

  ngOnInit() {


  }

}
