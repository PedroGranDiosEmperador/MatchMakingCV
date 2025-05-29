import { Routes } from '@angular/router';
import { AccesoComponent } from './acceso/acceso.component';
import { OpcionesComponent } from './opciones/opciones.component';
import { SubirEmpleoComponent } from './subir-empleo/subir-empleo.component';
import { EliminarEmpleoComponent } from './eliminar-empleo/eliminar-empleo.component';
import { CvComponent } from './cv/cv.component';
import { BuscarempleoComponent } from './buscarempleo/buscarempleo.component';

export const routes: Routes = [ 
  { path: '', component: AccesoComponent },
  { path: 'opciones/:tipo', component: OpcionesComponent },
  { path: 'subir', component: SubirEmpleoComponent },
  { path: 'eliminar', component: EliminarEmpleoComponent },
  { path: 'cv', component: CvComponent },
  { path: 'buscarempleo', component: BuscarempleoComponent },

];
