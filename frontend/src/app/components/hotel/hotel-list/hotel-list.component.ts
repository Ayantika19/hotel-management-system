import { Component, OnInit } from '@angular/core';
import { Hotel } from 'src/app/models/hotel/hotel.model';
import { HotelService } from 'src/app/_services/hotel/hotel.service';

@Component({
  selector: 'app-hotel-list',
  templateUrl: './hotel-list.component.html',
  styleUrls: ['./hotel-list.component.css']
})
export class HotelListComponent implements OnInit {
  hotel?: Hotel[];
  currentHotel?: Hotel;
  currentIndex = -1;

  constructor(private hotelService: HotelService) { }

  ngOnInit(): void {
    this.retrieveHotels();
  }

  retrieveHotels(): void {
    this.hotelService.getAll()
      .subscribe(
        data => {
          this.hotel = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }

  refreshList(): void {
    this.retrieveHotels();
    this.currentHotel = undefined;
    this.currentIndex = -1;
  }

  setActiveHotel(hotels: Hotel, index: number): void {
    this.currentHotel = hotels;
    this.currentIndex = index;
  }
}

