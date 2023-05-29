import { Component, ElementRef, OnInit, ViewChild } from "@angular/core";
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
  private wishes: Pageable<Wish>;
  completeWishList: Set<Wish> = new Set();
  displayedWishes: Wish[] = [];
  stats: Statistics[] = []
  statusFilterList: StatusName[] = [];
  @ViewChild('endOfList', { static: false }) endOfList: ElementRef;
  loadingWishes: boolean = false;

  constructor(private wishesService: WishesService) {}
  
  ngOnInit(): void {
      this.getWishes();
      this.getWishesStats();
  }
    
  ngAfterViewInit() {
    this.setupScrollListener();
  }

  /**
   * get Wishes throught the wishesService and add them to wishes and displayedWishes variables
   */
  getWishes(page?: number): void {
    if(this.loadingWishes) {
        return;
    }
    this.loadingWishes = true;
    this.wishesService.getPageableWishes(page).subscribe((data: Pageable<Wish>) => {
        this.wishes = data;
        data.content.forEach(w => this.completeWishList.add(w)) // TODO fix Set not working nicely
        this.displayedWishes = [...this.completeWishList].filter(w => this.statusFilterList.includes(w.status))
        if(this.displayedWishes.length == 0) {
            this.displayedWishes = [...this.completeWishList]
        }
        this.loadingWishes = false;
    });
    
  }

  /**
   * Add statistics to the stats variable
   */
  getWishesStats(page?: number): void {
    this.wishesService.getWishesStats().subscribe((data: Statistics[]) => {
      this.stats = data;
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

    if(this.statusFilterList.length > 0) {
        this.displayedWishes = [...this.completeWishList].filter(w => this.statusFilterList.includes(w.status))
    } else {
        this.displayedWishes = [...this.completeWishList]
    }
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

  /**
   * setup a scroll listener to initiate infinite scroll effect for wish list.
   */
  setupScrollListener() {
    const scrollContainer = window;

    scrollContainer.addEventListener('scroll', () => {
      const windowHeight = scrollContainer.innerHeight;
     
      const scrollTop = scrollContainer.pageYOffset || scrollContainer.scrollY;
      const endOfListOffset = this.endOfList.nativeElement.offsetTop;

      // if the scroll is on top of endList mark and there is more wishes pages then load one more
      if (scrollTop + windowHeight >= endOfListOffset) {
        if(this.wishes.pageable.pageNumber < this.wishes.totalPages) {
            this.getWishes(this.wishes.pageable.pageNumber + 1);
        }
      }
    });
  }
}
