import { Component, OnInit } from '@angular/core';
import { Location } from 'src/app/models/location/location.model';
import { LocationService } from 'src/app/_services/location/location.service';

@Component({
  selector: 'app-location-list',
  templateUrl: './location-list.component.html',
  styleUrls: ['./location-list.component.css']
})
export class LocationListComponent implements OnInit {
  location?: Location[];
  currentLocation?: Location;
  currentIndex = -1;

  constructor(private locationService: LocationService) { }

  ngOnInit(): void {
    this.retrieveLocations();
  }

  retrieveLocations(): void {
    this.locationService.getAll()
      .subscribe(
        data => {
          this.location = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }

  refreshList(): void {
    this.retrieveLocations();
    this.currentLocation = undefined;
    this.currentIndex = -1;
  }

  setActiveLocation(locations: Location, index: number): void {
    this.currentLocation = locations;
    this.currentIndex = index;
  }
}

