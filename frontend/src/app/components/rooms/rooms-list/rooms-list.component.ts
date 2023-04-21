import { Component, OnInit } from '@angular/core';
import { Rooms } from 'src/app/models/rooms/rooms.model';
import { RoomsService } from 'src/app/_services/rooms/rooms.service';

@Component({
  selector: 'app-rooms-list',
  templateUrl: './rooms-list.component.html',
  styleUrls: ['./rooms-list.component.css']
})
export class RoomsListComponent implements OnInit {
  rooms?: Rooms[];
  currentRooms?: Rooms;
  currentIndex = -1;
  
  constructor(private roomsService: RoomsService) { }

  ngOnInit(): void {
    this.retrieveRooms();
  }

  retrieveRooms(): void {
    this.roomsService.getAll()
      .subscribe(
        data => {
          this.rooms = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }

  refreshList(): void {
    this.retrieveRooms();
    this.currentRooms = undefined;
    this.currentIndex = -1;
  }

  setActiveRooms(roomss: Rooms, index: number): void {
    this.currentRooms = roomss;
    this.currentIndex = index;
  }
}
