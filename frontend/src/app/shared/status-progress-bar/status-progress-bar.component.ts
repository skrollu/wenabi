import { Component, OnInit, Input } from "@angular/core";
import { Statistics, StatusName } from "src/app/core/models/statistics";
import { StatusService } from "src/app/core/services/status.service";

@Component({
    selector: "app-status-progress-bar",
    templateUrl: "./status-progress-bar.component.html",
    styleUrls: ["./status-progress-bar.component.scss"],
})
export class StatusProgressBarComponent implements OnInit {
    @Input() statistics: Statistics[];
    @Input() statusList: StatusName[];


    constructor(private statusService: StatusService) { }

    ngOnInit(): void { }

    calculatePercentage(status: string): number {
        const totalStatisticsCount = this.countTotalStatiticsCount();
        const statIndex = this.statistics.findIndex(stat => stat.status === status);
        const count = this.statistics[statIndex].count;

        return (count / totalStatisticsCount) * 100;
    }

    /**
     * @returns the total amount of wishes
     */
    countTotalStatiticsCount(): number {
        let total: number = 0;
        this.statistics.forEach((stat) => {
            total += stat.count;
        });
        return total;
    }

    getStatusColor(status: StatusName): string {
        return this.statusService.getStatusColor(status)
    }
}
