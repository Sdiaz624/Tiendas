import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { MaterialModule } from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppComponent } from './app.component';
import 'rxjs/Rx';
import { TiendasComponent } from './tiendas/tiendas.component';

@NgModule({
  declarations: [
    AppComponent,
    TiendasComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    MaterialModule,
    BrowserAnimationsModule
  ],

  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
