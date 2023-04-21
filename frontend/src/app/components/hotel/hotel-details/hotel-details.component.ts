import { Component, OnInit } from '@angular/core';
import { Hotel } from 'src/app/models/hotel/hotel.model';
import { HotelService } from 'src/app/_services/hotel/hotel.service';
import { AddLocationComponent } from '../../location/add-location/add-location.component';
import { Location } from 'src/app/models/location/location.model';
import { Discount } from 'src/app/models/discount/discount.model';
import { Items } from 'src/app/models/items/items.model';
import { ActivatedRoute, Router } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
    selector: 'app-hotel-details',
    templateUrl: './hotel-details.component.html',
    styleUrls: ['./hotel-details.component.css']
})
export class HotelDetailsComponent implements OnInit {
   currentHotel: Hotel = {
        hotelName: '',
        location: new Location().locationName,
        discounts: new Discount().companyName,
        hotelItems: new Items().charges,
        gymAvailable: false,
        swimmingPoolAvailable: false,
        parkingZoneAvailable: false,
        totalRooms: '',
        roomsAvailable: '',
        carRentAvailable: false,
        gameZoneAvailable: false,
        laundryAvailable: false,
    };
    submitted = false;
    message = '';

    constructor(private hotelService: HotelService, private route: ActivatedRoute,
        private router: Router) { }

    ngOnInit(): void {
        this.message = '';
        this.getHotel(this.route.snapshot.params.id);
    }

    getHotel(id: string): void {
        this.hotelService.get(id)
            .subscribe(
                data => {
                    this.currentHotel = data;
                    console.log(data);
                },
                error => {
                    console.log(error);
                });
    }

    deleteHotel(): void {
        this.message = '';
        this.hotelService.delete(this.currentHotel.hotelId)
            .subscribe(
                response => {
                    console.log(response);
                    this.message = response.message ? response.message : 'This hotel is deleted successfully!';
                    this.router.navigate(['/hotel']);
                },
                error => {
                    console.log(error);
                });
    }

    updateHotel(): void {
        this.message = '';

        this.hotelService.update(this.currentHotel.hotelId, this.currentHotel)
            .subscribe(
                response => {
                    console.log(response);
                    this.submitted = true;
                    this.message = response.message ? response.message : 'This hotel is updated successfully!';
                },
                error => {
                    console.log(error);
                });
    }

}
