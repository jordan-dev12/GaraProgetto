import { TestBed } from '@angular/core/testing';

import { ParServiceService } from '../par-service.service';

describe('ParServiceService', () => {
  let service: ParServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ParServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
