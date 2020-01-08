import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ErsComponent } from './ers.component';

describe('ErsComponent', () => {
  let component: ErsComponent;
  let fixture: ComponentFixture<ErsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ErsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ErsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
