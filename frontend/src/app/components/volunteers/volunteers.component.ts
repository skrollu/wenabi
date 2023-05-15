import { Component, OnInit } from '@angular/core';
import { faHandPointRight} from '@fortawesome/free-regular-svg-icons';

@Component({
  selector: 'app-volunteers',
  templateUrl: './volunteers.component.html',
  styleUrls: ['./volunteers.component.scss']
})
export class VolunteersComponent implements OnInit {

  handIcon = faHandPointRight;

  constructor() { }

  ngOnInit() {
  }

}
