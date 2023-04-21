import { Component, OnInit } from '@angular/core';
import { RoomsService } from 'src/app/_services/rooms/rooms.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Rooms } from 'src/app/models/rooms/rooms.model';
import { Hotel } from 'src/app/models/hotel/hotel.model';
import { Reservation } from 'src/app/models/reservation/reservation.model';

@Component({
  selector: 'app-rooms-details',
  templateUrl: './rooms-details.component.html',
  styleUrls: ['./rooms-details.component.css']
})
export class RoomsDetailsComponent implements OnInit {
  currentRooms: Rooms = {
    roomNumber: '',
    roomCharges: '',
    roomType: '',
    hotelDetails: new Hotel().hotelName,
  };
  message = '';

  constructor(
    private roomsService: RoomsService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.message = '';
    this.getRooms(this.route.snapshot.params.id);
  }

  getRooms(id: string): void {
    this.roomsService.get(id)
      .subscribe(
        data => {
          this.currentRooms = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }

  deleteRooms(): void {
    this.message = '';
    this.roomsService.delete(this.currentRooms.roomId)
      .subscribe(
        response => {
          console.log(response);
          this.message = response.message ? response.message : 'This room is deleted successfully!';
          this.router.navigate(['/rooms']);
        },
        error => {
          console.log(error);
        });
  }
    }
