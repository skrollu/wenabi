import { Component, OnInit } from "@angular/core";
import { tap } from "rxjs/internal/operators/tap";
import { WishesService } from "../../../../core/services/wishes.service";
import { Pageable } from '../../../../core/models/pageable';
import { Wish } from "src/app/core/models/wish";

@Component({
  selector: "app-list",
  templateUrl: "./list.component.html",
  styleUrls: ["./list.component.scss"],
})
export class ListComponent implements OnInit {
  wishes: Wish[] = [];

  constructor(private wishesService: WishesService) {}

  ngOnInit(): void {
    this.getWishes();
  }

  getWishes(): void {
    this.wishesService.getPageableWishes().subscribe((data: Pageable<Wish>) => {
      this.wishes = data.content;
    });
  }
}
