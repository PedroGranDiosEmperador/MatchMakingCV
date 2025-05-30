import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

@Component({
  standalone: true,
  selector: 'app-opciones',
  templateUrl: './opciones.component.html',
  imports: [CommonModule, RouterModule]
})
export class OpcionesComponent implements OnInit {
  tipoUsuario: string = '';

  constructor(private route: ActivatedRoute) {}

  ngOnInit(): void {
    this.tipoUsuario = this.route.snapshot.paramMap.get('tipo') || '';
  }
}
