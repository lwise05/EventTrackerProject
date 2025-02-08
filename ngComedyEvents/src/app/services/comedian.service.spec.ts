import { TestBed } from '@angular/core/testing';

import { ComedianService } from './comedian.service';

describe('ComedianService', () => {
  let service: ComedianService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ComedianService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
