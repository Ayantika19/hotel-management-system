import { Component, OnInit } from '@angular/core';
import { DiscountService } from 'src/app/_services/discount/discount.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Discount } from 'src/app/models/discount/discount.model';

@Component({
    selector: 'app-discount-details',
    templateUrl: './discount-details.component.html',
    styleUrls: ['./discount-details.component.css']
})
export class DiscountDetailsComponent implements OnInit {
    currentDiscount: Discount = {
        companyName: '',
        houseNumber: '',
        street: '',
        city: '',
        pincode: '',
        emailID: '',
        number: '',
        countrycode: '',
        rebate:'',
    };
    submitted = false;
    message = '';

    constructor(
        private discountService: DiscountService,
        private route: ActivatedRoute,
        private router: Router) { }

    ngOnInit(): void {
        this.message = '';
        this.getDiscount(this.route.snapshot.params.id);
    }

    getDiscount(id: string): void {
        this.discountService.get(id)
            .subscribe(
                data => {
                    this.currentDiscount = data;
                    console.log(data);
                },
                error => {
                    console.log(error);
                });
    }

    deleteDiscount(): void {
        this.message = '';
        this.discountService.delete(this.currentDiscount.discountId)
            .subscribe(
                response => {
                    console.log(response);
                    this.message = response.message ? response.message : 'This discount is deleted successfully!';
                    this.router.navigate(['/discount']);
                },
                error => {
                    console.log(error);
                });
    }

    updateDiscount(): void {
        this.message = '';
    
        this.discountService.update(this.currentDiscount.discountId, this.currentDiscount)
          .subscribe(
            response => {
              console.log(response);
              this.submitted = true;
              this.message = response.message ? response.message : 'This discount is updated successfully!';
            },
            error => {
              console.log(error);
            });
      }
}
