import { Component, OnInit } from '@angular/core';
import { Location } from 'src/app/models/location/location.model';
import { LocationService } from 'src/app/_services/location/location.service';

@Component({
  selector: 'app-add-location',
  templateUrl: './add-location.component.html',
  styleUrls: ['./add-location.component.css']
})
export class AddLocationComponent implements OnInit {
  location: Location = {
    locationName: '',
  };
  submitted = false;

  constructor(private locationService: LocationService) { }

  ngOnInit(): void {
  }

  saveLocation(): void {
    const data = {
      locationName: this.location.locationName
    };

    this.locationService.create(data)
      .subscribe(
        response => {
          console.log(response);
          this.submitted = true;
        },
        error => {
          console.log(error);
        });
  }

  newLocation(): void {
    this.submitted = false;
    this.location = {
      locationName: ''
    };
  }

}
