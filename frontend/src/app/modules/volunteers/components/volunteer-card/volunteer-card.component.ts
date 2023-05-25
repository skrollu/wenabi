import { Component, OnInit } from "@angular/core";
import { faHandPointRight } from "@fortawesome/free-regular-svg-icons";

@Component({
  selector: "volunteer-card",
  templateUrl: "./volunteer-card.component.html",
  styleUrls: ["./volunteer-card.component.scss"],
})
export class VolunteerCard implements OnInit {
  handIcon = faHandPointRight;

  constructor() {}

  ngOnInit() {}
}
