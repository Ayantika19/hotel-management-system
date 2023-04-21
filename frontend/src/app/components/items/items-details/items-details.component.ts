import { Component, OnInit } from '@angular/core';
import { ItemsService } from 'src/app/_services/items/items.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Items } from 'src/app/models/items/items.model';

@Component({
  selector: 'app-items-details',
  templateUrl: './items-details.component.html',
  styleUrls: ['./items-details.component.css']
})
export class ItemsDetailsComponent implements OnInit {
  currentItem: Items = {
    itemName: '',
    charges: '',
  };
  message = '';

  constructor(
    private itemsService: ItemsService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.message = '';
    this.getItems(this.route.snapshot.params.id);
  }

  getItems(id: string): void {
    this.itemsService.get(id)
      .subscribe(
        data => {
          this.currentItem = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }

  deleteItem(): void {
    this.message = '';
    this.itemsService.delete(this.currentItem.itemId)
      .subscribe(
        response => {
          console.log(response);
          this.message = response.message ? response.message : 'This item is deleted successfully!';
          this.router.navigate(['/items']);
        },
        error => {
          console.log(error);
        });
  }
    }
