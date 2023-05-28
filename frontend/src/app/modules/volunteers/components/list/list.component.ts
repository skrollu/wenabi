import { Component, OnInit } from "@angular/core";
import { WishesService } from "../../../../core/services/wishes.service";
import { Pageable } from "../../../../core/models/pageable";
import { Wish } from "src/app/core/models/wish";
import { Statistics, StatusName } from "src/app/core/models/statistics";

@Component({
  selector: "app-list",
  templateUrl: "./list.component.html",
  styleUrls: ["./list.component.scss"],
})
export class ListComponent implements OnInit {
  private wishes: Wish[] = [];
  displayedWishes: Wish[] = [];
  stats: Statistics[] = []
  statusFilterList: StatusName[] = [];

  constructor(private wishesService: WishesService) {}

  ngOnInit(): void {
    this.getWishes();
    this.getWishesStats();
  }

  /**
   * get Wishes throught the wishesService and add them to wishes and displayedWishes variables
   */
  getWishes(): void {
    this.wishesService.getPageableWishes().subscribe((data: Pageable<Wish>) => {
      this.wishes = data.content;
      this.displayedWishes = this.wishes;
    });
  }

  /**
   * Add statistics to the stats variable
   */
  getWishesStats(): void {
    this.wishesService.getWishesStats().subscribe((data: Statistics[]) => {
      this.stats = data;
      console.log("data from API", this.stats)
    });
  }

  /**
   * @returns the total amount of wishes
   */
  countTotalStatsCount(): number {
    let total: number = 0;
    this.stats.forEach((s) => {
      total += s.count;
    });
    return total;
  }

  /**
   * Add or remove the selectedStatus to the statusFilterList and modify consequently displayedWishes variable
   * @param selectedStatus 
   */
  toggleStatus(selectedStatus: StatusName): void {
    const index = this.statusFilterList.indexOf(selectedStatus);
    if (index > -1) {
      this.statusFilterList.splice(index, 1); // remove the status if already in the liste
    } else {
      this.statusFilterList.push(selectedStatus); // add the status if not
    }

    this.displayedWishes = this.wishes.filter(w => this.statusFilterList.includes(w.status))
  }

  /**
   * @param status 
   * @returns if the status is included in statusFilterList
   */
  isStatusSelected(status: StatusName): boolean {
    return this.statusFilterList.includes(status)
  }

  getStatusList(): StatusName[] {
    const result: StatusName[] = []
    this.stats.forEach(stat => result.push(stat.status))
    return result;
  }
}
