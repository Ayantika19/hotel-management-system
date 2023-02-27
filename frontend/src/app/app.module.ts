import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddLocationComponent } from './components/location/add-location/add-location.component';
import { LocationDetailsComponent } from './components/location/location-details/location-details.component';
import { LocationListComponent } from './components/location/location-list/location-list.component';

@NgModule({
  declarations: [
    AppComponent,
    AddLocationComponent,
    LocationDetailsComponent,
    LocationListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
