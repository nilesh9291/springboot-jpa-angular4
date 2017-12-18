import {AppRoutingModule} from './app-routing.module';
import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';

import {AppComponent} from './app.component';

import {CustomerDetailsComponent} from './customer-details/customer-details.component';
import {CustomersComponent} from './customers/customers.component';
import {DataService} from './data.service';
import {CreateCustomerComponent} from './create-customer/create-customer.component';
import {SearchCustomersComponent} from './search-customers/search-customers.component';
import {SocialComponent} from './social/social.component';

import { SocialLoginModule } from "angular4-social-login";
import { AuthServiceConfig, GoogleLoginProvider, FacebookLoginProvider } from 'angular4-social-login';
import {enableProdMode} from '@angular/core';
import { NavigationComponent } from './navigation/navigation.component';

let config = new AuthServiceConfig([
  {
    id: GoogleLoginProvider.PROVIDER_ID,
    provider: new GoogleLoginProvider("960134227899-mdksoeof0cps4nb8okn1is3n066al7n1.apps.googleusercontent.com")
  },
  {
    id: FacebookLoginProvider.PROVIDER_ID,
    provider: new FacebookLoginProvider("164142291004184")
  }
]);

export function provideConfig() {
  return config;
}

@NgModule({
  declarations: [
    AppComponent,
    CustomerDetailsComponent,
    CustomersComponent,
    CreateCustomerComponent,
    SearchCustomersComponent,
    SocialComponent,
    NavigationComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    AppRoutingModule,
    SocialLoginModule
  ],
  providers: [
    {
      provide: AuthServiceConfig,
      useFactory: provideConfig
    },
    DataService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
