import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderModule } from './Controller/header.module';
import { FooterModule } from './Controller/footer.module';

@NgModule({
  declarations: [
    AppComponent,
    
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule, 
    HeaderModule, 
    FooterModule

  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule { }
