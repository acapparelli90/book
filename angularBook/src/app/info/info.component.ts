import { BookService } from './../services/book.service';
import { Component, OnInit } from '@angular/core';
import { Book } from '../model/book';
import { ActivatedRoute, Router } from '@angular/router';


@Component({
  selector: 'app-info',
  templateUrl: './info.component.html',
  styleUrls: ['./info.component.css']
})
export class InfoComponent implements OnInit {
  id: any;
  book: Book; 
  
  constructor(private service: BookService, private router: Router, private route: ActivatedRoute) {
    this.route.paramMap.subscribe(param => {
      if( param.has("id") ) {
        this.id = param.get("id") 
        this.service.getBook(this.id).subscribe(result => {  this.book = result });
      }
    }) 
   }

  getInfo(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.service.getBook(id)
    .subscribe(book => this.book = book);
  }
  goBack(): void {
    this.router.navigate(['']);
  }
  ngOnInit() {
    this.getInfo();
  }

}
