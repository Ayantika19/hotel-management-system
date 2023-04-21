import { Component, OnInit } from '@angular/core';
import { Discount } from 'src/app/models/discount/discount.model';
import { DiscountService } from 'src/app/_services/discount/discount.service';

@Component({
    selector: 'app-add-discount',
    templateUrl: './add-discount.component.html',
    styleUrls: ['./add-discount.component.css']
})
export class AddDiscountComponent implements OnInit {
    discount: Discount = {
        companyName: '',
        houseNumber: '',
        street: '',
        city: '',
        pincode: '',
        emailID: '',
        number: '',
        countrycode: '',
        rebate: '',
    };
    submitted = false;

    constructor(private discountService: DiscountService) { }

    ngOnInit(): void {
    }

    saveDiscount(): void {
        const data = {
            companyName: this.discount.companyName,
            houseNumber: this.discount.houseNumber,
            street: this.discount.street,
            city: this.discount.city,
            pincode: this.discount.pincode,
            emailID: this.discount.emailID,
            number: this.discount.number,
            countrycode: this.discount.countrycode,
            rebate:this.discount.rebate
        };

        this.discountService.create(data)
            .subscribe(
                response => {
                    console.log(response);
                    this.submitted = true;
                },
                error => {
                    console.log(error);
                });
    }

    newDiscount(): void {
        this.submitted = false;
        this.discount = {
            companyName: '',
            houseNumber: '',
            street: '',
            city: '',
            pincode: '',
            emailID: '',
            number: '',
            countrycode: '',
            rebate: '',
        };
    }

}
