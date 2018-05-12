import { HttpClient, HttpHeaders } from '@angular/common/http';



private heroesUrl = 'http://localhost:9999/Employee/';  // URL to web api

constructor(
  private http: HttpClient,
  private messageService: MessageService) { }
  private log(message: string) {
  this.messageService.add('HeroService: ' + message);
}


getHeroes (): Observable<Hero[]> {
  return this.http.get<Hero[]>(this.heroesUrl)
}
