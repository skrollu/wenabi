import { Injectable } from '@angular/core';
import { Statistics, StatusName } from '../models/statistics';

@Injectable({
    providedIn: 'root'
})
export class StatusService {

    constructor() { }

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