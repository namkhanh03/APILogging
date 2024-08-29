import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Log, Page } from './log';

@Injectable({
  providedIn: 'root'
})
export class LogService {
  private baseUrl = 'http://localhost:9000/log/1.0.0/logs';
  constructor(private httpClient: HttpClient) { }

  getLogList(page: number, size: number): Observable<Page<Log>>{
    return this.httpClient.get<any>(`${this.baseUrl}?page=${page}&size=${size}`);
  }

  searchLogList(page: number, size: number, method: string): Observable<Page<Log>> {
    return this.httpClient.get<any>(`${this.baseUrl}/search?page=${page}&size=${size}&method=${method}`);
  }
}
