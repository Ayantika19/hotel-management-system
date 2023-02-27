import { Component, OnInit } from '@angular/core';
import { Location } from 'src/app/models/location/location.model';
import { LocationService } from 'src/app/services/location/location.service';

@Component({
  selector: 'app-add-location',
  templateUrl: './add-location.component.html',
  styleUrls: ['./add-location.component.css']
})
export class AddLocationComponent implements OnInit {
  location: Location = {
    locationname: '',
  };
  submitted = false;

  constructor(private locationService: LocationService) { }

  ngOnInit(): void {
  }

  saveLocation(): void {
    const data = {
      locationname: this.location.locationname
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
      locationname: ''
    };
  }

}
