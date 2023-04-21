import { Component, OnInit } from '@angular/core';
import { LocationService } from 'src/app/_services/location/location.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Location } from 'src/app/models/location/location.model';

@Component({
  selector: 'app-location-details',
  templateUrl: './location-details.component.html',
  styleUrls: ['./location-details.component.css']
})
export class LocationDetailsComponent implements OnInit {
  currentLocation: Location = {
    locationName: '',
  };
  message = '';

  constructor(
    private locationService: LocationService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.message = '';
    this.getLocation(this.route.snapshot.params.id);
  }

  getLocation(id: string): void {
    this.locationService.get(id)
      .subscribe(
        data => {
          this.currentLocation = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }

  deleteLocation(): void {
    this.message = '';
    this.locationService.delete(this.currentLocation.locationId)
      .subscribe(
        response => {
          console.log(response);
          this.message = response.message ? response.message : 'This location is deleted successfully!';
          this.router.navigate(['/location']);
        },
        error => {
          console.log(error);
        });
  }
    }
