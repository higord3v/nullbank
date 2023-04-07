import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments';
import { ICustomer } from '../interfaces/customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  uri = "clientes";
  api = environment.api;
  constructor(private http: HttpClient) { }

  findAllCustomers() {
    return this.http.get<ICustomer[]>(`${this.api}/${this.uri}`);
  }

  register(customer: ICustomer) {
    return this.http.post(`${this.api}/${this.uri}`, customer)
  }

  findByCpf(cpf: string) {
    return this.http.get<ICustomer>(`${this.api}/${this.uri}/${cpf}`);
  }

  update(customer: ICustomer, cpf: string) {
    return this.http.put<ICustomer>(`${this.api}/${this.uri}/${cpf}`, customer);
  }

  deleteCustomer(cpf: string) {
    return this.http.delete(`${this.api}/${this.uri}/${cpf}`);
  }
}
