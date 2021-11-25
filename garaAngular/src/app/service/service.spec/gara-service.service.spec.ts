import { TestBed } from '@angular/core/testing';

import { GaraServiceService } from '../gara-service.service';

describe('GaraServiceService', () => {
  let service: GaraServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GaraServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
