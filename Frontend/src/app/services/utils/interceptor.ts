import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { finalize, Observable } from "rxjs";
import { LoadingService } from "./loading.service";

@Injectable()
export class Interceptor implements HttpInterceptor{

    constructor(private loadingService: LoadingService) {    }

    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
       this.loadingService.display();
       return next.handle(req).pipe(
        finalize(() => this.loadingService.hide())
       )
    }
}
