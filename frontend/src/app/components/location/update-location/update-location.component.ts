import { Component, OnInit } from '@angular/core';
import { LocationService } from 'src/app/services/location/location.service';
import { Location } from 'src/app/models/location/location.model';

@Component({
  selector: 'app-update-location',
  templateUrl: './update-location.component.html',
  styleUrls: ['./update-location.component.css']
})
export class UpdateLocationComponent implements OnInit {
  currentLocation: Location = {
    id: '',
    locationname: '',
  };
  message = '';

  constructor(
    private locationService: LocationService) { }

  ngOnInit(): void {
    this.message = '';
  }

  updateLocation(): void {
    this.message = '';

    this.locationService.update(this.currentLocation.id, this.currentLocation)
      .subscribe(
        response => {
          console.log(response);
          this.message = response.message ? response.message : 'This location was updated successfully!';
        },
        error => {
          console.log(error);
        });
  }
}
