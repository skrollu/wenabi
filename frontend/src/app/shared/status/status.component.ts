import { Component, OnInit, Input } from "@angular/core";
import { StatusName } from "src/app/core/models/statistics";
import { StatusService } from "src/app/core/services/status.service";

@Component({
  selector: "app-status",
  templateUrl: "./status.component.html",
  styleUrls: ["./status.component.scss"],
})
export class StatusComponent implements OnInit {
  @Input() status: StatusName;
  @Input() count: number;
  @Input() styleClass: string;
  statusName: string;
  color: string;

  constructor(private statusService: StatusService) {}

  ngOnInit(): void {
    this.statusName = StatusName[this.status];
    this.getStatusColor(this.status);
  }

  getStatusColor(status: StatusName): void {
    this.color = this.statusService.getStatusColor(status);
  }
}
