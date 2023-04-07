import { Component } from '@angular/core';
import { ICustomer } from 'src/app/interfaces/customer';
import { CustomerService } from 'src/app/services/customer.service';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent {
  customers: ICustomer[] = [];

  constructor (
    private customerService: CustomerService
  ) {}

  ngOnInit() {
    this.customerService
    .findAllCustomers()
    .subscribe(c => {
      this.customers = c;
    })
  }
}
