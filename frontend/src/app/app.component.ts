import { Component, OnInit } from '@angular/core';
import { TokenStorageService } from './_services/token-storage/token-storage.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  private roles: string[] = [];
  isLoggedIn = false;
  showtoAdmin = false;
  showtoManager = false;
  showtoFrontEndEmployee = false;
  showtoGuest = false;
  showNotToFEE = false;
  showNotToGuests = false;
  username?: string;

  constructor(private tokenStorageService: TokenStorageService) { }

  ngOnInit(): void {
    this.isLoggedIn = !!this.tokenStorageService.getToken();

    if (this.isLoggedIn) {
      const user = this.tokenStorageService.getUser();
      this.roles = user.roles;
      
      this.showtoAdmin = this.roles.includes('ROLE_ADMIN');
      this.showtoManager = this.roles.includes('ROLE_MANAGER');
      this.showtoFrontEndEmployee = this.roles.includes('ROLE_FRONTENDEMPLOYEE');
      this.showtoGuest = this.roles.includes('ROLE_GUEST');
      
      this.showNotToGuests = this.roles.includes('ROLE_ADMIN');
      this.showNotToGuests = this.roles.includes('ROLE_MANAGER');
      this.showNotToGuests = this.roles.includes('ROLE_FRONTENDEMPLOYEE');

      this.showNotToFEE = this.roles.includes('ROLE_ADMIN');
      this.showNotToFEE = this.roles.includes('ROLE_MANAGER');

      this.username = user.username;
    }
  }

  logout(): void {
    this.tokenStorageService.signOut();
    window.location.reload();
  }
}