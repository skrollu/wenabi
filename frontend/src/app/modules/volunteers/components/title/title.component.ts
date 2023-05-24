import { Component, OnInit } from "@angular/core";
import { faHandPointRight } from "@fortawesome/free-regular-svg-icons";

@Component({
  selector: "app-title",
  templateUrl: "./title.component.html",
  styleUrls: ["./title.component.scss"],
})
export class TitleComponent implements OnInit {
  handIcon = faHandPointRight;

  constructor() {}

  ngOnInit() {}
}
