import { Injectable } from '@angular/core';
import Swal from 'sweetalert2';

@Injectable({
  providedIn: 'root'
})
export class AlertService {

  constructor() { }

  submitSuccessAlert()
  {
    Swal.fire({
      title: 'Success',
      text: 'Successfully Submitted',
      icon: 'success',
      timer:3000,
      timerProgressBar:true,
      confirmButtonText: 'OK',
    });
  }

}
