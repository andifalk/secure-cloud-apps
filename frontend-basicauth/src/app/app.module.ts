import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app.component';
import {BookListComponent} from "./books/book.list.component";
import {PageNotFoundComponent} from "./error/page.notfound.component";
import {BookDetailComponent} from "./books/book.detail.component";
import {LoginComponent} from "./login/login.component";
import {LoginService} from "./login/login.service";
import {MainComponent} from "./main/main.component";
import {BookService} from "./books/book.service";

const appRoutes: Routes = [
  { path: 'books/:id',      component: BookDetailComponent },
  { path: 'login',      component: LoginComponent },
  { path: 'main',      component: MainComponent },
  {
    path: 'books',
    component: BookListComponent,
    data: { title: 'Books List' }
  },
  { path: '',
    redirectTo: '/main',
    pathMatch: 'full'
  },
  { path: '**', component: PageNotFoundComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    MainComponent,
    PageNotFoundComponent,
    BookListComponent,
    BookDetailComponent,
    LoginComponent
  ],
  imports: [
    RouterModule.forRoot(appRoutes),
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpModule
  ],
  providers: [LoginService, BookService],
  bootstrap: [AppComponent]
})
export class AppModule { }
