import { Component, OnInit, Input } from "@angular/core";
import { faHandPointRight, faUser , faMap} from "@fortawesome/free-regular-svg-icons";
import { StatusName } from "src/app/core/models/statistics";
import { Wish } from "src/app/core/models/wish";

@Component({
  selector: "volunteer-card",
  templateUrl: "./volunteer-card.component.html",
  styleUrls: ["./volunteer-card.component.scss"],
})
export class VolunteerCard implements OnInit {
  @Input() wish: Wish;
  handIcon = faHandPointRight;
  userIcon = faUser;
  pointer = faMap;

  constructor() {  }

  ngOnInit() {  }
}
