import { Component, OnInit, Input } from "@angular/core";
import { Statistics, StatusName } from "src/app/core/models/statistics";

@Component({
    selector: "app-status-progress-bar",
    templateUrl: "./status-progress-bar.component.html",
    styleUrls: ["./status-progress-bar.component.scss"],
})
export class StatusProgressBarComponent implements OnInit {
    @Input() statistics: Statistics[];
    @Input() statusList: StatusName[];


    constructor() { }

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
        switch (StatusName[status]) {
            case StatusName.APPLICATION.valueOf():
                return "pink";
            case StatusName.CANCELLED.valueOf():
                return "grey";
            case StatusName.DISCUSSION.valueOf():
                return "red";
            case StatusName.IN_PROGRESS.valueOf():
                return "green";
            case StatusName.USER_HAS_PARTICIPATED.valueOf():
                return "purple";
            case StatusName.WAITING_ASSOCIATION_VALIDATION.valueOf():
                return "gold";
            case StatusName.WAITING_MANAGER_VALIDATION.valueOf():
                return "yellow";
            default:
                console.error("status is not managed");
                return "black";
        }
    }
}
