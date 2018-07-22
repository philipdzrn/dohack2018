import { TestBed, inject } from '@angular/core/testing';

import { NavbarHeadertitleService } from './navbar-headertitle.service';

describe('NavbarHeadertitleService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [NavbarHeadertitleService]
    });
  });

  it('should be created', inject([NavbarHeadertitleService], (service: NavbarHeadertitleService) => {
    expect(service).toBeTruthy();
  }));
});
