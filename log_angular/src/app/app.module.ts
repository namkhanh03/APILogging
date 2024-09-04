import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';
import { HttpClientModule, provideHttpClient } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoglistComponent } from './loglist/loglist.component';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import {NgxPaginationModule} from 'ngx-pagination';
import { FormsModule } from '@angular/forms';
import { NZ_I18N } from 'ng-zorro-antd/i18n';
import { en_US } from 'ng-zorro-antd/i18n';
import { registerLocaleData } from '@angular/common';
import en from '@angular/common/locales/en';
import { NzDatePickerModule } from 'ng-zorro-antd/date-picker';

registerLocaleData(en);

@NgModule({
  declarations: [
    AppComponent,
    LoglistComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NgxPaginationModule,
    FormsModule,
    NzDatePickerModule  
  ],
  providers: [
    provideClientHydration(),
    provideAnimationsAsync(),
    { provide: NZ_I18N, useValue: en_US },
    provideHttpClient()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
