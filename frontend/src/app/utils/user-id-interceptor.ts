import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {Injectable} from "@angular/core";
import {AuthenticationService} from "../login/authentication.service";

@Injectable()
export class UserIdInterceptor implements HttpInterceptor{

  constructor(private authenticationService:AuthenticationService) {
  }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    const req = request.clone({
      headers: request.headers.set('userid', this.authenticationService.getCurrentUserId())
    });
    return next.handle(req);
  }
}
