import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { RegisterComponent } from './components/register/register.component';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';
import { ProfileComponent } from './components/profile/profile.component';

import { AddLocationComponent } from './components/location/add-location/add-location.component';
import { LocationDetailsComponent } from './components/location/location-details/location-details.component';
import { LocationListComponent } from './components/location/location-list/location-list.component';

import { AddDiscountComponent } from './components/discount/add-discount/add-discount.component';
import { DiscountDetailsComponent } from './components/discount/discount-details/discount-details.component';
import { DiscountListComponent } from './components/discount/discount-list/discount-list.component';

import { HotelListComponent } from './components/hotel/hotel-list/hotel-list.component';
import { HotelDetailsComponent } from './components/hotel/hotel-details/hotel-details.component';

import { ItemsListComponent } from './components/items/items-list/items-list.component';
import { ItemsDetailsComponent } from './components/items/items-details/items-details.component';
import { AddItemsComponent } from './components/items/add-items/add-items.component';

import { RoomsListComponent } from './components/rooms/rooms-list/rooms-list.component';
import { RoomsDetailsComponent } from './components/rooms/rooms-details/rooms-details.component';

import { ReservationListComponent } from './components/reservation/reservation-list/reservation-list.component';

import { authInterceptorProviders } from './_helpers/auth.interceptor';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    ProfileComponent,
    AddLocationComponent,
    LocationDetailsComponent,
    LocationListComponent,
    AddDiscountComponent,
    DiscountDetailsComponent,
    DiscountListComponent,
    HotelListComponent,
    HotelDetailsComponent,
    ItemsListComponent,
    ItemsDetailsComponent,
    AddItemsComponent,
    RoomsListComponent,
    RoomsDetailsComponent,
    ReservationListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [authInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }