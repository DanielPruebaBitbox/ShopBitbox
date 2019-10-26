import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DeactivateItemComponent } from './deactivate-item.component';

describe('DeactivateItemComponent', () => {
  let component: DeactivateItemComponent;
  let fixture: ComponentFixture<DeactivateItemComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DeactivateItemComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DeactivateItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
