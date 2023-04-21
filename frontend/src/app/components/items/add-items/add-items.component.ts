import { Component, OnInit } from '@angular/core';
import { Items } from 'src/app/models/items/items.model';
import { ItemsService } from 'src/app/_services/items/items.service';

@Component({
  selector: 'app-add-items',
  templateUrl: './add-items.component.html',
  styleUrls: ['./add-items.component.css']
})
export class AddItemsComponent implements OnInit {
  item: Items = {
    itemName: '',
    charges: '',
  };
  submitted = false;

  constructor(private itemsService: ItemsService) { }

  ngOnInit(): void {
  }

  saveItems(): void {
    const data = {
      itemName: this.item.itemName,
      charges: this.item.charges
    };

    this.itemsService.create(data)
      .subscribe(
        response => {
          console.log(response);
          this.submitted = true;
        },
        error => {
          console.log(error);
        });
  }

  newItems(): void {
    this.submitted = false;
    this.item = {
        itemName: '',
        charges: ''
    };
  }

}
