import { TestBed } from '@angular/core/testing';

import { ComedyEventService } from './comedy-event.service';

describe('ComedyEventService', () => {
  let service: ComedyEventService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ComedyEventService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
