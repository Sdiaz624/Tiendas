import { Component } from '@angular/core';
import { Http } from '@angular/http';
import { FormControl, Validators } from '@angular/forms';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import "rxjs/add/operator/map";

@Component({
  selector: 'app-tiendas',
  templateUrl: './tiendas.component.html',
  styleUrls: ['./tiendas.component.css']
})
export class TiendasComponent {

  myTiendas: Array<any>;
  myProductos: Array<any>;
  
   constructor(private http: Http) {
     
     this.http.get('http://localhost:8080/project/Tienda/Tienda/consulta')
     .map(response => response.json())
     .subscribe(res => this.myTiendas = res);
   }
 
  getProductos(id:any){
    this.http.get('http://localhost:8080/project/Producto/Producto/consulta/'+id)
    .map(response => response.json())
    .subscribe(res => this.myProductos = res);
    
  } 
  myConfirmp={id:'',nombre:'',descripcion:'',precio:'',tienda:''}; 
  updProductos(id:any,nombre:any,desc:any,precio:any,tienda:any){
    const _url='http://localhost:8080/project/Producto/Producto/actualizar';
    return  this.http.post(_url,{id:id,
                                 nombre:nombre,
                                 descripcion:desc,
                                 precio:precio,
                                 tienda:id})
    .map(response => response.json())
    .subscribe(res => this.myConfirmp = res);   
  } 
  
  
  myConfirmt={id:'',nombre:''}; 
  updTienda(id:any, nombre:any){
    const _url='http://localhost:8080/project/Tienda/Tienda/actualizar';
    return  this.http.post(_url,{id:id,
                                 nombre:nombre})
    .map(response => response.json())
    .subscribe(res => this.myConfirmt = res);   
        
  } 
  
insProducto(nompro:any,despro:any,prepro:any,id:any){
    
    const _url='http://localhost:8080/project/Producto/Producto/registrar';
    return  this.http.post(_url,{id:'0',
                                 nombre:nompro,
                                 descripcion:despro,
                                 precio:prepro,
                                 tienda:id})
    .map(response => response.json())
    .subscribe(res => this.myConfirmp = res);
         
  } 
  
  insTienda(nombre:any){

    this.http.get('http://localhost:8080/project/Tienda/Tienda/registrar/'+nombre)
    .map(response => response.json())
    .subscribe(res => this.myTiendas = res);
  }  

  dropProducto(id:any){
    this.http.get('http://localhost:8080/project/Producto/Producto/eliminar/'+id)
    .map(response => response.json())
    .subscribe(res => this.myProductos = res);
  }  

  droptienda(id:any){
    this.http.get('http://localhost:8080/project/Tienda/Tienda/eliminar/'+id)
    .map(response => response.json())
    .subscribe(res => this.myTiendas )
  } 
  

}
