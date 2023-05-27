import { Component, OnInit } from "@angular/core";
import { tap } from "rxjs/internal/operators/tap";
import { WishesService } from "../../../../core/services/wishes.service";
import { Pageable } from "../../../../core/models/pageable";
import { Wish } from "src/app/core/models/wish";
import { Statistics } from "src/app/core/models/statistics";

@Component({
  selector: "app-list",
  templateUrl: "./list.component.html",
  styleUrls: ["./list.component.scss"],
})
export class ListComponent implements OnInit {
  wishes: Wish[] = [];
  stats: Statistics[] = [];

  constructor(private wishesService: WishesService) {}

  ngOnInit(): void {
    this.getWishes();
    this.getWishesStats();
  }

  getWishes(): void {
    this.wishesService.getPageableWishes().subscribe((data: Pageable<Wish>) => {
      this.wishes = data.content;
    });
  }

  getWishesStats(): void {
    this.wishesService.getWishesStats().subscribe((data: Statistics[]) => {
      this.stats = data;
    });
  }

  countTotalStatsCount(): number {
    let total: number = 0;
    this.stats.forEach((s) => {
      total += s.count;
    });
    return total;
  }
}
