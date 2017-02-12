
import {Component, OnInit} from "@angular/core";
import {Book} from "./book";
import {BookService} from "./book.service";
import {Response} from "@angular/http";

@Component({
  selector: 'booklist',
  templateUrl: 'book.list.component.html'
})
export class BookListComponent implements OnInit {

  public title = 'My favourite books';
  public books: Book[];

  constructor(private bookService:BookService) {

  }

  ngOnInit(): void {
    this.loadBooks();
  }

  public loadBooks(): void {
    console.info('loadBooks');
    this.bookService.findAllBooks().subscribe(
      (books:Book[]) => {this.books = books},
      (error:Response) => {console.warn(error.statusText)}
    );
  }


}
