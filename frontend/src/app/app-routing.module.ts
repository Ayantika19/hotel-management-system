import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { RegisterComponent } from './components/register/register.component';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';
import { ProfileComponent } from './components/profile/profile.component';

import { LocationListComponent } from './components/location/location-list/location-list.component';
import { LocationDetailsComponent } from './components/location/location-details/location-details.component';
import { AddLocationComponent } from './components/location/add-location/add-location.component';

import { DiscountListComponent } from './components/discount/discount-list/discount-list.component';
import { DiscountDetailsComponent } from './components/discount/discount-details/discount-details.component';
import { AddDiscountComponent } from './components/discount/add-discount/add-discount.component';

import { HotelListComponent } from './components/hotel/hotel-list/hotel-list.component';
import { HotelDetailsComponent } from './components/hotel/hotel-details/hotel-details.component';

import { ItemsListComponent } from './components/items/items-list/items-list.component';
import { ItemsDetailsComponent } from './components/items/items-details/items-details.component';
import { AddItemsComponent } from './components/items/add-items/add-items.component';

import { RoomsListComponent } from './components/rooms/rooms-list/rooms-list.component';
import { RoomsDetailsComponent } from './components/rooms/rooms-details/rooms-details.component';

import { ReservationListComponent } from './components/reservation/reservation-list/reservation-list.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'profile', component: ProfileComponent },

  { path: 'location', component: LocationListComponent },
  { path: 'location/:id', component: LocationDetailsComponent },
  { path: 'add-location', component: AddLocationComponent },

  { path: 'discount', component: DiscountListComponent },
  { path: 'discount/:id', component: DiscountDetailsComponent },
  { path: 'add-discount', component: AddDiscountComponent },

  { path: 'hotel', component: HotelListComponent },
  { path: 'hotel/:id', component: HotelDetailsComponent },

  { path: 'items', component: ItemsListComponent },
  { path: 'items/:id', component: ItemsDetailsComponent },
  { path: 'add-items', component: AddItemsComponent },

  { path: 'rooms', component: RoomsListComponent },
  { path: 'rooms/:id', component: RoomsDetailsComponent },

  { path: 'reservation', component: ReservationListComponent },  

  { path: '', redirectTo: 'home', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
