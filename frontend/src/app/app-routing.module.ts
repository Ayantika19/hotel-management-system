import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LocationListComponent } from './components/location/location-list/location-list.component';
import { LocationDetailsComponent } from './components/location/location-details/location-details.component';
import { AddLocationComponent } from './components/location/add-location/add-location.component';

const routes: Routes = [
  { path: '', redirectTo: 'alllocations', pathMatch: 'full' },
  { path: 'alllocations', component: LocationListComponent },
  { path: 'find/:id', component: LocationDetailsComponent }, 
  { path: 'remove/:id', component: LocationDetailsComponent }, 
  { path: 'update/:id', component: LocationDetailsComponent }, 
  { path: 'add', component: AddLocationComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
