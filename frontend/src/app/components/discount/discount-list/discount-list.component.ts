import { Component, OnInit } from '@angular/core';
import { Discount } from 'src/app/models/discount/discount.model';
import { DiscountService } from 'src/app/_services/discount/discount.service';

@Component({
  selector: 'app-discount-list',
  templateUrl: './discount-list.component.html',
  styleUrls: ['./discount-list.component.css']
})
export class DiscountListComponent implements OnInit {
  discount?: Discount[];
  currentDiscount?: Discount;
  currentIndex = -1;

  constructor(private discountService: DiscountService) { }

  ngOnInit(): void {
    this.retrieveDiscounts();
  }

  retrieveDiscounts(): void {
    this.discountService.getAll()
      .subscribe(
        data => {
          this.discount = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }

  refreshList(): void {
    this.retrieveDiscounts();
    this.currentDiscount = undefined;
    this.currentIndex = -1;
  }

  setActiveDiscount(discounts: Discount, index: number): void {
    this.currentDiscount = discounts;
    this.currentIndex = index;
  }


//   deleteDiscount(index: number): void {
//     this.currentIndex = index;
//     this.discountService.delete(this.currentIndex)
//       .subscribe(
//         response => {
//           console.log(response);
//           this.refreshList();
//         },
//         error => {
//           console.log(error);
//         });
//   }
 }


//   deleteDiscount(discountId:string): void {
//     this.discountService.delete(discountId)
//       .subscribe(
//         response => {
//           console.log(response);
//           this.submitted = true;
//         },
//         error => {
//           console.log(error);
//         });
//   }

  // to use for update discount
  // saveDiscount(): void {
  //   const data = {
  //     discountName: this.updatediscount.discountName
  //   };

  //   this.discountService.create(data)
  //     .subscribe(
  //       response => {
  //         console.log(response);
  //         this.submitted = true;
  //       },
  //       error => {
  //         console.log(error);
  //       });
  // }

  // newDiscount(): void {
  //   this.submitted = false;
  //   this.updatediscount = {
  //     discountName: ''
  //   };
  // }

//   removeAllDiscounts(): void {
//     this.discountService.deleteAll()
//       .subscribe(
//         response => {
//           console.log(response);
//           this.refreshList();
//         },
//         error => {
//           console.log(error);
//         });
//   }

//   searchTitle(): void {
//     this.currentDiscount = undefined;
//     this.currentIndex = -1;

//     this.discountService.findByTitle(this.title)
//       .subscribe(
//         data => {
//           this.discount = data;
//           console.log(data);
//         },
//         error => {
//           console.log(error);
//         });
//   }

