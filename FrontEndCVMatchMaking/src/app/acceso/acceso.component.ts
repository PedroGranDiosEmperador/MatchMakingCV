import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';

@Component({
  standalone: true,
  selector: 'app-acceso',
  templateUrl: './acceso.component.html',
  imports: [RouterModule]  // 👈 esta línea es clave
})
export class AccesoComponent {}
