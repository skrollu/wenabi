import { Component, OnInit, Input } from "@angular/core";
import { StatusName } from "src/app/core/models/statistics";

@Component({
  selector: "app-status",
  templateUrl: "./status.component.html",
  styleUrls: ["./status.component.scss"],
})
export class StatusComponent implements OnInit {
  @Input() status: StatusName;
  statusName: string;
  color: string;

  constructor() {}

  ngOnInit(): void {
    this.statusName = StatusName[this.status];
    this.getStatusColor(this.status);
  }

  getStatusColor(status: StatusName): void {
    switch (StatusName[status]) {
      case StatusName.APPLICATION.valueOf():
        this.color = "pink";
        break;
      case StatusName.CANCELLED.valueOf():
        this.color = "grey";
        break;
      case StatusName.DISCUSSION.valueOf():
        this.color = "red";
        break;
      case StatusName.IN_PROGRESS.valueOf():
        this.color = "green";
        break;
      case StatusName.USER_HAS_PARTICIPATED.valueOf():
        this.color = "purple";
        break;
      case StatusName.WAITING_ASSOCIATION_VALIDATION.valueOf():
        this.color = "gold";
        break;
      case StatusName.WAITING_MANAGER_VALIDATION.valueOf():
        this.color = "yellow";
        break;
      default:
        this.color = "black";
        console.error("status is not managed");
        break;
    }
  }
}
