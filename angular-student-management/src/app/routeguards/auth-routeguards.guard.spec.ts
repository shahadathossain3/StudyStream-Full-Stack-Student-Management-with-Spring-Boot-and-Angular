import { TestBed } from '@angular/core/testing';

import { AuthRouteguardsGuard } from './auth-routeguards.guard';

describe('AuthRouteguardsGuard', () => {
  let guard: AuthRouteguardsGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(AuthRouteguardsGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
