import { Component, OnInit } from '@angular/core';
import { Reservation } from 'src/app/models/reservation/reservation.model';
import { ReservationService } from 'src/app/_services/reservation/reservation.service';

@Component({
  selector: 'app-reservation-list',
  templateUrl: './reservation-list.component.html',
  styleUrls: ['./reservation-list.component.css']
})
export class ReservationListComponent implements OnInit {
  reservation?: Reservation[];
  currentReservation?: Reservation;
  currentIndex = -1;

  constructor(private reservationService: ReservationService) { }

  ngOnInit(): void {
    this.retrieveReservations();
  }

  retrieveReservations(): void {
    this.reservationService.getAll()
      .subscribe(
        data => {
          this.reservation = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }

  refreshList(): void {
    this.retrieveReservations();
    this.currentReservation = undefined;
    this.currentIndex = -1;
  }

  setActiveReservation(reservations: Reservation, index: number): void {
    this.currentReservation = reservations;
    this.currentIndex = index;
  }
}

