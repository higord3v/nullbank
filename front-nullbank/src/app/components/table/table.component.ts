import { Component, Input } from '@angular/core';
import { ICustomer } from 'src/app/interfaces/customer';
import { CustomerService } from 'src/app/services/customer.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent {
  @Input() customers: ICustomer[] = [];

  constructor(
    private customerService: CustomerService,
  ) {}

  deleteCustomer(cpf: string) {
    const swalWithBootstrapButtons = Swal.mixin({
      customClass: {
        confirmButton: 'btn btn-success',
        cancelButton: 'btn btn-danger'
      },
      buttonsStyling: false
    })

    swalWithBootstrapButtons.fire({
      title: 'Tem certeza que quer deletar o cliente?',
      text: "Não é possível reverter",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Sim, deletar',
      cancelButtonText: 'Não, cancelar',
      reverseButtons: true
    }).then((result) => {
      if (result.isConfirmed) {
        this.customerService.deleteCustomer(cpf).subscribe();
        this.customers = this.customers.filter(c => c.cpf !== cpf);

        swalWithBootstrapButtons.fire(
          'Deletado!',
          'Cliente Excluído',
          'success'
        )
      } else if (
        result.dismiss === Swal.DismissReason.cancel
      ) {
        swalWithBootstrapButtons.fire(
          'Cancelado',
          'O cliente não foi deletado',
          'error'
        )
      }
    });
  }
}
