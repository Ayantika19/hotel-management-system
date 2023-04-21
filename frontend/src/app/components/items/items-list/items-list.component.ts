import { Component, OnInit } from '@angular/core';
import { Items } from 'src/app/models/items/items.model';
import { ItemsService } from 'src/app/_services/items/items.service';

@Component({
  selector: 'app-items-list',
  templateUrl: './items-list.component.html',
  styleUrls: ['./items-list.component.css']
})
export class ItemsListComponent implements OnInit {
  items?: Items[];
  currentItem?: Items;
  currentIndex = -1;
  // deleteitems: Item = {
  //   itemsName: '',
  // };
  // submitted = false;

  constructor(private itemsService: ItemsService) { }

  ngOnInit(): void {
    this.retrieveItems();
  }

  retrieveItems(): void {
    this.itemsService.getAll()
      .subscribe(
        data => {
          this.items = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }

  refreshList(): void {
    this.retrieveItems();
    this.currentItem = undefined;
    this.currentIndex = -1;
  }

  setActiveItem(itemss: Items, index: number): void {
    this.currentItem = itemss;
    this.currentIndex = index;
  }


  deleteItem(index: number): void {
    this.currentIndex = index;
    this.itemsService.delete(this.currentIndex)
      .subscribe(
        response => {
          console.log(response);
          this.refreshList();
        },
        error => {
          console.log(error);
        });
  }
 }

