import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Log } from './log';

@Injectable({
  providedIn: 'root'
})
export class LogService {
  private baseUrl = 'http://localhost:9000/log/1.0.0/logs';
  constructor(private httpClient: HttpClient) { }

  getLogList(): Observable<Log[]>{
    return this.httpClient.get<Log[]>(`${this.baseUrl}`);
  }
}
