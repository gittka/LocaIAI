import { TestBed } from '@angular/core/testing';

import { AnthenticationService } from './anthentication.service';

describe('AnthenticationService', () => {
  let service: AnthenticationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AnthenticationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
