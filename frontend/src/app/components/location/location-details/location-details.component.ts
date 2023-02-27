import { Component, OnInit } from '@angular/core';
import { LocationService } from 'src/app/services/location/location.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Location } from 'src/app/models/location/location.model';

@Component({
  selector: 'app-location-details',
  templateUrl: './location-details.component.html',
  styleUrls: ['./location-details.component.css']
})
export class LocationDetailsComponent implements OnInit {
  currentLocation: Location = {
    id: '',
    locationname: '',
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

//   updatePublished(status: boolean): void {
//     const data = {
//       id: this.currentLocation.id,
//       locationname: this.currentLocation.locationname,
//     };

//     this.message = '';

//     this.locationService.update(this.currentLocation.id, data)
//       .subscribe(
//         response => {
//           console.log(response);
//           this.message = response.message ? response.message : 'This location was updated successfully!';
//         },
//         error => {
//           console.log(error);
//         });
//   }

  // updateLocation(): void {
  //   this.message = '';

  //   this.locationService.update(this.currentLocation.id, this.currentLocation)
  //     .subscribe(
  //       response => {
  //         console.log(response);
  //         this.message = response.message ? response.message : 'This location was updated successfully!';
  //       },
  //       error => {
  //         console.log(error);
  //       });
  // }

  deleteLocation(): void {
    this.locationService.delete(this.currentLocation.id)
      .subscribe(
        response => {
          console.log(response);
          this.router.navigate(['/alllocations']);
        },
        error => {
          console.log(error);
        });
  }
}
