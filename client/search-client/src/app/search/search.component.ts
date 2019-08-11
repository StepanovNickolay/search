import {Component, OnInit} from '@angular/core';
import {MovieService} from '../movie.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  movies: any = [];

  constructor(private movieService: MovieService) {
  }

  ngOnInit() {
    this.getMovies();
  }

  getMovies() {
    this.movies = [];
    this.movieService.getMovies().subscribe((data: {}) => {
      console.log(data);
      this.movies = data;
    });
  }

}
