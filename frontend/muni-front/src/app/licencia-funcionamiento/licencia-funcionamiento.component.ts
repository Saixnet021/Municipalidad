import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-licencia-funcionamiento',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './licencia-funcionamiento.component.html'
})
export class LicenciaFuncionamientoComponent implements OnInit {
  form: FormGroup;
  items: any[] = [];
  private apiUrl = 'http://localhost:8080/api/v1/licencias';

  constructor(private fb: FormBuilder, private http: HttpClient) {
    this.form = this.fb.group({
      negocio: ['', Validators.required],
      ruc: ['', Validators.required],
      direccion: ['', Validators.required],
      representante: ['', Validators.required]
    });
  }

  ngOnInit() {
    this.loadItems();
  }

  loadItems() {
    this.http.get<any[]>(`${this.apiUrl}/mis-tramites`).subscribe({
      next: (data) => this.items = data,
      error: (err) => console.error(err)
    });
  }

  onSubmit() {
    if (this.form.valid) {
      this.http.post(this.apiUrl, this.form.value).subscribe({
        next: () => {
          this.form.reset();
          this.loadItems();
          alert('Solicitud enviada');
        },
        error: (err) => alert('Error al enviar solicitud')
      });
    }
  }
}
