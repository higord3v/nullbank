import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ICustomer } from 'src/app/interfaces/customer';
import { CustomerService } from 'src/app/services/customer.service';
import Swal from 'sweetalert2'

@Component({
  selector: 'app-customer-create-update',
  templateUrl: './customer-create-update.component.html',
  styleUrls: ['./customer-create-update.component.css']
})
export class CustomerCreateUpdateComponent {
  routeParam: string = '';
  customerForm: FormGroup;
  isAddMode: boolean = true;
  customer: ICustomer;
  prevPage: number = 0;

  constructor(
    private customerService: CustomerService,
    private route: ActivatedRoute,
    private router: Router
  ) {
    this.customer = {
      name: '',
      cpf: '',
      phone: '',
      monthly_income: 0,
      street: '',
      cep: 0,
      address_number: 0,
      relationship: 'BRONZE',
    };

    this.customerForm = new FormGroup({});
    this.route.params.subscribe(p => {
      this.customerForm.reset();
      this.customerForm.value.name = '';
    })
  }

  ngOnInit() {
    this.customerForm.reset();
    if (this.getUrlParam() === 'create') {
        this.customerForm = new FormGroup({
          cpf: new FormControl('', Validators.required),
          name: new FormControl('', Validators.required),
          phone: new FormControl('', Validators.required),
            monthly_income: new FormControl('', Validators.required),
            cep: new FormControl('', Validators.required),
            street: new FormControl('', Validators.required),
            address_number: new FormControl('', Validators.required),
            relationship: new FormControl('BRONZE', Validators.required),
          });
        return;
      }

    this.isAddMode = false;
    this.customerService.findByCpf(this.getUrlParam() as string).subscribe(result => {
      this.customerForm.value.cpf = result.cpf;
      this.customerForm.value.name =  result.name;
      this.customerForm.value.monthly_income = result.monthly_income;
      this.customerForm.value.phone =  result.phone;
    });
  }

  onSubmit(event: any) {
    const customer: ICustomer = {
      name: event.target.name.value,
      cpf: event.target.cpf.value,
      phone: event.target.phone.value,
      monthly_income: event.target.monthly_income.value || null,
    };

    if (this.getUrlParam() === 'create') {
      customer.street = event.target.street.value;
      customer.cep = event.target.cep.value;
      customer.address_number = event.target.address_number.value;
      customer.relationship = event.target.relationship.value;

      this.customerService
      .register(customer)
      .subscribe();

      Swal.fire(
        'Sucesso!',
        'Cliente Cadastrado!',
        'success'
      )
      setTimeout(() => {
        this.router.navigate(['/clientes']);

      }, 500);
      return;
    }

    this.isAddMode = false;
    this.customerService
    .update(customer, this.customerForm.value.cpf)
    .subscribe(r => {
      Swal.fire({
        position: 'top-end',
        icon: 'success',
        title: 'Alterações salvas!',
        showConfirmButton: false,
        timer: 1500
      })
      this.router.navigate(['/clientes']);
    });
  }

  getUrlParam() {
    return this.route.snapshot.paramMap.get('cpf');
  }

}
